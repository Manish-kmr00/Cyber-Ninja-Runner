package com.facebook.ads.redexgen.core;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M0 implements InterfaceC2614id {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public M0(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.core.AM
    public final void AC6() {
        BP.A00(new C2610iZ(this));
    }

    @Override // com.facebook.ads.redexgen.core.AM
    public final void ACA() {
        BP.A00(new C2611ia(this));
    }

    @Override // com.facebook.ads.redexgen.core.AM
    public final void AD4(C1468Ag c1468Ag) {
        BP.A00(new C2613ic(this, c1468Ag));
    }

    @Override // com.facebook.ads.redexgen.core.AM
    public final void AE0() {
        BP.A00(new C2609iY(this));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2614id
    public final void AE5() {
        BP.A00(new C2612ib(this));
    }
}
