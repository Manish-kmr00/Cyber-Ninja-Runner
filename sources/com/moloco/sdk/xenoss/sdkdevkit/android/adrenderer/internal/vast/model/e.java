package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static final int j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6891a;
    public final Integer b;
    public final Integer c;
    public final String d;
    public final String e;
    public final f f;
    public final c g;
    public final List<u> h;
    public final List<y> i;

    /* JADX WARN: Multi-variable type inference failed */
    public e(String str, Integer num, Integer num2, String str2, String str3, f fVar, c cVar, List<u> creativeViewTrackingList, List<? extends y> resources) {
        Intrinsics.checkNotNullParameter(creativeViewTrackingList, "creativeViewTrackingList");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.f6891a = str;
        this.b = num;
        this.c = num2;
        this.d = str2;
        this.e = str3;
        this.f = fVar;
        this.g = cVar;
        this.h = creativeViewTrackingList;
        this.i = resources;
    }

    public final c a() {
        return this.g;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final f d() {
        return this.f;
    }

    public final List<u> e() {
        return this.h;
    }

    public final Integer f() {
        return this.c;
    }

    public final String g() {
        return this.f6891a;
    }

    public final List<y> h() {
        return this.i;
    }

    public final Integer i() {
        return this.b;
    }
}
