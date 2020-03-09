package com.bolyartech.forge.admin.dagger

import dagger.Binds
import dagger.Module
import org.example.myapp.units.main.TestTask
import org.example.myapp.units.main.TestTaskImpl


@Module
abstract class TaskDaggerModule {

    @Binds
    internal abstract fun provideTestTask(impl: TestTaskImpl): TestTask


}