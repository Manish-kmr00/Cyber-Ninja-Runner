package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public class BSW {
    private static String pA;

    public static String pA() {
        if (TextUtils.isEmpty(pA)) {
            pA = com.bykv.vk.openvk.pA.pA.pA.KZx.pA().getCacheDir() + File.separator + "proxy_cache";
        }
        return pA;
    }

    public static void pA(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}
