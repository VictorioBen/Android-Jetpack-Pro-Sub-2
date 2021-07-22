package utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {

    const val API_KEY = "0f39d26119b683bda02291ee16a9a348"
    const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    const val backdropPathURL = "https://image.tmdb.org/t/p/original"

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }
}