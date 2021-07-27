package repository.movie

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

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val listMovie = ResponseDataDummy.responseDummyMovies()
    private val remoteDataSource = Mockito.mock(RemoteDataSourceImpl::class.java)
    private val movieRepository = FakeMovieRepository(remoteDataSource)

    private val listMovieDetail = ResponseDataDummy.responseDummyDetailMovies()[1]
    private val getMovieID = listMovie[0].id!!

    @Test
    fun getPopularMovie() {
        runBlocking {
            doAnswer {
                (it.arguments[0] as RemoteDataSourceImpl.LoadMovieCallback).onAllMovieReceived(listMovie)

            }.`when`(remoteDataSource).getMoviePopular(any())
        }

        val movie = LiveDataTest.getValue(movieRepository.getPopularMovie())

        runBlocking {
            verify(remoteDataSource).getMoviePopular(any())
        }

        org.junit.Assert.assertNotNull(movie)
        assertEquals(listMovie.size.toLong(), movie.size.toLong())

    }

    @Test
    fun getDetailMovie() {
        runBlocking {
            doAnswer {
                (it.arguments[1] as RemoteDataSourceImpl.LoadDetailMovieCallback).
                onAllDetailMovieReceived(listMovieDetail)
                null
            }.`when`(remoteDataSource).getDetailMovie(eq(getMovieID), any())
        }

        val movieDetail = LiveDataTest.getValue(movieRepository.getDetailMovie(getMovieID, API_KEY))

        runBlocking {
                verify(remoteDataSource).getDetailMovie(eq(getMovieID), any())
        }

        org.junit.Assert.assertNotNull(movieDetail)
        assertEquals(listMovieDetail.id, movieDetail.id)

    }
}