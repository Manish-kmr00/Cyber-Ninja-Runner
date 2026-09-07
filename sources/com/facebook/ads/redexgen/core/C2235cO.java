package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2235cO extends BY {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C2232cL A02;
    public final /* synthetic */ JI A03;

    public C2235cO(C2232cL c2232cL, JI ji, int i, int i2) {
        this.A02 = c2232cL;
        this.A03 = ji;
        this.A00 = i;
        this.A01 = i2;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        if (this.A03 == JI.A07) {
            this.A02.A0M(AE.A0y);
            this.A02.A0B.A0F().A3Z();
            this.A02.A0C.A02(C2232cL.A0J);
            return;
        }
        if (this.A03 == JI.A03) {
            this.A02.A0M(AE.A0t);
            this.A02.A04 = true;
            this.A02.A0C.A02(C2232cL.A0H);
            this.A02.A0L(this.A00);
            return;
        }
        if (this.A03 == JI.A06) {
            this.A02.A0M(AE.A0s);
            this.A02.A0B.A0F().A3R();
            this.A02.A04 = true;
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0C.A02(new C1705Ka(this.A01, this.A01));
            this.A02.A0L(this.A01);
            return;
        }
        if (this.A03 == JI.A0A) {
            if (C14499m.A1s(this.A02.A0B)) {
                this.A02.A0B.A0B().AFk();
            }
            this.A02.A0M(AE.A0w);
            this.A02.A0B.A0F().A3g();
            this.A02.A0C.A02(C2232cL.A0I);
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0I();
            return;
        }
        if (this.A03 == JI.A05) {
            this.A02.A0M(AE.A0v);
            this.A02.A0B.A0F().A3V();
            this.A02.A0C.A02(new KY(this.A00));
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0L(this.A00);
            return;
        }
        if (this.A03 == JI.A04) {
            this.A02.A0M(AE.A0u);
            this.A02.A0B.A0F().A3S();
            this.A02.A0C.A02(C2232cL.A0L);
            this.A02.A08.removeCallbacksAndMessages(null);
            return;
        }
        if (this.A03 == JI.A09) {
            this.A02.A0M(AE.A0s);
            this.A02.A0B.A0F().A3b();
            this.A02.A04 = true;
            this.A02.A08.removeCallbacksAndMessages(null);
            this.A02.A0C.A02(new C1705Ka(this.A00, this.A01));
            this.A02.A0L(this.A00);
        }
    }
}
