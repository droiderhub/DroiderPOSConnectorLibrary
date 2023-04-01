package com.droider.droiderposconnectorlibrary;

import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_AMOUNT;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_NAME;

import android.content.Context;
import android.content.Intent;

public class TheDroider {

    private static TheDroider instance = null;

    public TheDroider() {
    }

    public static TheDroider connectPOS() {
        if (instance == null) {
            instance = new TheDroider();
        }
        return instance;
    }

    public  void sendAmount(Context context, Intent intent){
        Intent i= DroiderIntent.createYourSpecialIntent(intent)
                .putExtra(DROIDER_AMOUNT, "1599.89")
                .putExtra(DROIDER_APPLICATION_NAME, context.getApplicationContext().getPackageName())
                ;
        context.startActivity(i);
    }
}
