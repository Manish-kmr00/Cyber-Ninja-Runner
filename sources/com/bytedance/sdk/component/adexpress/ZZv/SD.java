package com.bytedance.sdk.component.adexpress.ZZv;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes7.dex */
public class SD {
    public static boolean pA(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean Og(String str) {
        return com.bytedance.sdk.component.adexpress.ZZv.Og() && pA(str);
    }
}
