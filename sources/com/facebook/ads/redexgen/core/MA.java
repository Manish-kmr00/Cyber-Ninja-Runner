package com.facebook.ads.redexgen.core;

import com.facebook.ads.VideoStartReason;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MA extends AbstractC2214c3 {
    public final /* synthetic */ C13826v A00;

    public MA(C13826v c13826v) {
        this.A00 = c13826v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C1705Ka c1705Ka) {
        this.A00.A00.onCompleted();
        if (C14499m.A1c(this.A00.A00.getContext())) {
            this.A00.A00.play(VideoStartReason.AUTO_STARTED);
        }
    }
}
