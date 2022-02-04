package com.example.gigamaisuradze.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gigamaisuradze.R
import com.example.gigamaisuradze.data.Expense
import kotlinx.android.synthetic.main.custom_row.view.*

class ExpenseAdapter: RecyclerView.Adapter<ExpenseAdapter.MyViewHolder>() {
    private var expenseList = emptyList<Expense>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    override fun onBindViewHolder(holder: ExpenseAdapter.MyViewHolder, position: Int) {
        val currentItem = expenseList[position]
        holder.itemView.nameTxt.text = currentItem.name
        holder.itemView.descriptionTxt.text = currentItem.description
        holder.itemView.priceTxt.text = currentItem.amountSpent.toString()
        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }
    fun setData(expense: List<Expense>) {
        this.expenseList =  expense
        notifyDataSetChanged()
    }

}