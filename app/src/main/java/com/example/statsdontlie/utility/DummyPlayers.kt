package com.example.statsdontlie.utility

import com.example.statsdontlie.api.model.PlayerJson
import com.example.statsdontlie.api.model.TeamJson

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