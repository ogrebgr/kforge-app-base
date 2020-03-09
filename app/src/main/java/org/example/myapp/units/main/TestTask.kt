package org.example.myapp.units.main

import com.bolyartech.forge.base.exchange.SessionSimpleExchangeExecutor
import com.bolyartech.forge.base.exchange.SimpleExchangeOutcomeOk
import com.bolyartech.forge.base.exchange.SimpleExchangeResult
import com.bolyartech.forge.base.exchange.SimpleExchangeResultProducer
import com.bolyartech.forge.base.exchange.builders.FormHttpExchangeBuilder
import com.bolyartech.forge.base.rc_task.AbstractRcTask
import com.bolyartech.forge.base.rc_task.RcTask
import com.bolyartech.forge.base.rc_task.RcTaskResult
import okhttp3.OkHttpClient
import org.example.myapp.misc.TaskIds
import javax.inject.Inject
import javax.inject.Named


interface TestTask : RcTask<RcTaskResult<String, Int>>


class TestTaskImpl @Inject constructor(
    private val sessionSimpleExchangeExecutor: SessionSimpleExchangeExecutor,
    @Named("base url") private val baseUrl: String,
    private val okHttpClient: OkHttpClient
) :
    TestTask, AbstractRcTask<RcTaskResult<String, Int>>(TaskIds.TEST_TASK) {

    override fun execute() {
        val b = FormHttpExchangeBuilder<SimpleExchangeResult>(
            okHttpClient,
            SimpleExchangeResultProducer(),
            "$baseUrl/"
        )
        when (val rez = sessionSimpleExchangeExecutor.execute(b.build())) {
            is SimpleExchangeOutcomeOk -> {
                setTaskResult(RcTaskResult.createSuccessResult(rez.payload))
            }
            else -> {
                setTaskResult(RcTaskResult.createErrorResult(-1))
            }
        }
    }

}