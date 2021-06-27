package com.testapp.mvvmlearn.data.repositories.tvshows.datasource

import com.testapp.mvvmlearn.data.model.tvShows.TvShow

interface TvShowsCacheDataSource {
    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShoesToCache(tvShowsList: List<TvShow>)
}