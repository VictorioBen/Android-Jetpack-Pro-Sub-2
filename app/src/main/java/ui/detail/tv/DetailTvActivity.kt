package ui.detail.tv

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import data.tv.TvShowEntity

class DetailTvActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TV = "extra_tv"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val detailTvShow = intent.getParcelableExtra<TvShowEntity>(EXTRA_TV)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvViewModel::class.java]


         if (detailTvShow != null) {
            val tvShow: TvShowEntity? = detailTvShow
            if (tvShow != null) {
                viewModel.setSelectedDetail(tvShow.tvShowID)
                val getTvShow = viewModel.getTv()
                initTvShow(getTvShow)
            }

        }
    }


    private fun initTvShow(tvShowID: TvShowEntity?) {
        val txtTitle = findViewById<TextView>(R.id.txtTitleTvDetail)
        val txtGenre = findViewById<TextView>(R.id.txtGenreTvDetail)
        val txtDuration = findViewById<TextView>(R.id.txtDurationTvDetail)
        val txtDirector = findViewById<TextView>(R.id.txtDirectorTvDetail)
        val txtAge = findViewById<TextView>(R.id.txtAgeTvDetail)
        val imgMovie = findViewById<ImageView>(R.id.imageTvDetail)
        val txtSynopsis = findViewById<TextView>(R.id.txtSynopsisTvDetail)
        val txtRating = findViewById<TextView>(R.id.txtRateTvDetail)

        txtTitle.text = tvShowID?.title
        txtGenre.text = tvShowID?.genre
        txtDuration.text = tvShowID?.duration
        txtDirector.text = tvShowID?.director
        txtAge.text = tvShowID?.age
        txtSynopsis.text = tvShowID?.synopsis
        txtRating.text = tvShowID?.rating.toString()
        Glide.with(this).load(tvShowID?.poster).apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)).into(imgMovie)
    }
}