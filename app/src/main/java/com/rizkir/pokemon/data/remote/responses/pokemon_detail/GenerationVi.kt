package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GenerationVi(

	@Json(name="omegaruby-alphasapphire")
	val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,

	@Json(name="x-y")
	val xY: XY? = null
)