package com.testapp.mvvmlearn.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.testapp.mvvmlearn.R
import com.testapp.mvvmlearn.data.model.tvShows.TvShow
import com.testapp.mvvmlearn.databinding.ListItemTvShowBinding

class TvShowsAdapter : RecyclerView.Adapter<TvShowsViewHolder>() {
    private val tvShowsList = ArrayList<TvShow>()

    fun setTvShowsList(newTvShowsList: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList.addAll(newTvShowsList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemTvShowBinding = DataBindingUtil.inflate(
            layoutInflater,R.layout.list_item_tv_show,parent,false
        )

        return TvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int {
       return tvShowsList.size
    }
}

class TvShowsViewHolder(private val binding: ListItemTvShowBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow:TvShow) {
            binding.titleTextViewTvShow.text = tvShow.name
            binding.descriptionTextViewTvShow.text = tvShow.overview

            val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath

            Glide.with(binding.imageViewTvShow.context)
                .load(posterURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewTvShow)
        }
    }