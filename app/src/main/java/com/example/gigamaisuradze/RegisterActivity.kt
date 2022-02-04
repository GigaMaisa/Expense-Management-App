package com.example.gigamaisuradze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gigamaisuradze.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        continueButton.setOnClickListener {
            if (firstNameEditText.text.isNotEmpty() && lastNameEditText.text.isNotEmpty() && ageEditText.text.isNotEmpty() && emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                val expensesManagementActivity = Intent(this,ExpensesManagementActivity::class.java)
                startActivity(expensesManagementActivity)
            }
            else {
                Toast.makeText(this,"Firstly, register",Toast.LENGTH_SHORT).show()
            }
        }
    }
}