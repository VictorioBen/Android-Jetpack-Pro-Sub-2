package ui.movies


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.remote.repository.movie.MovieRepository
import source.remote.response.movie.ResultItem


class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

        fun getMoviePopular(): LiveData<List<ResultItem>> = movieRepository.getPopularMovie()


}




