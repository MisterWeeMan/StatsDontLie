package com.example.statsdontlie.api

import com.example.statsdontlie.api.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * HTTP client to communicate with  balldontlie API.
 * Balldontlie API provides NBA data.
 * Documentation: https://www.balldontlie.io/
 */

private const val BASE_URL = " https://www.balldontlie.io/api/v1/"

// This interface contains all HTTP API calls that I need in the application
interface NbaService {

    @GET("players") // return all players from all seasons
    suspend fun getPlayers(
        @Query("page") page: Int = 0,
        @Query("per_page") playersPerPage: Int = 25,
        @Query("search") search: String = ""
    ): DataJson<PlayerJson>

    @GET("players/{id}") // return a specific player by ID
    suspend fun getPlayerById(@Path("id") playerId: Int): PlayerJson

    @GET("teams") // return all teams form the current season
    suspend fun getTeams(
        @Query("page") page: Int = 0,
        @Query("per_page") teamsPerPage: Int = 30
    ): DataJson<TeamJson>

    @GET("teams/{id}") // return a specific team by ID
    suspend fun getTeamById(@Path("id") teamId: Int): TeamJson

    @GET("games") // return all games
    suspend fun getGames(
        @Query("page") page: Int = 0,
        @Query("per_page") playersPerPage: Int = 25,
        @Query("dates") dates: Array<String> = arrayOf(), // format "YYYY-MM-DD"
        @Query("seasons") seasons: Array<Int> = arrayOf(),
        @Query("team_ids") teamIds: Array<Int> = arrayOf(),
        @Query("postseason") postseasonGames: Boolean = false,
        @Query("start_date") startDate: String = "", // format "YYYY-MM-DD"
        @Query("end_date") endDate: String = "" // format "YYYY-MM-DD"
    ): DataJson<GameJson>

    @GET("games/{id}") // return a specific game by ID
    suspend fun getGameById(@Path("id") gameId: Int): GameJson

    @GET("stats") // return all stats
    suspend fun getStats(
        @Query("page") page: Int = 0,
        @Query("per_page") playersPerPage: Int = 25,
        @Query("dates") dates: Array<String> = arrayOf(), // format "YYYY-MM-DD"
        @Query("seasons") seasons: Array<Int> = arrayOf(),
        @Query("player_ids") playerIds: Array<Int> = arrayOf(),
        @Query("game_ids") gameIds: Array<Int> = arrayOf(),
        @Query("postseason") postseasonGames: Boolean = false,
        @Query("start_date") startDate: String = "", // format "YYYY-MM-DD"
        @Query("end_date") endDate: String = "" // format "YYYY-MM-DD"
    ): DataJson<StatJson>

    @GET("season_averages") // return season averages for specific players
    suspend fun getSeasonAverages(
        @Query("season") season: Int = Calendar.getInstance().get(Calendar.YEAR), // get the current year
        @Query("player_ids") playerIds: Array<Int> = arrayOf()
    ): DataJson<SeasonAvaragesJson>
}

// Moshi object that is use to tell retrofit to use Moshi as the converter
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()) // add kotlin annotation adapter
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

// Object that return an implementation of NbaService interface
object Service {
    val api: NbaService by lazy {
        retrofit.create(NbaService::class.java)
    }
}