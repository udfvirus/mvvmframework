package com.litesoftteam.mvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ru.terrakok.cicerone.Router

abstract class BaseViewModel(protected val router: Router) : ViewModel()