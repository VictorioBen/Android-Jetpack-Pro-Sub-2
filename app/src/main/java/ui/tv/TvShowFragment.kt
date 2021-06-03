package ui.tv

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
import ui.detail.tv.DetailTvActivity


class TvShowFragment : Fragment() {
    private lateinit var rvTvShow: RecyclerView
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var viewModel: TvShowViewModel

    companion object {
        const val API = "0f39d26119b683bda02291ee16a9a348"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_tv_show, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if (activity != null) {
            viewModel = ViewModelProvider(requireActivity()).get(TvShowViewModel::class.java)
            initData(API)
            viewModel.listTvResult.observe(requireActivity()) {

                tvShowAdapter.setTvShow(it)
            }
            tvShowAdapter = TvShowAdapter(onClickListener = {
                val intent = Intent(requireActivity(), DetailTvActivity::class.java)
                intent.putExtra(DetailTvActivity.EXTRA_TV, it)
                startActivity(intent)
            })

            rvTvShow = view.findViewById(R.id.rvTvShow)
            rvTvShow.setHasFixedSize(true)
            rvTvShow.layoutManager = LinearLayoutManager(context)
            rvTvShow.adapter = tvShowAdapter

        }


    }

    private fun initData(api: String) {
        viewModel.onResponseTv(api)
    }


}