package ui.detail.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import source.entity.tv.TvDetailEntity
import source.remote.repository.tv.TvRepositoryImpl
import ui.tv.detail.DetailTvViewModel
import utils.Helper.API_KEY
import utils.dataDummy.GenerateDataDummy

@RunWith(MockitoJUnitRunner::class)
class TvMovieViewModelTest {
    private lateinit var viewModel: DetailTvViewModel
    private val dummyTv = GenerateDataDummy.generateDummyTvDetail()[0]
    private val tvID = dummyTv.id!!

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: TvRepositoryImpl

    @Mock
    private lateinit var observer: Observer<TvDetailEntity>


    @Before
    fun setUp() {
        viewModel = DetailTvViewModel(tvRepository)
    }


    @Test
    fun getDetailMovie() {
        val tvDummy = MutableLiveData<TvDetailEntity>()
        tvDummy.value = dummyTv
        `when`(tvRepository.getDetailTv(tvID, API_KEY)).thenReturn(tvDummy)
        val tvDetailEntity = viewModel.getDetail(tvID, API_KEY).value as TvDetailEntity

        assertNotNull(tvDetailEntity)
        assertEquals(dummyTv.id, tvDetailEntity.id)
        assertEquals(dummyTv.originalName, tvDetailEntity.originalName)
        assertEquals(dummyTv.tagline, tvDetailEntity.tagline)
        assertEquals(dummyTv.firstAirDate, tvDetailEntity.firstAirDate)
        assertEquals(dummyTv.numberOfSeasons, tvDetailEntity.numberOfSeasons)
        assertEquals(dummyTv.numberOfEpisodes, tvDetailEntity.numberOfEpisodes)
        assertEquals(dummyTv.episodeRunTime, tvDetailEntity.episodeRunTime)
        assertEquals(dummyTv.overview, tvDetailEntity.overview)
        assertEquals(dummyTv.voteAverage, tvDetailEntity.voteAverage)
        assertEquals(dummyTv.posterPath, tvDetailEntity.posterPath)
        assertEquals(dummyTv.backdropPath, tvDetailEntity.backdropPath)

        viewModel.getDetail(tvID, API_KEY).observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }


}