package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class be2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ge2 f8501a;
    private final pj1 b;

    public be2(pj1 positionProviderHolder, ge2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        this.f8501a = videoDurationHolder;
        this.b = positionProviderHolder;
    }

    public final boolean a() {
        long jA = this.f8501a.a();
        if (jA != -9223372036854775807L) {
            ki1 ki1VarB = this.b.b();
            if ((ki1VarB != null ? ki1VarB.a() : -1L) + 1000 >= jA) {
                return true;
            }
        }
        return false;
    }
}
