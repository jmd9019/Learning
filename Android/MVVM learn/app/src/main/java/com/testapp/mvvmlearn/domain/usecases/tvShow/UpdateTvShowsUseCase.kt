package com.testapp.mvvmlearn.domain.usecases.tvShow

import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.domain.repositories.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute() : List<TvShow>? = tvShowsRepository.updateTvShows()
}