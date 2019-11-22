package com.example.statsdontlie.api.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Team JSON data.
 */
@Parcelize
data class TeamJson(
    @Json(name = "id") val id: Int,
    @Json(name = "abbreviation") val abbreviation: String,
    @Json(name = "city") val city: String,
    @Json(name = "conference") val conference: String,
    @Json(name = "division") val division: String,
    @Json(name = "full_name") val fullName: String,
    @Json(name = "name") val name: String
) : Parcelable