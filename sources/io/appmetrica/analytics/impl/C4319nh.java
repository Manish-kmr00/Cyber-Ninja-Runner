package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4319nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3984a6 f11686a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final C4568xh e;

    public C4319nh(C3984a6 c3984a6, boolean z, int i, HashMap map, C4568xh c4568xh) {
        this.f11686a = c3984a6;
        this.b = z;
        this.c = i;
        this.d = map;
        this.e = c4568xh;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.f11686a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
