package ui.movies


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import source.remote.network.ApiClient
import source.remote.response.movie.MovieResponsePopular
import source.remote.response.movie.ResultItem


class MovieViewModel : ViewModel() {
    private val list: MutableLiveData<List<ResultItem?>?> = MutableLiveData()
    val listResult: LiveData<List<ResultItem?>?> = list



     fun onResponse(apiKey: String){
        val call = ApiClient.service.getPopularMovie(apiKey)
        call.enqueue(object : Callback<MovieResponsePopular> {

            override fun onResponse(call: Call<MovieResponsePopular>, response: Response<MovieResponsePopular>) {
                if (response.isSuccessful) {
                    val listMovie: List<ResultItem?>? = response.body()?.results
                    list.postValue(listMovie)

                }else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponsePopular>, t: Throwable) {
                list.postValue(emptyList())
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })

    }

}




