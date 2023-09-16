package com.rizkir.pokemon.data.remote.responses.pokemon_list

import com.squareup.moshi.Json

data class PokemonList(

	@Json(name="next")
	val next: String? = null,

	@Json(name="previous")
	val previous: Any? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="results")
	val results: List<ResultsItem?>? = null
)