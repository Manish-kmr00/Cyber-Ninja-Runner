package com.bytedance.sdk.component.adexpress.ZZv;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ML {
    public static boolean pA(String str) {
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            return TextUtils.equals(str, "embeded_ad") || TextUtils.equals(str, "banner_ad");
        }
        return false;
    }
}
