package source.remote.repository.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import source.remote.RemoteDataSource
import source.remote.network.ApiClient
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.ResultItem
import timber.log.Timber

class MovieRepository(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getPopularMovie(): LiveData<List<ResultItem>> {
        val movieResult = MutableLiveData<List<ResultItem>>()
        remoteDataSource.getMoviePopular(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponse: List<ResultItem>) {
                val movieList = ArrayList<ResultItem>()
                for (response in movieResponse) {
                    val movie = ResultItem(response.id,response.title,response.posterPath,response.releaseDate,response.voteAverage)
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }
        })

        return movieResult


        }

    override fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailResponse> {
        val list = MutableLiveData<MovieDetailResponse>()
        val call = ApiClient.service.getDetailMovie(movieId,apiKey)
        call.enqueue(object : Callback<MovieDetailResponse> {

            override fun onFailure(call: Call<MovieDetailResponse>?, t: Throwable?) {
                list.postValue(null)

            }

            override fun onResponse(
                    call: Call<MovieDetailResponse>?, response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val data: MovieDetailResponse? = response.body()
                    list.postValue(data)


                }

            }

        })
        return list
    }


}