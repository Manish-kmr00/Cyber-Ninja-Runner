package com.bytedance.adsdk.Og;

import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
public final class WV<V> {
    private final Throwable Og;
    private final V pA;

    public WV(V v) {
        this.pA = v;
        this.Og = null;
    }

    public WV(Throwable th) {
        this.Og = th;
        this.pA = null;
    }

    public V pA() {
        return this.pA;
    }

    public Throwable Og() {
        return this.Og;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WV)) {
            return false;
        }
        WV wv = (WV) obj;
        if (pA() != null && pA().equals(wv.pA())) {
            return true;
        }
        if (Og() == null || wv.Og() == null) {
            return false;
        }
        return Og().toString().equals(Og().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{pA(), Og()});
    }
}
