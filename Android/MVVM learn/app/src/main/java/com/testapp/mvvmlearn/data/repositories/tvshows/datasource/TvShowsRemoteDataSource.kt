package com.testapp.mvvmlearn.data.repositories.tvshows.datasource

import com.testapp.mvvmlearn.data.model.tvShows.TvShowsList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows() : Response<TvShowsList>
}