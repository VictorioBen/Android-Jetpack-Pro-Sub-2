package utils

import android.content.ContentValues
import android.content.Context
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import source.remote.network.ApiClient
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.ResultItem
import source.remote.response.tv.ResultsItem
import source.remote.response.tv.TvResponsePopular
import java.io.IOException
import kotlin.collections.ArrayList

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMoviePopular(): List<ResultItem> {

        val list = ArrayList<ResultItem>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviePopular.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)


                val id = movie.getInt("id")
                val title = movie.getString("title")
                val posterPath = movie.getString("poster_path")
                val releaseDate = movie.getString("release_date")
                val voteAverage = movie.getDouble("vote_average")


                val movieResponsePopular = ResultItem(id,title,posterPath,releaseDate,voteAverage)
                list.add(movieResponsePopular)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

     fun detailMovie(movieId: Int, apiKey: String) = ApiClient.service.getDetailMovie(movieId, apiKey)


}