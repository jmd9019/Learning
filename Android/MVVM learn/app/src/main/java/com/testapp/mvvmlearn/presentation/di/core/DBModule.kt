package com.testapp.mvvmlearn.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.testapp.mvvmlearn.data.database.TMDBDatabase
import com.testapp.mvvmlearn.data.database.dao.ArtistDao
import com.testapp.mvvmlearn.data.database.dao.MovieDao
import com.testapp.mvvmlearn.data.database.dao.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule  {

    @Singleton
    @Provides
    fun provideDataBase(context: Context) : TMDBDatabase {
       return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
           .build()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) : TvShowsDao {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(tmdbDatabase: TMDBDatabase) : MovieDao {
        return tmdbDatabase.movieDao()
    }
}