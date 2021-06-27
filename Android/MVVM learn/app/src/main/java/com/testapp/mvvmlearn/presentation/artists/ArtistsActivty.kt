package com.testapp.mvvmlearn.presentation.artists

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
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.databinding.ActivityArtistsBinding
import com.testapp.mvvmlearn.presentation.di.Injector
import javax.inject.Inject

class ArtistsActivty : AppCompatActivity() {
    private val TAG = this::class.simpleName

    private lateinit var binding:ActivityArtistsBinding
    private lateinit var adapter: ArtistAdapter

    private lateinit var artistViewModel: ArtistViewModel
    @Inject lateinit var factory: ArtistsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)

        (application as Injector).creteArtistSubcomponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this,factory).get(ArtistViewModel::class.java)

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
                displayPopularArtists(true)
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewArtists.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.recyclerViewArtists.adapter = adapter
        displayPopularArtists(false)
    }

    private fun displayPopularArtists(updateList:Boolean) {
        binding.progressBarArtist.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<People>?> =
            if (updateList)
                artistViewModel.updateArtists()
            else artistViewModel.getArtists()

        responseLiveData.observe(this,{
            if (it != null) {
                adapter.setArtistList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarArtist.visibility = View.GONE
            } else {
                binding.progressBarArtist.visibility = View.GONE

            }
        })
    }
}