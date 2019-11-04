package com.example.portfolioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.example.portfolioapp.api.Service
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate UI
        setContentView(R.layout.activity_main)

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
}
