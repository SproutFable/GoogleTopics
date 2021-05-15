package com.ehsankolivand.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.os.AsyncTask
import android.util.Log
const val MY_TAG = "TestBackground"
class MyJobSchedulerClass : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }

}