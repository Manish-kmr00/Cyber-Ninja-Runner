package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2767l8 implements C6R {
    public final /* synthetic */ MG A00;

    public C2767l8(MG mg) {
        this.A00 = mg;
    }

    @Override // com.facebook.ads.redexgen.core.C6R
    public final void AGH(C6K c6k, C13585x c13585x, C13585x c13585x2) {
        this.A00.A1l(c6k, c13585x, c13585x2);
    }

    @Override // com.facebook.ads.redexgen.core.C6R
    public final void AGJ(C6K c6k, C13585x c13585x, C13585x c13585x2) {
        this.A00.A0r.A0Y(c6k);
        this.A00.A1m(c6k, c13585x, c13585x2);
    }

    @Override // com.facebook.ads.redexgen.core.C6R
    public final void AGL(C6K c6k, C13585x c13585x, C13585x c13585x2) {
        c6k.A0X(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0H(c6k, c6k, c13585x, c13585x2)) {
                this.A00.A1O();
            }
        } else {
            if (!this.A00.A05.A0G(c6k, c13585x, c13585x2)) {
                return;
            }
            this.A00.A1O();
        }
    }

    @Override // com.facebook.ads.redexgen.core.C6R
    public final void AJe(C6K c6k) {
        this.A00.A06.A1D(c6k.A0H, this.A00.A0r);
    }
}
