package com.example.doctorprescriptioncustomer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.doctorprescriptioncustomer.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController
    lateinit var mainmenu: Unit
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
        navController = findNavController(R.id.fragment)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        mainmenu=menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.myOrder ->{
//                navController.navigate(R.id.myOrdersListFragment)
                return true
            }

            R.id.myRequests ->{
                navController.navigate(R.id.myRequestsFragment)
                return true
            }
            R.id.logout->{
                logout()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun logout() {
        mAuth.signOut()
        // Redirect to LoginActivity
        startActivity(Intent(this, CustomerLoginActivity::class.java))
        finish() // Close MainActivity
        // Clear any saved user authentication state


    }
}

