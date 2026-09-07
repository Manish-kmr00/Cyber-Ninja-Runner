package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public class TX {
    private static volatile String pA;

    public static String pA() {
        if (!TextUtils.isEmpty(pA)) {
            return pA;
        }
        String str = Build.MODEL;
        pA = str;
        return str;
    }
}
