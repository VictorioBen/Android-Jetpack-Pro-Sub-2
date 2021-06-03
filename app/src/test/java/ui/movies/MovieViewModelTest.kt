package ui.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel


    @Before
    fun setUp(){
        viewModel =  MovieViewModel()
    }


    @Test
    fun getMovie() {
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity.size)
    }
}