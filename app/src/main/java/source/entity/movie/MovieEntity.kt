package source.entity.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class MovieResultEntity(
    val id: Int? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = null
) : Parcelable
