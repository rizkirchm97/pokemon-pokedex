package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class Icons(

	@Json(name="front_default")
	val frontDefault: String? = null,

	@Json(name="front_female")
	val frontFemale: Any? = null
)