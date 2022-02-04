package com.example.gigamaisuradze.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gigamaisuradze.R
import com.example.gigamaisuradze.data.Expense
import com.example.gigamaisuradze.data.ExpenseViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mExpenseViewModel: ExpenseViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mExpenseViewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)

        view.updateNameEditText.setText(args.currentExpense.name)
        view.updateDescriptionEditText.setText(args.currentExpense.description)
        view.updateAmountSpentEditText.setText(args.currentExpense.amountSpent.toString())

        view.updateButton.setOnClickListener {
            updateExpense()
        }
        setHasOptionsMenu(true)
        return view
    }
    private fun updateExpense(){
        val name = updateNameEditText.text.toString()
        val description = updateDescriptionEditText.text.toString()
        val amountSpent = Integer.parseInt(updateAmountSpentEditText.text.toString())

        if (inputCheck(name,description, updateAmountSpentEditText.text)) {
            val updatedExpense = Expense(args.currentExpense.id, name, description, amountSpent)
            mExpenseViewModel.updateExpense(updatedExpense)
            Toast.makeText(requireContext(),"Successfully updated",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        else {
            Toast.makeText(requireContext(),"Fill out all fields",Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(name: String, description: String, amountSpent: Editable):Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(description) && amountSpent.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteExpense()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteExpense() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_,_ ->
            mExpenseViewModel.deleteExpense(args.currentExpense)
            Toast.makeText(requireContext(),"Successfully deleted",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }
        builder.setNegativeButton("No") { _, _ ->}
            builder.setTitle("Delete ${args.currentExpense.name}?")
            builder.setMessage("Are you sure you want to delete ${args.currentExpense.name}?")
            builder.create().show()

    }
}