package com.testapp.roomdbbasicslearn.ui.viewmodels

import androidx.lifecycle.*
import com.testapp.roomdbbasicslearn.db.repository.SubscriberRepository
import com.testapp.roomdbbasicslearn.models.Subscriber
import com.testapp.roomdbbasicslearn.ui.Event
import kotlinx.coroutines.launch

class SubscriberViewModel(private val subscriberRepository: SubscriberRepository) : ViewModel() {

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()

    private val _statusMessage = MutableLiveData<Event<String>>()
    val statusMessage:LiveData<Event<String>> get() = _statusMessage

    val btnSave = MutableLiveData("Save")
    val btnClearAll = MutableLiveData("Clear all")

    private var showUpdateBtn = false
    private var showDeleteBtn = false

    private lateinit var subscriberToDeleteOrUpdate:Subscriber

    private val subscribers = subscriberRepository.allSubscribers

    val subscribersLiveData = subscribers.asLiveData(viewModelScope.coroutineContext)

    fun saveOrUpdate() {
        if (showUpdateBtn) {
            update(
                Subscriber(subscriberToDeleteOrUpdate.id,
            inputName.value!!,inputEmail.value!!)
            )
        } else {
            insert(Subscriber(0,inputName.value!!,inputEmail.value!!))
            inputEmail.value = null
            inputName.value = null
        }
    }

    fun showSelectedSubscriberUpdateButtons(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.emailId

        subscriberToDeleteOrUpdate = subscriber

        btnSave.value = "Update"
        btnClearAll.value = "Delete"

        showDeleteBtn = true
        showUpdateBtn = true
    }

    fun clearAllOrDelete() {
        if (showUpdateBtn) delete(subscriberToDeleteOrUpdate)
        else clearAll()
    }

    fun insert(subscriber: Subscriber) {
        viewModelScope.launch {
            val newRowId = subscriberRepository.insert(subscriber)
            if (newRowId > -1) {
                _statusMessage.value = Event("New subscriber with id = $newRowId added..!!")
            } else {
                _statusMessage.value = Event("Error adding..!!")
            }
        }
    }

    fun update(subscriber: Subscriber) {
        viewModelScope.launch {
            val noOfRowsUpdated = subscriberRepository.update(subscriber)
            if (noOfRowsUpdated > 0) {
                _statusMessage.value = Event("$noOfRowsUpdated Subscriber updated..!!")

                inputEmail.value = null
                inputName.value = null

                showDeleteBtn = false
                showUpdateBtn = false

                btnSave.value = "Save"
                btnClearAll.value = "Clear All"
            } else {
                _statusMessage.value = Event("Error updating..!!")
            }
        }
    }

    fun delete(subscriber: Subscriber) {
        viewModelScope.launch {
            val noOfRowsDeleted = subscriberRepository.delete(subscriber)

            if (noOfRowsDeleted > 0) {
                _statusMessage.value = Event("Subscriber deleted..!!")

                inputEmail.value = null
                inputName.value = null

                showDeleteBtn = false
                showUpdateBtn = false

                btnSave.value = "Save"
                btnClearAll.value = "Clear All"
            } else {
                _statusMessage.value = Event("Error deleting..!!")
            }

        }
    }

    fun clearAll() {
        viewModelScope.launch {
            subscriberRepository.deleteAll()
        }
    }



}