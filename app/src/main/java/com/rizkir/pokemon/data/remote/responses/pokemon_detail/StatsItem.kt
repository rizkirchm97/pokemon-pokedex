package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class StatsItem(

	@Json(name="stat")
	val stat: Stat? = null,

	@Json(name="base_stat")
	val baseStat: Int? = null,

	@Json(name="effort")
	val effort: Int? = null
)