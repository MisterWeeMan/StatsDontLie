package com.example.statsdontlie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.statsdontlie.utility.StatsTimer

/**
 * Remember to credit the author of icons
 * <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"     title="Flaticon">www.flaticon.com</a></div><div>Icons made by <a href="https://www.flaticon.com/authors/surang" title="surang">surang</a> from <a href="https://www.flaticon.com/"     title="Flaticon">www.flaticon.com</a></div>
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var timer: StatsTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = StatsTimer(this.lifecycle)
        navController = this.findNavController(R.id.my_nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
