package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GenerationV(

	@Json(name="black-white")
	val blackWhite: BlackWhite? = null
)