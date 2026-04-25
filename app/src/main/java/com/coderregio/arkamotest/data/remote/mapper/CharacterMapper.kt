package com.coderregio.arkamotest.data.remote.mapper

import com.coderregio.arkamotest.data.model.CharacterModel
import com.coderregio.arkamotest.data.model.CharacterStatusModel
import com.coderregio.arkamotest.data.remote.dto.CharacterDto

fun CharacterDto.toDomain(): CharacterModel {
    return CharacterModel(
        id = id ?: 0,
        name = name ?: "",
        status = CharacterStatusModel.from(status),
        image = image ?: ""
    )
}