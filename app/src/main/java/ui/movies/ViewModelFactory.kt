package ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import source.remote.repository.movie.MovieRepositoryImpl
import ui.movies.detail.DetailMovieViewModel
import utils.Injection

class ViewModelFactory private constructor(private val movieRepositoryImpl: MovieRepositoryImpl) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieRepositoryImpl) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieRepositoryImpl) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}