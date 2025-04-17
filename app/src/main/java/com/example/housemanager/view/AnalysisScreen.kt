package com.example.housemanager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.housemanager.R
import com.example.housemanager.databinding.FragmentAnalysisScreenBinding
import com.example.housemanager.view.model.SplitObject


class AnalysisScreen : Fragment() {

    private var binding: FragmentAnalysisScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalysisScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.expPieChart?.setExpenses(listOf(
            SplitObject(
                color = requireContext().getColor(R.color.red),
                tag = "Bills",
                expense = 12000.0
            ),
            SplitObject(
                color = requireContext().getColor(R.color.light_blue),
                tag = "Clothing",
                expense = 3200.0
            ),
            SplitObject(
                color = requireContext().getColor(R.color.yellow),
                tag = "Medical",
                expense = 1500.0
            ),
            SplitObject(
                color = requireContext().getColor(R.color.light_green),
                tag = "Rent",
                expense = 8400.0
            )
        ))
    }
}