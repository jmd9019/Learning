package com.testapp.mvvmlearn.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.domain.usecases.artist.GetArtistUseCase
import com.testapp.mvvmlearn.domain.usecases.artist.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {
    fun getArtists() = liveData {
        val artistList: List<People>? = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList:List<People>? = updateArtistUseCase.execute()
        emit(artistList)
    }
}