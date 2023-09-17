package com.rizkir.pokemon.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.rizkir.pokemon.data.local.model.PokemonItemList

@Dao
interface PokemonDao {

    @Upsert
    suspend fun insertAllPokemon(data: List<PokemonItemList>)

    @Transaction
    @Query("SELECT * FROM PokemonItemList")
    suspend fun getAllPokemon(): List<PokemonItemList>

    @Transaction
    @Query("SELECT * FROM PokemonItemList ORDER BY NAME DESC")
    suspend fun getAllPokemonOrderByDesc(): List<PokemonItemList>

    @Transaction
    @Query("SELECT * FROM PokemonItemList ORDER BY NAME ASC")
    suspend fun getAllPokemonOrderByAsc(): List<PokemonItemList>

    @Transaction
    @Query("SELECT * FROM PokemonItemList WHERE LOWER(NAME) LIKE '%' || LOWER(:pokemonName) || '%'")
    suspend fun searchPokemon(pokemonName: String): List<PokemonItemList>
}