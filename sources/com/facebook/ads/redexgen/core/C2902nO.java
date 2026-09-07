package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2902nO implements InterfaceC12431j {
    public final InterfaceC12401g A00;

    public C2902nO(InterfaceC12401g interfaceC12401g) {
        this.A00 = interfaceC12401g;
    }

    public final InterfaceC12401g A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12431j
    public final NI ABh() {
        return new NI(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12431j
    public final C2904nQ ABi() {
        return new C2904nQ(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12431j
    public final C2904nQ ABj(String str) {
        return new C2904nQ(this, str);
    }
}
