package com.example.housemanager.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.housemanager.databinding.SubCategoryLayoutBinding

class SubCategoryAdapter(private val subCatList:List<String>):RecyclerView.Adapter<SubCategoryAdapter.SubCatViewHolder>() {

    inner class SubCatViewHolder(val binding:SubCategoryLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCatViewHolder {
      val binding = SubCategoryLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SubCatViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return subCatList.size
    }

    override fun onBindViewHolder(holder: SubCatViewHolder, position: Int) {
       holder.binding.title = subCatList[position]
    }
}