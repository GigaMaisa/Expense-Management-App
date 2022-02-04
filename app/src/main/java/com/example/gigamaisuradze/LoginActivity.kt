package com.example.gigamaisuradze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gigamaisuradze.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginActivityLoginButton.setOnClickListener {
            if (emailLoginEditText.text.isNotEmpty() && passwordLoginEditText.text.isNotEmpty()) {
                val expensesManagementActivity = Intent(this,ExpensesManagementActivity::class.java)
                startActivity(expensesManagementActivity)
            }
            else {
                Toast.makeText(this,"Please, fill all lines",Toast.LENGTH_SHORT).show()
            }
        }
    }
}