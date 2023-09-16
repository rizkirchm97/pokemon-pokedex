package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class TypesItem(

	@Json(name="slot")
	val slot: Int? = null,

	@Json(name="type")
	val type: Type? = null
)