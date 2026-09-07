package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2249cc extends AbstractC13515q<C2247ca> {
    public final int A00;
    public final C2699k1 A01;
    public final ViewOnClickListenerC2488gW A02;
    public final List<String> A03;

    public C2249cc(C2699k1 c2699k1, List<String> screenshotUrls, int i, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
        this.A03 = screenshotUrls;
        this.A00 = i;
        this.A01 = c2699k1;
        this.A02 = viewOnClickListenerC2488gW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final C2247ca A0D(ViewGroup viewGroup, int i) {
        C2248cb c2248cb = new C2248cb(this.A01);
        if (C14499m.A1B(this.A01)) {
            c2248cb.setOnClickListener(new I6(this));
        }
        return new C2247ca(c2248cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final void A0E(C2247ca c2247ca, int i) {
        String str = this.A03.get(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int startSpacing = this.A00 * 4;
        if (i != 0) {
            startSpacing = this.A00;
        }
        marginLayoutParams.setMargins(startSpacing, 0, i >= A0C() + (-1) ? this.A00 * 4 : this.A00, 0);
        c2247ca.A0j().setLayoutParams(marginLayoutParams);
        c2247ca.A0j().A00(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    public final int A0C() {
        return this.A03.size();
    }
}
