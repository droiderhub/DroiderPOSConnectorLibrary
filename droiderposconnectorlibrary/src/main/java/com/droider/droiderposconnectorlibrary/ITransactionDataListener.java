package com.droider.droiderposconnectorlibrary;

import android.app.Activity;

import androidx.annotation.NonNull;

import java.io.Serializable;

public interface ITransactionDataListener extends Serializable {
    public String getTransactionResponseCode(@NonNull Activity activity);
    public String getTransactionInvoiceNumber(@NonNull Activity activity);
    public String getTransactionStatus(@NonNull Activity activity);
}
