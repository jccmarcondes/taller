package com.example.code_chalenge.views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.code_chalenge.R

class LoginActivity : AppCompatActivity() {

    var usernameTxt = findViewById<EditText>(R.id.usernameEditText)
    var passwordTxt = findViewById<EditText>(R.id.passwordEditText)
    var loginBtn = findViewById<Button>(R.id.enterButton)

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        observableEvents()
        observeActions()
    }

    private fun observableEvents() {
        viewModel.result.observe(this) { result ->
            if (result) {
                Toast.makeText(this@LoginActivity, "Connected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@LoginActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeActions() {
        loginBtn.setOnClickListener {
            viewModel.login(usernameTxt.text.toString(), passwordTxt.text.toString())
        }
    }
}