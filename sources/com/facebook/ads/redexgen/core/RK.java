package com.facebook.ads.redexgen.core;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RK {
    public static final RK A03;
    public final String A00;
    public final RJ A01;
    public final Object A02;

    static {
        RK rk;
        if (AbstractC2471gE.A02 < 31) {
            rk = new RK("");
        } else {
            rk = new RK(RJ.A01, "");
        }
        A03 = rk;
    }

    public RK(RJ rj, String str) {
        this.A01 = rj;
        this.A00 = str;
        this.A02 = new Object();
    }

    public RK(String str) {
        AbstractC2388es.A08(AbstractC2471gE.A02 < 31);
        this.A00 = str;
        this.A01 = null;
        this.A02 = new Object();
    }

    public final LogSessionId A00() {
        return ((RJ) AbstractC2388es.A01(this.A01)).A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RK)) {
            return false;
        }
        RK rk = (RK) obj;
        if (Objects.equals(this.A00, rk.A00) && Objects.equals(this.A01, rk.A01) && Objects.equals(this.A02, rk.A02)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.A00, this.A01, this.A02);
    }
}
