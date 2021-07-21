package source.remote.repository.tv

import androidx.lifecycle.LiveData
import source.entity.tv.TvDetailEntity
import source.entity.tv.TvResultEntity


interface TvRepository {
    fun getTvPopular(): LiveData<List<TvResultEntity>>

    fun getDetailTv(tvId: Int, apiKey: String): LiveData<TvDetailEntity>
}