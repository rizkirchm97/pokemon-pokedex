package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class Other(

	@Json(name="dream_world")
	val dreamWorld: DreamWorld? = null,

	@Json(name="official-artwork")
	val officialArtwork: OfficialArtwork? = null,

	@Json(name="home")
	val home: Home? = null
)