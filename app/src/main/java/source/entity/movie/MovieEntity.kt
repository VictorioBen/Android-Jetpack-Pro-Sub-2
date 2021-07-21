package source.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    val page: Int? = null,
    val totalPages: Int? = null,
    val results: List<MovieResultEntity?>? = null,
    val totalResults: Int? = null
) : Parcelable

@Parcelize
data class MovieResultEntity(
    val id: Int? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = null
) : Parcelable
