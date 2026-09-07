package com.yandex.mobile.ads.impl;

import android.os.Build;
import com.amazon.device.ads.DtbDeviceData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class pn2 {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        zn2.a(jSONObject, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zn2.a(jSONObject, DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, Integer.toString(Build.VERSION.SDK_INT));
        zn2.a(jSONObject, "os", "Android");
        return jSONObject;
    }
}
