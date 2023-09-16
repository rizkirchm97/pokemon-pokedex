package com.rizkir.pokemon.data.remote.responses.pokemon_detail

import com.squareup.moshi.Json

data class Versions(

	@Json(name="generation-iii")
	val generationIii: GenerationIii? = null,

	@Json(name="generation-ii")
	val generationIi: GenerationIi? = null,

	@Json(name="generation-v")
	val generationV: GenerationV? = null,

	@Json(name="generation-iv")
	val generationIv: GenerationIv? = null,

	@Json(name="generation-vii")
	val generationVii: GenerationVii? = null,

	@Json(name="generation-i")
	val generationI: GenerationI? = null,

	@Json(name="generation-viii")
	val generationViii: GenerationViii? = null,

	@Json(name="generation-vi")
	val generationVi: GenerationVi? = null
)