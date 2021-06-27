package com.testapp.mvvmlearn.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.domain.usecases.tvShow.GetTvShowsUseCase
import com.testapp.mvvmlearn.domain.usecases.tvShow.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowsList:List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData {
        val tvShowsList:List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}