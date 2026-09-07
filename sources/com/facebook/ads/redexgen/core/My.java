package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class My extends AbstractC2856me {
    public final C2699k1 A00;

    public My(C0X c0x, List<C2615ie> list, C2699k1 c2699k1) {
        super(c0x, list, c2699k1);
        this.A00 = c2699k1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2569hr A0D(ViewGroup viewGroup, int i) {
        return new C2569hr(new C1526Dd(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public final void A0E(C2569hr c2569hr, int i) {
        super.A0E(c2569hr, i);
        C1526Dd c1526Dd = (C1526Dd) c2569hr.A0j();
        E0 imageView = (E0) c1526Dd.getImageCardView();
        imageView.setImageDrawable(null);
        A0G(imageView, i);
        C2615ie childAd = ((AbstractC2856me) this).A01.get(i);
        childAd.A12().A0L(this.A00);
        childAd.A1O(c1526Dd, c1526Dd);
    }
}
