package org.example.myapp.units.main

import com.bolyartech.forge.android.app_unit.rc_task.AbstractRctResidentComponent
import com.bolyartech.forge.android.app_unit.rc_task.RctResidentComponent
import com.bolyartech.forge.android.app_unit.rc_task.executor.RcTaskExecutor
import com.bolyartech.forge.base.rc_task.RcTaskToExecutor
import javax.inject.Inject
import javax.inject.Provider

interface ResMain : RctResidentComponent {
    fun test()
}


class ResMainImpl @Inject constructor(
    taskExecutor: RcTaskExecutor,
    private val taskProvider: Provider<TestTask>
) : ResMain,
    AbstractRctResidentComponent(taskExecutor) {

    private var task: TestTask? = null


    override fun test() {
        if (isIdle) {
            task = taskProvider.get()
            executeTask(task)
        }
    }

    override fun onTaskPostExecute(endedTask: RcTaskToExecutor) {
        // empty
    }

}