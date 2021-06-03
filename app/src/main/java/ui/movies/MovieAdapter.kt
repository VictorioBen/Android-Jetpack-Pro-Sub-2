package ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import source.remote.response.movie.ResultItem

class MovieAdapter(private val listMovie: MutableList<ResultItem?>? = mutableListOf(),
                   private val onClickListener: ((ResultItem) -> Unit)? = null
) : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {
    private lateinit var view: View

    companion object {
        const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    }

    fun setMovie(movies: List<ResultItem?>?) {
        if (movies == null) return
        this.listMovie?.clear()
        this.listMovie?.addAll(movies)
        notifyDataSetChanged()
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
        return listMovie?.size ?: 0
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movieItem = listMovie?.get(position)
        holder.txtTitle.text = movieItem?.title
        holder.txtGenre.text = movieItem?.genreIds.toString()
        holder.txtRelease.text = movieItem?.releaseDate.toString()
        

        Glide.with(view.context)
                .load(imageFormatter+movieItem?.posterPath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(holder.imageMovie)

        holder.itemView.setOnClickListener {
            if (movieItem != null) {
                onClickListener?.invoke(movieItem)
            }

        }


    }






}