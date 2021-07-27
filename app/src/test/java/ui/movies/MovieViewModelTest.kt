package ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import source.entity.movie.MovieResultEntity
import source.remote.repository.movie.MovieRepositoryImpl
import utils.dataDummy.GenerateDataDummy

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var  viewModel: MovieViewModel
    private val listMovie = GenerateDataDummy.generateDummyMovies()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepositoryImpl

    @Mock
    private lateinit var observer: Observer<List<MovieResultEntity>>

    @Before
    fun setUp(){
        viewModel =  MovieViewModel(movieRepository)
    }


    @Test
    fun getMoviePopular() {
        val movieResultEntity = MutableLiveData<List<MovieResultEntity>>()
        movieResultEntity.value = listMovie

        `when`(movieRepository.getPopularMovie()).thenReturn(movieResultEntity)

        val listMoviePopular = viewModel.getMoviePopular().value

        verify(movieRepository).getPopularMovie()
        Assert.assertNotNull(listMoviePopular)
        Assert.assertEquals(10, listMoviePopular?.size)

        viewModel.getMoviePopular().observeForever(observer)
        verify(observer).onChanged(listMovie)
    }


}