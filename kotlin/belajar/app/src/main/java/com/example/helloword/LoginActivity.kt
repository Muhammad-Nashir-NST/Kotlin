package com.example.helloword

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var history: TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data : Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text = returnString
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        history = findViewById(R.id.history)
        etEmail = findViewById(R.id.Email)
        etPassword = findViewById(R.id.Password)

        val bundle = intent.extras

        if (bundle != null) {
            etEmail.setText(bundle.getString("email"))
            etPassword.setText(bundle.getString("password"))
        }

        val btnSignUp : Button = findViewById(R.id.buttonSignup)
        btnSignUp.setOnClickListener(this)

        val btnLogin : Button = findViewById(R.id.buttonLogin)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

            when(v!!.id) {
                R.id.buttonSignup -> {
                    val intent = Intent(this@LoginActivity, SignupAactivity::class.java)
                    startActivity(intent)
                }
            }

            when(v!!.id) {
                R.id.buttonLogin -> {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.putExtra("User", User(etEmail.text.toString(),
                        etPassword.text.toString()))
                    resultLauncher.launch(intent)
                }
            }

    }
}
