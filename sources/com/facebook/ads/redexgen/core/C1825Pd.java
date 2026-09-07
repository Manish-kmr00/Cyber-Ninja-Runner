package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1825Pd implements InterfaceC2305dW {
    public InterfaceC2361eR A02;
    public long A01 = 5242880;
    public int A00 = 20480;

    public final C1825Pd A00(InterfaceC2361eR interfaceC2361eR) {
        this.A02 = interfaceC2361eR;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2305dW
    public final PY A57() {
        return new PY((InterfaceC2361eR) AbstractC2388es.A01(this.A02), this.A01, this.A00);
    }
}
