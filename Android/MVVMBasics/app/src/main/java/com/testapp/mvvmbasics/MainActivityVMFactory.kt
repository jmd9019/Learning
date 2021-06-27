package com.testapp.mvvmbasics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityVMFactory(private val initValue:Double) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(initValue) as T
    }
}