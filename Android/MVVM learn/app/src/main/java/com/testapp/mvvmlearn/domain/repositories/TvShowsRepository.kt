package com.testapp.mvvmlearn.domain.repositories

import com.testapp.mvvmlearn.data.model.tvShows.TvShow

interface TvShowsRepository {
    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?
}