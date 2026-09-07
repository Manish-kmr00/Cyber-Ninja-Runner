package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.lc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4264lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f11650a;

    public static String a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public final String b() {
        if (this.f11650a != null) {
            return this.f11650a;
        }
        synchronized (this) {
            if (this.f11650a == null) {
                this.f11650a = a();
            }
        }
        return this.f11650a;
    }

    public final boolean c() {
        try {
            return (TextUtils.isEmpty(b()) || b().contains(":")) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean a(String str) {
        try {
            return !TextUtils.isEmpty(b()) && b().endsWith(new StringBuilder(":").append(str).toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}
