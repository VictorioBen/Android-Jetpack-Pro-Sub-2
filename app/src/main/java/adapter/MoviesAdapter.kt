package adapter

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.submission.victorio_jetpackpro.R
import data.movies.MovieEntity

import data.movies.MovieModel

class MoviesAdapter (private val listMovie: MutableList<MovieEntity>? = mutableListOf(),
                     private val onClickListener: ((MovieEntity) -> Unit)? = null
                    ):RecyclerView.Adapter<MoviesAdapter.ListViewHolder>()
{
    private  lateinit var view: View


    fun setMovie(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovie?.clear()
        this.listMovie?.addAll(movies)
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
        val txtGenre : TextView = itemView.findViewById(R.id.txtGenre)
        val txtRelease : TextView = itemView.findViewById(R.id.txtRelease)
        val imageMovie  : ImageView = itemView.findViewById(R.id.imageMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
            return listMovie?.size ?:0
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val movieItem = listMovie?.get(position)
            holder.txtTitle.text = movieItem?.title
            holder.txtGenre.text = movieItem?.genre
            holder.txtRelease.text = movieItem?.release_date

            val res: Resources = view.context.resources
            val urlImage: String? = movieItem?.poster
            val resID: Int = res.getIdentifier(urlImage, "", view.context.packageName)
            val drawable: Drawable? = res.getDrawableForDensity(resID, DisplayMetrics.DENSITY_XXHIGH, null)

            holder.imageMovie.setImageDrawable(drawable)

        holder.itemView.setOnClickListener {
            if (movieItem != null) {
                onClickListener?.invoke(movieItem)
            }

        }
    }



}