package ui.movies

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import source.remote.response.movie.ResultItem
import ui.detail.movies.DetailMovieActivity

class MovieAdapter :
        RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listMovie = ArrayList<ResultItem>()

    private lateinit var view: View

    companion object {
        const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    }

    fun setMovie(movie: List<ResultItem>) {
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtGenre: TextView = itemView.findViewById(R.id.txtGenre)
        val txtRelease: TextView = itemView.findViewById(R.id.txtRelease)
        val imageMovie: ImageView = itemView.findViewById(R.id.imageMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movieItem = listMovie[position]
        val getId = movieItem.id
        holder.txtTitle.text = movieItem.title
        holder.txtGenre.text = movieItem.voteAverage.toString()
        holder.txtRelease.text = movieItem.releaseDate.toString()


        Glide.with(view.context)
                .load(imageFormatter + movieItem.posterPath)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error)
                )
                .into(holder.imageMovie)

        holder.itemView.setOnClickListener {

            //Toast.makeText(holder.itemView.context, getId.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movieItem)
            holder.itemView.context.startActivity(intent)

        }


    }


}