package com.rizkir.pokemon.data.mapper

import com.rizkir.pokemon.data.remote.responses.pokemon_detail.AbilitiesItem
import com.rizkir.pokemon.data.remote.responses.pokemon_detail.Ability
import com.rizkir.pokemon.data.remote.responses.pokemon_detail.Pokemon
import com.rizkir.pokemon.data.remote.responses.pokemon_detail.Sprites
import com.rizkir.pokemon.data.remote.responses.pokemon_detail.Type
import com.rizkir.pokemon.data.remote.responses.pokemon_detail.TypesItem
import com.rizkir.pokemon.domain.entities.pokemon_detail.Pokemon as PokemonEntity
import com.rizkir.pokemon.domain.entities.pokemon_detail.TypesItem as TypesItemEntity
import com.rizkir.pokemon.domain.entities.pokemon_detail.Type as TypeEntity
import com.rizkir.pokemon.domain.entities.pokemon_detail.Sprites as SpritesEntity
import com.rizkir.pokemon.domain.entities.pokemon_detail.AbilitiesItem as AbilitiesItemEntity
import com.rizkir.pokemon.domain.entities.pokemon_detail.Ability as AbilityEntity

fun Pokemon.mapToEntity(): PokemonEntity {
    return PokemonEntity(
        sprites = sprites?.mapToEntity(),
        abilities = abilities.mapToEntity(),
        name = name
    )
}


private fun Sprites.mapToEntity(): SpritesEntity {
    return SpritesEntity(
        frontDefault = frontDefault,
    )
}

private fun List<AbilitiesItem?>?.mapToEntity(): List<AbilitiesItemEntity?>? {
    return this?.map { model ->
        model?.mapTypesToEntity()
    }
}


private fun AbilitiesItem.mapTypesToEntity(): AbilitiesItemEntity {
    return AbilitiesItemEntity(
        isHidden = isHidden,
        ability = ability?.mapAbilitiesToEntity(),
        slot = slot
    )
}

private fun Ability.mapAbilitiesToEntity(): AbilityEntity {
    return AbilityEntity(
        name = name,
        url = url
    )
}

