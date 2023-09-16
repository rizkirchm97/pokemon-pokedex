package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GenerationIi(

	@Json(name="gold")
	val gold: Gold? = null,

	@Json(name="crystal")
	val crystal: Crystal? = null,

	@Json(name="silver")
	val silver: Silver? = null
)