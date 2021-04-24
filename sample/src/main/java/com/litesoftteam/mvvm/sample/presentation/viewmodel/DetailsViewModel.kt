package com.litesoftteam.mvvm.sample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.litesoftteam.mvvm.core.entity.Event
import com.litesoftteam.mvvm.presentation.viewmodel.BaseViewModel
import com.litesoftteam.mvvm.sample.core.entity.Characteristic
import com.litesoftteam.mvvm.sample.domain.repository.CharacteristicRepository
import ru.terrakok.cicerone.Router

class DetailsViewModel(
        router: Router,
        private val characteristicRepository: CharacteristicRepository
) : BaseViewModel(router) {

    private val _characteristicsLiveData = MutableLiveData<Event<List<Characteristic>>>()

    val characteristicsLiveData: LiveData<Event<List<Characteristic>>> = _characteristicsLiveData

    fun load(menuId: Int) {
        subscribe(_characteristicsLiveData) {
            characteristicRepository.getCharacteristicsByMenuId(menuId)
        }
    }
}