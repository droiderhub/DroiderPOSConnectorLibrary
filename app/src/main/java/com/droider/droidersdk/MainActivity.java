package com.droider.droidersdk;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.droider.droiderposconnectorlibrary.TheDroider;

public class MainActivity extends AppCompatActivity {

    Button send_amount;
    TextView result_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_amount = findViewById(R.id.send_amount);
        result_tv = findViewById(R.id.result_tv);
        result_tv.setText(TheDroider.connectPOS().getTransactionStatus(this));

        send_amount.setOnClickListener(v -> {
            TheDroider.connectPOS().performSale(this,"1599.89");
        });
    }

}