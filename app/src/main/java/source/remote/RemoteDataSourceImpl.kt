package source.remote

import retrofit2.await
import source.remote.network.ApiClient
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResultItem
import source.remote.response.tv.TvResponseDetail
import source.remote.response.tv.TvResultsItem
import utils.EspressoIdlingResources
import utils.Helper.API_KEY

class RemoteDataSourceImpl {

    companion object {

        @Volatile
        private var instance: RemoteDataSourceImpl? = null
        fun getInstance(): RemoteDataSourceImpl =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSourceImpl().apply { instance = this }
            }
    }
    suspend fun getMoviePopular(callback: LoadMovieCallback) {
        EspressoIdlingResources.increment()
        ApiClient.service.getPopularMovie(API_KEY).await().results?.let {
            callback.onAllMovieReceived(
                it
            )
            EspressoIdlingResources.decrement()
        }
    }

    suspend fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback){
        EspressoIdlingResources.increment()
        ApiClient.service.getDetailMovie(movieId, API_KEY).await().let {
            callback.onAllDetailMovieReceived(it)
        }
        EspressoIdlingResources.decrement()
    }

    suspend fun getTvPopular(callback: LoadTvCallback) {
        EspressoIdlingResources.increment()
        ApiClient.service.getPopularTv(API_KEY).await().results?.let {
            callback.onAllTvReceived(
                it
            )
            EspressoIdlingResources.decrement()
        }
    }

    suspend fun getDetailTv(tvId: Int, callback: LoadDetailTvCallback){
        EspressoIdlingResources.increment()
        ApiClient.service.getDetailTv(tvId, API_KEY).await().let {
            callback.onAllDetailTvReceived(it)
        }
        EspressoIdlingResources.decrement()
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