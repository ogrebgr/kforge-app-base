package org.example.myapp.dagger

import android.content.Context
import com.bolyartech.forge.admin.R
import com.bolyartech.forge.admin.dagger.ExchangeDaggerModule

object DefaultMyAppDaggerComponentHelper {
    fun create(
        ctx: Context
    ): AppDaggerComponent {
        val exchangeDaggerModule =
            ExchangeDaggerModule(
                ctx.getString(R.string.build_conf_base_url)
            )

        return DaggerAppDaggerComponent.builder().coreModule(CoreModule(ctx))
            .exchangeDaggerModule(exchangeDaggerModule)
            .myAppDaggerModuleProvides(
                MyAppDaggerModuleProvides(ctx)
            )
            .httpDaggerModule(HttpDaggerModule()).build()
    }
}