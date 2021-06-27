package com.testapp.mvvmlearn.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.testapp.mvvmlearn.R
import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.databinding.ActivityTvShowsBinding
import com.testapp.mvvmlearn.presentation.di.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    private val TAG = this::class.simpleName

    private lateinit var binding: ActivityTvShowsBinding

    @Inject lateinit var factory: TvShowsViewModelFactory
    private lateinit var tvShowsViewModel: TvShowsViewModel

    private lateinit var adapter: TvShowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_shows)

        (application as Injector).createTvShowsSubcomponent()
            .inject(this)

        tvShowsViewModel = ViewModelProvider(this,factory).get(TvShowsViewModel::class.java)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.menu_item_update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update -> {
                displayPopularTvShows(true)
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewTvShows.layoutManager = LinearLayoutManager(this)
        adapter = TvShowsAdapter()
        binding.recyclerViewTvShows.adapter = adapter
        displayPopularTvShows(false)
    }

    private fun displayPopularTvShows(getUpdatedData:Boolean) {
        binding.progressBarTvShows.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<TvShow>?> =
            if (getUpdatedData) tvShowsViewModel.updateTvShows()
            else tvShowsViewModel.getTvShows()

        responseLiveData.observe(this, {
            if (it != null) {
                adapter.setTvShowsList(it)
                adapter.notifyDataSetChanged()

                binding.progressBarTvShows.visibility = View.GONE
            } else {
                binding.progressBarTvShows.visibility = View.GONE
            }
        })
    }
}