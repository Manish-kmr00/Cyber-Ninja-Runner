package com.safedk.android.analytics.brandsafety;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f8113a = Long.valueOf(System.currentTimeMillis());
    public Long b = Long.valueOf(SystemClock.elapsedRealtime());
    public String c;
    public String d;
    public String e;
    public String f;
    public m g;
    public StackTraceElement[] h;

    public m(String str, String str2, String str3, String str4, m mVar, StackTraceElement[] stackTraceElementArr) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = mVar;
        this.h = stackTraceElementArr;
    }

    public String toString() {
        return "IntentDetails{ " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + " }";
    }
}
