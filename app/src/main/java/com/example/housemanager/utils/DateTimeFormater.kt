package com.example.housemanager.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.dateToMonthFormat():String{

        val inputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())

        val date = inputFormat.parse(this)
        val formattedDate = date?.let { outputFormat.format(it) }
    return  formattedDate?:""
    }