package com.droider.droidersdk;

import android.content.Context;
import android.content.Intent;

public class DroiderManager {

    private static DroiderManager instance = null;

    public DroiderManager() {
    }

    public static DroiderManager getInstance() {
        if (instance == null) {
            instance = new DroiderManager();
        }
        return instance;
    }

    public  void sendAmount(Context context, Intent intent){
        Intent i= DroiderIntent.createYourSpecialIntent(intent)
                .putExtra("DROIDER_AMOUNT", "1599.89")
                .putExtra("DROIDER_APPLICATION_NAME", context.getApplicationContext().getPackageName())
                ;
        context.startActivity(i);
    }
}
