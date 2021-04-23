package com.litesoftteam.mvvm.sample.data.repository

import com.litesoftteam.mvvm.sample.data.mapper.CharacteristicMapper
import com.litesoftteam.mvvm.sample.data.network.api.ApiService
import com.litesoftteam.mvvm.sample.domain.repository.CharacteristicRepository


class NetworkCharacteristicRepository constructor(
        private val api: ApiService
) : CharacteristicRepository {

    override suspend fun getCharacteristicsByMenuId(menuId: Int) = api.getDeviceInfo(menuId)
            .map(CharacteristicMapper()::toCharacteristic)
}