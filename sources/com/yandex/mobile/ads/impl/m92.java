package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9614a;
    private final List<eb2> b;

    public m92(String version, List<eb2> videoAds) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        this.f9614a = version;
        this.b = videoAds;
    }

    public final String a() {
        return this.f9614a;
    }

    public final List<eb2> b() {
        return this.b;
    }
}
