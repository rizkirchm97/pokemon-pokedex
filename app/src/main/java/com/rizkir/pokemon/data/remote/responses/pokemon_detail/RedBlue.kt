package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class RedBlue(

	@Json(name="front_gray")
	val frontGray: String? = null,

	@Json(name="back_transparent")
	val backTransparent: String? = null,

	@Json(name="back_default")
	val backDefault: String? = null,

	@Json(name="back_gray")
	val backGray: String? = null,

	@Json(name="front_default")
	val frontDefault: String? = null,

	@Json(name="front_transparent")
	val frontTransparent: String? = null
)