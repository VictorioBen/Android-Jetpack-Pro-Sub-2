package ui.detail.movies

import androidx.lifecycle.ViewModel
import data.movies.MovieEntity
import utils.dataDummy.DataDummy

class DetailMovieViewModel: ViewModel() {
    private lateinit var detailID: String

    fun setSelectedDetail(detailID: String) {
        this.detailID = detailID
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieID == detailID) {
                movie = movieEntity
            }
        }
        return movie
    }





}