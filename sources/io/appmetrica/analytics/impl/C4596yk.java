package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.yk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4596yk {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11864a;
    protected final Le b;
    public C4263lb c;

    public C4596yk(Le le, String str) {
        this.b = le;
        this.f11864a = str;
        C4263lb c4263lb = new C4263lb();
        try {
            String strH = le.h(str);
            if (!TextUtils.isEmpty(strH)) {
                c4263lb = new C4263lb(strH);
            }
        } catch (Throwable unused) {
        }
        this.c = c4263lb;
    }

    public final C4596yk a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final C4596yk b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final C4596yk d(long j) {
        a(f, Long.valueOf(j));
        return this;
    }

    public final Long e() {
        return this.c.a(g);
    }

    public final Long f() {
        return this.c.a(f);
    }

    public final Long g() {
        return this.c.a(d);
    }

    public final boolean h() {
        return this.c.length() > 0;
    }

    public final Boolean i() {
        C4263lb c4263lb = this.c;
        c4263lb.getClass();
        try {
            return Boolean.valueOf(c4263lb.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final C4596yk a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.f11864a, this.c.toString());
        this.b.b();
    }

    public final C4596yk c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final C4596yk e(long j) {
        a(d, Long.valueOf(j));
        return this;
    }

    public final void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.c = new C4263lb();
        b();
    }
}
