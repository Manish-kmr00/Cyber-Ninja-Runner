package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rb2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ru f10093a;
    private final eb2 b;
    private final aw0 c;
    private final T d;
    private final b12 e;
    private final String f;
    private final w9 g;

    /* JADX WARN: Multi-variable type inference failed */
    public rb2(ru creative, eb2 vastVideoAd, aw0 mediaFile, Object obj, b12 b12Var, String preloadRequestId, w9 w9Var) {
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(vastVideoAd, "vastVideoAd");
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        Intrinsics.checkNotNullParameter(preloadRequestId, "preloadRequestId");
        this.f10093a = creative;
        this.b = vastVideoAd;
        this.c = mediaFile;
        this.d = obj;
        this.e = b12Var;
        this.f = preloadRequestId;
        this.g = w9Var;
    }

    public final ru b() {
        return this.f10093a;
    }

    public final eb2 g() {
        return this.b;
    }

    public final aw0 c() {
        return this.c;
    }

    public final T d() {
        return this.d;
    }

    public final b12 f() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public final w9 a() {
        return this.g;
    }
}
