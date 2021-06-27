package com.testapp.mvvmlearn.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.testapp.mvvmlearn.R
import com.testapp.mvvmlearn.data.model.movies.Movie
import com.testapp.mvvmlearn.databinding.ActivityMoviesBinding
import com.testapp.mvvmlearn.presentation.di.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    private val TAG = this::class.simpleName

    private lateinit var adaptor: MovieAdapter

    private lateinit var binding:ActivityMoviesBinding
    @Inject lateinit var factory: MovieViewModelFactory
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movies)

        (application as Injector).createMovieSubcomponent()
            .inject(this)

        moviesViewModel = ViewModelProvider(this,factory).get(MoviesViewModel::class.java)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator:MenuInflater = menuInflater
        inflator.inflate(R.menu.menu_item_update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        adaptor = MovieAdapter()
        binding.moviesRecyclerView.adapter = adaptor
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.progressBarMovies.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<Movie>?> = moviesViewModel.getMovies()

        responseLiveData.observe(this, {
            if (it != null) {
                adaptor.setMoviesList(it)
                adaptor.notifyDataSetChanged()
                binding.progressBarMovies.visibility = View.GONE
            } else {
                binding.progressBarMovies.visibility = View.GONE
            }
        })
    }

    private fun updateMovies() {
        binding.progressBarMovies.visibility = View.VISIBLE
        val response = moviesViewModel.updateMovies()

        response.observe(this,{
            if (it != null) {
                adaptor.setMoviesList(it)
                adaptor.notifyDataSetChanged()
                binding.progressBarMovies.visibility = View.GONE
            } else {
                binding.progressBarMovies.visibility = View.GONE
            }
        })
    }
}