package com.testapp.mvvmlearn.data.repositories.artists.datasource

import com.testapp.mvvmlearn.data.model.peoples.People

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache() : List<People>
    suspend fun saveArtistToCache(artistList: List<People>)
}