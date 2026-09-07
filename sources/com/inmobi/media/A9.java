package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class A9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K5 f3027a;

    public A9(Context context, String sharePrefFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharePrefFile, "sharePrefFile");
        ConcurrentHashMap concurrentHashMap = K5.b;
        this.f3027a = J5.a(context, sharePrefFile);
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f3027a.a(key, value);
    }

    public final void b(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f3027a.a(key, value);
        a(System.currentTimeMillis() / ((long) 1000));
    }

    public final boolean c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f3027a.a(key);
    }

    public final void a(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f3027a.a(key, z);
    }

    public final String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        K5 k5 = this.f3027a;
        k5.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        return k5.f3112a.getString(key, null);
    }

    public final long b() {
        K5 k5 = this.f3027a;
        k5.getClass();
        Intrinsics.checkNotNullParameter("last_ts", "key");
        return k5.f3112a.getLong("last_ts", 0L);
    }

    public final void a(long j) {
        this.f3027a.a("last_ts", j);
    }

    public final void a() {
        this.f3027a.b();
    }

    public final boolean b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        K5 k5 = this.f3027a;
        k5.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        return k5.f3112a.contains(key);
    }
}
