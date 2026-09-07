package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes10.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7535a = -1;
    public static int b = -1;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.b = v.b(x.b());
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt("camera_count", v.b).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        int i = b;
        if (i != -1) {
            return i;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                b = cameraManager.getCameraIdList().length;
            } catch (Throwable unused) {
                b = -1;
            }
        } else {
            b = -2;
        }
        return b;
    }

    public static int c(Context context) {
        TelephonyManager telephonyManager;
        if (f7535a == -1 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            f7535a = telephonyManager.getSimState();
        }
        return f7535a;
    }

    public static int a() {
        int i;
        int i2 = b;
        if (i2 != -1) {
            return i2;
        }
        SharedPreferences sharedPreferencesA = u0.a(x.b());
        if (sharedPreferencesA == null || (i = sharedPreferencesA.getInt("camera_count", -1)) == -1) {
            o0.b(new a());
            return -1;
        }
        b = i;
        return i;
    }
}
