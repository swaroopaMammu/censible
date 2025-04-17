package com.example.housemanager.view.maincategory

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.housemanager.R
import com.example.housemanager.databinding.FragmentEssentialListBinding

class EssentialListFragment : Fragment() {

    private var binding:FragmentEssentialListBinding? = null
    companion object {
        fun newInstance(data:String): EssentialListFragment{
            val fragment = EssentialListFragment()
            val bundle = Bundle()
            bundle.putString("show_data", data)
            fragment.arguments = bundle
           return EssentialListFragment()
        }
    }

    private val viewModel: EssentialListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEssentialListBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.dataValue?.text = arguments?.getString("show_data")

    }
}