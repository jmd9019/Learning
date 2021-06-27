package com.testapp.mvvmlearn.domain.repositories

import com.testapp.mvvmlearn.data.model.movies.Movie

interface MoviesRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}