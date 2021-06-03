package source.remote.response.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreMovieResponse(
	val genres: List<MovieGenresItem?>? = null
):Parcelable

@Parcelize
data class MovieGenresItem(
	val name: String? = null,
	val id: Int? = null
):Parcelable

