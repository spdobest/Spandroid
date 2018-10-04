package spandroid.dev.android8_oreo.jobServices

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import spandroid.dev.R

import kotlinx.android.synthetic.main.activity_job_services.*
import android.app.job.JobInfo
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import spandroid.dev.android8_oreo.jobScheduler.MyJobService
import android.os.Build.VERSION_CODES.O
import android.os.Build.VERSION.SDK_INT

class JobServicesActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * IMPORTANT LINKS
     * https://developer.android.com/about/versions/oreo/background
     * https://medium.com/exploring-android/exploring-background-execution-limits-on-android-oreo-ab384762a66c
     * https://medium.com/urbanclap-engineering/making-app-ready-for-oreo-738bf57114f4
     *
     */
    val LOAD_ARTWORK_JOB_ID = 123

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.buttonStartJobService ->{
                val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
                jobScheduler.schedule(JobInfo.Builder(LOAD_ARTWORK_JOB_ID,
                        ComponentName(this, MyJobService::class.java))
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                        .build())
            }
            R.id.buttonStartJobIntentService ->{

            }
            R.id.buttonStartJobScheduler ->{

            }
            R.id.buttonStartForegroundService ->{
               /* val intentService = Intent(applicationContext,ForegroundService.class)
                startService(applicationContext,intentService)*/
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_services)


        buttonStartJobService.setOnClickListener(this)
        buttonStartJobIntentService.setOnClickListener(this)
        buttonStartJobScheduler.setOnClickListener(this)
        buttonStartForegroundService.setOnClickListener(this)

    }

    //The way i use it is
    fun startService(context: Context, intent: Intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }


    /**
     * JobScheduler jobScheduler =
    (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
    jobScheduler.schedule(new JobInfo.Builder(LOAD_ARTWORK_JOB_ID,
    new ComponentName(this, DownloadArtworkJobService.class))
    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
    .build());
     */
}
