package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.av, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2147av implements InterfaceC1669Iq {
    public ViewPropertyAnimator A00;
    public EnumC1668Ip A01 = EnumC1668Ip.A04;
    public final int A02;
    public final View A03;
    public final boolean A04;

    public C2147av(View view, int i, boolean z) {
        this.A02 = i;
        this.A03 = view;
        this.A04 = z;
    }

    private void A04(boolean z) {
        this.A01 = EnumC1668Ip.A03;
        if (this.A04) {
            D3.A0J(this.A03);
        }
        if (!z) {
            this.A03.setAlpha(1.0f);
            this.A01 = EnumC1668Ip.A02;
        } else {
            this.A00 = this.A03.animate().alpha(1.0f).setDuration(this.A02).setListener(new C1673Iu(this));
        }
    }

    private void A05(boolean z) {
        this.A01 = EnumC1668Ip.A05;
        if (!z) {
            this.A03.setAlpha(0.0f);
            this.A01 = EnumC1668Ip.A04;
        } else {
            this.A00 = this.A03.animate().alpha(0.0f).setDuration(this.A02).setListener(new C1674Iv(this));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final void A40(boolean z, boolean z2) {
        if (z2) {
            A05(z);
        } else {
            A04(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final EnumC1668Ip A91() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final void cancel() {
        this.A03.clearAnimation();
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
