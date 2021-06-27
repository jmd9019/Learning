package com.testapp.mvvmbasics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(initValue:Double = 0.0) : ViewModel() {

    private val _sum = MutableLiveData(initValue)
    val sum:LiveData<Double> get() = _sum

    var inputNumber = MutableLiveData<String>()

    fun add() {
        val value = inputNumber.value!!.toDouble()
       _sum.value =  _sum.value?.plus(value)
    }

}