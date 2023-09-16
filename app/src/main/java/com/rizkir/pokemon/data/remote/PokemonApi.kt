package com.rizkir.pokemon.data.remote

import com.rizkir.pokemon.data.remote.responses.pokemon_detail.Pokemon
import com.rizkir.pokemon.data.remote.responses.pokemon_list.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): Pokemon
}