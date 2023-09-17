package com.rizkir.pokemon.presentation.home.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rizkir.pokemon.common.NavRoute
import com.rizkir.pokemon.presentation.home.HomeScreen
import com.rizkir.pokemon.presentation.home.HomeViewModel
import com.rizkir.pokemon.presentation.home.UiState
import dagger.hilt.android.lifecycle.HiltViewModel

fun NavController.navigateToDetailItem(pokemonName: String) {
    this.navigate(NavRoute.DetailItem.route + "/$pokemonName")
}

fun NavGraphBuilder.homeNavigation(onItemClick: (String) -> Unit) {
    composable(route = NavRoute.HomeScreen.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        val uiState: UiState by viewModel.uiState.collectAsStateWithLifecycle()
        HomeScreen(
            uiState,
            onItemClick,
            onSearch = {
                (viewModel::searchPokemon)(it)
            },
        )
    }
}