package com.facebook.ads.redexgen.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1766Mr extends AbstractC2835mI {
    public C1766Mr(C2699k1 c2699k1, AnonymousClass37 anonymousClass37) {
        super(c2699k1, anonymousClass37);
    }

    private C2832mF A00(Runnable runnable) {
        return new C2832mF(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final C2S A0I() {
        C2881n3 successfullyLoadedAdapter = (C2881n3) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0P() {
        C2881n3 interstitialAdapter = (C2881n3) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0R(AnonymousClass23 anonymousClass23, C14318t c14318t, C14298r c14298r, AnonymousClass38 anonymousClass38) {
        C2881n3 c2881n3 = (C2881n3) anonymousClass23;
        C2833mG c2833mG = new C2833mG(this, anonymousClass38, c2881n3);
        A0H().postDelayed(c2833mG, c14318t.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c2881n3.A0A(this.A0B, A00(c2833mG), anonymousClass38, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
