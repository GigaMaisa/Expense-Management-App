package com.example.gigamaisuradze.data

import androidx.lifecycle.LiveData


class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val readAllData: LiveData<List<Expense>> = expenseDao.readAllData()

    suspend fun addExpense(expense: Expense) {
        expenseDao.addExpense(expense)
    }

    suspend fun updateExpense(expense: Expense) {
        expenseDao.updateExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }

    suspend fun deleteAllExpenses() {
        expenseDao.deleteAllExpenses()
    }

}