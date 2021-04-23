package com.litesoftteam.mvvm.sample.data.network.api

import com.litesoftteam.mvvm.sample.data.entity.CharacteristicNetwork
import com.litesoftteam.mvvm.sample.data.entity.DeviceMenuNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("GetMenuItemsDevice/")
    suspend fun getMenuItemsDevice(): DeviceMenuNetwork


    @GET(" GetDeviceInfo/")
    suspend fun getDeviceInfo(@Query("id_menu") menuId: Int): List<CharacteristicNetwork>
}