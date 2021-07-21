package repository

import android.os.Handler
import android.os.Looper
import source.remote.response.movie.ResultItem
import source.remote.response.tv.ResultsItem

class FakeRemoteDataSource(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000
        private const val movieId = 0
        private const val API_KEY = ""

        @Volatile
        private var instance: FakeRemoteDataSource? = null

        fun getInstance(helper: JsonHelper): FakeRemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: FakeRemoteDataSource(helper).apply { instance = this }
            }


    }

    fun getMoviePopular(callback: LoadMovieCallback) {
        handler.postDelayed({ callback.onAllMovieReceived(jsonHelper.loadMoviePopular()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvPopular(callback: LoadTvCallback){
        handler.postDelayed({ callback.onAllTvReceived(jsonHelper.loadTvPopular()) }, SERVICE_LATENCY_IN_MILLIS)
    }


    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<ResultItem>)
    }

    interface LoadTvCallback {
        fun onAllTvReceived(moduleResponses: List<ResultsItem>)
    }




}