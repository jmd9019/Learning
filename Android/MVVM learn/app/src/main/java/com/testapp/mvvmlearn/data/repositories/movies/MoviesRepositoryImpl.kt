package com.testapp.mvvmlearn.data.repositories.movies

import android.util.Log
import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieLocalDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MovieRemoteDataSource
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MoviesCacheDataSource
import com.testapp.mvvmlearn.domain.repositories.MoviesRepository

class MoviesRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val moviesCacheDataSource: MoviesCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MoviesRepository {
    private val TAG: String? = MoviesRepositoryImpl::class.qualifiedName

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies: List<Movie> = getMoviesFromAPI()

        movieLocalDataSource.clearAllMoviesList()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)

        moviesCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e:Exception) {
            Log.e(TAG, "getMoviesFromAPI: error = ${e.message.toString()}")
        }
        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
            if (movieList.size > 0) {
                return movieList
            }
            //If no data from DB take from API and save to DB
            else {
                movieList = getMoviesFromAPI()
                movieLocalDataSource.saveMoviesToDB(movieList)
            }
        } catch (e:Exception) {
            Log.d(TAG, "getMoviesFromDB: error = ${e.message.toString()}")
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var movieList: List<Movie>
        movieList = moviesCacheDataSource.getMoviesFromCache()
        if (movieList.size > 0) {
            return movieList
        }
        //If no data from cache take from DB and save in cache
        else {
            movieList = getMoviesFromDB()
            moviesCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}