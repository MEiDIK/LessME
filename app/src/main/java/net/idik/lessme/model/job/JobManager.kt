package net.idik.lessme.model.job

import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.config.Configuration
import net.idik.lessme.core.Core
import net.idik.lessme.model.job.jobs.BaseJob

/**
 * Created by linshuaibin on 28/03/2017.
 */

object JobManager {

    val jobManager: JobManager = JobManager(Configuration.Builder(Core.instance).build())

    fun schedule(job: IJob) {
        when (job) {
            is BaseJob -> jobManager.addJobInBackground(job)
        }
    }

//    fun cancel(job: IJob) {
//        when (job) {
//            is BaseJob -> jobManager.cancelJobsInBackground(null, TagConstraint.ANY, job.)
//        }
//    }

}

