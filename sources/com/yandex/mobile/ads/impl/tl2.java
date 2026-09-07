package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreak;
import com.yandex.mobile.ads.instream.InstreamAdBreakPosition;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tl2 implements InstreamAdBreak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dt f10315a;
    private final vl2 b;

    public /* synthetic */ tl2(dt dtVar) {
        this(dtVar, new vl2());
    }

    public tl2(dt adBreak, vl2 adBreakPositionAdapter) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(adBreakPositionAdapter, "adBreakPositionAdapter");
        this.f10315a = adBreak;
        this.b = adBreakPositionAdapter;
    }

    @Override // com.yandex.mobile.ads.instream.InstreamAdBreak
    public final String getType() {
        return this.f10315a.e();
    }

    @Override // com.yandex.mobile.ads.instream.InstreamAdBreak
    public final InstreamAdBreakPosition getAdBreakPosition() {
        InstreamAdBreakPosition.Type type;
        vl2 vl2Var = this.b;
        et corePosition = this.f10315a.b();
        vl2Var.getClass();
        Intrinsics.checkNotNullParameter(corePosition, "corePosition");
        int iOrdinal = corePosition.a().ordinal();
        if (iOrdinal == 0) {
            type = InstreamAdBreakPosition.Type.PERCENTS;
        } else if (iOrdinal == 1) {
            type = InstreamAdBreakPosition.Type.MILLISECONDS;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            type = InstreamAdBreakPosition.Type.POSITION;
        }
        return new InstreamAdBreakPosition(type, corePosition.b());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof tl2) && Intrinsics.areEqual(((tl2) obj).f10315a, this.f10315a);
    }

    public final int hashCode() {
        return this.f10315a.hashCode();
    }
}
