package source.remote

import retrofit2.await
import source.remote.network.ApiClient
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResultItem
import source.remote.response.tv.TvResponseDetail
import source.remote.response.tv.TvResultsItem

class RemoteDataSourceImpl {

    companion object {
        private const val API_KEY = "0f39d26119b683bda02291ee16a9a348"
        @Volatile
        private var instance: RemoteDataSourceImpl? = null
        fun getInstance(): RemoteDataSourceImpl =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSourceImpl().apply { instance = this }
            }
    }
    suspend fun getMoviePopular(callback: LoadMovieCallback) {
        ApiClient.service.getPopularMovie(API_KEY).await().results?.let {
            callback.onAllMovieReceived(
                it
            )
        }
    }

    suspend fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback){
        ApiClient.service.getDetailMovie(movieId, API_KEY).await().let {
            callback.onAllDetailMovieReceived(it)
        }
    }

    suspend fun getTvPopular(callback: LoadTvCallback) {
        ApiClient.service.getPopularTv(API_KEY).await().results?.let {
            callback.onAllTvReceived(
                it
            )
        }
    }

    suspend fun getDetailTv(tvId: Int, callback: LoadDetailTvCallback){
        ApiClient.service.getDetailTv(tvId, API_KEY).await().let {
            callback.onAllDetailTvReceived(it)
        }
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResultItem?>)
    }

    interface LoadDetailMovieCallback{
        fun onAllDetailMovieReceived(detailResponse: MovieDetailResponse)
    }

    interface LoadTvCallback {
        fun onAllTvReceived(moduleResponses: List<TvResultsItem?>)
    }

    interface LoadDetailTvCallback{
        fun onAllDetailTvReceived(tvResponseDetail: TvResponseDetail)
    }



}