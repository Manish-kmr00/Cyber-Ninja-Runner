package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h {
    public static final int p = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f7073a;
    public final List<String> b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final List<String> f;
    public final List<String> g;
    public final List<String> h;
    public final List<String> i;
    public final List<String> j;
    public final List<String> k;
    public final List<String> l;
    public final List<String> m;
    public final List<String> n;
    public final List<g> o;

    public h(List<String> click, List<String> creativeView, List<String> start, List<String> firstQuartile, List<String> midpoint, List<String> thirdQuartile, List<String> complete, List<String> mute, List<String> unMute, List<String> pause, List<String> resume, List<String> rewind, List<String> skip, List<String> closeLinear, List<g> progress) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(creativeView, "creativeView");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(firstQuartile, "firstQuartile");
        Intrinsics.checkNotNullParameter(midpoint, "midpoint");
        Intrinsics.checkNotNullParameter(thirdQuartile, "thirdQuartile");
        Intrinsics.checkNotNullParameter(complete, "complete");
        Intrinsics.checkNotNullParameter(mute, "mute");
        Intrinsics.checkNotNullParameter(unMute, "unMute");
        Intrinsics.checkNotNullParameter(pause, "pause");
        Intrinsics.checkNotNullParameter(resume, "resume");
        Intrinsics.checkNotNullParameter(rewind, "rewind");
        Intrinsics.checkNotNullParameter(skip, "skip");
        Intrinsics.checkNotNullParameter(closeLinear, "closeLinear");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.f7073a = click;
        this.b = creativeView;
        this.c = start;
        this.d = firstQuartile;
        this.e = midpoint;
        this.f = thirdQuartile;
        this.g = complete;
        this.h = mute;
        this.i = unMute;
        this.j = pause;
        this.k = resume;
        this.l = rewind;
        this.m = skip;
        this.n = closeLinear;
        this.o = progress;
    }

    public final List<String> a() {
        return this.f7073a;
    }

    public final List<String> b() {
        return this.n;
    }

    public final List<String> c() {
        return this.g;
    }

    public final List<String> d() {
        return this.b;
    }

    public final List<String> e() {
        return this.d;
    }

    public final List<String> f() {
        return this.e;
    }

    public final List<String> g() {
        return this.h;
    }

    public final List<String> h() {
        return this.j;
    }

    public final List<g> i() {
        return this.o;
    }

    public final List<String> j() {
        return this.k;
    }

    public final List<String> k() {
        return this.l;
    }

    public final List<String> l() {
        return this.m;
    }

    public final List<String> m() {
        return this.c;
    }

    public final List<String> n() {
        return this.f;
    }

    public final List<String> o() {
        return this.i;
    }
}
