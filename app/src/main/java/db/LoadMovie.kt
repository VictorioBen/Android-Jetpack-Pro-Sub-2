package db



import androidx.appcompat.app.AppCompatActivity
import data.movies.MovieModel
import org.json.JSONArray
import org.json.JSONObject

import java.io.InputStream

class LoadMovie: AppCompatActivity(){

   // @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
//     fun readJsonFromAsset(): String? {
//
//        val json: String?
//        val mList = ArrayList<MovieModel>()
//        try {
//
//            val inputStream: InputStream? = assets?.open("movie.json")
//            json = inputStream?.bufferedReader().use { it?.readText() }
//            val jsonObject = JSONObject(json)
//            val jsonArray = JSONArray(jsonObject.get("movies").toString())
//
//            for (i in 0 until jsonArray.length()) {
//                val listObject: JSONObject? = jsonArray.getJSONObject(i)
//                val uuid: String? = listObject?.getString("uuid")
//                val title: String? = listObject?.getString("title")
//                val director: String? = listObject?.getString("director")
//                val poster: String? = listObject?.getString("poster")
//                val age: String? = listObject?.getString("age")
//                val genre: String? = listObject?.getString("genre")
//                val duration: String? = listObject?.getString("duration")
//                val rating: Int? = listObject?.getInt("rating")
//                val category: String? = listObject?.getString("category")
//                val releaseDate: String? = listObject?.getString("release_date")
//                val synopsis: String? = listObject?.getString("synopsis")
//                val list = rating?.let {
//                    MovieModel(
//                        uuid,
//                        title,
//                        director,
//                        poster,
//                        age,
//                        genre,
//                        duration,
//                        it,
//                        category,
//                        releaseDate,
//                        synopsis
//                    )
//                }
//                if (list != null) {
//                    mList.add(list)
//                }
//                val mList = ArrayList<MovieModel>()
//                list?.let { mList.add(it) }
//
//
//            }
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//            return null
//        }
//        return mList.toString()
//    }

//    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
//        val jsonString: String
//        try {
//            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
//        } catch (ioException: IOException) {
//            ioException.printStackTrace()
//            return null
//        }
//        return jsonString
//    }
}