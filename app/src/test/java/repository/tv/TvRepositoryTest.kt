package repository.tv

import LiveDataTest
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import source.remote.RemoteDataSourceImpl
import utils.Helper.API_KEY
import utils.dataDummy.ResponseDataDummy

class TvRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val listTv = ResponseDataDummy.responseDummyTvShow()
    private val remoteDataSource = Mockito.mock(RemoteDataSourceImpl::class.java)
    private val tvRepository = FakeTvRepository(remoteDataSource)

    private val listTvDetail = ResponseDataDummy.responseDummyTvDetail()[1]
    private val getTvID = listTv[0].id!!

    @Test
    fun getPopularTv() {
        runBlocking {
            doAnswer {
                (it.arguments[0] as RemoteDataSourceImpl.LoadTvCallback).onAllTvReceived(listTv)

            }.`when`(remoteDataSource).getTvPopular(any())
        }

        val dataTv = LiveDataTest.getValue(tvRepository.getTvPopular())

        runBlocking {
            verify(remoteDataSource).getTvPopular(any())
        }

        org.junit.Assert.assertNotNull(dataTv)
        assertEquals(listTv.size.toLong(), dataTv.size.toLong())

    }

    @Test
    fun getDetailTv() {
        runBlocking {
            doAnswer {
                (it.arguments[1] as RemoteDataSourceImpl.LoadDetailTvCallback).onAllDetailTvReceived(
                    listTvDetail
                )
                null
            }.`when`(remoteDataSource).getDetailTv(eq(getTvID), any())
        }

        val dataTvDetail = LiveDataTest.getValue(tvRepository.getDetailTv(getTvID, API_KEY))

        runBlocking {
            verify(remoteDataSource).getDetailTv(eq(getTvID), any())
        }

        org.junit.Assert.assertNotNull(dataTvDetail)
        assertEquals(listTvDetail.id, dataTvDetail.id)

    }
}