package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes6.dex */
public final class at0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f8439a = new Object();

    @Pure
    public static void c(String str, String str2) {
        synchronized (f8439a) {
            Log.i(str, str2);
        }
    }

    @Pure
    public static void d(String str, String str2) {
        synchronized (f8439a) {
            Log.w(str, str2);
        }
    }

    @Pure
    private static String a(String str, Throwable th) {
        String strReplace;
        synchronized (f8439a) {
            try {
                if (th != null) {
                    Throwable cause = th;
                    while (true) {
                        if (cause == null) {
                            strReplace = Log.getStackTraceString(th).trim().replace("\t", "    ");
                            break;
                        }
                        if (cause instanceof UnknownHostException) {
                            strReplace = "UnknownHostException (no network)";
                            break;
                        }
                        cause = cause.getCause();
                    }
                } else {
                    strReplace = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return !TextUtils.isEmpty(strReplace) ? str + "\n  " + strReplace.replace("\n", "\n  ") + '\n' : str;
    }

    @Pure
    public static void b(String str, String str2, Throwable th) {
        d(str, a(str2, th));
    }

    @Pure
    public static void b(String str, String str2) {
        synchronized (f8439a) {
            Log.e(str, str2);
        }
    }

    @Pure
    public static void a(String str, String str2, Throwable th) {
        b(str, a(str2, th));
    }

    @Pure
    public static void a(String str, Exception exc) {
        c("BundleUtil", a(str, (Throwable) exc));
    }

    @Pure
    public static void a(String str, String str2) {
        synchronized (f8439a) {
            Log.d(str, str2);
        }
    }
}
