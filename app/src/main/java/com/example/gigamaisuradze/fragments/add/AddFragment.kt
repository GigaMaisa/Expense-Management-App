package com.example.gigamaisuradze.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gigamaisuradze.R
import com.example.gigamaisuradze.data.Expense
import com.example.gigamaisuradze.data.ExpenseViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mExpenseViewModel: ExpenseViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mExpenseViewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)

        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view

    }

    private fun insertDataToDatabase() {
        val name = nameExpenseAddFragmentEditText.text.toString()
        val description = descriptionAddFragmentEditText.text.toString()
        val amountSpent = amountSpentAddFragmentEditText.text

        if (inputCheck(name, description, amountSpent)) {
            val expense = Expense(0, name, description, Integer.parseInt(amountSpent.toString()))
            mExpenseViewModel.addExpense(expense)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else{
            Toast.makeText(requireContext(),"Please fill all lines",Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(name: String, description: String, amountSpent: Editable):Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(description) && amountSpent.isEmpty())
    }


}