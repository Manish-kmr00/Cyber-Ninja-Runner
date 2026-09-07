package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.z4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4605z4 {
    public static InterfaceC4555x4 a(C4157h4 c4157h4) {
        switch (AbstractC4580y4.f11852a[c4157h4.e.ordinal()]) {
            case 1:
                return new C4115fc();
            case 2:
                return new Yi();
            case 3:
                return new C4022bj();
            case 4:
                return new C4493uh(new C4543wh());
            case 5:
                return new C4493uh(new Hj());
            case 6:
                return new C4413rc();
            case 7:
                return new C4413rc();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
