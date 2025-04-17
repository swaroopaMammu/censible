package com.example.housemanager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.housemanager.R
import com.example.housemanager.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    private var binding : FragmentWelcomeScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.enterB?.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeScreen_to_mainCategoryDetailScreen)
        }
    }
}