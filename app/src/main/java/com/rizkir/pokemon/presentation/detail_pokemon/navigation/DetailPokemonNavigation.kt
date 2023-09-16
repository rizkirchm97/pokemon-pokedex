package com.rizkir.pokemon.presentation.detail_pokemon.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rizkir.pokemon.common.NavRoute

fun NavController.navigateToHome(pokemonName: String) {
    this.navigate(NavRoute.HomeScreen.route)
}

fun NavGraphBuilder.detailPokemonNavigation(onItemClick: (String) -> Unit) {
    composable(route = "${NavRoute.DetailItem.route}/{pokemonName}", arguments = listOf(
        navArgument("pokemonName") {
            type = NavType.StringType
        },
    )) {

    }
}