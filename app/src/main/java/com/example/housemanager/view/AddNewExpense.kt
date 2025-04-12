package com.example.housemanager.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.example.housemanager.R
import com.example.housemanager.databinding.FragmentAddNewExpenseBinding
import com.example.housemanager.utils.dateToMonthFormat
import java.util.Calendar

class AddNewExpense : Fragment() {

    private var binding: FragmentAddNewExpenseBinding? =null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddNewExpenseBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.categoryValue?.setOnClickListener{
            val popUpMenu =  PopupMenu(requireContext(),it)
            popUpMenu.menuInflater.inflate(R.menu.category_list, popUpMenu.menu)
            popUpMenu.setOnMenuItemClickListener { menuItem ->
                binding?.categoryValue?.text = menuItem.title
                true
            }

            popUpMenu.show()
        }


        binding?.dateValue?.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding?.dateValue?.text = date.dateToMonthFormat()
            }, year, month, day)
            datePickerDialog.show()
        }
    }

}