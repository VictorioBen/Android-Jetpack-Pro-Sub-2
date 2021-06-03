package source.remote.response.tv

data class GenreTvResponse(
	val genres: List<TvGenresItem?>? = null
)

data class TvGenresItem(
	val name: String? = null,
	val id: Int? = null
)

