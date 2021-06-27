package com.testapp.mvvmlearn.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testapp.mvvmlearn.domain.usecases.tvShow.GetTvShowsUseCase
import com.testapp.mvvmlearn.domain.usecases.tvShow.UpdateTvShowsUseCase

class TvShowsViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}