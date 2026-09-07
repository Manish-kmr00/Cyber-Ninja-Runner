package com.iab.omid.library.bigosg.d;

import android.os.Build;
import com.amazon.device.ads.DtbDeviceData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String c() {
        return "Android";
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "deviceType", a());
        b.a(jSONObject, DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, b());
        b.a(jSONObject, "os", c());
        return jSONObject;
    }
}
