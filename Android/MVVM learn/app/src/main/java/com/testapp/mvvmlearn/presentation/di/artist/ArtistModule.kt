package com.testapp.mvvmlearn.presentation.di.artist

import com.testapp.mvvmlearn.domain.usecases.artist.GetArtistUseCase
import com.testapp.mvvmlearn.domain.usecases.artist.UpdateArtistUseCase
import com.testapp.mvvmlearn.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule  {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ) : ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}