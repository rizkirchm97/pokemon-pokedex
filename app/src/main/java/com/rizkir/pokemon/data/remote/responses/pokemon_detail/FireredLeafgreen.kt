package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class FireredLeafgreen(

	@Json(name="back_default")
	val backDefault: String? = null,

	@Json(name="front_default")
	val frontDefault: String? = null,

	@Json(name="back_shiny")
	val backShiny: String? = null,

	@Json(name="front_shiny")
	val frontShiny: String? = null
)