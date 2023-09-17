package com.rizkir.pokemon.presentation.detail_pokemon

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizkir.pokemon.common.Resource
import com.rizkir.pokemon.domain.entities.pokemon_detail.Pokemon
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList
import com.rizkir.pokemon.domain.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailPokemonViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: PokemonRepository
) : ViewModel() {

    private val pokemonName = savedStateHandle.get<String>("pokemonName")

    val uiState = uiState(repository, pokemonName)
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Loading(isLoading = true)
        )

    private fun uiState(repository: PokemonRepository, pokemonName: String?): Flow<UiState> = flow {
        val result = repository.getPokemonDetail(pokemonName)
        when(result) {
            is Resource.Loading -> {
                emit(UiState.Loading(isLoading = false))
            }
            is Resource.Success -> {
                emit(UiState.Success(result.data))
            }
            is Resource.Error -> {
                emit(UiState.Error(message = result.message))
            }
        }
    }
}

sealed interface UiState {
    data class Success(val data: Pokemon?) : UiState
    data class Error(val message: String?) : UiState
    data class Loading(val isLoading: Boolean?) : UiState
}