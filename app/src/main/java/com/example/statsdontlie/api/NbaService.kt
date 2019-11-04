package com.example.statsdontlie.api

import com.example.statsdontlie.model.json.PlayersData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " https://www.balldontlie.io/api/v1/"

// add kotlin annotation adapter
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface NbaService {
    @GET("players")
    suspend fun getPlayers(): PlayersData
}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object Service {
    val api: NbaService by lazy {
        retrofit.create(NbaService::class.java)
    }
}