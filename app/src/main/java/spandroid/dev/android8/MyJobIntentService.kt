package spandroid.dev.android8

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.SystemClock
import android.support.v4.app.JobIntentService
import android.util.Log
import android.widget.Toast


class MyJobIntentService : JobIntentService() {


    companion object {
        val JOB_ID = 1000
        fun enqueueWork(context: Context, work: Intent) {
            JobIntentService.enqueueWork(context, MyJobIntentService::class.java, JOB_ID, work)
        }
    }

    /**
     * Unique job ID for this service.
     */


    /**
     * Convenience method for enqueuing work in to this service.
     */


    override fun onHandleWork(intent: Intent) {
        // We have received work to do.  The system or framework is already
        // holding a wake lock for us at this point, so we can just go.
        Log.i("SimpleJobIntentService", "Executing work: " + intent)
        var label: String? = intent.getStringExtra("label")
        if (label == null) {
            label = intent.toString()
        }
        toast("Executing: " + label)
        for (i in 0..4) {
            Log.i("SimpleJobIntentService", "Running service " + (i + 1)
                    + "/5 @ " + SystemClock.elapsedRealtime())
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
            }

        }
        Log.i("SimpleJobIntentService", "Completed service @ " + SystemClock.elapsedRealtime())
    }

    override fun onDestroy() {
        super.onDestroy()
        toast("All work complete")
    }

    val mHandler = Handler()

    // Helper for showing tests
    fun toast(text: CharSequence) {
        mHandler.post(Runnable { Toast.makeText(this@MyJobIntentService, text, Toast.LENGTH_SHORT).show() })
    }
}
