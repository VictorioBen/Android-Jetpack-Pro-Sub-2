package ui.tv

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var  viewModel: TvShowViewModel


    @Before
    fun setUp(){
        viewModel =  TvShowViewModel()
    }


    @Test
    fun getTvShow() {
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity.size)
    }
}