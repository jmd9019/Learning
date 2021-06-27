package com.testapp.mvvmlearn.presentation.di.core

import com.testapp.mvvmlearn.data.repositories.artists.ArtistRepositoryImpl
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistCacheDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistLocalDataSource
import com.testapp.mvvmlearn.data.repositories.artists.datasource.ArtistRemoteDataSource
import com.testapp.mvvmlearn.data.repositories.movies.MoviesRepositoryImpl
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieLocalDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieRemoteDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MoviesCacheDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.TvShowsRepositoryImpl
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsCacheDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsLocalDataSource
import com.testapp.mvvmlearn.data.repositories.tvshows.datasource.TvShowsRemoteDataSource
import com.testapp.mvvmlearn.domain.repositories.ArtistsRepository
import com.testapp.mvvmlearn.domain.repositories.MoviesRepository
import com.testapp.mvvmlearn.domain.repositories.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        moviesCacheDataSource: MoviesCacheDataSource
    ) : MoviesRepository {
        return MoviesRepositoryImpl(movieRemoteDataSource, moviesCacheDataSource, movieLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ) : ArtistsRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(
        tvShowsCacheDataSource: TvShowsCacheDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsRemoteDataSource: TvShowsRemoteDataSource
    ) : TvShowsRepository {
        return TvShowsRepositoryImpl(tvShowsLocalDataSource, tvShowsRemoteDataSource, tvShowsCacheDataSource)
    }
}