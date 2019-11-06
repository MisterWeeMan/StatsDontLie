package com.example.statsdontlie.dummies

import com.example.statsdontlie.model.Player
import com.example.statsdontlie.model.Team

private val dummyLebron = Player(
    id = 237,
    firstName = "LeBron",
    lastName = "James",
    position = "F",
    heightFeet = 6,
    heightInches = 8,
    weightPounds = 250,
    team = Team(
        id = 14,
        abbreviation = "LAL",
        city = "Los Angeles",
        conference = "West",
        division = "Pacific",
        fullName = "Los Angeles Lakers",
        name = "Lakers"
    )
)

private val dummyDurant = Player(
    id = 140,
    firstName = "Kevin",
    lastName = "Durant",
    position = "F",
    heightFeet = 6,
    heightInches = 9,
    weightPounds = 240,
    team = Team(
        id = 140,
        abbreviation = "BKN",
        city = "Brooklyn",
        conference = "East",
        division = "Atlantic",
        fullName = "Brooklyn Nets",
        name = "Nets"
    )
)

private val dummyCurry = Player(
    id = 115,
    firstName = "Stephen",
    lastName = "James",
    position = "F",
    heightFeet = 6,
    heightInches = 3,
    weightPounds = 190,
    team = Team(
        id = 10,
        abbreviation = "GSW",
        city = "Golden State",
        conference = "West",
        division = "Pacific",
        fullName = "Golden State Warriors",
        name = "Warriors"
    )
)