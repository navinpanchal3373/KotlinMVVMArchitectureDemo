package com.example.retrofit

class MainRepository constructor(val retrofitService: RetrofitService) {
    fun getAllMovieData() = retrofitService.getAllMovies();
}