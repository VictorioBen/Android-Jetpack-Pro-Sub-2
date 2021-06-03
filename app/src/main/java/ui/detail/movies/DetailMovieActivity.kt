package ui.detail.movies

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import data.movies.MovieEntity

class DetailMovieActivity : AppCompatActivity() {


    companion object {
        const val EXTRA_MOVIE = "extra_movie"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailMovie = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)


        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        if (detailMovie != null) {
            val movie: MovieEntity? = detailMovie
            if (movie != null) {
                viewModel.setSelectedDetail(movie.movieID)
                val getMovie = viewModel.getMovie()
                initMovie(getMovie)
            }
        }

    }

    private fun initMovie(movieID: MovieEntity?) {
        val txtTitle = findViewById<TextView>(R.id.txtTitleDetail)
        val txtGenre = findViewById<TextView>(R.id.txtGenreDetail)
        val txtDuration = findViewById<TextView>(R.id.txtDurationDetail)
        val txtDirector = findViewById<TextView>(R.id.txtDirectorDetail)
        val txtAge = findViewById<TextView>(R.id.txtAgeDetail)
        val imgMovie = findViewById<ImageView>(R.id.imageMovieDetail)
        val txtSynopsis = findViewById<TextView>(R.id.txtSynopsisDetail)
        val txtRating = findViewById<TextView>(R.id.txtRateDetail)


        txtTitle.text = movieID?.title
        txtGenre.text = movieID?.genre
        txtDuration.text = movieID?.duration
        txtDirector.text = movieID?.director
        txtAge.text = movieID?.age
        txtSynopsis.text = movieID?.synopsis
        txtRating.text = movieID?.rating.toString()
        Glide.with(this).load(movieID?.poster).apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)).into(imgMovie)
    }


}
