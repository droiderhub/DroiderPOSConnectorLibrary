package com.droider.droiderposconnectorlibrary;

import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER;

import android.util.Log;


public class Logger {

    public static void v(String s) {
        Log.v(DROIDER, "the_droider --" + s);
    }

    public static void d(String s) {
        Log.d(DROIDER, "the_droider --" + s);
    }

    public static void e(String s) {
        Log.e(DROIDER, "the_droider --" + s);
    }

}
