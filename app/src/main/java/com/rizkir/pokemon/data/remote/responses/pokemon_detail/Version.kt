package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class Version(

	@Json(name="name")
	val name: String? = null,

	@Json(name="url")
	val url: String? = null
)