package com.testapp.mvvmlearn.data.repositories.tvshows.datasource

import com.testapp.mvvmlearn.data.model.tvShows.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShowsList: List<TvShow>)
    suspend fun clearAllTvShowsList()
}