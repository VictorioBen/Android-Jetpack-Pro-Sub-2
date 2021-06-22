package ui.detail.movies

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.ResultItem
import ui.movies.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var path: String
    private lateinit var voteAverage: String
    private lateinit var releaseDate: String
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

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar2)
        val movieDetailLayout = findViewById<ConstraintLayout>(R.id.movieDetailLayout)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        val detailMovie = intent.getParcelableExtra<ResultItem>(EXTRA_MOVIE)
        val movie = detailMovie?.id!!.toInt()
        path = detailMovie.posterPath.toString()
        voteAverage = detailMovie.voteAverage.toString()
        releaseDate = detailMovie.releaseDate.toString()

        viewModel.getDetail(movie, API_KEY).observe(this) {
            progressBar.visibility = View.GONE
            movieDetailLayout.visibility = View.VISIBLE
            initMovie(it)

        }
    }


    private fun initMovie(movieID: MovieDetailResponse?) {
        val txtTitle = findViewById<TextView>(R.id.txtTitleDetail)
        val txtGenre = findViewById<TextView>(R.id.txtGenreDetail)
        val txtDuration = findViewById<TextView>(R.id.txtDurationDetail)
        val txtRelease = findViewById<TextView>(R.id.txtRelease)
        val txtStatus = findViewById<TextView>(R.id.txtStatus)
        val imgMovie = findViewById<ImageView>(R.id.imageMovieDetail)
        val txtSynopsis = findViewById<TextView>(R.id.txtSynopsisDetail)
        val txtRating = findViewById<TextView>(R.id.txtRateDetail2)


        txtTitle.text = movieID?.title
        txtGenre.text = movieID?.tagline
        txtDuration.text = movieID?.runtime.toString()
        txtRelease.text = releaseDate
        txtStatus.text = movieID?.status
        txtSynopsis.text = movieID?.overview
        txtRating.text = voteAverage
        Glide.with(this).load(imageFormatter + path).apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)).into(imgMovie)
    }


}







