package spandroid.dev.linearlayoutPercentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import spandroid.dev.R;

public class LinearLayoutPercentageActivity extends AppCompatActivity {


    LinearLayout ll1;
    LinearLayout ll2;
    AppCompatTextView textViewPercentage;
    View viewDebtYellow;
    AppCompatTextView viewEquityWhite;
    View viewEquityYellow;

    AppCompatEditText edittextAMountDebt;
    AppCompatEditText edittextAMountEquity;
    AppCompatButton buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_view);

         ll1 = findViewById(R.id.ll1);
         ll2 = findViewById(R.id.ll2);
        textViewPercentage = findViewById(R.id.textViewPercentage);
         viewDebtYellow = findViewById(R.id.viewDebtYellow);
         viewEquityWhite = findViewById(R.id.viewEquityWhite);
         viewEquityYellow = findViewById(R.id.viewEquityYellow);
        edittextAMountDebt = findViewById(R.id.edittextAMountDebt);
        edittextAMountEquity = findViewById(R.id.edittextAMountEquity);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double equity = Double.parseDouble(edittextAMountEquity.getText().toString().trim());
                double debt = Double.parseDouble(edittextAMountDebt.getText().toString().trim());
                setPercentage(debt,equity);

            }
        });

    }

    private void setPercentage(double debtAMount,double  equityAmount){


        double percentageDebt = (debtAMount/equityAmount)*100;
        double percentageWhite = 100 - percentageDebt;

        LinearLayout.LayoutParams paramYellow = (LinearLayout.LayoutParams) viewDebtYellow.getLayoutParams();
        paramYellow.weight = (float)percentageDebt;
        viewDebtYellow.setLayoutParams(paramYellow);

        textViewPercentage.setText(""+debtAMount);

        if(percentageDebt<100) {
            LinearLayout.LayoutParams paramWhite = (LinearLayout.LayoutParams) textViewPercentage.getLayoutParams();
            paramWhite.weight = (float) percentageWhite;
            textViewPercentage.setLayoutParams(paramWhite);
        }

        viewEquityWhite.setText(""+equityAmount);

    }

}
