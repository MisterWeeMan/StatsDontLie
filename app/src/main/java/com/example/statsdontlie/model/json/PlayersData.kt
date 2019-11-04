package com.example.statsdontlie.model.json

import com.example.statsdontlie.model.Player
import com.squareup.moshi.Json

data class PlayersData(
    val data: List<Player>,
    val meta: ApiMetadata
)

data class ApiMetadata(
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "current_page") val currentPage: Int,
    @Json(name = "next_page") val nextPage: Int,
    @Json(name = "per_page") val perPage: Int,
    @Json(name = "total_count") val totalCount: Int
)