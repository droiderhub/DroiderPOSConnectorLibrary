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
        result_tv.setText(getIntent().getStringExtra("DROIDER_AMOUNT_RESULT"));
        Log.d("DROIDER_APPLICATION", getApplicationContext().getPackageName());
        Log.d("DROIDER_APPL_name", this.getClass().getSimpleName());

        send_amount.setOnClickListener(v -> {
            TheDroider.connectPOS().sendAmount(getApplicationContext(), getIntent());
        });
    }

}