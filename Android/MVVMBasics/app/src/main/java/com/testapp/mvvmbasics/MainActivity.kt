package com.testapp.mvvmbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.testapp.mvvmbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var activityViewModel: MainActivityViewModel
    private lateinit var factory:MainActivityVMFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        factory = MainActivityVMFactory(10.0)
        activityViewModel = ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)
        binding.viewModel = activityViewModel
        binding.lifecycleOwner = this
    }
}