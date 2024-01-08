package com.example.footballleague

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.footballleague.ui.navigation.AllMatches
import com.example.footballleague.ui.navigation.SingleMatch
import com.example.footballleague.ui.screens.competitions.AllMatchesScreen
import com.example.footballleague.ui.theme.FootballLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            startDestination = AllMatches.route
        ) {
            composable(route = AllMatches.route) {
                AllMatchesScreen(onClickSingleMatch = { navController.navigate(SingleMatch.route) })
            }
            composable(route = SingleMatch.route) {
                (SingleMatchScreen())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleMatchScreen() {
    Scaffold() { innerPadding ->
        Greeting(name = "Second Screen", modifier = Modifier.padding(innerPadding))

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FootballLeagueTheme {
        Greeting("Android")
    }
}