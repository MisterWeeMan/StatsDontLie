package com.example.statsdontlie.api.model

import com.squareup.moshi.Json

/**
 * Team JSON data.
 */
data class TeamJson(
    @Json(name = "id") val id: Int,
    @Json(name = "abbreviation") val abbreviation: String,
    @Json(name = "city") val city: String,
    @Json(name = "conference") val conference: String,
    @Json(name = "division") val division: String,
    @Json(name = "full_name") val fullName: String,
    @Json(name = "name") val name: String
)