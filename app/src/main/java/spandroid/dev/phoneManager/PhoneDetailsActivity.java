package spandroid.dev.phoneManager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.List;

import spandroid.dev.R;

public class PhoneDetailsActivity extends AppCompatActivity {
    AppCompatTextView tvSimNumber, tvSimSerialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);

        tvSimNumber = findViewById(R.id.tvSimNumber);
        tvSimSerialNumber = findViewById(R.id.tvSimSerialNumber);

        TelephonyManager telemamanger = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String getSimSerialNumber = telemamanger.getSimSerialNumber();
        String getSimNumber = telemamanger.getLine1Number();


        tvSimNumber.setText("Sim Number " + getSimNumber);
        tvSimSerialNumber.setText("Serial Number " + getSimSerialNumber);


        SubscriptionManager subscriptionManager = SubscriptionManager.from(getApplicationContext());
        List<SubscriptionInfo> subsList = subscriptionManager.getActiveSubscriptionInfoList();

        for (SubscriptionInfo subscriptionInfo : subsList) {
            // get IMEI
            int simSlotIndex = subscriptionInfo.getSimSlotIndex();
            String imei = telemamanger.getImei(simSlotIndex);

            // get serial number
            String serialNumber = subscriptionInfo.getIccId();

            // get line number
            String lineNumber = subscriptionInfo.getNumber();
            if (TextUtils.isEmpty(getSimNumber)) {
                tvSimNumber.setText("Sim Number " + serialNumber);
            }
        }

    }
}
