package com.testapp.mvvmlearn.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testapp.mvvmlearn.data.database.dao.ArtistDao
import com.testapp.mvvmlearn.data.database.dao.MovieDao
import com.testapp.mvvmlearn.data.database.dao.TvShowsDao
import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.data.model.tvShows.TvShow

@Database(entities = [Movie::class,TvShow::class,People::class],version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun tvShowDao() : TvShowsDao
    abstract fun artistDao() : ArtistDao

}