package com.facebook.ads.redexgen.core;

import java.util.Collection;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2898nK implements InterfaceC12581y {
    public final /* synthetic */ C2699k1 A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C2898nK(JSONObject jSONObject, C2699k1 c2699k1, String str) {
        this.A02 = jSONObject;
        this.A00 = c2699k1;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final String A7E() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final Collection<String> A7f() {
        return AbstractC12591z.A03(this.A00, this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final EnumC12571x A8A() {
        return AbstractC12591z.A00(this.A02);
    }
}
