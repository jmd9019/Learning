package com.testapp.mvvmlearn.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.testapp.mvvmlearn.R
import com.testapp.mvvmlearn.databinding.ActivityHomeBinding
import com.testapp.mvvmlearn.presentation.artists.ArtistsActivty
import com.testapp.mvvmlearn.presentation.movies.MoviesActivity
import com.testapp.mvvmlearn.presentation.tvshows.TvShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this,MoviesActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistsActivty::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this,TvShowsActivity::class.java)
            startActivity(intent)
        }
    }
}