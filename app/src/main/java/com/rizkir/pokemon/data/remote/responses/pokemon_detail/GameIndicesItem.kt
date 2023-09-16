package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GameIndicesItem(

	@Json(name="game_index")
	val gameIndex: Int? = null,

	@Json(name="version")
	val version: Version? = null
)