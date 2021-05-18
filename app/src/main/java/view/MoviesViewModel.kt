package view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import db.LoadMovie
import data.movies.MovieModel


class MoviesViewModel : ViewModel() {
    private val list: MutableLiveData<List<MovieModel>> = MutableLiveData()
     val listResult: LiveData<List<MovieModel>> = list


   private fun loadData(): List<MovieModel>? {
        val loadMovie = LoadMovie()
       // loadMovie.readJsonFromAsset()
      return loadData()
    }

     fun loadMovieFromData() {
        list.postValue(loadData())

        if (loadData()?.isEmpty() == true){
            list.postValue(emptyList())
        }
    }




}