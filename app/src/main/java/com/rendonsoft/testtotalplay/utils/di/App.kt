package com.rendonsoft.testtotalplay.utils.diimport android.app.Applicationimport com.rendonsoft.testtotalplay.BuildConfigimport com.rendonsoft.testtotalplay.features.home.framework.di.homeModuleimport org.koin.android.ext.koin.androidContextimport org.koin.android.ext.koin.androidLoggerimport org.koin.core.context.startKoinimport org.koin.core.logger.Levelclass App : Application() {    override fun onCreate() {        super.onCreate()        startKoin {            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)            androidContext(this@App)            modules(homeModule)        }    }}