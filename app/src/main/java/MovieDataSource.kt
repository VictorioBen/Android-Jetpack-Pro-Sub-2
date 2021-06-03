import data.movies.MovieEntity
import data.tv.TvShowEntity

interface MovieDataSource {


    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShow(): List<TvShowEntity>

    fun getMoviesDetail(movieID: String?): MovieEntity

    fun getTvShowDetail(tvShowID: String?): TvShowEntity
}