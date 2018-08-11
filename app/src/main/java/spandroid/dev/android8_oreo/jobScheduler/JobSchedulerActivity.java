package spandroid.dev.android8_oreo.jobScheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import spandroid.dev.R;

public class JobSchedulerActivity extends AppCompatActivity {

    private static final String TAG = "JobSchedulerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_scheduler2);


        ComponentName componentName = new ComponentName(this, MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(12, componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = jobScheduler.schedule(jobInfo);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled!");
        } else {
            Log.d(TAG, "Job not scheduled");
        }

    }


    String reverseString(String sentense) {
        if (!TextUtils.isEmpty(sentense) && sentense.length() > 1) {

            StringBuffer stringBuffer = new StringBuffer();


            for (int i = sentense.length() - 1; i >= 0; i--) {
                stringBuffer.append(sentense.charAt(i));
            }

            return stringBuffer.toString();

        } else {
            return sentense;
        }

    }

    int reverseNumber(int number) {
        if (number >= 10) {

            int num = 1234, reversed = 0;

            while (num > 0) {
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num /= 10;
            }
        }
    }

}
