package com.rizkir.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rizkir.pokemon.data.local.model.PokemonItemList

@Database(
    entities = [
        PokemonItemList::class,
    ],
    version = 2
)
abstract class PokemonDatabase: RoomDatabase() {
    abstract val pokemonDao: PokemonDao

    companion object {
        const val DATABASE_NAME = "pokemon_db"
    }
}