package source.remote.response.tv

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponseDetail(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("original_name")
	val originalName: String? = null,

	@field:SerializedName("tagline")
	val tagline: String? = null,

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	@field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int? = null,

	@field:SerializedName("number_of_episodes")
	val numberOfEpisodes: Int? = null,

	@field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int?>? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null

) : Parcelable


