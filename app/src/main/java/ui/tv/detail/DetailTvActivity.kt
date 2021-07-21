package ui.tv.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import source.entity.tv.TvDetailEntity
import source.entity.tv.TvResultEntity
import ui.movies.detail.DetailMovieActivity
import ui.tv.TvViewModelFactory

class DetailTvActivity : AppCompatActivity() {
    private lateinit var path: String
    private lateinit var viewModel: DetailTvViewModel


    companion object {
        const val EXTRA_TV = "extra_tv"
        const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val progressBar = findViewById<ProgressBar>(R.id.tv_dt_progress_bar)
        val tvDetailLayout = findViewById<ConstraintLayout>(R.id.tv_dt_frame)

        val factory = TvViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailTvViewModel::class.java]
        val detailTv = intent.getParcelableExtra<TvResultEntity>(EXTRA_TV)
        val tv = detailTv?.id!!.toInt()
        path = detailTv.posterPath.toString()


        viewModel.getDetail(tv, DetailMovieActivity.API_KEY).observe(this, Observer {
            initTvShow(it)
            progressBar.visibility = View.GONE
            tvDetailLayout.visibility = View.VISIBLE
        })
    }

    private fun initTvShow(tvShowID: TvDetailEntity?) {

        val txtTitle = findViewById<TextView>(R.id.txtTitleTvDetail)
        val txtTagline = findViewById<TextView>(R.id.txtTagline)
        val txtFirstAirDate = findViewById<TextView>(R.id.txtFirstAirDate)
        val txtSeason = findViewById<TextView>(R.id.txtSeason)
        val txtEpisode = findViewById<TextView>(R.id.txtEpisode)
        val txtRuntime = findViewById<TextView>(R.id.txtRuntime)
        val imgMovie = findViewById<ImageView>(R.id.imageTvDetail)
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
        Glide.with(this).load(imageFormatter + path)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(imgMovie)

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
}