package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Bf {
    public static final AtomicReference<InterfaceC1483Be> A00 = new AtomicReference<>(null);

    public static InterfaceC1483Be A00() {
        InterfaceC1483Be errorLogger = A00.get();
        if (errorLogger == null) {
            return new C2599iN();
        }
        return errorLogger;
    }

    public static void A01(InterfaceC1483Be interfaceC1483Be) {
        A00.set(interfaceC1483Be);
    }
}
