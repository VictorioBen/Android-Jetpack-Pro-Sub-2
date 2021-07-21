package ui.tv.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import source.entity.tv.TvDetailEntity
import source.remote.repository.tv.TvRepositoryImpl

class DetailTvViewModel(private  val tvRepositoryImpl: TvRepositoryImpl) : ViewModel(){

    fun getDetail(tvId: Int, api:String): LiveData<TvDetailEntity> = tvRepositoryImpl.getDetailTv(tvId, api)


}
