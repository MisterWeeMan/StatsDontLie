package com.mattiabano.statsdontlie.utility

import com.mattiabano.statsdontlie.api.model.PlayerJson
import com.mattiabano.statsdontlie.api.model.TeamJson

val dummyGenericTeam = TeamJson(
    id = 1,
    abbreviation = "TEM",
    city = "London",
    conference = "West",
    division = "Pacific",
    fullName = "London Team",
    name = "Team"
)

val dummyGenericPlayer = PlayerJson(
    id = 1,
    firstName = "Player",
    lastName = "Lastname",
    position = "G",
    heightFeet = 6,
    heightInches = 8,
    weightPounds = 250,
    team = dummyGenericTeam
)