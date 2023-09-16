package com.rizkir.pokemon.domain.entities.pokemon_detail

data class Pokemon(
	val locationAreaEncounters: String? = null,
	val types: List<TypesItem?>? = null,
	val baseExperience: Int? = null,
	val heldItems: List<Any?>? = null,
	val weight: Int? = null,
	val isDefault: Boolean? = null,
	val pastTypes: List<Any?>? = null,
	val sprites: Sprites? = null,
	val abilities: List<AbilitiesItem?>? = null,
	val gameIndices: List<GameIndicesItem?>? = null,
	val species: Species? = null,
	val stats: List<StatsItem?>? = null,
	val moves: List<MovesItem?>? = null,
	val name: String? = null,
	val id: Int? = null,
	val forms: List<FormsItem?>? = null,
	val height: Int? = null,
	val order: Int? = null
)
