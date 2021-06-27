package com.testapp.mvvmlearn.presentation.di.core.datamodule

import com.testapp.mvvmlearn.data.database.dao.ArtistDao
import com.testapp.mvvmlearn.data.database.dao.MovieDao
import com.testapp.mvvmlearn.data.database.dao.TvShowsDao
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistLocalDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasourceimpl.ArtistLocalDataSourceImpl
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieLocalDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasourceimpl.MovieLocalDataSourceImpl
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsLocalDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasourceimpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvSHowsLocalDataSource(tvShowsDao: TvShowsDao) : TvShowsLocalDataSource {
        return TvShowsLocalDataSourceImpl(tvShowsDao)
    }
}