package com.example.helloword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SignupAactivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var etConfirmPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_aactivity)

        etEmail = findViewById(R.id.Email)
        etPassword = findViewById(R.id.Password)
        etConfirmPassword = findViewById(R.id.ConfirmPassword)

        val btnSignUp : Button = findViewById(R.id.buttonSignup)
        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.buttonSignup -> {

                    val bundle = Bundle()
                    bundle.putString("email", etEmail.text.toString())
                    bundle.putString("password", etPassword.text.toString())

                    val intent = Intent(this@SignupAactivity, LoginActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }
        }
        TODO("Not yet implemented")
    }
}