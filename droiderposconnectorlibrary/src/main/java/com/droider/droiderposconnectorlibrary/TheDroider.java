package com.droider.droiderposconnectorlibrary;

import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_INPUT_MONEY_ACTIVITY;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_PACKAGE_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_SETTLEMENT_ACTIVITY;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DESTINATION_VOID_ACTIVITY;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_AMOUNT;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_ACTIVITY_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_NAME_SILVER_LINE;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_APPLICATION_PACKAGE_NAME;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_SALE_TRANSACTION;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_SALE_WITH_QR_TRANSACTION;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_SETTLEMENT_TRANSACTION;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_RESPONSE_CODE;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_STATUS;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_TRANSACTION_TYPE;
import static com.droider.droiderposconnectorlibrary.DroiderConstant.DROIDER_VOID_TRANSACTION;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

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

    public void performSale(Activity activity, String amount) {
        Logger.v("performSale_____amount==" + amount);
        Logger.v("performSale_____activity-name==" + activity.getApplicationContext().getPackageName() + "." + activity.getClass().getSimpleName());
        Logger.v("performSale_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN)
                .putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_SILVER_LINE)
                .putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_SALE_TRANSACTION)
                .putExtra(DROIDER_AMOUNT, amount)
                .putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName())
                .putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, activity.getApplicationContext().getPackageName() + "." + activity.getClass().getSimpleName());
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_INPUT_MONEY_ACTIVITY));
        activity.startActivity(i);
    }

    public void performSaleWithQR(Activity activity, String amount) {
        Logger.v("performSaleWithQR_____amount==" + amount);
        Logger.v("performSaleWithQR_____activity-name==" + activity.getApplicationContext().getPackageName() + "." + activity.getApplicationContext().getClass().getSimpleName());
        Logger.v("performSaleWithQR_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN)
                .putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_SILVER_LINE)
                .putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_SALE_WITH_QR_TRANSACTION)
                .putExtra(DROIDER_AMOUNT, amount)
                .putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName())
                .putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, activity.getApplicationContext().getPackageName() + "." + activity.getClass().getSimpleName());
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_INPUT_MONEY_ACTIVITY));
        activity.startActivity(i);
    }

    public void performSettlement(Activity activity) {
        Logger.v("performSettlement_____activity-name==" + activity.getApplicationContext().getPackageName() + "." + activity.getApplicationContext().getClass().getSimpleName());
        Logger.v("performSettlement_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN)
                .putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_SILVER_LINE)
                .putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_SETTLEMENT_TRANSACTION)
                .putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName())
                .putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, activity.getApplicationContext().getPackageName() + "." + activity.getClass().getSimpleName());
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_SETTLEMENT_ACTIVITY));
        activity.startActivity(i);
    }

    public void performVoid(Activity activity) {
        Logger.v("performSettlement_____activity-name==" + activity.getApplicationContext().getPackageName() + "." + activity.getApplicationContext().getClass().getSimpleName());
        Logger.v("performSettlement_____package-name==" + activity.getApplicationContext().getPackageName());
        Intent i = new Intent(Intent.ACTION_MAIN)
                .putExtra(DROIDER_APPLICATION_NAME, DROIDER_APPLICATION_NAME_SILVER_LINE)
                .putExtra(DROIDER_TRANSACTION_TYPE, DROIDER_VOID_TRANSACTION)
                .putExtra(DROIDER_APPLICATION_PACKAGE_NAME, activity.getApplicationContext().getPackageName())
                .putExtra(DROIDER_APPLICATION_ACTIVITY_NAME, activity.getApplicationContext().getPackageName() + "." + activity.getClass().getSimpleName());
        i.setComponent(new ComponentName(DESTINATION_PACKAGE_NAME, DESTINATION_VOID_ACTIVITY));
        activity.startActivity(i);
    }

    public String getTransactionStatus(Activity activity) {
        String transactionStatus = activity.getIntent().getStringExtra(DROIDER_TRANSACTION_STATUS);
        Logger.v("getTransactionStatus===" + transactionStatus);
        return transactionStatus;
    }

    public String getTransactionResponseCode(Activity activity) {
        String transactionResponseCode = activity.getIntent().getStringExtra(DROIDER_TRANSACTION_RESPONSE_CODE);
        Logger.v("getTransactionResponseCode===" + transactionResponseCode);
        return transactionResponseCode;
    }

}
