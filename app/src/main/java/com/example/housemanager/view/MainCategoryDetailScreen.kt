package com.example.housemanager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.housemanager.R
import com.example.housemanager.databinding.FragmentMainCategoryDetailScreenBinding
import com.example.housemanager.view.adapter.ExpenseListAdapter
import com.example.housemanager.view.adapter.SubCategoryAdapter
import com.example.housemanager.view.model.ExpenseDisplayModel

class MainCategoryDetailScreen : Fragment() {

   private var binding : FragmentMainCategoryDetailScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainCategoryDetailScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.dateFilter?.setOnClickListener{
            val popUpMenu =  PopupMenu(requireContext(),it)
            popUpMenu.menuInflater.inflate(R.menu.date_filter_menu, popUpMenu.menu)
            popUpMenu.setOnMenuItemClickListener { menuItem ->
                binding?.dateFilter?.text = menuItem.title
                true
            }

            popUpMenu.show()
        }
        val list = listOf(
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
            ExpenseDisplayModel(title = "Milk", date = "April 8th,2025", amount = "₹200"),
        )

        val list2 = listOf(
            "All","Groceries","Utilities","Transportation","Medical"
        )
        binding?.viewPager?.adapter = ExpenseListAdapter(list)
        binding?.subCategory?.adapter = SubCategoryAdapter(list2)

        binding?.addNewExpButton?.setOnClickListener {
          //  findNavController().navigate(R.id.action_mainCategoryDetailScreen_to_addNewExpense)
            findNavController().navigate(R.id.action_mainCategoryDetailScreen_to_analysisScreen)
        }

    }


}