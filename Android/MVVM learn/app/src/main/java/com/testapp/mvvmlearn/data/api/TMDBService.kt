package com.testapp.mvvmlearn.data.api

import com.testapp.mvvmlearn.data.model.movies.MovieList
import com.testapp.mvvmlearn.data.model.peoples.PeoplesList
import com.testapp.mvvmlearn.data.model.tvShows.TvShowsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey: String
    ) : Response<TvShowsList>

    @GET("person/popular")
    suspend fun getPopularPeoples(
        @Query("api_key") apiKey: String
    ) : Response<PeoplesList>
}