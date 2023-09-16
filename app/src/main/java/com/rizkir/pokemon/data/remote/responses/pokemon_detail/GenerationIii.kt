package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GenerationIii(

	@Json(name="firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreen? = null,

	@Json(name="ruby-sapphire")
	val rubySapphire: RubySapphire? = null,

	@Json(name="emerald")
	val emerald: Emerald? = null
)