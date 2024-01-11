package com.example.footballleague

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footballleague.data.models.CompetitionDetails
import com.example.footballleague.ui.navigation.Screens
import com.example.footballleague.ui.screens.competitions.AllMatchesScreen
import com.example.footballleague.ui.screens.singleCompetiion.SingleMatchScreen
import com.example.footballleague.ui.theme.FootballLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // To prevent screen shots and screen recording.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        setContent {
            FootballLeagueApp()
        }
    }
}

@Composable
fun FootballLeagueApp() {
    val navController = rememberNavController()
    FootballLeagueTheme {
        NavHost(
            navController = navController,
            startDestination = Screens.AllMatches.route
        ) {
            composable(route = Screens.AllMatches.route) {

                AllMatchesScreen(onClickSingleMatch = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("competition", it)
                    navController.navigate(Screens.SingleMatch.route)
                })
            }
            composable(route = Screens.SingleMatch.route) {
                val competition: CompetitionDetails? =
                    navController.previousBackStackEntry?.savedStateHandle?.get("competition") // new
                (SingleMatchScreen(competition,onBackButtonPress = { navController.navigateUp() }))
            }
        }
    }
}