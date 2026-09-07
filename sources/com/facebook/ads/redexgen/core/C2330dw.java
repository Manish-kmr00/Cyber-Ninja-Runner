package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2330dw extends BY {
    public final /* synthetic */ C1721Kq A00;

    public C2330dw(C1721Kq c1721Kq) {
        this.A00 = c1721Kq;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        if (this.A00.A00 != null) {
            this.A00.A00.A12();
        }
        this.A00.A08.setToolbarActionMode(this.A00.getCloseButtonStyle());
        this.A00.A08.A07();
        this.A00.A05.set(true);
    }
}
