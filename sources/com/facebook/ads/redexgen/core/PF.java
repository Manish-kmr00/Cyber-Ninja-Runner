package com.facebook.ads.redexgen.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class PF {
    public static int A00(boolean a2, boolean b) {
        if (a2 == b) {
            return 0;
        }
        return a2 ? 1 : -1;
    }
}
