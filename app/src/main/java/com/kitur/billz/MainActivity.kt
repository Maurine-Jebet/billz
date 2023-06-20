package com.kitur.billz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilPasswordCheckout: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etPasswordCheckout: TextInputEditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()

    }

    override fun onResume() {
        super.onResume()
        tvLogin.setOnClickListener {
            val intent = Intent(this,tvLogin::class.java)
            startActivity(intent)
        }



    }

    fun castViews() {
        tvLogin = findViewById(R.id.tvLogin)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilPasswordCheckout = findViewById(R.id.tilConfirmPassword)



    }


    fun validateSignup() {
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val checkout = etPasswordCheckout.text.toString()
        val error = false


        if (firstName.isBlank()) {
            tilFirstName.error = "First name is required"


        }
        if (lastName.isBlank()) {
            tilLastName.error = "Last name is required"

        }
        if (email.isBlank()) {
            tilEmail.error = "Email is required"

        }
        if (password.isBlank()) {
            tilPassword.error = "Password is required"

        }
        if (checkout.isBlank()) {
            tilPasswordCheckout.error = "PasswordCheckout is required"

        }
        if (password != checkout) {
            tilPasswordCheckout.error = "Password and PasswordCheckout does not match"
        }

        if (!error){
            Toast
                .makeText(this,"$firstName$lastName$email", Toast.LENGTH_LONG)
                .show()

        }
        fun clearErrors(){
            tilFirstName.error = null
            tilLastName.error = null
            tilEmail.error = null
            tilPassword.error = null
            tilPasswordCheckout.error = null



        }


    }
}
