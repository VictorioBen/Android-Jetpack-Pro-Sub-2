package ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.entity.movie.MovieDetailEntity
import source.remote.repository.movie.MovieRepositoryImpl
import source.remote.response.movie.MovieDetailResponse

class DetailMovieViewModel(private val movieRepositoryImpl: MovieRepositoryImpl): ViewModel() {



    fun getDetail(movieId: Int, api:String): LiveData<MovieDetailEntity> = movieRepositoryImpl.getDetailMovie(movieId, api)


}