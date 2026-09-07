package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static final int g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f6944a;
    public final int b;
    public final int c;
    public final String d;
    public final List<String> e;
    public final List<String> f;

    public c(y resource, int i, int i2, String str, List<String> clickTracking, List<String> creativeViewTracking) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        Intrinsics.checkNotNullParameter(creativeViewTracking, "creativeViewTracking");
        this.f6944a = resource;
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = clickTracking;
        this.f = creativeViewTracking;
    }

    public final String a() {
        return this.d;
    }

    public final List<String> b() {
        return this.e;
    }

    public final List<String> c() {
        return this.f;
    }

    public final int d() {
        return this.c;
    }

    public final y e() {
        return this.f6944a;
    }

    public final int f() {
        return this.b;
    }
}
