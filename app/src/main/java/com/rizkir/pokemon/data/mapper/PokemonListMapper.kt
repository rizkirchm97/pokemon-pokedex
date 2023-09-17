package com.rizkir.pokemon.data.mapper

import com.rizkir.pokemon.data.local.model.PokemonItemList
import com.rizkir.pokemon.data.remote.responses.pokemon_list.PokemonList
import com.rizkir.pokemon.data.remote.responses.pokemon_list.ResultsItem
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList as PokemonListEntity
import com.rizkir.pokemon.domain.entities.pokemon_list.ResultsItem as ResultsItemEntity

fun PokemonList.mapToEntity() : PokemonListEntity {
    return PokemonListEntity(
        next = next,
        previous = previous,
        count = count,
        results = results.mapToEntity()
    )
}

fun List<PokemonItemList>.mapLocalListToEntity(): List<ResultsItemEntity> {
    return this.map { model ->
        model.mapLocalToEntity()
    }
}

fun PokemonItemList.mapLocalToEntity(): ResultsItemEntity {
    return ResultsItemEntity(
        name = name,
        url = url
    )
}

private  fun List<ResultsItem?>?.mapToEntity(): List<ResultsItemEntity?>? {
    return this?.map {model ->
        model?.mapToEntity()
    }
}

private fun ResultsItem.mapToEntity(): ResultsItemEntity {
    return ResultsItemEntity(
        name = name,
        url = url
    )
}
