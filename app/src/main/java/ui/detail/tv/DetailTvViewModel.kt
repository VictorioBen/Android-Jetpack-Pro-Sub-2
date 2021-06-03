package ui.detail.tv

import androidx.lifecycle.ViewModel
import data.tv.TvShowEntity
import utils.dataDummy.DataDummy

class DetailTvViewModel : ViewModel(){

    private lateinit var detailID: String

    fun setSelectedDetail(detailID: String) {
        this.detailID = detailID
    }

    fun getTv(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvEntities = DataDummy.generateDummyTvShow()
        for (tvEntity in tvEntities){
            if (tvEntity.tvShowID == detailID){
                tvShow = tvEntity
            }
        }
        return tvShow
    }
}
