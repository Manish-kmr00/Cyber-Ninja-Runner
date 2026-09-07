package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class P3 {
    public static String[] A01 = {"YwrNdni1f5xaVIfDCBpdk2mDwbnjmL5w", "bqxPCkfc5PVgpmbXl7zfXSakktvu1UwV", "4cKYSH1h", "1LFJybDCj8pbtvDfpsT5sKrTzd1Kzm53", "IpCHvfG5zVXZdgwzcHJYlkFhjl9eb4Oa", "cah6qasTEsrkSIoL5nfwPcZe4cvMPweF", "8eD3p690du5bFEhlC6yHc6M0A1FYyZTF", "sj3suw5zEhU1fNKtejpxSkfArn2xg2JB"};
    public final SparseBooleanArray A00;

    public P3(SparseBooleanArray sparseBooleanArray) {
        this.A00 = sparseBooleanArray;
    }

    public final int A00() {
        return this.A00.size();
    }

    public final int A01(int i) {
        AbstractC2388es.A00(i, 0, A00());
        return this.A00.keyAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P3)) {
            return false;
        }
        P3 p3 = (P3) obj;
        if (AbstractC2471gE.A02 < 24) {
            if (A00() != p3.A00()) {
                return false;
            }
            for (int i = 0; i < A00(); i++) {
                if (A01(i) != p3.A01(i)) {
                    return false;
                }
            }
            return true;
        }
        return this.A00.equals(p3.A00);
    }

    public final int hashCode() {
        if (AbstractC2471gE.A02 < 24) {
            int iA00 = A00();
            String[] strArr = A01;
            if (strArr[4].charAt(6) == strArr[7].charAt(6)) {
                throw new RuntimeException();
            }
            A01[2] = "hxMrUk5s";
            for (int hashCode = 0; hashCode < i; hashCode++) {
                int i = A01(hashCode);
                iA00 = (iA00 * 31) + i;
            }
            return iA00;
        }
        return this.A00.hashCode();
    }
}
