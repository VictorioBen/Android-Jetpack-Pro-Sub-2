package source.entity.tv

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TvResultEntity(
    val id: Int? = null,
    val originalName: String? = null,
    val posterPath: String? = null,
    val firstAirDate: String? = null,
    val voteAverage: Double? = null
) : Parcelable