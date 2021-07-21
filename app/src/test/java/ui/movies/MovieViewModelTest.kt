package ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import repository.FakeRepository
import source.remote.response.movie.ResultItem

class MovieViewModelTest(private val movieRepository: FakeRepository) : ViewModel() {

    fun getMoviePopular(): LiveData<List<ResultItem>> = movieRepository.getPopularMovie()


}