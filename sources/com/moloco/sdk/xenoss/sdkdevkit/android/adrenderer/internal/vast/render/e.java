package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {
    public static final int i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f7070a;
    public final int b;
    public final int c;
    public final String d;
    public final List<String> e;
    public final List<String> f;
    public final Long g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r h;

    public e(y resource, int i2, int i3, String str, List<String> clickTracking, List<String> viewTracking, Long l, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r rVar) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        Intrinsics.checkNotNullParameter(viewTracking, "viewTracking");
        this.f7070a = resource;
        this.b = i2;
        this.c = i3;
        this.d = str;
        this.e = clickTracking;
        this.f = viewTracking;
        this.g = l;
        this.h = rVar;
    }

    public final String a() {
        return this.d;
    }

    public final List<String> b() {
        return this.e;
    }

    public final Long c() {
        return this.g;
    }

    public final int d() {
        return this.c;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r e() {
        return this.h;
    }

    public final y f() {
        return this.f7070a;
    }

    public final List<String> g() {
        return this.f;
    }

    public final int h() {
        return this.b;
    }
}
