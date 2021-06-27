package com.testapp.mvvmlearn.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.testapp.mvvmlearn.R
import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.databinding.ListItemMoviesBinding

class MovieAdapter : RecyclerView.Adapter<MoviesViewHolder>() {
    private val moviesList = ArrayList<Movie>()

    fun setMoviesList(moviesListData: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(moviesListData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemMoviesBinding = DataBindingUtil.inflate(
            layoutInflater,R.layout.list_item_movies,parent,false
        )
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}

class MoviesViewHolder(private val binding:ListItemMoviesBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(movie:Movie) {
            binding.titleTextViewMovies.text = movie.title
            binding.descriptionTextViewMovies.text = movie.overview

            val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath

            Glide.with(binding.imageViewMovies.context)
                .load(posterURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewMovies)
        }
    }