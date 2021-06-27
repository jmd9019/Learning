package com.testapp.mvvmlearn.data.repositories.tvshows.datasourceimpl

import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsCacheDataSource

class TvShowsCacheDataSourceImpl:TvShowsCacheDataSource {
    private var tvShowsArrayList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
       return tvShowsArrayList
    }

    override suspend fun saveTvShoesToCache(tvShowsList: List<TvShow>) {
        tvShowsArrayList.clear()
        tvShowsArrayList = ArrayList(tvShowsList)
    }
}