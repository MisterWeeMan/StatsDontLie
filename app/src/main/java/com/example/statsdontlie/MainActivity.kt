package com.example.statsdontlie

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.statsdontlie.databinding.ActivityMainBinding
import com.example.statsdontlie.databinding.ActivityMainConstraintsBinding

/**
 * Remember to credit the author of icons
 * <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"     title="Flaticon">www.flaticon.com</a></div><div>Icons made by <a href="https://www.flaticon.com/authors/surang" title="surang">surang</a> from <a href="https://www.flaticon.com/"     title="Flaticon">www.flaticon.com</a></div>
 */
class MainActivity : AppCompatActivity() {

    // like a layer of glue between layouts and its views and data
    private lateinit var binding: ActivityMainConstraintsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * inflate UI
         * without binding: setContentView(R.layout.activity_main)
         *
         * in order to change layout you need also to change the bind object type
         */
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // LinearLayout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_constraints) // ConstraintLayout

        binding.apply {
            playersBtn.setOnClickListener { playersClicked(it) }
            teamsBtn.setOnClickListener { teamsClicked(it) }
            gamesBtn.setOnClickListener { gamesClicked(it) }
            whoDoneButton.setOnClickListener { setName(it) }
        }

//        var player: String = "ciao"
//
//        GlobalScope.launch {
//            val service = Service.api
//
//            val players = service.getPlayers()
//
//            player = players.data[0].toString()
//        }
//
//        text_view.text = player
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

    private fun setName(view: View) {
        binding.apply {
            val newName = binding.whoEditText.text
            welcomeText.text = getString(R.string.welcome_message_username, newName)
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
