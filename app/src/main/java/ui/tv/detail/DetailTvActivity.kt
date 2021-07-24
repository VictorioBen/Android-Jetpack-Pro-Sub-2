package ui.tv.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.submission.victorio_jetpackpro.R
import com.submission.victorio_jetpackpro.databinding.ActivityDetailTvBinding
import source.entity.tv.TvDetailEntity
import source.entity.tv.TvResultEntity
import ui.tv.TvViewModelFactory
import utils.Helper
import utils.Helper.API_KEY

class DetailTvActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailTvViewModel
    private lateinit var binding: ActivityDetailTvBinding

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val factory = TvViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailTvViewModel::class.java]
        val detailTv = intent.getParcelableExtra<TvResultEntity>(EXTRA_TV)
        val tv = detailTv?.id!!.toInt()

        viewModel.getDetail(tv, API_KEY).observe(this, Observer {
            initTvShow(it)
            binding.tvDtProgressBar.visibility = View.GONE
            binding.includeTv.itemTv.visibility = View.VISIBLE
        })

        setupToolbar(detailTv.originalName.toString())
    }

    private fun initTvShow(tvShowID: TvDetailEntity?) {
        binding.includeTv.txtTitleTvDetail.text = tvShowID?.originalName
        binding.includeTv.txtTagline.text = tvShowID?.tagline
        binding.includeTv.txtFirstAirDate.text = tvShowID?.firstAirDate.toString()
        binding.includeTv.txtSeason.text =  tvShowID?.numberOfSeasons.toString()
        binding.includeTv.txtEpisode.text = tvShowID?.numberOfEpisodes.toString()
        binding.includeTv.txtRuntime.text = tvShowID?.episodeRunTime.toString()
        binding.includeTv.txtSynopsisTvDetail.text = tvShowID?.overview.toString()
        binding.includeTv.txtRateTvDetail.text =  tvShowID?.voteAverage.toString()

        Helper.setImageWithGlide(this,
            Helper.imageFormatter + tvShowID?.posterPath, binding.includeTv.imageTvDetail)

        Helper.setImageWithGlide(this,
            Helper.backdropPathURL + tvShowID?.backdropPath, binding.imgTvPreview)

        when {
            tvShowID?.originalName?.isEmpty() == true -> {
                binding.includeTv.txtTitleTvDetail.text = "-"
            }
            tvShowID?.tagline?.isEmpty() == true -> {
                binding.includeTv.txtTagline.text  = "-"
            }
            tvShowID?.firstAirDate?.isEmpty() == true -> {
                binding.includeTv.txtFirstAirDate.text = "-"
            }
            tvShowID?.numberOfSeasons?.toString()?.isEmpty() == true -> {
                binding.includeTv.txtSeason.text  = "-"
            }
            tvShowID?.numberOfEpisodes?.toString()?.isEmpty() == true -> {
                binding.includeTv.txtEpisode.text = "-"
            }
            tvShowID?.overview?.isEmpty() == true -> {
                binding.includeTv.txtSynopsisTvDetail.text = "-"
            }
            tvShowID?.voteAverage?.toString()?.isEmpty() == true -> {
                binding.includeTv.txtRateTvDetail.text  = "-"
            }

            tvShowID?.episodeRunTime?.toString()?.isEmpty() == true -> {
                binding.includeTv.txtRuntime.text = "-"
            }
        }
    }

    private fun setupToolbar(title: String) {
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarTv)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
        val collapsingToolbarTv = findViewById<CollapsingToolbarLayout>(R.id.collapsing_tv_toolbar)
        collapsingToolbarTv.setExpandedTitleColor(Color.TRANSPARENT)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}