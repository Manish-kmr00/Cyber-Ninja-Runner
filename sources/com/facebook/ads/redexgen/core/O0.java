package com.facebook.ads.redexgen.core;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class O0 extends AbstractC2896nI<Object> {
    public final /* synthetic */ int A00;

    public O0(final int val$expectedKeys) {
        this.A00 = val$expectedKeys;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2896nI
    public final <K, V> Map<K, Collection<V>> A04() {
        return AbstractC2914nb.A00(this.A00);
    }
}
