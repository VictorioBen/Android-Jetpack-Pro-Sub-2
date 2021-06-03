package source.remote.network

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

class ApiClient {
    companion object {
        private val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
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
    suspend fun getDetailMovie(@Path("movie_id") movie_id: Int, @Query("api_key") apiKey: String): Call<MovieDetailResponse>

    @GET("tv/popular")
    suspend fun getPopularTv(@Query("api_key") apiKey: String): Call<TvListResponse>

    @GET("tv/{tv_id}")
    suspend fun getDetailTv(@Path("tv_id") tv_id: Int, @Query("api_key") apiKey: String): Call<DetailTvListResponse>


}