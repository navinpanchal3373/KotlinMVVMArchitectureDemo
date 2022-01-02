package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.Movie
import retrofit2.Call
import retrofit2.Response

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    val errorMsg = MutableLiveData<String>()

    fun getAllMovies() {
        val response = mainRepository.getAllMovieData();
        response.enqueue(object : retrofit2.Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }
        })
    }
}