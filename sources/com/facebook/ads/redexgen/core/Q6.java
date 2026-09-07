package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Q6 extends IOException {
    public int A00;
    public boolean A01;

    @Deprecated
    public Q6() {
    }

    @Deprecated
    public Q6(String str) {
        super(str);
    }

    public Q6(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.A01 = z;
        this.A00 = i;
    }

    public static Q6 A00(String str) {
        return new Q6(str, null, false, 1);
    }

    public static Q6 A01(String str, Throwable th) {
        return new Q6(str, th, true, 1);
    }

    public static Q6 A02(String str, Throwable th) {
        return new Q6(str, th, true, 0);
    }
}
