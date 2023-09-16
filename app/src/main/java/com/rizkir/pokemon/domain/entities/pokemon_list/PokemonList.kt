package com.rizkir.pokemon.domain.entities.pokemon_list

data class PokemonList(
	val next: String? = null,
	val previous: Any? = null,
	val count: Int? = null,
	val results: List<ResultsItem?>? = null
)
