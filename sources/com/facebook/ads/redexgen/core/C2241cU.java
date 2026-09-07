package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2241cU implements InterfaceC1689Jk {
    public final /* synthetic */ I7 A00;

    public C2241cU(I7 i7) {
        this.A00 = i7;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1689Jk
    public final void AGI() {
        if (this.A00.A02 != null) {
            this.A00.A02.A4Z(this.A00.A03.A8u());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1689Jk
    public final void AGK(C1691Jm c1691Jm) {
        if (this.A00.A02 == null) {
            return;
        }
        if (c1691Jm != null && c1691Jm.A00()) {
            this.A00.A02.A4Z(this.A00.A03.A8v());
        } else {
            this.A00.A02.A4Z(this.A00.A03.A8u());
        }
    }
}
