package com.bytedance.sdk.openadsdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes7.dex */
public class ML {
    private static long KZx = 0;
    static float Og = 0.0f;
    static int pA = -1;

    private static void pA(Intent intent) {
        if (intent.getIntExtra("status", -1) == 2) {
            pA = 1;
        } else {
            pA = 0;
        }
        Og = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
    }

    public static pA pA() {
        if (KZx == 0 || SystemClock.elapsedRealtime() - KZx > 60000) {
            Intent intentRegisterReceiver = com.bytedance.sdk.openadsdk.core.aBv.pA().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            Log.d("BatteryDataWatcher", "obtainCurrentState: registerReceiver result is ".concat(String.valueOf(intentRegisterReceiver)));
            if (intentRegisterReceiver != null) {
                pA(intentRegisterReceiver);
                KZx = SystemClock.elapsedRealtime();
            }
        }
        pA pAVar = new pA(pA, Og);
        int i = pAVar.pA;
        float f = pAVar.Og;
        return pAVar;
    }

    public static class pA {
        public final float Og;
        public final int pA;

        public pA(int i, float f) {
            this.pA = i;
            this.Og = f;
        }
    }
}
