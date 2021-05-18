package ui.movies

import adapter.MoviesAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.submission.victorio_jetpackpro.R
import data.movies.MovieModel
import org.json.JSONArray
import org.json.JSONObject
import utils.DataDummy
import view.MoviesViewModel
import java.io.InputStream


class MovieFragment : Fragment() {

    private lateinit var  rvMovie : RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val model = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
        model.listResult.observe(requireActivity()) { list: List<MovieModel> ->
            model.loadMovieFromData()

        }
        val dataMovie = DataDummy.generateDummyMovies()
        moviesAdapter = MoviesAdapter()
        moviesAdapter.setMovie(dataMovie)
        rvMovie = view?.findViewById(R.id.rvMovie)!!
        rvMovie.setHasFixedSize(true)
        rvMovie.layoutManager  = LinearLayoutManager(context)
        rvMovie.adapter = moviesAdapter

    }



   // @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
//    private fun rvFromAsset(): String? {
//        val json: String?
//        try {
//            val inputStream: InputStream? = context?.assets?.open("movie.json")
//            json = inputStream?.bufferedReader().use { it?.readText() }
//            val jsonObject = JSONObject(json)
//            val jsonArray = JSONArray(jsonObject.get("movies").toString())
//
//            val mList = ArrayList<MovieModel>()
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
//                            uuid,
//                            title,
//                            director,
//                            poster,
//                            age,
//                            genre,
//                            duration,
//                            it,
//                            category,
//                            releaseDate,
//                            synopsis
//                    )
//                }
//
//                list?.let { mList.add(it) }
//
//
//
//            }
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//            return null
//        }
//        return json
//    }
}