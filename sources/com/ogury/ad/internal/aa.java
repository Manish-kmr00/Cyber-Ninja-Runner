package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7263a;
    public final boolean b;
    public final String c;
    public boolean d;
    public boolean e;
    public boolean f;

    public aa(boolean z, boolean z2, String url, boolean z3, int i) {
        z3 = (i & 8) != 0 ? false : z3;
        Intrinsics.checkNotNullParameter(url, "url");
        this.f7263a = z;
        this.b = z2;
        this.c = url;
        this.d = z3;
        this.e = false;
        this.f = false;
    }
}
