package com.example.lab_7


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable



@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("upcoming_races") {
            UpcomingRacesScreen(navController)

        }
        composable("drivers") {
            DriversScreen(navController,) }
    }

}

