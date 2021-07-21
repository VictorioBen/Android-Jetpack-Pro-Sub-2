package ui.tv


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import source.remote.repository.tv.TvRepositoryImpl
import ui.tv.detail.DetailTvViewModel
import utils.Injection

class TvViewModelFactory private constructor(private val tvRepositoryImpl: TvRepositoryImpl) :
        ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: TvViewModelFactory? = null

        fun getInstance(): TvViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: TvViewModelFactory(Injection.provideTvRepository()).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(tvRepositoryImpl) as T
            }
            modelClass.isAssignableFrom(DetailTvViewModel::class.java) -> {
                DetailTvViewModel(tvRepositoryImpl) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}