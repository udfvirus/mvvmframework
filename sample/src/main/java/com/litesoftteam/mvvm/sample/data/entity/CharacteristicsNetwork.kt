package com.litesoftteam.mvvm.sample.data.entity

import com.google.gson.annotations.SerializedName

data class CharacteristicsNetwork(
        @SerializedName("deviceInformation") val deviceInformation: List<CharacteristicNetwork>
)