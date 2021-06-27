package com.testapp.navigationarchitecturebasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.testapp.navigationarchitecturebasics.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding:FragmentWelcomeBinding
    private val args:WelcomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = args.inputText
        val email = args.inputEmail

        binding.tvName.text =
            if (name.isNullOrEmpty()) "Welcome Guest"
        else "Welcome $name"


        binding.tvEmail.text =
            if (name.isNullOrEmpty()) "Welcome Guest"
            else email

        binding.btnTAndC.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_TAndCFragment)
        }
    }
}