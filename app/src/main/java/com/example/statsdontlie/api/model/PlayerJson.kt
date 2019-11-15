package com.example.statsdontlie.api.model

import com.squareup.moshi.Json

/**
 * Player JSON data.
 */
data class PlayerJson(
    @Json(name = "id") val id: Int,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "position") val position: String,
    @Json(name = "height_feet") val heightFeet: Int?,
    @Json(name = "height_inches") val heightInches: Int?,
    @Json(name = "weight_pounds") val weightPounds: Int?,
    @Json(name = "team") val team: TeamJson
)