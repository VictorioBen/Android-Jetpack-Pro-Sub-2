package ui.tv

import androidx.lifecycle.ViewModel
import data.tv.TvShowEntity
import utils.dataDummy.DataDummy

class TvShowViewModel: ViewModel(){


    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShow()


}