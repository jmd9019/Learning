package com.testapp.mvvmlearn.data.repositories.movies.datasource

import com.testapp.mvvmlearn.data.model.movies.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movieList:List<Movie>)

}