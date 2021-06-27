package com.testapp.mvvmlearn.presentation.di.artist

import com.testapp.mvvmlearn.presentation.artists.ArtistsActivty
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubcomponent {

    fun inject(artistsActivty: ArtistsActivty)

    @Subcomponent.Factory
    interface Factory {
        fun create() : ArtistSubcomponent
    }
}