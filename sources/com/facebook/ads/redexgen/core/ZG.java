package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZG implements InterfaceC1775Nb {
    public final float A00;
    public final float A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public static String[] A05 = {"E66l8wlZ4v3iEKCEFHgH9VLRvbTNFtpL", "tE4S3r0V5ycsTYM8Dy5oJD9FoMT1glcU", "wH8wICNcmP8YQ3MTU1MeFa2PWIeGD1lC", "97GTnnCIIcAH3EgCF5ouocWI", "GyFtWuyKbXIMU8WgRoBB5FfFAAaLXJhA", "CMHQy90E6JDQYMfZEUcgLzvffNMrkZNI", "RRx1hV4SwDog4weIlrRs3P0MX6JysyL7", "VFHZIREO7BA91sSd"};
    public static final ZG A07 = new PN().A05();
    public static final InterfaceC1774Na<ZG> A06 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZH
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return ZG.A00(bundle);
        }
    };

    @Deprecated
    public ZG(long j, long j2, long j3, float f, float f2) {
        this.A04 = j;
        this.A03 = j2;
        this.A02 = j3;
        this.A01 = f;
        this.A00 = f2;
    }

    public ZG(PN pn) {
        this(pn.A04, pn.A03, pn.A02, pn.A01, pn.A00);
    }

    public static /* synthetic */ ZG A00(Bundle bundle) {
        return new ZG(bundle.getLong(A01(0), -9223372036854775807L), bundle.getLong(A01(1), -9223372036854775807L), bundle.getLong(A01(2), -9223372036854775807L), bundle.getFloat(A01(3), -3.4028235E38f), bundle.getFloat(A01(4), -3.4028235E38f));
    }

    public static String A01(int i) {
        return Integer.toString(i, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZG)) {
            return false;
        }
        ZG zg = (ZG) obj;
        long j = this.A04;
        long j2 = zg.A04;
        String[] strArr = A05;
        if (strArr[3].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[2] = "q9INe8qnlpk9hGRlHP1h549I0GC0iD7c";
        strArr2[0] = "dDn4d8zun5hFgG6eoF3cZR7p2qKAzpbN";
        return j == j2 && this.A03 == zg.A03 && this.A02 == zg.A02 && this.A01 == zg.A01 && this.A00 == zg.A00;
    }

    public final int hashCode() {
        int i = ((((int) (this.A04 ^ (this.A04 >>> 32))) * 31) + ((int) (this.A03 ^ (this.A03 >>> 32)))) * 31;
        int result = (int) (this.A02 ^ (this.A02 >>> 32));
        int iFloatToIntBits = ((i + result) * 31) + (this.A01 != 0.0f ? Float.floatToIntBits(this.A01) : 0);
        String[] strArr = A05;
        String str = strArr[3];
        String str2 = strArr[7];
        int result2 = str.length();
        if (result2 == str2.length()) {
            throw new RuntimeException();
        }
        A05[4] = "2J5b96YasdupXuMGSA5xaFObQUmrmG7j";
        int result3 = (iFloatToIntBits * 31) + (this.A00 != 0.0f ? Float.floatToIntBits(this.A00) : 0);
        return result3;
    }
}
