package com.testapp.mvvmlearn.data.model.tvShows


import com.google.gson.annotations.SerializedName

data class TvShowsList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tvShows: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)