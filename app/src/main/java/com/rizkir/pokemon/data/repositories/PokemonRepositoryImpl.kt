package com.rizkir.pokemon.data.repositories

import com.rizkir.pokemon.common.Resource
import com.rizkir.pokemon.data.remote.PokemonApi
import com.rizkir.pokemon.domain.entities.pokemon_detail.Pokemon
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList
import com.rizkir.pokemon.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val api: PokemonApi) : PokemonRepository{

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        TODO("Not yet implemented")
    }

}