package com.litesoftteam.mvvm.sample.data.mapper

import com.litesoftteam.mvvm.sample.core.entity.Characteristic
import com.litesoftteam.mvvm.sample.data.entity.CharacteristicNetwork

class CharacteristicMapper {

    fun toCharacteristic(characteristic: CharacteristicNetwork) = Characteristic(
            characteristic.id,
            characteristic.name,
            characteristic.value,
            characteristic.type,
            characteristic.visible
    )
}