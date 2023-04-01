package com.droider.droidersdk;

import android.content.ComponentName;
import android.content.Intent;

public class DroiderIntent {

    public static Intent createYourSpecialIntent(Intent src) {
        return new Intent(Intent.ACTION_MAIN).addCategory("DROIDER_AMOUNT")
                .putExtras(src)
                .setComponent(new ComponentName("com.hbl.centerm", "com.hbl.centerm.view.activities.InputMoneyActivity"))
                ;
    }
}
