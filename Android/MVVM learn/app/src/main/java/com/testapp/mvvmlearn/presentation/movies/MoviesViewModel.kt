package com.testapp.mvvmlearn.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.domain.usecases.movie.GetMoviesUseCase
import com.testapp.mvvmlearn.domain.usecases.movie.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList:List<Movie>? = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList:List<Movie>? = updateMoviesUseCase.execute()
        emit(moviesList)
    }
}