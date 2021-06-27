package com.testapp.mvvmlearn.data.repositories.tvshows.datasourceimpl

import com.testapp.mvvmlearn.data.database.dao.TvShowsDao
import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(
    private val tvShowsDao: TvShowsDao
) : TvShowsLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShowsList: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShowsList)
        }
    }

    override suspend fun clearAllTvShowsList() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShows()
        }
    }
}