package com.bytedance.sdk.component.JG.pA.pA.pA;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes11.dex */
public class JG {
    public static String pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(), 10);
    }

    public static String Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new String(Base64.decode(str, 10));
    }
}
