package com.testapp.mvvmlearn.presentation.di.core

import com.testapp.mvvmlearn.presentation.di.artist.ArtistSubcomponent
import com.testapp.mvvmlearn.presentation.di.core.datamodule.CacheDataModule
import com.testapp.mvvmlearn.presentation.di.core.datamodule.LocalDataModule
import com.testapp.mvvmlearn.presentation.di.core.datamodule.RemoteDataModule
import com.testapp.mvvmlearn.presentation.di.movie.MovieSubcomponent
import com.testapp.mvvmlearn.presentation.di.tvshow.TvShowSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class, NetworkModule::class, DBModule::class,
    UseCaseModule::class,RepositoryModule::class,
    CacheDataModule::class, LocalDataModule::class, RemoteDataModule::class
])
interface AppComponent {

    fun movieSubcomponent() : MovieSubcomponent.Factory
    fun artistSubcomponent() : ArtistSubcomponent.Factory
    fun tvShowSubcomponent() : TvShowSubcomponent.Factory
}