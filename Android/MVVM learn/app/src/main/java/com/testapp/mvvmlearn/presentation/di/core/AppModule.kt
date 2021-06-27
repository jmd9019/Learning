package com.testapp.mvvmlearn.presentation.di.core

import android.content.Context
import com.testapp.mvvmlearn.presentation.di.artist.ArtistSubcomponent
import com.testapp.mvvmlearn.presentation.di.movie.MovieSubcomponent
import com.testapp.mvvmlearn.presentation.di.tvshow.TvShowSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubcomponent::class,TvShowSubcomponent::class,ArtistSubcomponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideAppContext() : Context {
        return context.applicationContext
    }
}