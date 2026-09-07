package com.facebook.ads.redexgen.core;

import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2009Wr implements TO {
    @Override // com.facebook.ads.redexgen.core.TO
    public final /* synthetic */ TN AGB(TJ tj, ZM zm) {
        return TL.A00(this, tj, zm);
    }

    @Override // com.facebook.ads.redexgen.core.TO
    public final /* synthetic */ void AGC() {
    }

    @Override // com.facebook.ads.redexgen.core.TO
    public final TA A32(TJ tj, ZM zm) {
        if (zm.A0O == null) {
            return null;
        }
        return new C2007Wp(new T8(new C1940Tt(1), 6001));
    }

    @Override // com.facebook.ads.redexgen.core.TO
    public final int A7M(ZM zm) {
        return zm.A0O != null ? 1 : 0;
    }

    @Override // com.facebook.ads.redexgen.core.TO
    public final void AIk(Looper looper, RK rk) {
    }
}
