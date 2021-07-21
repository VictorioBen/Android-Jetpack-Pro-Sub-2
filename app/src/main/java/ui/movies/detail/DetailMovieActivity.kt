package ui.movies.detail

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
import source.entity.MovieResultEntity
import source.entity.movie.MovieDetailEntity
import ui.movies.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var path: String
    private lateinit var viewModel: DetailMovieViewModel

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val API_KEY = "0f39d26119b683bda02291ee16a9a348"
        const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val progressBar = findViewById<ProgressBar>(R.id.mv_dt_progress_bar)
        val movieDetailLayout = findViewById<ConstraintLayout>(R.id.movieDetailLayout)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        val detailMovie = intent.getParcelableExtra<MovieResultEntity>(EXTRA_MOVIE)
        val movie = detailMovie?.id!!.toInt()
        path = detailMovie.posterPath.toString()


        viewModel.getDetail(movie, API_KEY).observe(this, Observer {
            initMovie(it)
            progressBar.visibility = View.GONE
            movieDetailLayout.visibility = View.VISIBLE
        })
    }

    private fun initMovie(movieID: MovieDetailEntity?) {
        val txtTitle = findViewById<TextView>(R.id.txtTitleDetail)
        val txtTagline = findViewById<TextView>(R.id.txtGenreDetail)
        val txtDuration = findViewById<TextView>(R.id.txtDurationDetail)
        val txtRelease = findViewById<TextView>(R.id.txtRelease)
        val txtStatus = findViewById<TextView>(R.id.txtStatus)
        val imgMovie = findViewById<ImageView>(R.id.imageMovieDetail)
        val txtSynopsis = findViewById<TextView>(R.id.txtSynopsisDetail)
        val txtRating = findViewById<TextView>(R.id.txtRateDetail2)

        txtTitle.text = movieID?.title
        txtTagline.text = movieID?.tagline
        txtDuration.text = movieID?.runtime.toString()
        txtRelease.text = movieID?.releaseDate.toString()
        txtStatus.text = movieID?.status
        txtSynopsis.text = movieID?.overview
        txtRating.text = movieID?.voteAverage.toString()
        Glide.with(this).load(imageFormatter + path).apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
        ).into(imgMovie)

        when {
            movieID?.title?.isEmpty() == true -> {
                txtTitle.text = "-"
            }
            movieID?.tagline?.isEmpty() == true -> {
                txtTagline.text = "-"
            }
            movieID?.runtime?.toString()?.isEmpty() == true -> {
                txtDuration.text = "-"
            }
            movieID?.releaseDate?.isEmpty() == true -> {
                txtRelease.text = "-"
            }
            movieID?.status?.isEmpty() == true -> {
                txtStatus.text = "-"
            }
            movieID?.overview?.isEmpty() == true -> {
                txtSynopsis.text = "-"
            }
            movieID?.voteAverage?.toString()?.isEmpty() == true -> {
                txtRating.text = "-"
            }
        }
    }


}







