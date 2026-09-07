package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class un0 implements jc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final et f10409a;
    private final String b;
    private final int c;
    private final int d;
    private final String e;
    private final Integer f;
    private final String g;

    public un0(et adBreakPosition, String url, int i, int i2, String str, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f10409a = adBreakPosition;
        this.b = url;
        this.c = i;
        this.d = i2;
        this.e = str;
        this.f = num;
        this.g = str2;
    }

    public final et a() {
        return this.f10409a;
    }

    @Override // com.yandex.mobile.ads.impl.jc2
    public final String getUrl() {
        return this.b;
    }

    public final int getAdWidth() {
        return this.c;
    }

    public final int getAdHeight() {
        return this.d;
    }

    public final String getMediaType() {
        return this.e;
    }

    public final Integer getBitrate() {
        return this.f;
    }

    public final String getApiFramework() {
        return this.g;
    }
}
