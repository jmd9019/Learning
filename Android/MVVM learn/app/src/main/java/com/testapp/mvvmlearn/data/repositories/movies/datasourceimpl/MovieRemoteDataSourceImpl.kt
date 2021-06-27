package com.testapp.mvvmlearn.data.repositories.movies.datasourceimpl

import com.testapp.mvvmlearn.data.api.TMDBService
import com.testapp.mvvmlearn.data.model.movies.MovieList
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}