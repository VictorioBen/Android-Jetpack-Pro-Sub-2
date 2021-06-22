package source.remote.network

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResponsePopular
import source.remote.response.tv.DetailTvListResponse
import source.remote.response.tv.TvListResponse
import source.remote.response.tv.TvResponsePopular

class ApiClient {
    companion object {
        private val okHttpClient = OkHttpClient.Builder()

        private val builder = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())

        private val retrofit = builder.build()

        val service by lazy {
            val create: ApiService = retrofit.create(ApiService::class.java)
            create
        }
    }
}

interface ApiService {

    @GET("movie/popular")
    @Headers("Authorization: token 0f39d26119b683bda02291ee16a9a348")
     fun getPopularMovie(@Query("api_key") apiKey: String
    ): Call<MovieResponsePopular>

    @GET("movie/{movie_id}")
     fun getDetailMovie(@Path("movie_id") movie_id: Int, @Query("api_key") apiKey: String): Call<MovieDetailResponse>

    @GET("tv/popular")
    @Headers("Authorization: token 0f39d26119b683bda02291ee16a9a348")
    fun getPopularTv(@Query("api_key") apiKey: String): Call<TvResponsePopular>

    @GET("tv/{tv_id}")
    suspend fun getDetailTv(@Path("tv_id") tv_id: Int, @Query("api_key") apiKey: String): Call<DetailTvListResponse>


}