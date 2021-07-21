package ui.tv

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


class TvShowFragment : Fragment() {
    private lateinit var rvTvShow: RecyclerView
    private lateinit var viewModel: TvShowViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tv_show, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if (activity != null) {
            val factory = TvViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()
            val progressBar = view.findViewById<ProgressBar>(R.id.tv_progress_bar)

            viewModel.getTvPopular().observe(viewLifecycleOwner) {
                progressBar.visibility = View.GONE
                tvShowAdapter.setMovie(it)
                tvShowAdapter.notifyDataSetChanged()
            }

            rvTvShow = view.findViewById(R.id.rvTvShow)!!
            rvTvShow.setHasFixedSize(true)
            rvTvShow.layoutManager = LinearLayoutManager(context)
            rvTvShow.adapter = tvShowAdapter


        }

    }


}