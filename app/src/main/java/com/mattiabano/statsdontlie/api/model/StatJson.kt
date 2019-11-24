package com.mattiabano.statsdontlie.api.model

import com.squareup.moshi.Json

/**
 * Stat JSON data
 */
data class StatJson(
    @Json(name = "ast") val assists: Int,
    @Json(name = "blk") val blocks: Int,
    @Json(name = "dreb") val defRebounds: Int,
    @Json(name = "fg3_pct") val threeFieldGoalsPct: Double,
    @Json(name = "fg3a") val threeFieldGoalsAttempted: Int,
    @Json(name = "fg3m") val threeFieldGoalsMade: Int,
    @Json(name = "fg_pct") val fieldGoalsPct: Double,
    @Json(name = "fga") val fieldGoalsAttempted: Int,
    @Json(name = "fgm") val fieldGoalsMade: Int,
    @Json(name = "ft_pct") val freeThrowsPct: Double,
    @Json(name = "fta") val freeThrowsAttempted: Int,
    @Json(name = "ftm") val freeThrowsMade: Int,
    @Json(name = "game") val game: GameJson,
    @Json(name = "id") val id: Int,
    @Json(name = "min") val minute: String,
    @Json(name = "oreb") val offensiveRebounds: Int,
    @Json(name = "pf") val personalFouls: Int,
    @Json(name = "player") val player: PlayerJson,
    @Json(name = "pts") val points: Int,
    @Json(name = "reb") val rebounds: Int,
    @Json(name = "stl") val steals: Int,
    @Json(name = "team") val team: TeamJson,
    @Json(name = "turnover") val turnovers: Int
)