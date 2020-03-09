package org.example.myapp.units.main

import android.os.Bundle
import com.bolyartech.forge.admin.R
import kotlinx.android.synthetic.main.act__main.*
import org.example.myapp.base.RctUnitActivity
import org.example.myapp.dialogs.hideGenericWaitDialog
import org.example.myapp.dialogs.showGenericWaitDialog
import javax.inject.Inject
import javax.inject.Provider

class ActMain : RctUnitActivity<ResMain>() {
    @Inject
    internal lateinit var resProvider: Provider<ResMain>


    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencyInjector().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act__main)

        btnTest.setOnClickListener {
            res.test()
        }
    }

    override fun createResidentComponent(): ResMain {
        return resProvider.get()
    }

    override fun handleResidentEndedState() {
        if (res.currentTask.isSuccess) {
            val task = res.currentTask as TestTask
            tvRez.text = task.result.successValue
        } else {
            tvRez.text = "Error"
        }
    }

    override fun handleResidentBusyState() {
        showGenericWaitDialog(supportFragmentManager)
    }

    override fun handleResidentIdleState() {
        hideGenericWaitDialog(supportFragmentManager)
    }
}
