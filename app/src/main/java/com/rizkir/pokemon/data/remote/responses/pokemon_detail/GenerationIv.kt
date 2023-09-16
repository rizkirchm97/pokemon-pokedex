package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class GenerationIv(

	@Json(name="platinum")
	val platinum: Platinum? = null,

	@Json(name="diamond-pearl")
	val diamondPearl: DiamondPearl? = null,

	@Json(name="heartgold-soulsilver")
	val heartgoldSoulsilver: HeartgoldSoulsilver? = null
)