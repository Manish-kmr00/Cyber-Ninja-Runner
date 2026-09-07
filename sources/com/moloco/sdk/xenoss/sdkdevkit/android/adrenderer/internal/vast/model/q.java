package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q {
    public static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6903a;
    public final String b;
    public final boolean c;
    public final String d;
    public final Integer e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final Boolean k;
    public final String l;

    public q(String mediaFileUrl, String str, boolean z, String type, Integer num, Integer num2, String str2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3) {
        Intrinsics.checkNotNullParameter(mediaFileUrl, "mediaFileUrl");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f6903a = mediaFileUrl;
        this.b = str;
        this.c = z;
        this.d = type;
        this.e = num;
        this.f = num2;
        this.g = str2;
        this.h = num3;
        this.i = num4;
        this.j = num5;
        this.k = bool;
        this.l = str3;
    }

    public final String a() {
        return this.l;
    }

    public final Integer b() {
        return this.h;
    }

    public final String c() {
        return this.g;
    }

    public final Integer d() {
        return this.f;
    }

    public final String e() {
        return this.b;
    }

    public final Integer f() {
        return this.j;
    }

    public final String g() {
        return this.f6903a;
    }

    public final Integer h() {
        return this.i;
    }

    public final String i() {
        return this.d;
    }

    public final Integer j() {
        return this.e;
    }

    public final boolean k() {
        return this.c;
    }

    public final Boolean l() {
        return this.k;
    }
}
