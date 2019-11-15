package com.example.statsdontlie.ui.playerslist

import androidx.lifecycle.ViewModel
import com.example.statsdontlie.utility.dummyGenericPlayer
import com.example.statsdontlie.utility.dummyGenericTeam

class PlayersViewModel: ViewModel() {

    val listDummies = (1..30).toList().map {
        dummyGenericPlayer.copy(
            id = it,
            firstName = "Player$it",
            team = dummyGenericTeam.copy(
                id = it,
                name = "Team$it"
            )
        )
    }
}