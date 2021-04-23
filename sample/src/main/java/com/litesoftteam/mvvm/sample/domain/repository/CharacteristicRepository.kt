package com.litesoftteam.mvvm.sample.domain.repository

import com.litesoftteam.mvvm.sample.core.entity.Characteristic


interface CharacteristicRepository {

    suspend fun getCharacteristicsByMenuId(menuId: Int): List<Characteristic>
}