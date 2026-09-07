package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2833mG extends BY {
    public final /* synthetic */ C2881n3 A00;
    public final /* synthetic */ AnonymousClass38 A01;
    public final /* synthetic */ C1766Mr A02;

    public C2833mG(C1766Mr c1766Mr, AnonymousClass38 anonymousClass38, C2881n3 c2881n3) {
        this.A02 = c1766Mr;
        this.A01 = anonymousClass38;
        this.A00 = c2881n3;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        C1468Ag c1468AgA00 = C1468Ag.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0F().A5W(c1468AgA00.A03().getErrorCode(), c1468AgA00.A04());
        this.A02.A07.A0G(c1468AgA00);
    }
}
