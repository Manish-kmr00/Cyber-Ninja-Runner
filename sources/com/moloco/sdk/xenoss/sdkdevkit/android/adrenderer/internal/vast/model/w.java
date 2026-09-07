package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f6909a;
    public final String b;
    public final String c;

    public w(List<a> ads, String str, String str2) {
        Intrinsics.checkNotNullParameter(ads, "ads");
        this.f6909a = ads;
        this.b = str;
        this.c = str2;
    }

    public final List<a> a() {
        return this.f6909a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
