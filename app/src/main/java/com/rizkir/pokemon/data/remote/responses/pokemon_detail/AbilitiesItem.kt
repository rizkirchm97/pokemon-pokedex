package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class AbilitiesItem(

	@Json(name="is_hidden")
	val isHidden: Boolean? = null,

	@Json(name="ability")
	val ability: Ability? = null,

	@Json(name="slot")
	val slot: Int? = null
)