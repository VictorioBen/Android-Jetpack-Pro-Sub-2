package ui.movies.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.submission.victorio_jetpackpro.R
import com.submission.victorio_jetpackpro.databinding.ActivityDetailMovieBinding
import source.entity.movie.MovieDetailEntity
import source.entity.movie.MovieResultEntity
import ui.movies.ViewModelFactory
import utils.Helper.API_KEY
import utils.Helper.backdropPathURL
import utils.Helper.imageFormatter
import utils.Helper.setImageWithGlide

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var binding: ActivityDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        val detailMovie = intent.getParcelableExtra<MovieResultEntity>(EXTRA_MOVIE)
        val movie = detailMovie?.id!!.toInt()

        viewModel.getDetail(movie, API_KEY).observe(this, Observer {
            initMovie(it)
            binding.mvDtProgressBar.visibility = View.GONE
            binding.includeMovie.itemMovie.visibility = View.VISIBLE
        })

        setupToolbar(detailMovie.title.toString())
    }

    private fun initMovie(movieID: MovieDetailEntity?) {
        binding.includeMovie.txtMvTitleDetail.text = movieID?.title
        binding.includeMovie.txtMvTaglineDetail.text = movieID?.tagline
        binding.includeMovie.txtMvDurationDetail.text =  movieID?.runtime.toString()
        binding.includeMovie.txtMvRelease.text =  movieID?.releaseDate.toString()
        binding.includeMovie.txtMvStatus.text =  movieID?.status
        binding.includeMovie.txtMvSynopsisDetail.text =  movieID?.overview
        binding.includeMovie.txtMvRateDetail.text = movieID?.voteAverage.toString()

        setImageWithGlide(this, imageFormatter + movieID?.posterPath, binding.includeMovie.imageMovieDetail)

        setImageWithGlide(this, backdropPathURL + movieID?.backdropPath, binding.imgMoviePreview)

        when {
            movieID?.title?.isEmpty() == true -> {
                binding.includeMovie.txtMvTitleDetail.text = "-"
            }
            movieID?.tagline?.isEmpty() == true -> {
                binding.includeMovie.txtMvTaglineDetail.text = "-"
            }
            movieID?.runtime?.toString()?.isEmpty() == true -> {
                binding.includeMovie.txtMvDurationDetail.text = "-"
            }
            movieID?.releaseDate?.isEmpty() == true -> {
                binding.includeMovie.txtMvRelease.text = "-"
            }
            movieID?.status?.isEmpty() == true -> {
                binding.includeMovie.txtMvStatus.text = "-"
            }
            movieID?.overview?.isEmpty() == true -> {
                binding.includeMovie.txtMvSynopsisDetail.text = "-"
            }
            movieID?.voteAverage?.toString()?.isEmpty() == true -> {
                binding.includeMovie.txtMvRateDetail.text = "-"
            }
        }
    }

    private fun setupToolbar(title: String) {
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}







