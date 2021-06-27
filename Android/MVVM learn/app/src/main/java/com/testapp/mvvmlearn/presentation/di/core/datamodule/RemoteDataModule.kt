package com.testapp.mvvmlearn.presentation.di.core.datamodule

import com.testapp.mvvmlearn.data.api.TMDBService
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistRemoteDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasourceimpl.ArtistRemoteDataSourceImpl
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieRemoteDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasourceimpl.MovieRemoteDataSourceImpl
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsRemoteDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasourceimpl.TvShowsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowsRemoteDataSource(tmdbService: TMDBService) : TvShowsRemoteDataSource {
        return TvShowsRemoteDataSourceImpl(tmdbService,apiKey)
    }
}