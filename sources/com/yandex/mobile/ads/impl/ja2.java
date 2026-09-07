package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ja2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eb2 f9298a;
    private final ru b;
    private final aw0 c;
    private final b12 d;
    private final String e;
    private final JSONObject f;
    private final w9 g;

    public ja2(eb2 videoAd, ru creative, aw0 mediaFile, b12 b12Var, String str, JSONObject jSONObject, w9 w9Var) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        this.f9298a = videoAd;
        this.b = creative;
        this.c = mediaFile;
        this.d = b12Var;
        this.e = str;
        this.f = jSONObject;
        this.g = w9Var;
    }

    public final eb2 e() {
        return this.f9298a;
    }

    public final ru b() {
        return this.b;
    }

    public final aw0 c() {
        return this.c;
    }

    public final b12 d() {
        return this.d;
    }

    public final String f() {
        return this.e;
    }

    public final JSONObject g() {
        return this.f;
    }

    public final w9 a() {
        return this.g;
    }
}
