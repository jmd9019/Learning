package com.testapp.mvvmlearn.data.repositories.artists.datasourceimpl

import com.testapp.mvvmlearn.data.database.dao.ArtistDao
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<People> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artistList: List<People>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artistList)
        }
    }

    override suspend fun clearAllArtist() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}