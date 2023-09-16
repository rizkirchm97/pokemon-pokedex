package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class OfficialArtwork(

	@Json(name="front_default")
	val frontDefault: String? = null,

	@Json(name="front_shiny")
	val frontShiny: String? = null
)