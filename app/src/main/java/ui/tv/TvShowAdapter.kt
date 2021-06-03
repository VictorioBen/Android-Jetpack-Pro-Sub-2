package ui.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import source.remote.response.tv.ResultsItem

class TvShowAdapter(private val listTvShow: MutableList<ResultsItem?>? = mutableListOf(),
                    private val onClickListener: ((ResultsItem) -> Unit)? = null
) : RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {
    private lateinit var view: View

    companion object {
        const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    }


    fun setTvShow(tvShow: List<ResultsItem?>?) {
        if (tvShow == null) return
        this.listTvShow?.clear()
        this.listTvShow?.addAll(tvShow)
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
        return listTvShow?.size ?: 0
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movieItem = listTvShow?.get(position)
        holder.txtTitle.text = movieItem?.originalName
        holder.txtGenre.text = movieItem?.genreIds.toString()
        holder.txtRelease.text = movieItem?.firstAirDate.toString()



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