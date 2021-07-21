package ui.movies


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.entity.movie.MovieResultEntity
import source.remote.repository.movie.MovieRepositoryImpl


class MovieViewModel(private val movieRepositoryImpl: MovieRepositoryImpl) : ViewModel() {

     fun getMoviePopular(): LiveData<List<MovieResultEntity>> =
        movieRepositoryImpl.getPopularMovie()

}




