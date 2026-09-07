package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class OW<K, V> extends C2758ky<K, V>.Itr<Map.Entry<K, V>> {
    public final /* synthetic */ C2758ky A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OW(final C2758ky this$0) {
        super(this$0, null);
        this.A00 = this$0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Map.Entry<K, V> A03(int entry) {
        return new OT(this.A00, entry);
    }
}
