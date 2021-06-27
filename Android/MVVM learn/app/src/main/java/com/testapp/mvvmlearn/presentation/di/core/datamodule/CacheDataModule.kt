package com.testapp.mvvmlearn.presentation.di.core.datamodule

import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistCacheDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistLocalDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasourceimpl.ArtistCacheDataSourceImpl
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MoviesCacheDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasourceimpl.MovieCacheDataSourceImpl
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsCacheDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasourceimpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMoviesCacheDataSource() : MoviesCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowsCacheDataSource() : TvShowsCacheDataSource {
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}