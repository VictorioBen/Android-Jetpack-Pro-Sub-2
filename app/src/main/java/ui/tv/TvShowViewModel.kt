package ui.tv

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import source.remote.network.ApiClient
import source.remote.response.tv.ResultsItem
import source.remote.response.tv.TvResponsePopular

class TvShowViewModel: ViewModel() {
    private val list: MutableLiveData<List<ResultsItem?>?> = MutableLiveData()
    val listTvResult: LiveData<List<ResultsItem?>?> = list


    fun onResponseTv(apiKey: String) {
        val call = ApiClient.service.getPopularTv(apiKey)
        call.enqueue(object : Callback<TvResponsePopular> {
            override fun onResponse(call: Call<TvResponsePopular>, response: Response<TvResponsePopular>) {
                if (response.isSuccessful) {
                    val listTv: List<ResultsItem?>? = response.body()?.results
                    list.postValue(listTv)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvResponsePopular>, t: Throwable) {
                list.postValue(emptyList())
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }



}