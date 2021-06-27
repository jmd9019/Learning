package com.testapp.mvvmlearn.data.repositories.artists

import android.util.Log
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistCacheDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistLocalDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistRemoteDataSource
import com.testapp.mvvmlearn.domain.repositories.ArtistsRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistsRepository {
    private val TAG = ArtistRepositoryImpl::class.simpleName

    override suspend fun getArtists(): List<People>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<People>? {
        val newListOfArtists: List<People> = getArtistFromAPI()
        artistLocalDataSource.clearAllArtist()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistFromAPI() : List<People> {
        lateinit var artistList: List<People>
        try {
            val respose = artistRemoteDataSource.getArtist()
            val body = respose.body()
            if (body != null) {
                artistList = body.people
            }
        } catch (e:Exception) {
            Log.e(TAG, "getArtistFromAPI: error = ${e.message.toString()}", )
        }

        return artistList
    }

    suspend fun getArtistFromDB() : List<People> {
        lateinit var artistList: List<People>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
            if (artistList.size > 0) {
                return artistList
            }
            //If no data from DB take from API and save to DB
            else {
                artistList = getArtistFromAPI()
                artistLocalDataSource.saveArtistToDB(artistList)
            }
        } catch (e:Exception) {
            Log.e(TAG, "getArtistFromAPI: error = ${e.message.toString()}", )
        }

        return artistList
    }

    suspend fun getArtistFromCache() : List<People> {
        lateinit var artistList: List<People>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
            if (artistList.size > 0) {
                return artistList
            }
            //If no data from cache take from DB and save in cache
            else {
                artistList = getArtistFromAPI()
                artistCacheDataSource.saveArtistToCache(artistList)
            }
        } catch (e:Exception) {
            Log.e(TAG, "getArtistFromAPI: error = ${e.message.toString()}", )
        }

        return artistList
    }
}