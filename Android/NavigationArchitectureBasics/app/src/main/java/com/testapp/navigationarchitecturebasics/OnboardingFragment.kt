package com.testapp.navigationarchitecturebasics

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.testapp.navigationarchitecturebasics.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private lateinit var binding:FragmentOnboardingBinding
    private val args:OnboardingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_onboarding, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val inputName:String = args.name
            val inputEmail = binding.tilEmail.editText?.text.toString()
            if (inputEmail.isNullOrEmpty()) binding.tilEmail.error = "Enter valid E-mail address"
            else {
                val action = OnboardingFragmentDirections.actionOnboardingFragmentToSecondFragment(inputName,inputEmail)
                findNavController().navigate(action)
            }
        }
    }
}