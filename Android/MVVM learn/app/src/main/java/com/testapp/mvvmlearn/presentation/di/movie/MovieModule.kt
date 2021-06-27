package com.testapp.mvvmlearn.presentation.di.movie

import com.testapp.mvvmlearn.domain.usecases.movie.GetMoviesUseCase
import com.testapp.mvvmlearn.domain.usecases.movie.UpdateMoviesUseCase
import com.testapp.mvvmlearn.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}