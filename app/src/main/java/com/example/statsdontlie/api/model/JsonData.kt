package com.example.statsdontlie.api.model

import com.squareup.moshi.Json

/**
 * Represents the JSON that is returned from the GET all calls in NbaService.
 */
data class DataJson<T>(
    @Json(name = "data") val dataList: List<T>,
    @Json(name = "meta") val metadataJson: MetadataJson?
)

data class MetadataJson(
    @Json(name = "total_pages") val pagesTotalCount: Int,
    @Json(name = "current_page") val currentPage: Int,
    @Json(name = "next_page") val nextPage: Int?,
    @Json(name = "per_page") val resultPerPage: Int,
    @Json(name = "total_count") val resultsTotalCount: Int
)