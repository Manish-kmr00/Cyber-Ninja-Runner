package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6912a;
    public final String b;

    public z(String str, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f6912a = str;
        this.b = url;
    }

    public final String a() {
        return this.f6912a;
    }

    public final String b() {
        return this.b;
    }
}
