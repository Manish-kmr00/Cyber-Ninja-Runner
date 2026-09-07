package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PX implements InterfaceC2308dZ {
    public int A00;
    public int A01;
    public InterfaceC2305dW A02;
    public InterfaceC2308dZ A04;
    public InterfaceC2361eR A05;
    public boolean A07;
    public InterfaceC2308dZ A03 = new C1837Pp();
    public InterfaceC2370ea A06 = InterfaceC2370ea.A00;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2308dZ
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C13164e A58() {
        return A01(this.A04 != null ? this.A04.A58() : null, this.A00, this.A01);
    }

    private C13164e A01(Q7 q7, int i, int i2) {
        PY pyA57;
        InterfaceC2361eR interfaceC2361eR = (InterfaceC2361eR) AbstractC2388es.A01(this.A05);
        if (this.A07 || q7 == null) {
            pyA57 = null;
        } else if (this.A02 != null) {
            pyA57 = this.A02.A57();
        } else {
            pyA57 = new C1825Pd().A00(interfaceC2361eR).A57();
        }
        return new C13164e(interfaceC2361eR, q7, this.A03.A58(), pyA57, this.A06, i, null, i2, null);
    }

    public final QV A02() {
        return null;
    }

    public final PX A03(int i) {
        this.A00 = i;
        return this;
    }

    public final PX A04(InterfaceC2308dZ interfaceC2308dZ) {
        this.A03 = interfaceC2308dZ;
        return this;
    }

    public final PX A05(InterfaceC2308dZ interfaceC2308dZ) {
        this.A04 = interfaceC2308dZ;
        return this;
    }

    public final PX A06(InterfaceC2361eR interfaceC2361eR) {
        this.A05 = interfaceC2361eR;
        return this;
    }

    public final C13164e A07() {
        return A01(this.A04 != null ? this.A04.A58() : null, this.A00 | 1, -1000);
    }
}
