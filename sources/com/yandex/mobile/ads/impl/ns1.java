package com.yandex.mobile.ads.impl;

import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class ns1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ns1 f9752a = new ns1();
    private static final String[] b = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};

    public static boolean a() {
        try {
            if (new File("/system/app/Superuser/Superuser.apk").exists()) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            String[] strArr = b;
            boolean z = false;
            for (int i = 0; i < 8; i++) {
                z = z || (Build.VERSION.SDK_INT < 31 && new File(strArr[i]).exists());
            }
            if (z) {
                return true;
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    private ns1() {
    }
}
