package ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.submission.victorio_jetpackpro.R


class MovieFragment : Fragment() {

    private lateinit var rvMovie: RecyclerView
    private lateinit var viewModel: MovieViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)

            viewModel.getMoviePopular().observe(viewLifecycleOwner) {
                movieAdapter.setMovie(it)
                progressBar.visibility = View.GONE
                movieAdapter.notifyDataSetChanged()
            }

            rvMovie = view.findViewById(R.id.rvMovie)!!
            rvMovie.setHasFixedSize(true)
            rvMovie.layoutManager = LinearLayoutManager(context)
            rvMovie.adapter = movieAdapter



        }


    }


}