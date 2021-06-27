package com.testapp.mvvmlearn.data.repositories.artists.datasourceimpl

import com.testapp.mvvmlearn.data.api.TMDBService
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.data.model.peoples.PeoplesList
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDataSource{
    override suspend fun getArtist(): Response<PeoplesList> = tmdbService.getPopularPeoples(apiKey)
}