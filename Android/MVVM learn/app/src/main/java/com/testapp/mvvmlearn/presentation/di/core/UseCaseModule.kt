package com.testapp.mvvmlearn.presentation.di.core

import com.testapp.mvvmlearn.domain.repositories.ArtistsRepository
import com.testapp.mvvmlearn.domain.repositories.MoviesRepository
import com.testapp.mvvmlearn.domain.repositories.TvShowsRepository
import com.testapp.mvvmlearn.domain.usecases.artist.GetArtistUseCase
import com.testapp.mvvmlearn.domain.usecases.artist.UpdateArtistUseCase
import com.testapp.mvvmlearn.domain.usecases.movie.GetMoviesUseCase
import com.testapp.mvvmlearn.domain.usecases.movie.UpdateMoviesUseCase
import com.testapp.mvvmlearn.domain.usecases.tvShow.GetTvShowsUseCase
import com.testapp.mvvmlearn.domain.usecases.tvShow.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(moviesRepository: MoviesRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)
    }
    @Provides
    fun provideUpdateMoviesUseCase(moviesRepository: MoviesRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowsRepository: TvShowsRepository) : GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsRepository)
    }
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowsRepository: TvShowsRepository) : UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistsRepository: ArtistsRepository) : GetArtistUseCase {
        return GetArtistUseCase(artistsRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository) : UpdateArtistUseCase {
        return UpdateArtistUseCase(artistsRepository)
    }
}