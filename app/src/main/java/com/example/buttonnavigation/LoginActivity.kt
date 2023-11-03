package com.example.buttonnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.buttonnavigation.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val validUsername = "Anisah"
    private val validPassword = "493059"

    private lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val usernameEditText = viewBinding.unameedit
        val passwordEditText = viewBinding.pwedit
        val loginButton = viewBinding.loginButton

        with(viewBinding){

        }
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.contains(" ") || !password.matches(Regex("\\d+"))) {
                // Validasi input pengguna
                Toast.makeText(this, "Invalid username and password", Toast.LENGTH_SHORT).show()
            } else if (username == validUsername && password == validPassword) {
                // Login berhasil, arahkan ke halaman berikutnya
                Log.d("MyApp", "Login berhasil. Arahkan ke halaman home.")
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish()
            }
        }
    }
}