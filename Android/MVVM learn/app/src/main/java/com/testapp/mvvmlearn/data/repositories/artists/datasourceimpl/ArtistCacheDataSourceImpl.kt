package com.testapp.mvvmlearn.data.repositories.artists.datasourceimpl

import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistListArrayList = ArrayList<People>()
    override suspend fun getArtistFromCache(): List<People> {
        return artistListArrayList
    }

    override suspend fun saveArtistToCache(artistList: List<People>) {
        artistListArrayList.clear()
        artistListArrayList = ArrayList(artistList)
    }
}