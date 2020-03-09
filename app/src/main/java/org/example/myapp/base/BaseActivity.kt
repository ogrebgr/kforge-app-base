package org.example.myapp.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bolyartech.forge.admin.R
import org.example.myapp.dagger.AppDaggerComponent
import org.example.myapp.dagger.DefaultMyAppDaggerComponentHelper
import org.example.myapp.dagger.DependencyInjector


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    protected fun getDependencyInjector(): AppDaggerComponent {
        return DependencyInjector.injector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // if not dev mode turn on secure screen mode
        if (!resources.getBoolean(R.bool.build_conf_dev_mode)) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }
    }


    protected fun createInjector(): AppDaggerComponent {
        DependencyInjector.init(
            DefaultMyAppDaggerComponentHelper.create(this)
        )


        return DependencyInjector.injector
    }


    protected fun isFullScreen(): Boolean {
        val lp = window.attributes
        val flg = lp.flags
        return (flg and WindowManager.LayoutParams.FLAG_FULLSCREEN) == WindowManager.LayoutParams.FLAG_FULLSCREEN
    }
}

