package com.testapp.mvvmlearn.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testapp.mvvmlearn.domain.usecases.movie.GetMoviesUseCase
import com.testapp.mvvmlearn.domain.usecases.movie.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}