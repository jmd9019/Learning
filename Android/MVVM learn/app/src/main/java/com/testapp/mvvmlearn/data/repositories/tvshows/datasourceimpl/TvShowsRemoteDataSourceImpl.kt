package com.testapp.mvvmlearn.data.repositories.tvshows.datasourceimpl

import com.testapp.mvvmlearn.data.api.TMDBService
import com.testapp.mvvmlearn.data.model.tvShows.TvShowsList
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowsList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}