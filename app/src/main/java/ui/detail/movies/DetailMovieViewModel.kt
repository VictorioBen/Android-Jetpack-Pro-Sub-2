package ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.remote.repository.movie.MovieRepository
import source.remote.response.movie.MovieDetailResponse
import utils.dataDummy.DataDummy

class DetailMovieViewModel(private val movieRepository: MovieRepository): ViewModel() {



     fun getDetail(movieId: Int, api:String): LiveData<MovieDetailResponse> = movieRepository.getDetailMovie(movieId, api)


}