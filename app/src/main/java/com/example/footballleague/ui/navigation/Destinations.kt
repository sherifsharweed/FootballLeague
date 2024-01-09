package com.example.footballleague.ui.navigation


sealed class Screens(val route: String) {

    object AllMatches : Screens("all_matches")

    object SingleMatch : Screens("single_match")
}