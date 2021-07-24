package ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.victorio_jetpackpro.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var _binding: FragmentMovieBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            viewModel.getMoviePopular().observe(viewLifecycleOwner) {
                movieAdapter.setMovie(it)
                binding.progressBar.visibility = View.GONE
                movieAdapter.notifyDataSetChanged()
            }


            binding.rvMovie.setHasFixedSize(true)
            binding.rvMovie.layoutManager = LinearLayoutManager(context)
            binding.rvMovie.adapter = movieAdapter


        }


    }


}