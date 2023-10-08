package com.example.helloword

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class HomeActivity : AppCompatActivity(), View.OnClickListener,
    NavigationBarView.OnItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fragHome : Fragment
    private lateinit var fragMenu : Fragment
    private lateinit var fragProfile : Fragment


    private lateinit var tv: TextView

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomView)
        bottomNavigationView.setOnItemSelectedListener(this)

        fragHome = HomeFragment()
        fragMenu = MenuFragment()
        fragProfile = ProfileFragment()


        tv = findViewById(R.id.textView2)

        val user = intent.getParcelableExtra<User>("User")
        user?.let {
            val email = intent.getParcelableExtra<User>("User")?.email
            val password = intent.getParcelableExtra<User>("User")?.password
            tv.text = "email : $email, password: $password"
        }
        val btnGo : Button = findViewById(R.id.btnGo)
        btnGo.setOnClickListener(this)

//        fragHome = findViewById(R.id.bottomView)
//        fragMenu = findViewById(R.id.bottomView)
//        fragProfile = findViewById(R.id.bottomView)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btnGo -> {
//                   val message ="Hallo"
//                    val intent = Intent()
//                    intent.action = Intent.ACTION_SEND
//                    intent.putExtra(Intent.EXTRA_TEXT, message)
//                    intent.type = "text/plain"
//                    startActivity(intent)
                    val intent = Intent()
                    intent.putExtra("history", "Anda Sudah Login")
                    setResult(RESULT_OK,intent)
                    finish()
                }
            }
        }
        TODO("Not yet implemented")
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, fragHome).commit()
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, fragMenu).commit()
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, fragProfile).commit()

        when (item.itemId) {
            R.id.home -> {
                transaction.replace(R.id.flFragment, fragHome)
            }
            R.id.menu -> {
                transaction.replace(R.id.flFragment, fragMenu)
            }
            R.id.profile -> {
                transaction.replace(R.id.flFragment, fragProfile)
            }
        }
        transaction.commit()
        return true
    }
}

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.home -> {
//                fragHome.visibility = View.VISIBLE
//                fragMenu.visibility = View.GONE
//                fragProfile.visibility = View.GONE
//            }
//            R.id.menu -> {
//                fragHome.visibility = View.GONE
//                fragMenu.visibility = View.VISIBLE
//                fragProfile.visibility = View.GONE
//            }
//            R.id.profile -> {
//                fragHome.visibility = View.GONE
//                fragMenu.visibility = View.GONE
//                fragProfile.visibility = View.VISIBLE
//            }
//        }
//        return true
//    }
//}