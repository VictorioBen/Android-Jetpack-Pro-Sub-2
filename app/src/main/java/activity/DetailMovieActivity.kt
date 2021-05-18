package activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.submission.victorio_jetpackpro.R
import com.submission.victorio_jetpackpro.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var detailContentBinding: ActivityDetailMovieBinding
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val activityDetailCourseBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
       // detailContentBinding = ActivityDetailMovieBinding.det

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
