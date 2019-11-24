package com.mattiabano.statsdontlie.ui.playerslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mattiabano.statsdontlie.api.Service
import com.mattiabano.statsdontlie.api.model.PlayerJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

enum class PlayersApiStatus {
    LOADING, ERROR, DONE
}

/**
 * The viewModel that is attached to PlayerListFragment
 */
class PlayersViewModel : ViewModel() {

    // Store the most recent response status
    private val _status = MutableLiveData<PlayersApiStatus>()
    val status: LiveData<PlayersApiStatus>
        get() = _status

    // Store the list of Players
    private val _properties = MutableLiveData<List<PlayerJson>>()
    val properties: LiveData<List<PlayerJson>>
        get() = _properties

    // Navigate to player detail
    private val _navigateToPlayerDetail = MutableLiveData<PlayerJson>()
    val navigateToPlayerDetail: LiveData<PlayerJson>
        get() = _navigateToPlayerDetail

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
        coroutineScope.launch {
            try {
                Timber.d("Starting fetching players")
                _status.value = PlayersApiStatus.LOADING

                // Api call to get the first page of players
                val apiResponse = Service.api.getPlayers(playersPerPage = 100)

                val totalPagesCount = apiResponse.metadataJson?.pagesTotalCount

                val resultList = mutableListOf<PlayerJson>()

                // loop to retrieve all players
                Timber.d("Starting get $totalPagesCount pages of players.")

                (1..totalPagesCount!!).forEach {
                    val apiPageResponse = Service.api.getPlayers(playersPerPage = 100, page = it)
                    resultList.addAll(apiPageResponse.dataList)

                    val resultPerPage = apiPageResponse.metadataJson?.resultPerPage
                    Timber.d("Fetched $resultPerPage players from page $it")
                }

                Timber.d("Fetched ${resultList.size} players")

                resultList.sortBy { it.firstName }

                _status.value = PlayersApiStatus.DONE
                _properties.value = resultList
            } catch (e: Exception) {
                _status.value = PlayersApiStatus.ERROR
                Timber.e(e.message)
                _properties.value = listOf()
            }
        }
    }

    // Navigate to the detail screen
    fun displayPlayerDetail(playerJson: PlayerJson) {
        _navigateToPlayerDetail.value = playerJson
    }

    // To call when navigation to detail screen is complete
    fun displayPlayerDetailComplete() {
        _navigateToPlayerDetail.value = null
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