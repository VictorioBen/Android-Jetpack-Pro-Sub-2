package repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import source.remote.RemoteDataSourceImpl
import source.remote.network.ApiClient
import source.remote.repository.movie.MovieRepositoryImpl
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.ResultItem


class FakeRepository(private val fakeRemoteDataSource: FakeRemoteDataSource) :
    FakeMovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepositoryImpl? = null
        fun getInstance(remoteDataImpl: RemoteDataSourceImpl): MovieRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: MovieRepositoryImpl(remoteDataImpl).apply { instance = this }
            }
    }

    override fun getPopularMovie(): LiveData<List<ResultItem>> {
        val movieResult = MutableLiveData<List<ResultItem>>()
        fakeRemoteDataSource.getMoviePopular(object : FakeRemoteDataSource.LoadMovieCallback {
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