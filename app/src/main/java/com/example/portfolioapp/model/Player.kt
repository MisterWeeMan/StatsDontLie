package com.example.portfolioapp.model

import com.squareup.moshi.Json

data class Player(
    val id: Int,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    val position: String, // can be enum in the future?
    @Json(name = "height_feet") val heightFeet: Int?, // altezza in piedi (unita' misura)
    @Json(name = "height_inches") val heightInches: Int?, // altezza in pollici
    @Json(name = "weight_pounds") val weightPounds: Int?, // peso in pounds
    val team: Team
)