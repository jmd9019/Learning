package com.testapp.roomdbbasicslearn.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.testapp.roomdbbasicslearn.R
import com.testapp.roomdbbasicslearn.databinding.FragmentHomeBinding
import com.testapp.roomdbbasicslearn.db.SubscriberDB
import com.testapp.roomdbbasicslearn.db.repository.SubscriberRepository
import com.testapp.roomdbbasicslearn.models.Subscriber
import com.testapp.roomdbbasicslearn.ui.viewmodels.SubscriberVMFactory
import com.testapp.roomdbbasicslearn.ui.viewmodels.SubscriberViewModel

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val dao = SubscriberDB.getInstance(context?.applicationContext ?: this.requireContext()).subscriberDao
        val subscriberRepository = SubscriberRepository(dao)
        val factory = SubscriberVMFactory(subscriberRepository)
        subscriberViewModel = ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)
        binding.subscriberViewModel = subscriberViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        displaySubscribers()

        subscriberViewModel.statusMessage.observe(viewLifecycleOwner,{
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this.requireContext(),it,Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        binding.rvSubscribers.layoutManager = LinearLayoutManager(this.requireContext())
    }

    private fun displaySubscribers() {
        subscriberViewModel.subscribersLiveData.observe(viewLifecycleOwner,{
            if (it != null) {
                Log.d("Data",it.toString())
                binding.rvSubscribers.adapter = SubscribersListAdapter(it) { subscriber: Subscriber ->
                    listItemClicked(subscriber)
                }
            }
        })
    }

    private fun listItemClicked(subscriber:Subscriber) {
        subscriberViewModel.showSelectedSubscriberUpdateButtons(subscriber)
    }
}