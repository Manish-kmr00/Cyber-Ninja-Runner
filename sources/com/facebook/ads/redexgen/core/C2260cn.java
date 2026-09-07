package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2260cn implements InterfaceC13716k {
    public final /* synthetic */ C13656e A00;
    public final /* synthetic */ C1713Ki A01;

    public C2260cn(C1713Ki c1713Ki, C13656e c13656e) {
        this.A01 = c1713Ki;
        this.A00 = c13656e;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13716k
    public final boolean AA8() {
        if (!this.A01.A0b()) {
            if (this.A01.A0c()) {
                return true;
            }
            return this.A01.A0d();
        }
        this.A01.A0a(this.A00);
        return true;
    }
}
