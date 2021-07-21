package repository

import androidx.lifecycle.LiveData
import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.ResultItem

interface FakeMovieDataSource {

    fun getPopularMovie(): LiveData<List<ResultItem>>

    fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailResponse>

}