package source.remote.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResponsePopular
import source.remote.response.tv.TvResponseDetail
import source.remote.response.tv.TvResponsePopular

interface ApiService {

    @GET("movie/popular")
    @Headers("Authorization: token 0f39d26119b683bda02291ee16a9a348")
    fun getPopularMovie(
        @Query("api_key") apiKey: String
    ): Call<MovieResponsePopular>

    @GET("tv/popular")
     fun getPopularTv(
        @Query("api_key") apiKey: String
    ): Call<TvResponsePopular>

    @GET("movie/{movie_id}")
    @Headers("Authorization: token 0f39d26119b683bda02291ee16a9a348")
    fun getDetailMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Call<MovieDetailResponse>

    @GET("tv/{tv_id}")

    fun getDetailTv(
        @Path("tv_id") tv_id: Int,
        @Query("api_key") apiKey: String
    ): Call<TvResponseDetail>


}