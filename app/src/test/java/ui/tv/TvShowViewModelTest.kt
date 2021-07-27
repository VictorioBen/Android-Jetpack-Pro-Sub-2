package ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import source.entity.tv.TvResultEntity
import source.remote.repository.tv.TvRepositoryImpl
import utils.dataDummy.GenerateDataDummy

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var  viewModel: TvShowViewModel
    private val listTv = GenerateDataDummy.generateDummyTvShow()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: TvRepositoryImpl

    @Mock
    private lateinit var observer: Observer<List<TvResultEntity>>

    @Before
    fun setUp(){
        viewModel =  TvShowViewModel(tvRepository)
    }


    @Test
    fun getTvPopular() {
        val tvResultEntity = MutableLiveData<List<TvResultEntity>>()
        tvResultEntity.value = listTv

        Mockito.`when`(tvRepository.getTvPopular()).thenReturn(tvResultEntity)

        val listTvPopular = viewModel.getTvPopular().value

        Mockito.verify(tvRepository).getTvPopular()
        Assert.assertNotNull(listTvPopular)
        Assert.assertEquals(10, listTvPopular?.size)

        viewModel.getTvPopular().observeForever(observer)
        Mockito.verify(observer).onChanged(listTv)
    }
}