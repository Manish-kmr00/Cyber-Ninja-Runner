package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class BQ {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<BO> A02 = new AtomicReference<>();

    public static void A00(Throwable th, Object obj) throws Throwable {
        if (A01.get()) {
            A00.add(obj);
            Bf.A00().AAm(3306, th);
            BO contextRepairHelper = A02.get();
            if (contextRepairHelper != null) {
                contextRepairHelper.AHf(th, obj);
                return;
            }
            return;
        }
        throw th;
    }

    public static void A01(boolean z, BO bo) {
        A01.set(z);
        A02.set(bo);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
