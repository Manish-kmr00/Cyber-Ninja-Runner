package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GS extends AbstractC2103aB {
    public final JSONObject A00;
    public final JSONObject A01;

    public GS(C2113aL c2113aL, JSONObject jSONObject, JSONObject jSONObject2) {
        super(c2113aL, KD.A03);
        this.A00 = jSONObject;
        this.A01 = jSONObject2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2103aB, com.facebook.ads.redexgen.core.K8
    public final void A43(Map<InterfaceC1695Jq, KD> map, Map<SyncModifiableBundle, K0> map2) {
        super.A00.A03(this.A00, this.A01);
        super.A43(map, map2);
    }
}
