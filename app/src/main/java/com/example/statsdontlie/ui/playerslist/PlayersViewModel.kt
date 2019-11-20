package com.example.statsdontlie.ui.playerslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.statsdontlie.api.Service
import com.example.statsdontlie.api.model.PlayerJson
import com.example.statsdontlie.api.model.TeamJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * The viewModel that is attached to PlayerListFragment
 */
class PlayersViewModel : ViewModel() {

    // Store the most recent response status
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    // Store the list of Players
    private val _properties = MutableLiveData<List<PlayerJson>>()
    val properties: LiveData<List<PlayerJson>>
        get() = _properties

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getPlayersProperties()
    }

    /**
     * Gets Player property information from the API Retrofit service and updates the
     * [PlayerJson] [List] [LiveData].
     */
    private fun getPlayersProperties() {
        Timber.d("GetPlayersProperties called!")

        coroutineScope.launch {
            Timber.d("CoroutineScope launched!")

            try {
                // Api call to get the first page of players
                val apiResponse = Service.api.getPlayers(playersPerPage = 100)

                val apiData = apiResponse.dataList
                val apiMetadata = apiResponse.metadataJson

                val totalPagesCount = apiMetadata?.pagesTotalCount

                val resultList: MutableList<PlayerJson> = apiData.toMutableList()

                // loop to retrieve all players
                Timber.d("Starting get $totalPagesCount pages of players.")
                (0..totalPagesCount!!).forEach {
                    Timber.d("Get page $it")
                    val apiPageResponse = Service.api.getPlayers(page = it)
                    resultList.addAll(apiPageResponse.dataList)
                }

                _properties.value = resultList
                _status.value = "Success: ${properties.value?.size} players retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Timber.d("Failure: ${e.message}")
            }
        }
    }

    /**
     * When the [PlayersViewModel] is finished, we cancel our coroutine [viewModelJob], which tells the
     * Retrofit service to stop.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}