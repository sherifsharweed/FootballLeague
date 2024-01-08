package com.example.footballleague.ui.navigation

interface FootballDestination {
    val route: String
}

object AllMatches : FootballDestination {
    override val route = "all_matches"
}

object SingleMatch : FootballDestination {
    override val route = "single_match"
}