package com.testapp.navigationarchitecturebasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.testapp.navigationarchitecturebasics.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val enteredText = binding.textInputLayout.editText?.text.toString()
            if(enteredText.isNullOrEmpty()) binding.textInputLayout.error = "Enter your name"
            else {
                val action =  HomeFragmentDirections.actionHomeFragmentToOnboardingFragment(enteredText)
                it.findNavController().navigate(action)
            }
        }

        binding.btnTAndC.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_TAndCFragment)
        }
    }

}