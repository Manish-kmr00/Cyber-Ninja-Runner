package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2575hx implements InterfaceC13716k {
    public final /* synthetic */ C2572hu A00;

    public C2575hx(C2572hu c2572hu) {
        this.A00 = c2572hu;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13716k
    public final boolean AA8() {
        if (this.A00.A0E.canGoBack()) {
            this.A00.A0E.goBack();
            return true;
        }
        return false;
    }
}
