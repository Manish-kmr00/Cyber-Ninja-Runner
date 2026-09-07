package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ld, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1734Ld extends C2291dI {
    public static String[] A00 = {"f1NrkMLFHAOxAk1WYXb4ZQBI9BQGMxNf", "ieQbYkP9qXWhodiL", "FasCpRA2RHhykdlBGUblwYUAQMGKU0mS", "sjzKgK2sh59qhJK5Sm5NCXrbKyy", "73hXtYSYooo4yypUFlMlXcqu25ITYI9G", "jFG3gQjXUuH0GALbmhZbm14pHMTfeDNL", "AB4YZhA3BNaHUCHwFjy4bae76Yz8EFa9", "dMMrkYyDXzmdfTW8HhUzXkOm8W"};

    public C1734Ld(C12411h c12411h, int i, List<C1629Hc> list, JL jl, Bundle bundle) {
        super(c12411h, i, list, jl, bundle);
        c12411h.A1h(this);
        this.A03 = new C2522h4(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        int iA23 = this.A0C.A23();
        if (this.A05 == null || iA23 == -1) {
            return;
        }
        int curPos = this.A05.size();
        if (iA23 < curPos - 1) {
            int i = iA23 + 1;
            if (A00[2].charAt(8) != 'R') {
                throw new RuntimeException();
            }
            A00[2] = "QoZYEwWSRtnMYn7R6MgH1oBp1kGEXSrp";
            A0U(i);
        }
    }

    private void A01(int i) {
        int visibleItem = this.A0C.A24();
        int lastVisibleItem = this.A0C.A25();
        int firstVisibleItem = this.A0C.A23();
        if (firstVisibleItem != visibleItem) {
            A0S(visibleItem);
        }
        if (firstVisibleItem != lastVisibleItem) {
            A0S(lastVisibleItem);
        }
        A0T(firstVisibleItem);
        A0V(visibleItem, lastVisibleItem, i);
    }

    @Override // com.facebook.ads.redexgen.core.C2291dI, com.facebook.ads.redexgen.core.AnonymousClass67
    public final void A0L(MG mg, int i) {
    }

    @Override // com.facebook.ads.redexgen.core.C2291dI, com.facebook.ads.redexgen.core.AnonymousClass67
    public final void A0M(MG mg, int i, int i2) {
        if (this.A0C.A23() != -1) {
            AbstractC2445fo curCard = (AbstractC2445fo) this.A0C.A1m(this.A0C.A23());
            if (curCard != null && curCard.A1F() && !curCard.A1E()) {
                curCard.A1C();
            }
            A01(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.C2291dI
    public final void A0X(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.8f);
    }

    @Override // com.facebook.ads.redexgen.core.C2291dI
    public final void A0Z(AbstractC2445fo abstractC2445fo, boolean z) {
        A0X(abstractC2445fo, z);
        if (!z && abstractC2445fo.A1E()) {
            abstractC2445fo.A1B();
        }
    }

    @Override // com.facebook.ads.redexgen.core.C2291dI
    public final boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.75f;
    }

    public final JL A0b() {
        return this.A04;
    }

    public final void A0c(JL jl) {
        this.A04 = jl;
    }

    public final void A0d(List<C1629Hc> list) {
        this.A05 = list;
    }
}
