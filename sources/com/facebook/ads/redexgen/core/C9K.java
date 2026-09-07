package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.C9I;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C9K<T extends C9I> {
    public abstract Class<T> A01();

    public abstract void A03(T t);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9K != com.facebook.ads.internal.events.EventSubscriber<T extends com.facebook.ads.redexgen.X.9I> */
    public final boolean A00(T event) {
        return true;
    }
}
