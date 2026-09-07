package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.28, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass28 {
    public static AnonymousClass23 A00;

    public final AnonymousClass23 A00(C2699k1 c2699k1, AdPlacementType adPlacementType) {
        if (A00 != null) {
            return A00;
        }
        switch (AnonymousClass27.A00[adPlacementType.ordinal()]) {
            case 1:
                return new N5();
            case 2:
                if (C14499m.A1L(c2699k1)) {
                    return new N4();
                }
                return new N5();
            case 3:
                return new C2881n3();
            case 4:
                return new C2873mv(c2699k1);
            case 5:
                return new N3(c2699k1);
            case 6:
                return new N0();
            default:
                return null;
        }
    }
}
