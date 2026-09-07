package com.json.sdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.json.eh;

/* JADX INFO: loaded from: classes11.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4404a;

    public static void d(String str, String str2) {
        if (f4404a) {
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f4404a) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (f4404a) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f4404a) {
            Log.e(str, str2, th);
        }
    }

    public static void enableLogging(int i) {
        f4404a = eh.d.MODE_0.a() != i;
    }

    public static void i(String str, String str2) {
        if (f4404a) {
            Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!f4404a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2, th);
    }

    public static void v(String str, String str2) {
        if (f4404a) {
            Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (f4404a) {
            Log.v(str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (f4404a) {
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f4404a) {
            Log.w(str, str2, th);
        }
    }
}
