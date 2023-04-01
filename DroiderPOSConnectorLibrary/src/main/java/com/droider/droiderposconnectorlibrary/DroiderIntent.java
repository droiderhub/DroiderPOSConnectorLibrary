package com.droider.droiderposconnectorlibrary;

import android.content.ComponentName;
import android.content.Intent;

public class DroiderIntent {

    public static Intent createYourSpecialIntent(Intent src) {
        return new Intent(Intent.ACTION_MAIN).addCategory("DROIDER")
                .putExtras(src)
                .setComponent(new ComponentName("com.hbl.centerm", "com.hbl.centerm.view.activities.InputMoneyActivity"))
                ;
    }
}
