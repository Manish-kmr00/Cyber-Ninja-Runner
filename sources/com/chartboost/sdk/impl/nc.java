package com.chartboost.sdk.impl;

import android.os.Build;
import com.amazon.device.ads.DtbDeviceData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class nc {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return "Android";
    }

    public static String c() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "deviceType", a());
        vc.a(jSONObject, DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, c());
        vc.a(jSONObject, "os", b());
        return jSONObject;
    }
}
