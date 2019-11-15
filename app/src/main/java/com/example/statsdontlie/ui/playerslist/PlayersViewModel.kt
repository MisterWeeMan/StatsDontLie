package com.example.statsdontlie.ui.playerslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.statsdontlie.api.model.PlayerJson
import com.example.statsdontlie.api.NbaService
import com.example.statsdontlie.api.Service
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlayersViewModel: ViewModel() {
    
    private val nbaService: NbaService = Service.api

    var playersCount = MutableLiveData<Int>()
    var players = MutableLiveData<List<PlayerJson>>()

    init {
        playersCount.value = 0
        players.value = listOf()
    }

    fun setPlayersCount() {
        GlobalScope.launch {
            val playersData = nbaService.getPlayers()
            playersCount.postValue(playersData.metadataJson?.resultsTotalCount)
        }
    }

    fun setPlayersList() {
        GlobalScope.launch {
            val playersData = nbaService.getPlayers()
            players.postValue(playersData.dataList)
        }
    }


}