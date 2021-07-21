package source.remote.repository.movie

import androidx.lifecycle.LiveData
import source.entity.MovieResultEntity
import source.entity.movie.MovieDetailEntity
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResultItem

interface MovieRepository {

    fun getPopularMovie(): LiveData<List<MovieResultEntity>>

    fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailEntity>

}