package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class q9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private xi1 f9997a;
    private final LinkedHashMap b = new LinkedHashMap();

    public q9(xi1 xi1Var) {
        this.f9997a = xi1Var;
    }

    public final xi1 c() {
        return this.f9997a;
    }

    public final boolean b() {
        Collection collectionValues = this.b.values();
        return collectionValues.contains(sm0.d) || collectionValues.contains(sm0.e);
    }

    public final void a() {
        this.b.clear();
    }

    public final sm0 a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        sm0 sm0Var = (sm0) this.b.get(videoAd);
        return sm0Var == null ? sm0.b : sm0Var;
    }

    public final void a(do0 videoAd, sm0 instreamAdStatus) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(instreamAdStatus, "instreamAdStatus");
        this.b.put(videoAd, instreamAdStatus);
    }

    public final void a(xi1 xi1Var) {
        this.f9997a = xi1Var;
    }
}
