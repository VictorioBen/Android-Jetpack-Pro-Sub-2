package ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.submission.victorio_jetpackpro.R
import ui.detail.movies.DetailMovieActivity


class MovieFragment : Fragment() {

    private lateinit var rvMovie: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel

    companion object {
        const val API_KEY = "0f39d26119b683bda02291ee16a9a348"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            viewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
            initData(API_KEY)
            viewModel.listResult.observe(requireActivity()) {

                movieAdapter.setMovie(it)

            }
            movieAdapter = MovieAdapter(onClickListener = {
                val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, it)
                startActivity(intent)

            })

            rvMovie = view.findViewById(R.id.rvMovie)!!
            rvMovie.setHasFixedSize(true)
            rvMovie.layoutManager = LinearLayoutManager(context)
            rvMovie.adapter = movieAdapter

        }


    }

    private fun initData(api: String) {

        viewModel.onResponse(api)
    }


}