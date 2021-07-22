package ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.submission.victorio_jetpackpro.R
import source.entity.tv.TvResultEntity
import ui.tv.detail.DetailTvActivity

class TvShowAdapter :
        RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {

    private var listTv = ArrayList<TvResultEntity>()

    private lateinit var view: View

    companion object {
        const val imageFormatter = "https://image.tmdb.org/t/p/w500"
    }

    fun setMovie(tv: List<TvResultEntity>) {
        this.listTv.clear()
        this.listTv.addAll(tv)
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtGenre: TextView = itemView.findViewById(R.id.txtGenre)
        val txtRelease: TextView = itemView.findViewById(R.id.txtRelease)
        val imageMovie: ImageView = itemView.findViewById(R.id.imageMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTv.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tvItem = listTv[position]

        holder.txtTitle.text = tvItem.originalName
        holder.txtGenre.text = tvItem.voteAverage.toString()
        holder.txtRelease.text = tvItem.firstAirDate.toString()


        Glide.with(view.context)
                .load(imageFormatter + tvItem.posterPath)
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error)
                )
                .into(holder.imageMovie)

        holder.itemView.setOnClickListener {


            val intent = Intent(holder.itemView.context, DetailTvActivity::class.java)
            intent.putExtra(DetailTvActivity.EXTRA_TV, tvItem)
            holder.itemView.context.startActivity(intent)

        }


    }


}