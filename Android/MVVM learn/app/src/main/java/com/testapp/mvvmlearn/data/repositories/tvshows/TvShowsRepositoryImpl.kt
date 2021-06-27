package com.testapp.mvvmlearn.data.repositories.tvshows

import android.util.Log
import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsCacheDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsLocalDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsRemoteDataSource
import com.testapp.mvvmlearn.domain.repositories.TvShowsRepository

class TvShowsRepositoryImpl(
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource
) : TvShowsRepository {
    private val TAG = this::class.simpleName
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowsList: List<TvShow> = getTvShowsFromAPI()

        tvShowsLocalDataSource.clearAllTvShowsList()
        tvShowsLocalDataSource.saveTvShowsToDB(newTvShowsList)

        tvShowsCacheDataSource.saveTvShoesToCache(newTvShowsList)

        return newTvShowsList
    }

    suspend fun getTvShowsFromAPI() : List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (e:Exception) {
            Log.e(TAG, "getMoviesFromAPI: error = ${e.message.toString()}")

        }
        return tvShowsList
    }

    suspend fun getTvShowsFromDB() : List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowsLocalDataSource.getTvShowsFromDB()
            if (tvShowsList.size > 0) {
                return tvShowsList
            }
            //If no data from DB take from API and save to DB
            else {
                tvShowsList = getTvShowsFromAPI()
                tvShowsLocalDataSource.saveTvShowsToDB(tvShowsList)
            }
        } catch (e:Exception) {
            Log.e(TAG, "getTvShowsFromDB: error = ${e.message.toString()}")

        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache() : List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowsCacheDataSource.getTvShowsFromCache()
            if (tvShowsList.size > 0) {
                return tvShowsList
            }
            //If no data from cache take from DB and save in cache
            else {
                tvShowsList = getTvShowsFromDB()
                tvShowsCacheDataSource.saveTvShoesToCache(tvShowsList)
            }
        } catch (e:Exception) {
            Log.e(TAG, "getTvShowsFromCache: error = ${e.message.toString()}")

        }
        return tvShowsList
    }
}