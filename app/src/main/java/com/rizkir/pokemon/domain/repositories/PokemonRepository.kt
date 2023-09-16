package com.rizkir.pokemon.domain.repositories

import com.rizkir.pokemon.common.Resource
import com.rizkir.pokemon.domain.entities.pokemon_detail.Pokemon
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>
    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon>
}