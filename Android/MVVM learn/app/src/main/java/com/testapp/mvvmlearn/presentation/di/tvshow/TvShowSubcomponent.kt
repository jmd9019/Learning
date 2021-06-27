package com.testapp.mvvmlearn.presentation.di.tvshow

import com.testapp.mvvmlearn.presentation.tvshows.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubcomponent {

    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubcomponent
    }
}