package com.testapp.mvvmlearn.data.repositories.artists.datasource

import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.data.model.peoples.PeoplesList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist() : Response<PeoplesList>
}