package com.facebook.ads.redexgen.core;

import android.os.Handler;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ox, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1819Ox implements InterfaceC2067Yy {
    public final /* synthetic */ C0T A00;

    public C1819Ox(C0T c0t, InterfaceC2068Yz interfaceC2068Yz) {
        this.A00 = c0t;
        interfaceC2068Yz.AIg(this, new Handler());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2067Yy
    public final void ADE(InterfaceC2068Yz interfaceC2068Yz, long j, long j2) {
        if (this != this.A00.A00) {
            return;
        }
        this.A00.A27();
    }
}
