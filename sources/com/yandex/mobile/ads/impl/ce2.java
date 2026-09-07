package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ce2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final he2 f8594a;
    private final qj1 b;

    public ce2(qj1 positionProviderHolder, he2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        this.f8594a = videoDurationHolder;
        this.b = positionProviderHolder;
    }

    public final boolean a() {
        long jA = this.f8594a.a();
        if (jA != -9223372036854775807L) {
            li1 li1VarB = this.b.b();
            if ((li1VarB != null ? li1VarB.a() : -1L) + 1000 >= jA) {
                return true;
            }
        }
        return false;
    }
}
