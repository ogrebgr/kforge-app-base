package org.example.myapp.base

import com.bolyartech.forge.android.app_unit.UnitApplication
import org.example.myapp.dagger.DefaultMyAppDaggerComponentHelper
import org.example.myapp.dagger.DependencyInjector

class App : UnitApplication() {
    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    /**
     * Initializes the injector
     * Unit tests should use empty implementation of this method and return false in order to have a chance to
     * initialize the injector with test configuration
     *
     * @return true if dependency injector was initialized, false otherwise
     */
    @Suppress("MemberVisibilityCanBePrivate")
    protected fun initInjector(): Boolean {
        DependencyInjector.init(DefaultMyAppDaggerComponentHelper.create(this))

        return true
    }
}