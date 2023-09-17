package com.rizkir.pokemon.presentation.detail_pokemon.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rizkir.pokemon.common.NavRoute
import com.rizkir.pokemon.presentation.detail_pokemon.DetailPokemonScreen
import com.rizkir.pokemon.presentation.detail_pokemon.DetailPokemonViewModel
import com.rizkir.pokemon.presentation.detail_pokemon.UiState

fun NavController.navigateToHome(pokemonName: String) {
    this.navigate(NavRoute.HomeScreen.route)
}

fun NavGraphBuilder.detailPokemonNavigation(onPopBack: () -> Unit) {
    composable(route = "${NavRoute.DetailItem.route}/{pokemonName}", arguments = listOf(
        navArgument("pokemonName") {
            type = NavType.StringType
        },
    )) {
        val viewModel: DetailPokemonViewModel = hiltViewModel()
        val uiState: UiState by viewModel.uiState.collectAsStateWithLifecycle()

        DetailPokemonScreen(
            uiState = uiState,
            onPopBack = onPopBack
        )
    }
}