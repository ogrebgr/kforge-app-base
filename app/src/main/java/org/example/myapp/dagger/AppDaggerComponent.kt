package org.example.myapp.dagger

import android.content.Context
import com.bolyartech.forge.admin.dagger.ExchangeDaggerModule
import com.bolyartech.forge.admin.dagger.TaskDaggerModule
import com.bolyartech.forge.admin.dagger.UnitDaggerModule
import dagger.Component
import dagger.Module
import dagger.Provides
import org.example.myapp.units.main.ActMain
import javax.inject.Singleton

@Component(
    modules = [CoreModule::class,
        MyAppDaggerModuleProvides::class,
        MyAppDaggerModuleBinds::class,
        UnitDaggerModule::class,
        TaskDaggerModule::class,
        HttpDaggerModule::class,
        ExchangeDaggerModule::class,
        SessionDaggerModule::class]
)
@Singleton
interface AppDaggerComponent {
    fun inject(act: ActMain)
}


@Module
class CoreModule(private val ctx: Context) {
    @Provides
    @ForApplication
    fun provideAppContext(): Context {
        return ctx
    }
}