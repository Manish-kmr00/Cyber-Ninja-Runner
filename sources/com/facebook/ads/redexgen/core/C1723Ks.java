package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ks, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1723Ks extends AbstractC2212c1 {
    public final /* synthetic */ C1722Kr A00;

    public C1723Ks(C1722Kr c1722Kr) {
        this.A00 = c1722Kr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2213c2 c2213c2) {
        new Handler(Looper.getMainLooper()).post(new HD(this));
    }
}
