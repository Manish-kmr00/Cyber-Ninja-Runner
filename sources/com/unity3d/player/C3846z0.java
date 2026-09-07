package com.unity3d.player;

import android.app.Activity;
import android.os.Build;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;

/* JADX INFO: renamed from: com.unity3d.player.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C3846z0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Thread.UncaughtExceptionHandler f8318a;
    private String b;

    C3846z0() {
    }

    static void a(String str) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C3846z0) {
            C3846z0 c3846z0 = (C3846z0) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int iIndexOf = str.indexOf(47, i + 1);
                if (iIndexOf == -1) {
                    break;
                }
                i2 = i;
                i = iIndexOf;
            }
            c3846z0.b = i2 < 0 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : str.substring(i2 + 1);
        }
    }

    final synchronized void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        this.f8318a = defaultUncaughtExceptionHandler;
        this.b = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        String strValueOf;
        try {
            StringBuilder sbAppend = new StringBuilder().append(String.format("FATAL EXCEPTION [%s]\n", thread.getName())).append(String.format("Unity version     : %s\n", "6000.0.56f1")).append(String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL)).append(String.format("Device fingerprint: %s\n", Build.FINGERPRINT)).append(String.format("CPU supported ABI : %s\n", Arrays.toString(Build.SUPPORTED_ABIS))).append(String.format("Build Type        : %s\n", "Release")).append(String.format("Scripting Backend : %s\n", "IL2CPP")).append(String.format("Libs loaded from  : %s\n", this.b));
            try {
                Activity activity = UnityPlayer.currentActivity;
                strValueOf = String.valueOf(activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData.getBoolean("unity.strip-engine-code"));
            } catch (Exception unused) {
                strValueOf = "Undefined";
            }
            Error error = new Error(sbAppend.append(String.format("Strip Engine Code : %s\n", strValueOf)).toString());
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f8318a.uncaughtException(thread, error);
        } catch (Throwable unused2) {
            this.f8318a.uncaughtException(thread, th);
        }
    }
}
