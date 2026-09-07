package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private yi1 f10084a;
    private final LinkedHashMap b = new LinkedHashMap();

    public r9(yi1 yi1Var) {
        this.f10084a = yi1Var;
    }

    public final yi1 c() {
        return this.f10084a;
    }

    public final boolean b() {
        Collection collectionValues = this.b.values();
        return collectionValues.contains(tm0.d) || collectionValues.contains(tm0.e);
    }

    public final void a() {
        this.b.clear();
    }

    public final tm0 a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        tm0 tm0Var = (tm0) this.b.get(videoAd);
        return tm0Var == null ? tm0.b : tm0Var;
    }

    public final void a(do0 videoAd, tm0 instreamAdStatus) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(instreamAdStatus, "instreamAdStatus");
        this.b.put(videoAd, instreamAdStatus);
    }

    public final void a(yi1 yi1Var) {
        this.f10084a = yi1Var;
    }
}
