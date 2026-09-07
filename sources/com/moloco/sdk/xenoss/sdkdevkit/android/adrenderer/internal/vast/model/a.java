package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6885a;
    public final Integer b;
    public final b c;

    public a(String str, Integer num, b child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.f6885a = str;
        this.b = num;
        this.c = child;
    }

    public final b a() {
        return this.c;
    }

    public final String b() {
        return this.f6885a;
    }

    public final Integer c() {
        return this.b;
    }
}
