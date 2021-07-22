package source.entity.tv

data class TvDetailEntity(
    val id: Int? = null,
    val originalName: String? = null,
    val tagline: String? = null,
    val firstAirDate: String? = null,
    val numberOfSeasons: Int? = null,
    val numberOfEpisodes: Int? = null,
    val episodeRunTime: List<Int?>? = null,
    val overview: String? = null,
    val voteAverage: Double? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null
)
