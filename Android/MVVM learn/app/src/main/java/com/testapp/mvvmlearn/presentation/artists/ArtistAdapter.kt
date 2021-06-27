package com.testapp.mvvmlearn.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.testapp.mvvmlearn.R
import com.testapp.mvvmlearn.data.model.peoples.People
import com.testapp.mvvmlearn.databinding.ListItemArtistBinding
import kotlin.math.roundToInt

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<People>()

    fun setArtistList(newArtistList: List<People>) {
        artistList.clear()
        artistList.addAll(newArtistList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemArtistBinding = DataBindingUtil.inflate(
            layoutInflater,R.layout.list_item_artist,parent,false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
       holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ArtistViewHolder(private val binding:ListItemArtistBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(artist:People) {
            binding.titleTextViewArtist.text = artist.name
            binding.tvPopularityNumbers.text = artist.popularity.toString()

            when(artist.popularity.roundToInt()) {
                in 0..19 ->  binding.ratingBarPopularity.rating = 1F
                in 20..39 ->  binding.ratingBarPopularity.rating = 2F
                in 40..59 ->  binding.ratingBarPopularity.rating = 3F
                in 60..79 ->  binding.ratingBarPopularity.rating = 4F
                in 80..100 ->  binding.ratingBarPopularity.rating = 5F
            }

            val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath

            Glide.with(binding.imageViewArtist.context)
                .load(posterURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewArtist)
        }
}