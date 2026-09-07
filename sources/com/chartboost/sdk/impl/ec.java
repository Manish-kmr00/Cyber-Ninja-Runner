package com.chartboost.sdk.impl;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public final class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UiModeManager f1009a;

    public static y3 a() {
        UiModeManager uiModeManager = f1009a;
        if (uiModeManager == null) {
            return y3.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType != 1) {
            return currentModeType != 4 ? y3.OTHER : y3.CTV;
        }
        return y3.MOBILE;
    }

    public static void a(Context context) {
        if (context != null) {
            f1009a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
