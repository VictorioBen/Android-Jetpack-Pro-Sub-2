package source.remote.repository.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import source.entity.MovieResultEntity
import source.entity.movie.MovieDetailEntity
import source.remote.RemoteDataSourceImpl
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResultItem


class MovieRepositoryImpl(private val remoteDataSourceImpl: RemoteDataSourceImpl) : MovieRepository {

    companion object {
        @Volatile
        private var instance: MovieRepositoryImpl? = null
        fun getInstance(remoteDataImpl: RemoteDataSourceImpl): MovieRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: MovieRepositoryImpl(remoteDataImpl).apply { instance = this }
            }
    }

    override  fun getPopularMovie(): LiveData<List<MovieResultEntity>> {
        val movieResult = MutableLiveData<List<MovieResultEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSourceImpl.getMoviePopular(object : RemoteDataSourceImpl.LoadMovieCallback {
                override fun onAllMovieReceived(movieResponse: List<MovieResultItem?>) {
                    val movieList = ArrayList<MovieResultEntity>()
                    for (response in movieResponse) {
                        val movie = MovieResultEntity(
                            response?.id,
                            response?.title,
                            response?.posterPath,
                            response?.releaseDate,
                            response?.voteAverage)
                        movieList.add(movie)
                    }
                    movieResult.postValue(movieList)
                }
            })


        }
        return movieResult
        }

    override fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailEntity> {
        val detailMovie = MutableLiveData<MovieDetailEntity>()
        CoroutineScope(IO).launch {
            remoteDataSourceImpl.getDetailMovie(movieId, object : RemoteDataSourceImpl.LoadDetailMovieCallback{

                override fun onAllDetailMovieReceived(detailResponse: MovieDetailResponse) {
                    val movieDetail = MovieDetailEntity(
                        detailResponse.title,
                        detailResponse.id,
                        detailResponse.overview,
                        detailResponse.runtime,
                        detailResponse.posterPath,
                        detailResponse.releaseDate,
                        detailResponse.voteAverage,
                        detailResponse.tagline,
                        detailResponse.status
                    )

                    detailMovie.postValue(movieDetail)
                }
            })
        }

       return detailMovie
    }


}