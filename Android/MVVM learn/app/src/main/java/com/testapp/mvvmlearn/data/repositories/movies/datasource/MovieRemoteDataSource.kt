package com.testapp.mvvmlearn.data.repositories.movies.datasource

import com.testapp.mvvmlearn.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource  {
    suspend fun getMovies() : Response<MovieList>
}