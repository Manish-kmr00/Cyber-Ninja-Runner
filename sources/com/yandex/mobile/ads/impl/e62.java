package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8767a;
    private final String b;
    private final fa2 c;

    public e62(String event, String trackingUrl, fa2 fa2Var) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(trackingUrl, "trackingUrl");
        this.f8767a = event;
        this.b = trackingUrl;
        this.c = fa2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e62)) {
            return false;
        }
        e62 e62Var = (e62) obj;
        return Intrinsics.areEqual(this.f8767a, e62Var.f8767a) && Intrinsics.areEqual(this.b, e62Var.b) && Intrinsics.areEqual(this.c, e62Var.c);
    }

    public final int hashCode() {
        int iA = v3.a(this.b, this.f8767a.hashCode() * 31, 31);
        fa2 fa2Var = this.c;
        return iA + (fa2Var == null ? 0 : fa2Var.hashCode());
    }

    public final String toString() {
        return "TrackingEvent(event=" + this.f8767a + ", trackingUrl=" + this.b + ", offset=" + this.c + ")";
    }

    public final String a() {
        return this.f8767a;
    }

    public final String c() {
        return this.b;
    }

    public final fa2 b() {
        return this.c;
    }
}
