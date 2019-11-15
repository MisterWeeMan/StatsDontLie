package com.example.statsdontlie.api.model

import com.squareup.moshi.Json

data class SeasonAvaragesJson(
    @Json(name = "ast") val assists: Double,
    @Json(name = "blk") val blocks: Double,
    @Json(name = "dreb") val defRebounds: Double,
    @Json(name = "fg3_pct") val threeFieldGoalsPct: Double,
    @Json(name = "fg3a") val threeFieldGoalsAttempted: Double,
    @Json(name = "fg3m") val threeFieldGoalsMade: Double,
    @Json(name = "fg_pct") val fieldGoalsPct: Double,
    @Json(name = "fga") val fieldGoalsAttempted: Double,
    @Json(name = "fgm") val fieldGoalsMade: Double,
    @Json(name = "ft_pct") val freeThrowsPct: Double,
    @Json(name = "fta") val freeThrowsAttempted: Double,
    @Json(name = "ftm") val freeThrowsMade: Double,
    @Json(name = "games_played") val gamesPlayed: Int,
    @Json(name = "min") val minute: String,
    @Json(name = "oreb") val offensiveRebounds: Double,
    @Json(name = "pf") val personalFouls: Double,
    @Json(name = "player_id") val playerId: Int,
    @Json(name = "pts") val points: Double,
    @Json(name = "reb") val rebounds: Double,
    @Json(name = "season") val season: Int,
    @Json(name = "stl") val steals: Double,
    @Json(name = "turnover") val turnovers: Double
)