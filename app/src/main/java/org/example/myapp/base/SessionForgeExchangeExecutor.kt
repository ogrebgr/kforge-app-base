//package org.example.myapp.base
//
//import com.bolyartech.forge.base.exchange.HttpExchange
//import com.bolyartech.forge.base.exchange.ResultProducer
//import com.bolyartech.forge.base.exchange.forge.BasicResponseCodes
//import com.bolyartech.forge.base.exchange.forge.ForgeExchangeResult
//import com.bolyartech.forge.base.session.Session
//import org.slf4j.LoggerFactory
//import java.io.IOException
//import javax.inject.Inject
//
//interface SessionForgeExchangeExecutor {
//    @Throws(IOException::class, ResultProducer.ResultProducerException::class)
//    fun execute(x: HttpExchange<ForgeExchangeResult>): ForgeExchangeOutcome
//}
//
//class SessionForgeExchangeExecutorImpl @Inject
//constructor(private val session: Session) :
//    SessionForgeExchangeExecutor {
//    private val logger = LoggerFactory.getLogger(this.javaClass)
//
//    @Throws(IOException::class, ResultProducer.ResultProducerException::class)
//    override fun execute(x: HttpExchange<ForgeExchangeResult>): ForgeExchangeOutcome {
//        try {
//            val ret = x.execute()
//            session.prolong()
//
//            return if (ret.code == BasicResponseCodes.OK) {
//                ForgeExchangeOutcomeOk(ret.payload)
//            } else {
//                ForgeExchangeOutcomeErrorCode(ret.code, ret.payload)
//            }
//        } catch (e: Exception) {
//            return ForgeExchangeOutcomeException(e)
//        }
//    }
//}
//
//
//sealed class ForgeExchangeOutcome
//
//sealed class ForgeExchangeOutcomeError : ForgeExchangeOutcome()
//
//class ForgeExchangeOutcomeErrorCode(val code: Int, val payload: String) :
//    ForgeExchangeOutcomeError()
//
//class ForgeExchangeOutcomeException(val e: Exception) :
//    ForgeExchangeOutcomeError()
//
//class ForgeExchangeOutcomeOk(val payload: String) : ForgeExchangeOutcome()