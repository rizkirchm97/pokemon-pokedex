package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GenerationI(

	@Json(name="yellow")
	val yellow: Yellow? = null,

	@Json(name="red-blue")
	val redBlue: RedBlue? = null
)