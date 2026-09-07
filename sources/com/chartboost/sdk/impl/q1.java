package com.chartboost.sdk.impl;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class q1 {
    public static boolean a(AtomicReference<o9> atomicReference, JSONObject jSONObject) {
        try {
            atomicReference.set(new o9(jSONObject));
            return true;
        } catch (Exception e) {
            b7.b("updateConfig: " + e, null);
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            if (context != null) {
                int iCheckSelfPermission = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
                boolean z = context.checkSelfPermission("android.permission.INTERNET") != 0;
                boolean z2 = iCheckSelfPermission != 0;
                if (z) {
                    throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
                }
                if (z2) {
                    throw new RuntimeException("Please add the permission : android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
                }
                return true;
            }
            throw new RuntimeException("Invalid activity context passed during intitalization");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
