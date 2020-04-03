package com.mattiabano.statsdontlie

import com.mattiabano.statsdontlie.api.Service
import com.mattiabano.statsdontlie.api.model.PlayerJson
import kotlinx.coroutines.runBlocking
import org.junit.Test
import timber.log.Timber

class TestingApi {

    @Test
    fun getAllPositions() {
        runBlocking {
            val apiResponse = Service.api.getPlayers(playersPerPage = 100)
            val totalPagesCount = apiResponse.metadataJson?.pagesTotalCount
            val resultList = mutableListOf<PlayerJson>()

            (1..totalPagesCount!!).forEach {
                val apiPageResponse = Service.api.getPlayers(playersPerPage = 100, page = it)
                resultList.addAll(apiPageResponse.dataList)
            }

            val positionsSet = resultList.map { it.position }.toSet()

            println(positionsSet)
        }
    }
}