package com.bytedance.sdk.openadsdk.yFO;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

/* JADX INFO: loaded from: classes10.dex */
public class ML {
    public static int BSW = 16;
    public static int Bzk = 4;
    public static int JG = 0;
    protected static int KZx = 1;
    protected static long ML = 15360;
    protected static String Og = null;
    public static int SD = 1;
    public static int SGo = 8;
    public static int WV = 32;
    protected static int ZZv = 30;
    public static int omh = 2;
    protected static String pA = "images";

    protected static boolean pA(Context context, String str) {
        return false;
    }

    protected static Bitmap pA(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static boolean pA(Context context, int i) {
        boolean zPA;
        boolean zPA2;
        if (JG == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zPA = pA(context, "android.permission.READ_MEDIA_IMAGES");
                zPA2 = true;
            } else {
                zPA = pA(context, "android.permission.READ_EXTERNAL_STORAGE");
                zPA2 = pA(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zPA3 = pA(context, "android.permission.CAMERA");
            boolean zPA4 = pA(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zPA && zPA2) {
                JG |= SD;
            }
            if (zPA3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                JG |= omh;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                JG |= Bzk;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                JG |= SGo;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                JG |= BSW;
            }
            if (zPA4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                JG |= WV;
            }
        }
        return (JG & i) != 0;
    }

    public static boolean pA(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z2 = false;
            }
            return !z2 && z;
        }
        z2 = true;
        if (z2) {
        }
    }

    public static boolean Og(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static float Og(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }
}
