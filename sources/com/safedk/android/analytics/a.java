package com.safedk.android.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7961a = "ANRDetector";
    private static final int b = 5000;
    private static final Set<String> c = new HashSet(Arrays.asList("com.android.internal.os.RuntimeInit$UncaughtHandler.uncaughtException", "com.android.internal.os.RuntimeInit$KillApplicationHandler.uncaughtException"));
    private volatile int d;
    private Context e;
    private int f;
    private Handler g;
    private com.safedk.android.analytics.reporters.a h;
    private String i;
    private boolean j;
    private final Runnable k;

    public a(Context context) {
        this(context, 5000, false);
    }

    public a(Context context, boolean z) {
        this(context, 5000, z);
    }

    public a(Context context, int i, boolean z) {
        this.d = 0;
        this.k = new Runnable() { // from class: com.safedk.android.analytics.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.d = (a.this.d + 1) % Integer.MAX_VALUE;
            }
        };
        this.e = context;
        this.f = i;
        this.j = z;
        this.g = new Handler(Looper.getMainLooper());
        this.h = new com.safedk.android.analytics.reporters.a(context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }

    private StackTraceElement[] a() {
        return Looper.getMainLooper().getThread().getStackTrace();
    }

    private static String a(StackTraceElement[] stackTraceElementArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                messageDigest.update(stackTraceElement.toString().getBytes());
            }
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
