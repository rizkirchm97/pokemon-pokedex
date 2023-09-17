package com.rizkir.pokemon.data.repositories

import android.util.Log
import com.rizkir.pokemon.common.Resource
import com.rizkir.pokemon.data.local.PokemonDao
import com.rizkir.pokemon.data.local.model.PokemonItemList
import com.rizkir.pokemon.data.mapper.mapLocalListToEntity
import com.rizkir.pokemon.data.mapper.mapToEntity
import com.rizkir.pokemon.data.remote.PokemonApi
import com.rizkir.pokemon.domain.entities.pokemon_detail.Pokemon
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList
import com.rizkir.pokemon.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val dao: PokemonDao
) : PokemonRepository {

    override suspend fun getPokemonList(): Resource<PokemonList> {
        try {
            val checkDb = dao.getAllPokemon()
            if (checkDb.isEmpty()) {
                val result = api.getPokemonList()
                if (result.results?.isNotEmpty() == true) {
                    val datas = mutableListOf<PokemonItemList>()
                    result.results.forEach { resultItem ->
                        if (resultItem?.name != null) {
                            datas.add(
                                PokemonItemList(
                                    name = resultItem.name,
                                    url = resultItem.url
                                )
                            )
                        }


                    }
                    dao.insertAllPokemon(datas)

                }
            }

        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }

        val response = try {
            dao.getAllPokemon()
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }

        return Resource.Success(PokemonList(results = response.mapLocalListToEntity()))
    }

    override suspend fun getPokemonDetail(pokemonName: String?): Resource<Pokemon> {
        val response = try {
            if (pokemonName != null) {
                api.getPokemonDetail(pokemonName)
            } else {
                return Resource.Error("Illegal Argument")
            }
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }

        Log.e("Sprites", api.getPokemonDetail(pokemonName).sprites.toString())

        return Resource.Success(response.mapToEntity())
    }

    override suspend fun searchPokemon(pokemonName: String): Resource<PokemonList> {
        val response = try {
            dao.searchPokemon(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
        if (response.isEmpty()) {
            return Resource.Error("No data")
        }

        return Resource.Success(PokemonList(results = response.mapLocalListToEntity()))
    }

}