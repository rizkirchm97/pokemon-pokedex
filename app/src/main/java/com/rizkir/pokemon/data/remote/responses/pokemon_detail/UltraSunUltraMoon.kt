package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class UltraSunUltraMoon(

	@Json(name="front_shiny_female")
	val frontShinyFemale: Any? = null,

	@Json(name="front_default")
	val frontDefault: String? = null,

	@Json(name="front_female")
	val frontFemale: Any? = null,

	@Json(name="front_shiny")
	val frontShiny: String? = null
)