package com.rizkir.pokemon.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizkir.pokemon.common.Resource
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList
import com.rizkir.pokemon.domain.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading(true))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            val result = repository.getPokemonList()
            handleResult(result)
        }
    }

    fun searchPokemon(query: String) {
        viewModelScope.launch {
            val result = repository.searchPokemon(query)
            handleResult(result)
        }
    }

    private fun handleResult(result: Resource<PokemonList>) {
        when(result) {
            is Resource.Loading -> {
              _uiState.value = UiState.Loading(isLoading = false)
            }

            is Resource.Success -> {
                _uiState.value = UiState.Success(result.data)
            }

            is Resource.Error -> {
               _uiState.value =  UiState.Error(result.message)
            }
        }
    }
}


sealed interface UiState {
    data class Success(val data: PokemonList?) : UiState
    data class Error(val message: String?) : UiState
    data class Loading(val isLoading: Boolean?) : UiState
}