package com.example.portfolioapp.model

import com.squareup.moshi.Json

data class Team(
    val id: Int,
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    @Json(name = "full_name") val fullName: String,
    val name: String
)