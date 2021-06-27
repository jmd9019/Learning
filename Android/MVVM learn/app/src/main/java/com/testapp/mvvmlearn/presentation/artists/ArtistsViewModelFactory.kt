package com.testapp.mvvmlearn.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testapp.mvvmlearn.domain.usecases.artist.GetArtistUseCase
import com.testapp.mvvmlearn.domain.usecases.artist.UpdateArtistUseCase

class ArtistsViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
    }
}