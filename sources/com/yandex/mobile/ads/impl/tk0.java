package com.yandex.mobile.ads.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final sk0 f10309a = new sk0(hp1.b.S, hp1.b.R, hp1.b.T, hp1.b.U);
    private static final sk0 b = new sk0(hp1.b.y, hp1.b.x, hp1.b.z, hp1.b.A);

    public static sk0 a(s9 adStructureType) {
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        int iOrdinal = adStructureType.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return f10309a;
        }
        if (iOrdinal == 2) {
            return b;
        }
        throw new NoWhenBranchMatchedException();
    }
}
