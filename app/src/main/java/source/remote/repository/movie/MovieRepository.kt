package source.remote.repository.movie

import androidx.lifecycle.LiveData
import source.entity.movie.MovieResultEntity
import source.entity.movie.MovieDetailEntity

interface MovieRepository {

    fun getPopularMovie(): LiveData<List<MovieResultEntity>>

    fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailEntity>

}