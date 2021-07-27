package repository.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import source.entity.tv.TvDetailEntity
import source.entity.tv.TvResultEntity
import source.remote.RemoteDataSourceImpl
import source.remote.repository.tv.TvRepository
import source.remote.response.tv.TvResponseDetail
import source.remote.response.tv.TvResultsItem

class FakeTvRepository(private val remoteDataSourceImpl: RemoteDataSourceImpl) :
    TvRepository {


    override fun getTvPopular(): LiveData<List<TvResultEntity>> {
        val tvResult = MutableLiveData<List<TvResultEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSourceImpl.getTvPopular(object : RemoteDataSourceImpl.LoadTvCallback {
                override fun onAllTvReceived(moduleResponses: List<TvResultsItem?>) {
                    val tvList = ArrayList<TvResultEntity>()
                    for (response in moduleResponses) {
                        val tv = TvResultEntity(
                            response?.id,
                            response?.originalName,
                            response?.posterPath,
                            response?.firstAirDate,
                            response?.voteAverage
                        )
                        tvList.add(tv)
                    }
                    tvResult.postValue(tvList)
                }
            })
        }

        return tvResult
    }

    override fun getDetailTv(tvId: Int, apiKey: String): LiveData<TvDetailEntity> {
        val tvDetailResult = MutableLiveData<TvDetailEntity>()
        CoroutineScope(IO).launch {
            remoteDataSourceImpl.getDetailTv(
                tvId,
                object : RemoteDataSourceImpl.LoadDetailTvCallback {
                    override fun onAllDetailTvReceived(tvResponseDetail: TvResponseDetail) {
                        val tvDetail = TvDetailEntity(
                            tvResponseDetail.id,
                            tvResponseDetail.originalName,
                            tvResponseDetail.tagline,
                            tvResponseDetail.firstAirDate,
                            tvResponseDetail.numberOfSeasons,
                            tvResponseDetail.numberOfEpisodes,
                            tvResponseDetail.episodeRunTime,
                            tvResponseDetail.overview,
                            tvResponseDetail.voteAverage,
                            tvResponseDetail.posterPath,
                            tvResponseDetail.backdropPath
                        )
                        tvDetailResult.postValue(tvDetail)
                    }

                })
        }
        return tvDetailResult
    }


}