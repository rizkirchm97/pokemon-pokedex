package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class Pokemon(

	@Json(name="location_area_encounters")
	val locationAreaEncounters: String? = null,

	@Json(name="types")
	val types: List<TypesItem?>? = null,

	@Json(name="base_experience")
	val baseExperience: Int? = null,

	@Json(name="held_items")
	val heldItems: List<Any?>? = null,

	@Json(name="weight")
	val weight: Int? = null,

	@Json(name="is_default")
	val isDefault: Boolean? = null,

	@Json(name="past_types")
	val pastTypes: List<Any?>? = null,

	@Json(name="sprites")
	val sprites: Sprites? = null,

	@Json(name="abilities")
	val abilities: List<AbilitiesItem?>? = null,

	@Json(name="game_indices")
	val gameIndices: List<GameIndicesItem?>? = null,

	@Json(name="species")
	val species: Species? = null,

	@Json(name="stats")
	val stats: List<StatsItem?>? = null,

	@Json(name="moves")
	val moves: List<MovesItem?>? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="forms")
	val forms: List<FormsItem?>? = null,

	@Json(name="height")
	val height: Int? = null,

	@Json(name="order")
	val order: Int? = null
)