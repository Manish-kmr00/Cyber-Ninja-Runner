package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f8493a;
    private final List<xx1> b;
    private final List<String> c;
    private final String d;
    private final t4 e;

    public bc1(List assets, ArrayList showNotices, ArrayList renderTrackingUrls, String str, t4 t4Var) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        Intrinsics.checkNotNullParameter(renderTrackingUrls, "renderTrackingUrls");
        this.f8493a = assets;
        this.b = showNotices;
        this.c = renderTrackingUrls;
        this.d = str;
        this.e = t4Var;
    }

    public final List<ig<?>> b() {
        return this.f8493a;
    }

    public final List<xx1> e() {
        return this.b;
    }

    public final List<String> d() {
        return this.c;
    }

    public final String a() {
        return this.d;
    }

    public final t4 c() {
        return this.e;
    }
}
