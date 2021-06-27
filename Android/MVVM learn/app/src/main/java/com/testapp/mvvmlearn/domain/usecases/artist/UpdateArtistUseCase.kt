package com.testapp.mvvmlearn.domain.usecases.artist

import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.domain.repositories.ArtistsRepository

class UpdateArtistUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute(): List<People>? = artistsRepository.updateArtists()
}