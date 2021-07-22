package ui.tv.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.submission.victorio_jetpackpro.R
import source.entity.tv.TvDetailEntity
import source.entity.tv.TvResultEntity
import ui.tv.TvViewModelFactory
import utils.Helper
import utils.Helper.API_KEY

class DetailTvActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailTvViewModel


    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        val progressBar = findViewById<ProgressBar>(R.id.tv_dt_progress_bar)
        val tvDetailLayout = findViewById<ConstraintLayout>(R.id.tv_dt_frame)

        val factory = TvViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailTvViewModel::class.java]
        val detailTv = intent.getParcelableExtra<TvResultEntity>(EXTRA_TV)
        val tv = detailTv?.id!!.toInt()



        viewModel.getDetail(tv, API_KEY).observe(this, Observer {
            initTvShow(it)
            progressBar.visibility = View.GONE
            tvDetailLayout.visibility = View.VISIBLE
        })

        setupToolbar(detailTv.originalName.toString())
    }

    private fun initTvShow(tvShowID: TvDetailEntity?) {

        val txtTitle = findViewById<TextView>(R.id.txtTitleTvDetail)
        val txtTagline = findViewById<TextView>(R.id.txtTagline)
        val txtFirstAirDate = findViewById<TextView>(R.id.txtFirstAirDate)
        val txtSeason = findViewById<TextView>(R.id.txtSeason)
        val txtEpisode = findViewById<TextView>(R.id.txtEpisode)
        val txtRuntime = findViewById<TextView>(R.id.txtRuntime)
        val imgMovie = findViewById<ImageView>(R.id.imageTvDetail)
        val backdropPathTv = findViewById<ImageView>(R.id.imgTvPreview)
        val txtOverview = findViewById<TextView>(R.id.txtSynopsisTvDetail)
        val txtVoteAverage = findViewById<TextView>(R.id.txtRateTvDetail)

        txtTitle.text = tvShowID?.originalName
        txtTagline.text = tvShowID?.tagline
        txtFirstAirDate.text = tvShowID?.firstAirDate.toString()
        txtSeason.text = tvShowID?.numberOfSeasons.toString()
        txtEpisode.text = tvShowID?.numberOfEpisodes.toString()
        txtRuntime.text = tvShowID?.episodeRunTime.toString()
        txtOverview.text = tvShowID?.overview
        txtVoteAverage.text = tvShowID?.voteAverage.toString()

        Helper.setImageWithGlide(this, Helper.imageFormatter + tvShowID?.posterPath, imgMovie)

        Helper.setImageWithGlide(this, Helper.backdropPathURL + tvShowID?.backdropPath, backdropPathTv)

        when {
            tvShowID?.originalName?.isEmpty() == true -> {
                txtTitle.text = "-"
            }
            tvShowID?.tagline?.isEmpty() == true -> {
                txtTagline.text = "-"
            }
            tvShowID?.firstAirDate?.isEmpty() == true -> {
                txtFirstAirDate.text = "-"
            }
            tvShowID?.numberOfSeasons?.toString()?.isEmpty() == true -> {
                txtSeason.text = "-"
            }
            tvShowID?.numberOfEpisodes?.toString()?.isEmpty() == true -> {
                txtEpisode.text = "-"
            }
            tvShowID?.overview?.isEmpty() == true -> {
                txtRuntime.text = "-"
            }
            tvShowID?.voteAverage?.toString()?.isEmpty() == true -> {
                txtOverview.text = "-"
            }

            tvShowID?.episodeRunTime?.toString()?.isEmpty() == true -> {
                txtRuntime.text = "-"
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