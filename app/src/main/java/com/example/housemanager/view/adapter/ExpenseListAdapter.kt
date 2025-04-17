package com.example.housemanager.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.housemanager.databinding.ExpenseListItemBinding
import com.example.housemanager.view.model.ExpenseDisplayModel

class ExpenseListAdapter(private val expList:List<ExpenseDisplayModel>):RecyclerView.Adapter<ExpenseListAdapter.ExpenseViewHolder>() {

    inner class ExpenseViewHolder(val binding: ExpenseListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ExpenseListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ExpenseViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return expList.size
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
       holder.binding.model = expList[position]
    }
}