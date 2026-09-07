package com.facebook.ads.redexgen.core;

import android.net.Uri;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class R3 implements InterfaceC2341e7, InterfaceC2142aq {
    public long A00;
    public InterfaceC1957Uo A01;
    public C2318dj A02;
    public boolean A04;
    public final Uri A06;
    public final UL A07;
    public final InterfaceC2164bF A09;
    public final AnonymousClass51 A0A;
    public final C2398f2 A0B;
    public volatile boolean A0C;
    public final /* synthetic */ C13947h A0D;
    public final C1952Ug A08 = new C1952Ug();
    public boolean A03 = true;
    public final long A05 = C2143ar.A00();

    public R3(C13947h c13947h, Uri uri, Q7 q7, InterfaceC2164bF interfaceC2164bF, UL ul, C2398f2 c2398f2) {
        this.A0D = c13947h;
        this.A06 = uri;
        this.A0A = new AnonymousClass51(q7);
        this.A09 = interfaceC2164bF;
        this.A07 = ul;
        this.A0B = c2398f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(long j, long j2) {
        this.A08.A00 = j;
        this.A00 = j2;
        this.A03 = true;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2341e7
    public final void A4h() {
        this.A0C = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00fa */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2341e7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AAg() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.R3.AAg():void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2142aq
    public final void ADK(C2447fq c2447fq) {
        long jMax;
        if (this.A04) {
            jMax = Math.max(this.A0D.A03(true), this.A00);
        } else {
            jMax = this.A00;
        }
        int iA07 = c2447fq.A07();
        InterfaceC1957Uo interfaceC1957Uo = (InterfaceC1957Uo) AbstractC2388es.A01(this.A01);
        interfaceC1957Uo.AHx(c2447fq, iA07);
        interfaceC1957Uo.AI0(jMax, 1, iA07, 0, null);
        this.A04 = true;
    }
}
