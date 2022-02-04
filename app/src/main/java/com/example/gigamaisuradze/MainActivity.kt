package com.example.gigamaisuradze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gigamaisuradze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun onRegister(v: View) {
        val registerActivity =Intent(this,RegisterActivity::class.java)
        startActivity(registerActivity)
    }
    fun onLogin(v: View) {
        val loginActivity = Intent(this,LoginActivity::class.java)
        startActivity(loginActivity)
    }
}