package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C3P {
    public static C3O A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static C3O A00(C2698k0 c2698k0) {
        if (A00 == null) {
            A00 = new C3O(c2698k0);
        }
        return A00;
    }

    public static void A01(C2698k0 c2698k0) {
        if (AbstractC14529p.A0C(c2698k0)) {
            A03(c2698k0);
        }
    }

    public static void A02(C2698k0 c2698k0) {
        if (AbstractC14529p.A0B(c2698k0)) {
            A03(c2698k0);
        }
    }

    public static void A03(C2698k0 c2698k0) {
        if (A01.compareAndSet(false, true)) {
            ExecutorC1520Cx.A01.execute(new C2805ln(c2698k0));
        }
    }
}
