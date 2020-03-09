package org.example.myapp.dagger

object DependencyInjector {
    lateinit var injector: AppDaggerComponent

    fun init(inj: AppDaggerComponent) {
        injector = inj
    }

}