package com.mattiabano.statsdontlie.api.model

import com.squareup.moshi.Json

/**
 * Game JSON data.
 */
data class GameJson(
    @Json(name = "date") val date: String,
    @Json(name = "home_team") val homeTeam: TeamJson,
    @Json(name = "home_team_score") val homeTeamScore: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "period") val period: Int,
    @Json(name = "postseason") val isPostseason: Boolean,
    @Json(name = "season") val season: Int,
    @Json(name = "status") val status: String,
    @Json(name = "time") val time: String,
    @Json(name = "visitor_team") val visitorTeam: TeamJson,
    @Json(name = "visitor_team_score") val visitorTeamScore: Int
)