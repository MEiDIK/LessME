package net.idik.lessme.model.job.jobs

import android.content.Context
import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import net.idik.lessme.core.Core
import net.idik.lessme.model.job.IJob

/**
 * Created by linshuaibin on 28/03/2017.
 */
abstract class BaseJob(persist: Boolean = true, params: BaseParams = BaseParams(persist = persist)) : Job(params), IJob {

    val context: Context
        get() = Core.instance

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        return RetryConstraint.RETRY
    }

    override fun onAdded() {
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
    }
}

class BaseParams(priority: Int = BaseParams.NORMAL, persist: Boolean) : Params(priority) {

    init {
        isPersistent = persist
    }

    companion object {
        val NORMAL = 1
    }
}