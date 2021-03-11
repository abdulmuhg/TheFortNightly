package com.abdulmughni.personal.thefortnightly

import android.app.Application
import com.abdulmughni.personal.thefortnightly.core.di.CoreComponent
import com.abdulmughni.personal.thefortnightly.core.di.DaggerCoreComponent
import com.abdulmughni.personal.thefortnightly.di.AppComponent
import com.abdulmughni.personal.thefortnightly.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}