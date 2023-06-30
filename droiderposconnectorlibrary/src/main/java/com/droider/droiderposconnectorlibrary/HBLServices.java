package com.droider.droiderposconnectorlibrary;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

public interface HBLServices {

    static HBLServices connectPOS() {
        return TheDroider.getHBLServices();
    }

    void performSale(@NonNull Activity activity, String amount);

    void performSaleWithQR(@NonNull Activity activity, String amount);

    void performSettlement(@NonNull Activity activity);

    void performVoid(@NonNull Activity activity);

    String getTransactionStatus(Intent intent);

    String getTransactionInvoiceNumber(Intent intent);

    String getTransactionResponseCode(Intent intent);

    boolean isTransactionCompleted(Intent intent);
}
