package com.rizkir.pokemon.data.remote.responses.pokemon_list

import com.squareup.moshi.Json

data class ResultsItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="url")
	val url: String? = null
)