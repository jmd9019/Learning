package com.testapp.roomdbbasicslearn.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testapp.roomdbbasicslearn.db.repository.SubscriberRepository

class SubscriberVMFactory(private val subscriberRepository: SubscriberRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SubscriberViewModel(subscriberRepository) as T
    }
}