package com.example.statsdontlie.utility

import com.example.statsdontlie.api.model.PlayerJson
import com.example.statsdontlie.api.model.TeamJson

val dummyLebron = PlayerJson(
    id = 237,
    firstName = "LeBron",
    lastName = "James",
    position = "F",
    heightFeet = 6,
    heightInches = 8,
    weightPounds = 250,
    teamJson = TeamJson(
        id = 14,
        abbreviation = "LAL",
        city = "Los Angeles",
        conference = "West",
        division = "Pacific",
        fullName = "Los Angeles Lakers",
        name = "Lakers"
    )
)

val dummyDurant = PlayerJson(
    id = 140,
    firstName = "Kevin",
    lastName = "Durant",
    position = "F",
    heightFeet = 6,
    heightInches = 9,
    weightPounds = 240,
    teamJson = TeamJson(
        id = 140,
        abbreviation = "BKN",
        city = "Brooklyn",
        conference = "East",
        division = "Atlantic",
        fullName = "Brooklyn Nets",
        name = "Nets"
    )
)

val dummyCurry = PlayerJson(
    id = 115,
    firstName = "Stephen",
    lastName = "Curry",
    position = "F",
    heightFeet = 6,
    heightInches = 3,
    weightPounds = 190,
    teamJson = TeamJson(
        id = 10,
        abbreviation = "GSW",
        city = "Golden State",
        conference = "West",
        division = "Pacific",
        fullName = "Golden State Warriors",
        name = "Warriors"
    )
)