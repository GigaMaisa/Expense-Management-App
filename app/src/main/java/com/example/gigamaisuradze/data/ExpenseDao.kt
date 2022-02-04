package com.example.gigamaisuradze.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExpense(expense: Expense)


    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Update
    suspend fun updateExpense(expense: Expense)

    @Query("DELETE FROM amount_table")
    suspend fun deleteAllExpenses()



    @Query("SELECT * FROM amount_table ORDER BY amountSpent DESC")
    fun readAllData(): LiveData<List<Expense>>
}
