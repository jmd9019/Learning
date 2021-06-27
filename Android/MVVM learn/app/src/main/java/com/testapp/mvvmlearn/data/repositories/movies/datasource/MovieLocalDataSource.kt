package com.testapp.mvvmlearn.data.repositories.movies.datasource

import com.testapp.mvvmlearn.data.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(moviesList:List<Movie>)
    suspend fun clearAllMoviesList()
}