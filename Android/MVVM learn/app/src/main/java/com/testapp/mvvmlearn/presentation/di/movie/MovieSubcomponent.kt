package com.testapp.mvvmlearn.presentation.di.movie

import com.testapp.mvvmlearn.presentation.movies.MoviesActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubcomponent {

    fun inject(moviesActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubcomponent
    }
}