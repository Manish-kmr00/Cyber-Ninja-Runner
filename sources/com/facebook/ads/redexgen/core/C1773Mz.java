package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1773Mz extends AbstractC2856me {
    public final C2699k1 A00;
    public final AW A01;

    public C1773Mz(C2699k1 c2699k1, C0X c0x, List<C2615ie> list, AW aw) {
        super(c0x, list, c2699k1);
        this.A00 = c2699k1;
        this.A01 = aw == null ? new AW() : aw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2569hr A0D(ViewGroup viewGroup, int i) {
        return new C2569hr(new DX(this.A00, this.A01));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A0I */
    public final void A0E(C2569hr c2569hr, int i) {
        super.A0E(c2569hr, i);
        DX dx = (DX) c2569hr.A0j();
        A0G(dx.getImageCardView(), i);
        if (((AbstractC2856me) this).A01.get(i) != null) {
            dx.setTitle(((AbstractC2856me) this).A01.get(i).getAdHeadline());
            dx.setSubtitle(((AbstractC2856me) this).A01.get(i).getAdLinkDescription());
            dx.setButtonText(((AbstractC2856me) this).A01.get(i).getAdCallToAction());
        }
        C2615ie c2615ie = ((AbstractC2856me) this).A01.get(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dx);
        c2615ie.A1P(dx, dx, arrayList);
    }
}
