package com.testapp.mvvmlearn.data.model.peoples


import com.google.gson.annotations.SerializedName

data class PeoplesList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val people: List<People>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)