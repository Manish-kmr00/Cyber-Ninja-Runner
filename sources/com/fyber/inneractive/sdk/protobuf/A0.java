package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes12.dex */
public final class A0 {
    public static C3236z0 a(Object obj, Object obj2) {
        C3236z0 c3236z0 = (C3236z0) obj;
        C3236z0 c3236z1 = (C3236z0) obj2;
        if (!c3236z1.isEmpty()) {
            if (!c3236z0.f2306a) {
                c3236z0 = c3236z0.isEmpty() ? new C3236z0() : new C3236z0(c3236z0);
            }
            if (!c3236z0.f2306a) {
                throw new UnsupportedOperationException();
            }
            if (!c3236z1.isEmpty()) {
                c3236z0.putAll(c3236z1);
            }
        }
        return c3236z0;
    }
}
