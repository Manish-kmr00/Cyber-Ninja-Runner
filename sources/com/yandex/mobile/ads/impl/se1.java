package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class se1 {
    public static y92 a(gd2 gd2Var, sc2 videoAdPosition) {
        kj1 kj1Var;
        Intrinsics.checkNotNullParameter(videoAdPosition, "videoAdPosition");
        Intrinsics.checkNotNullParameter(videoAdPosition, "videoAdPosition");
        int iOrdinal = videoAdPosition.ordinal();
        if (iOrdinal == 0) {
            kj1Var = kj1.c;
        } else if (iOrdinal == 1) {
            kj1Var = kj1.d;
        } else if (iOrdinal != 2) {
            kj1Var = iOrdinal != 3 ? kj1.f : kj1.f;
        } else {
            kj1Var = kj1.e;
        }
        if (gd2Var != null) {
            y92 y92VarA = y92.a(gd2Var.a() / 1000, kj1Var);
            Intrinsics.checkNotNull(y92VarA);
            return y92VarA;
        }
        y92 y92VarA2 = y92.a(kj1Var);
        Intrinsics.checkNotNull(y92VarA2);
        return y92VarA2;
    }
}
