package com.testapp.mvvmlearn.data.repositories.artists.datasource

import com.testapp.mvvmlearn.data.model.peoples.People

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB():List<People>
    suspend fun saveArtistToDB(artistList: List<People>)
    suspend fun clearAllArtist()
}