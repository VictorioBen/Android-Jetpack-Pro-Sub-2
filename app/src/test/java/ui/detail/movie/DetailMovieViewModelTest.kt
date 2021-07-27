package ui.detail.movie

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
import source.entity.movie.MovieDetailEntity
import source.remote.repository.movie.MovieRepositoryImpl
import ui.movies.detail.DetailMovieViewModel
import utils.Helper.API_KEY
import utils.dataDummy.GenerateDataDummy

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = GenerateDataDummy.generateDummyDetailMovies()[0]
    private val movieID = dummyMovie.id!!

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepositoryImpl

    @Mock
    private lateinit var observer: Observer<MovieDetailEntity>


    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieRepository)
    }


    @Test
    fun getDetailMovie() {
        val movieDummy = MutableLiveData<MovieDetailEntity>()
        movieDummy.value = dummyMovie
        `when`(movieRepository.getDetailMovie(movieID, API_KEY)).thenReturn(movieDummy)
        val movieDetailEntity = viewModel.getDetail(movieID, API_KEY).value as MovieDetailEntity

        assertNotNull(movieDetailEntity)
        assertEquals(dummyMovie.title, movieDetailEntity.title)
        assertEquals(dummyMovie.id, movieDetailEntity.id)
        assertEquals(dummyMovie.overview, movieDetailEntity.overview)
        assertEquals(dummyMovie.runtime, movieDetailEntity.runtime)
        assertEquals(dummyMovie.posterPath, movieDetailEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, movieDetailEntity.releaseDate)
        assertEquals(dummyMovie.voteAverage, movieDetailEntity.voteAverage)
        assertEquals(dummyMovie.tagline, movieDetailEntity.tagline)
        assertEquals(dummyMovie.status, movieDetailEntity.status)
        assertEquals(dummyMovie.backdropPath, movieDetailEntity.backdropPath)

        viewModel.getDetail(movieID, API_KEY).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }


}