package com.mattiabano.statsdontlie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = this.findNavController(R.id.my_nav_host_fragment)

        // Add navigation button to action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    // Tells the nav controller how to react when navigation button is clicked.
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
