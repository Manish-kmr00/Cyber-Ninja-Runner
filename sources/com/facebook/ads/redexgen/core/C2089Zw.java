package com.facebook.ads.redexgen.core;

import android.os.SystemClock;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2089Zw implements L3 {
    public static final C2089Zw A00 = new C2089Zw();

    public static C2089Zw A00() {
        return A00;
    }

    @Override // com.facebook.ads.redexgen.core.L3
    public final long AC0() {
        return SystemClock.elapsedRealtime();
    }
}
