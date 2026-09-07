package com.facebook.ads.redexgen.core;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1762Mi extends AbstractC2829mC {
    public final /* synthetic */ C2873mv A00;
    public final /* synthetic */ C2828mB A01;
    public final /* synthetic */ List A02;

    public C1762Mi(C2828mB c2828mB, List list, C2873mv c2873mv) {
        this.A01 = c2828mB;
        this.A02 = list;
        this.A00 = c2873mv;
    }

    @Override // com.facebook.ads.redexgen.core.C2I
    public final void AEB(C2873mv c2873mv) {
        this.A02.add(this.A00);
    }
}
