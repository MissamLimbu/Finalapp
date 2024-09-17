package com.example.finalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.LoginRequest
import com.example.finalapp.RetrofitInstance
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameField = findViewById<EditText>(R.id.username_field)
        val passwordField = findViewById<EditText>(R.id.password_field)
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()
            loginViewModel.login(username, password)
        }

        loginViewModel.loginSuccess.observe(this) { keypass ->
            // Navigate to Dashboard
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("keypass", keypass)
            startActivity(intent)
            finish()
        }

        loginViewModel.loginError.observe(this) {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}
