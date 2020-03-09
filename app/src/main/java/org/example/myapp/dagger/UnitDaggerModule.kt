package com.bolyartech.forge.admin.dagger

import com.bolyartech.forge.android.app_unit.UnitManager
import com.bolyartech.forge.android.app_unit.UnitManagerImpl
import com.bolyartech.forge.android.app_unit.rc_task.executor.RcTaskExecutor
import com.bolyartech.forge.android.app_unit.rc_task.executor.ThreadRcTaskExecutor
import com.bolyartech.forge.android.misc.RunOnUiThreadHelper
import com.bolyartech.forge.android.misc.RunOnUiThreadHelperDefault
import dagger.Binds
import dagger.Module
import org.example.myapp.units.main.ResMain
import org.example.myapp.units.main.ResMainImpl
import javax.inject.Singleton

@Module
abstract class UnitDaggerModule {
    @Binds
    @Singleton
    internal abstract fun provideUnitManager(impl: UnitManagerImpl): UnitManager


    @Binds
    internal abstract fun provideRcTaskExecutor(impl: ThreadRcTaskExecutor): RcTaskExecutor

    @Binds
    internal abstract fun provideRunOnUiThreadHelper(impl: RunOnUiThreadHelperDefault): RunOnUiThreadHelper


    @Binds
    internal abstract fun provideResMain(impl: ResMainImpl): ResMain
}