package com.litesoftteam.mvvm.di

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Suppress("MemberVisibilityCanBePrivate")
object NavigationFactory {

    val cicerone by lazy { Cicerone.create(Router()) }

    fun getRouter(cicerone: Cicerone<Router>) = cicerone.router

    fun getRouter(): Router {
        return getRouter(cicerone)
    }

    fun getNavigationHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder

    fun getNavigationHolder(): NavigatorHolder {
        return getNavigationHolder(cicerone)
    }
}