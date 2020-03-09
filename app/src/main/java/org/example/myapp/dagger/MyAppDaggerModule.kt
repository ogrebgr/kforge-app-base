package org.example.myapp.dagger

import android.content.Context
import android.content.pm.PackageManager
import com.bolyartech.forge.base.misc.TimeProvider
import com.bolyartech.forge.base.misc.TimeProviderImpl
import dagger.Module
import dagger.Provides
import org.example.myapp.base.AppPrefs
import org.example.myapp.base.AppPrefsImpl


@Module
class MyAppDaggerModuleProvides(private val ctx: Context) {
    private val versionCode: String

    init {
        try {
            val pInfo = ctx.packageManager.getPackageInfo(ctx.packageName, 0)
            versionCode = pInfo.versionCode.toString()
        } catch (e: PackageManager.NameNotFoundException) {
            throw RuntimeException(e)
        }

    }


    @Provides
    fun provideTimeProvider(): TimeProvider {
        return TimeProviderImpl()
    }

    @Provides
    fun provideAppPrefs(): AppPrefs {
        return AppPrefsImpl(ctx)
    }


    @Provides
    @AppVersion
    fun provideAppVersion(): String {
        return versionCode
    }

}


@Module
abstract class MyAppDaggerModuleBinds