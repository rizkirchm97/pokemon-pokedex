package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class MovesItem(

	@Json(name="version_group_details")
	val versionGroupDetails: List<VersionGroupDetailsItem?>? = null,

	@Json(name="move")
	val move: Move? = null
)