package com.testapp.mvvmlearn.data.repositories.movies.datasourceimpl

import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.data.repositories.movies.datasource.MoviesCacheDataSource

class MovieCacheDataSourceImpl: MoviesCacheDataSource {
    private var movieListArrayList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieListArrayList
    }

    override suspend fun saveMoviesToCache(movieList: List<Movie>) {
        movieListArrayList.clear()
        movieListArrayList = ArrayList(movieList)
    }
}