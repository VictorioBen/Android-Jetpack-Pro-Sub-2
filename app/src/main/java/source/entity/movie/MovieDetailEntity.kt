package source.entity.movie

import com.google.gson.annotations.SerializedName


data class MovieDetailEntity(
    val title: String? = null,
    val id: Int? = null,
    val overview: String? = null,
    val runtime: Int? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = null,
    val tagline: String? = null,
    val status: String? = null
)

