package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class VersionGroupDetailsItem(

	@Json(name="level_learned_at")
	val levelLearnedAt: Int? = null,

	@Json(name="version_group")
	val versionGroup: VersionGroup? = null,

	@Json(name="move_learn_method")
	val moveLearnMethod: MoveLearnMethod? = null
)