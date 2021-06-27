package com.testapp.mvvmlearn.domain.usecases.movie

import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.domain.repositories.MoviesRepository

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute() : List<Movie>? = moviesRepository.getMovies()
}