package source.remote

import android.os.Handler
import android.os.Looper
import retrofit2.Call
import source.remote.network.ApiClient
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.ResultItem
import utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000
        private const val movieId = 0
        private const val API_KEY = ""

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper).apply { instance = this }
                }


    }

    fun getMoviePopular(callback: LoadMovieCallback) {
        handler.postDelayed({ callback.onAllMovieReceived(jsonHelper.loadMoviePopular()) }, SERVICE_LATENCY_IN_MILLIS)
    }

     fun detailMovie(callback: LoadDetailMovie) {
         handler.postDelayed({ callback.onDetail(jsonHelper.detailMovie(movieId, API_KEY)) }, SERVICE_LATENCY_IN_MILLIS)
    }


    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<ResultItem>)
    }

    interface LoadDetailMovie {
        fun onDetail(moduleResponses: Call<MovieDetailResponse>)
    }




}