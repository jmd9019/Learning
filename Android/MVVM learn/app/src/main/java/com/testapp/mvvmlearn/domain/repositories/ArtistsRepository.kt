package com.testapp.mvvmlearn.domain.repositories

import com.testapp.mvvmlearn.data.model.peoples.People

interface ArtistsRepository {
    suspend fun getArtists() : List<People>?
    suspend fun updateArtists() : List<People>?
}