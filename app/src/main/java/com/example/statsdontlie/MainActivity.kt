package com.example.statsdontlie

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.statsdontlie.databinding.ActivityMainBinding
import com.example.statsdontlie.databinding.ActivityMainConstraintsBinding
import com.example.statsdontlie.databinding.ActivityMainFragmentBinding
import timber.log.Timber

/**
 * Remember to credit the author of icons
 * <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"     title="Flaticon">www.flaticon.com</a></div><div>Icons made by <a href="https://www.flaticon.com/authors/surang" title="surang">surang</a> from <a href="https://www.flaticon.com/"     title="Flaticon">www.flaticon.com</a></div>
 */
class MainActivity : AppCompatActivity() {

    // like a layer of glue between layouts and its views and data
    private lateinit var binding: ActivityMainFragmentBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("onCreate called!")
        /**
         * inflate UI
         * without binding: setContentView(R.layout.activity_main)
         *
         * in order to change layout you need also to change the bind object type
         */
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // LinearLayout
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_constraints) // ConstraintLayout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_fragment) // Fragments

//        binding.apply {
//            playersBtn.setOnClickListener { playersClicked(it) }
//            teamsBtn.setOnClickListener { teamsClicked(it) }
//            gamesBtn.setOnClickListener { gamesClicked(it) }
//            whoDoneButton.setOnClickListener { setName(it) }
//        }

        navController = this.findNavController(R.id.my_nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private fun playersClicked(view: View) {
        Toast.makeText(this, "Players clicked!", Toast.LENGTH_SHORT).show()
    }

    private fun teamsClicked(view: View) {
        Toast.makeText(this, "Teams clicked!", Toast.LENGTH_SHORT).show()
    }

    private fun gamesClicked(view: View) {
        Toast.makeText(this, "Games clicked!", Toast.LENGTH_SHORT).show()
    }

//    private fun setName(view: View) {
//        binding.apply {
//            val newName = binding.whoEditText.text
//            welcomeText.text = getString(R.string.welcome_message_username, newName)
//        }
//
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken, 0)
//    }
}
