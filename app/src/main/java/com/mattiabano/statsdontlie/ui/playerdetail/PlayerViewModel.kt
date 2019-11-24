package com.mattiabano.statsdontlie.ui.playerdetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mattiabano.statsdontlie.api.model.PlayerJson
import com.mattiabano.statsdontlie.api.model.SeasonAvaragesJson
import com.mattiabano.statsdontlie.ui.playerslist.PlayersApiStatus
import com.mattiabano.statsdontlie.utility.seasonAverages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class PlayerViewModel(playerJson: PlayerJson, app: Application): ViewModel() {

    // Store the most recent response status
    private val _status = MutableLiveData<PlayersApiStatus>()
    val status: LiveData<PlayersApiStatus>
        get() = _status

    private val _selectedPlayer = MutableLiveData<PlayerJson>()
    val selectedPlayer: LiveData<PlayerJson>
        get() = _selectedPlayer

    private val _playerAverages = MutableLiveData<SeasonAvaragesJson>()
    val playerAverages: LiveData<SeasonAvaragesJson>
        get() = _playerAverages

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        _selectedPlayer.value = playerJson
        getPlayerAverages()
    }

    private fun getPlayerAverages() {
        coroutineScope.launch {
            try {
                val playerName = "${_selectedPlayer.value!!.firstName} ${_selectedPlayer.value!!.lastName}"
                Timber.d("Starting fetching $playerName averages")

                _status.value = PlayersApiStatus.LOADING

                val apiResponse = com.mattiabano.statsdontlie.api.Service.api.getSeasonAverages(
                    season = seasonAverages, playerIds = arrayOf(_selectedPlayer.value!!.id)
                )

                val apiData = apiResponse.dataList

                _playerAverages.value = apiData[0]

                _status.value = PlayersApiStatus.DONE
            } catch (e: Exception) {
                _status.value = PlayersApiStatus.ERROR
                Timber.e(e.message)
            }
        }
    }

    class PlayerViewModelFactory(
        private val player: PlayerJson,
        private val application: Application
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
                return PlayerViewModel(player, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}