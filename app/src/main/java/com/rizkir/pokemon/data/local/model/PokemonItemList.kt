package com.rizkir.pokemon.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonItemList(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val url: String?
)
