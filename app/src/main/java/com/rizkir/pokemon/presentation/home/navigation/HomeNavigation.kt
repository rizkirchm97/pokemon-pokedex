package com.rizkir.pokemon.presentation.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rizkir.pokemon.common.NavRoute

fun NavController.navigateToDetailItem(pokemonName: String) {
    this.navigate(NavRoute.DetailItem.route + "/$pokemonName")
}

fun NavGraphBuilder.homeNavigation(onItemClick: (String) -> Unit) {
    composable(route = NavRoute.HomeScreen.route) {

    }
}