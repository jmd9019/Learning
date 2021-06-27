package com.testapp.mvvmlearn.presentation.di.tvshow

import com.testapp.mvvmlearn.domain.usecases.tvShow.GetTvShowsUseCase
import com.testapp.mvvmlearn.domain.usecases.tvShow.UpdateTvShowsUseCase
import com.testapp.mvvmlearn.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowsViewModelFactory {
        return TvShowsViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}