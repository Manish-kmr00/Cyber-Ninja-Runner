package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1715Kk extends AbstractC2212c1 {
    public final /* synthetic */ C1714Kj A00;

    public C1715Kk(C1714Kj c1714Kj) {
        this.A00 = c1714Kj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2213c2 c2213c2) {
        new Handler(Looper.getMainLooper()).post(new HR(this));
    }
}
