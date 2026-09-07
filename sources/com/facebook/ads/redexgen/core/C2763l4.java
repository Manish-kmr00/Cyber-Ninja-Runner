package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2763l4 implements InterfaceC13575w {
    public final /* synthetic */ MG A00;

    public C2763l4(MG mg) {
        this.A00 = mg;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13575w
    public final void ACD(C6K c6k) {
        c6k.A0X(true);
        if (c6k.A06 != null && c6k.A07 == null) {
            c6k.A06 = null;
        }
        c6k.A07 = null;
        if (!c6k.A0A() && !this.A00.A1x(c6k.A0H) && c6k.A0c()) {
            this.A00.removeDetachedView(c6k.A0H, false);
        }
    }
}
