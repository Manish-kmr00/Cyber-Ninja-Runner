package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class U3 extends W7 {
    @Override // io.appmetrica.analytics.impl.W7
    public final boolean a(L3 l3, L3 l4) {
        if (!In.a(l4.f11236a)) {
            if (In.a(l3.f11236a)) {
                return false;
            }
            X7 x7 = l3.b;
            if (x7 == X7.c) {
                if (((Number) this.f11403a.a(x7)).intValue() < ((Number) this.f11403a.a(l4.b)).intValue()) {
                    return false;
                }
            } else if (((Number) this.f11403a.a(x7)).intValue() <= ((Number) this.f11403a.a(l4.b)).intValue()) {
                return false;
            }
        }
        return true;
    }
}
