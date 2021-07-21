package source.remote.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private const val URL = "https://api.themoviedb.org/3/"
        private val okHttpClient = OkHttpClient.Builder()
        private val builder = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
        private val retrofit = builder.build()
        val service by lazy {
            val create: ApiService = retrofit.create(ApiService::class.java)
            create
        }
    }
}

