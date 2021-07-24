package ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.victorio_jetpackpro.databinding.FragmentTvShowBinding


class TvShowFragment : Fragment() {
    private lateinit var viewModel: TvShowViewModel
    private lateinit var _binding: FragmentTvShowBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = TvViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()


            viewModel.getTvPopular().observe(viewLifecycleOwner) {
                binding.tvProgressBar.visibility = View.GONE
                tvShowAdapter.setMovie(it)
                tvShowAdapter.notifyDataSetChanged()
            }

            binding.rvTvShow.setHasFixedSize(true)
            binding.rvTvShow.layoutManager = LinearLayoutManager(context)
            binding.rvTvShow.adapter = tvShowAdapter


        }

    }


}