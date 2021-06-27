package com.testapp.mvvmlearn.presentation.di

import com.testapp.mvvmlearn.presentation.di.artist.ArtistSubcomponent
import com.testapp.mvvmlearn.presentation.di.movie.MovieSubcomponent
import com.testapp.mvvmlearn.presentation.di.tvshow.TvShowSubcomponent

interface Injector {

    fun createMovieSubcomponent() : MovieSubcomponent
    fun createTvShowsSubcomponent() : TvShowSubcomponent
    fun creteArtistSubcomponent() : ArtistSubcomponent
}