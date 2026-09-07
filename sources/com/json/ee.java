package com.json;

import android.util.Base64;
import com.json.mediationsdk.logger.IronLog;

/* JADX INFO: loaded from: classes10.dex */
public class ee {
    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 10);
    }
}
