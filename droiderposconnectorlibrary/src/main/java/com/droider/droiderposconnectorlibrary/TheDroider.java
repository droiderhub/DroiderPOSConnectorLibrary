package com.droider.droiderposconnectorlibrary;

import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_INPUT_MONEY_ACTIVITY;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_PACKAGE_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_SETTLEMENT_ACTIVITY;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_VOID_ACTIVITY;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_AMOUNT;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_ACTIVITY_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_NAME_POS_UNIVERSAL;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_PACKAGE_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_IS_TRANSACTION_COMPLETED;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_SALE_TRANSACTION;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_SALE_WITH_QR_TRANSACTION;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_SETTLEMENT_TRANSACTION;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_INVOICE_NUMBER;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_RESPONSE_CODE;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_STATUS;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_TYPE;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_VOID_TRANSACTION;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.Objects;

public class TheDroider {

    private static TheDroider instance = null;

    private TheDroider() {
    }

    public static synchronized TheDroider connectPOS() {
        if (instance == null) {
            instance = new TheDroider();
        }
        return instance;
    }

    private String getActivityPath(@NonNull Activity value) {
        char[] temp = value.getClass().getName().toCharArray();
        for (int i = value.getClass().getPackage() == null ? 0 : value.getClass().getPackage().getName().length() + 1; i < temp.length; i++) {
            if (temp[i] == '.') {
                temp[i] = '$';
            }
        }
        return new String(temp);
    }

    public void performSale(@NonNull Activity activity, String amount) {
        if (amount == null) {
            Toast.makeText(activity, "Amount can not be null", Toast.LENGTH_LONG).show();
            return;
        }
        Logger.v("performSale_____amount==" + amount);
        Logger.v("performSale_____activity-name==" + getActivityPath(activity));
        Logger.v("performSale_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN).putExtra(DROIDER_IS_TRANSACTION_COMPLETED, false).putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_POS_UNIVERSAL).putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_SALE_TRANSACTION).putExtra(DROIDER_AMOUNT, amount).putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName()).putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, getActivityPath(activity));
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_INPUT_MONEY_ACTIVITY));
        activity.startActivity(i);
    }

    public void performSaleWithQR(@NonNull Activity activity, String amount) {
        if (amount == null) {
            Toast.makeText(activity, "Amount can not be null", Toast.LENGTH_LONG).show();
            return;
        }
        Logger.v("performSaleWithQR_____amount==" + amount);
        Logger.v("performSaleWithQR_____activity-name==" + getActivityPath(activity));
        Logger.v("performSaleWithQR_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN).putExtra(DROIDER_IS_TRANSACTION_COMPLETED, false).putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_POS_UNIVERSAL).putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_SALE_WITH_QR_TRANSACTION).putExtra(DROIDER_AMOUNT, amount).putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName()).putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, getActivityPath(activity));
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_INPUT_MONEY_ACTIVITY));
        activity.startActivity(i);
    }

    public void performSettlement(@NonNull Activity activity) {
        Logger.v("performSettlement_____activity-name==" + getActivityPath(activity));
        Logger.v("performSettlement_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN).putExtra(DROIDER_IS_TRANSACTION_COMPLETED, false).putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_POS_UNIVERSAL).putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_SETTLEMENT_TRANSACTION).putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName()).putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, getActivityPath(activity));
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_SETTLEMENT_ACTIVITY));
        activity.startActivity(i);
    }

    public void performVoid(@NonNull Activity activity) {
        Logger.v("performVoid_____activity-name==" + getActivityPath(activity));
        Logger.v("performVoid_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN).putExtra(DROIDER_IS_TRANSACTION_COMPLETED, false).putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_POS_UNIVERSAL).putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_VOID_TRANSACTION).putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName()).putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, getActivityPath(activity));
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_VOID_ACTIVITY));
        activity.startActivity(i);
    }

    public String getTransactionStatus(@NonNull Activity activity) {
        if (activity.getIntent().getBooleanExtra(DROIDER_IS_TRANSACTION_COMPLETED, false)) {
            String transactionStatus = activity.getIntent().getStringExtra(DROIDER_TRANSACTION_STATUS);
            Logger.v("getTransactionStatus===" + transactionStatus);
            return transactionStatus;
        } else {
            return null;
        }
    }

    public String getTransactionInvoiceNumber(@NonNull Activity activity) {
        if (activity.getIntent().getBooleanExtra(DROIDER_IS_TRANSACTION_COMPLETED, false)) {
            String transactionInvoiceNumber = activity.getIntent().getStringExtra(DROIDER_TRANSACTION_INVOICE_NUMBER);
            Logger.v("getTransactionInvoiceNumber===" + transactionInvoiceNumber);
            return transactionInvoiceNumber;
        } else {
            return null;
        }
    }

    public String getTransactionResponseCode(@NonNull Activity activity) {
        if (activity.getIntent().getBooleanExtra(DROIDER_IS_TRANSACTION_COMPLETED, false)) {
            String transactionResponseCode = activity.getIntent().getStringExtra(DROIDER_TRANSACTION_RESPONSE_CODE);
            Logger.v("getTransactionResponseCode===" + transactionResponseCode);
            return transactionResponseCode;
        } else {
            return null;
        }
    }

    public String getData(@NonNull Activity activity){
        if (Objects.equals(activity.getIntent().getAction(), Intent.ACTION_SEND) && activity.getIntent().getType().startsWith("text/")) {
            // Session 1: Handle received text data
//            return  activity.getIntent().getStringExtra(Intent.EXTRA_TEXT);
            return  activity.getIntent().getStringExtra(DROIDER_TRANSACTION_RESPONSE_CODE);
        }else {
            return null;
        }
    }

}
