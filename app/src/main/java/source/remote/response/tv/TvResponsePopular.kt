package source.remote.response.tv

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponsePopular(

		@field:SerializedName("page")
		val page: Int? = null,

		@field:SerializedName("total_pages")
		val totalPages: Int? = null,

		@field:SerializedName("results")
		val results: List<TvResultsItem?>? = null,

		@field:SerializedName("total_results")
		val totalResults: Int? = null


) : Parcelable

@Parcelize
data class TvResultsItem(

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("original_name")
		val originalName: String? = null,

		@field:SerializedName("poster_path")
		val posterPath: String? = null,

		@field:SerializedName("first_air_date")
		val firstAirDate: String? = null,

		@field:SerializedName("vote_average")
		val voteAverage: Double? = null


) : Parcelable

