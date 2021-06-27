package com.testapp.mvvmlearn.data.repositories.movies.datasourceimpl

import com.testapp.mvvmlearn.data.database.dao.MovieDao
import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao
): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(moviesList: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(moviesList)
        }
    }

    override suspend fun clearAllMoviesList() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}