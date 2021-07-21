package ui.movies


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.entity.MovieResultEntity
import source.remote.repository.movie.MovieRepositoryImpl
import source.remote.response.movie.MovieResultItem


class MovieViewModel(private val movieRepositoryImpl: MovieRepositoryImpl) : ViewModel() {

     fun getMoviePopular(): LiveData<List<MovieResultEntity>> =
        movieRepositoryImpl.getPopularMovie()

}




