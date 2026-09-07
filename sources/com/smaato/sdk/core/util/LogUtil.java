package com.smaato.sdk.core.util;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public class LogUtil {
    public static void logSmaatoInitMissing() {
        Log.println(6, "Initialisation Error", "Please check if Smaato SDK is initialised before performing this action.");
    }

    public static void logSmaatoAgeRestrictedUser() {
        Log.println(6, "Loading Error", "This user is age restricted.");
    }
}
