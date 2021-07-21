package ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.entity.tv.TvResultEntity
import source.remote.repository.tv.TvRepositoryImpl

class TvShowViewModel(private val tvRepositoryImpl: TvRepositoryImpl) : ViewModel() {

    fun getTvPopular(): LiveData<List<TvResultEntity>> = tvRepositoryImpl.getTvPopular()


}