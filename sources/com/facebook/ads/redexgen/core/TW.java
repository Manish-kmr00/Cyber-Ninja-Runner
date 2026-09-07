package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TW extends AbstractC2005Wm {
    public static String[] A02 = {"Oy4cVVo1q05MAKbLPgmqOD", "7ew8nUwi6G1RDKOByqWkFvsVE50B", "tr9sMmGcyDTt6qfpdd2BTd", "eXs9qGzfQAFNSJTKrpKETmvICTHM0C", "r", "kT8YhkgkCWBzT", "adqnmN7RQmpyCH5w2Bo90q", "mGhREreuXJXYJiMK3twEX63YkdwWzEmG"};
    public UU A00;
    public TX A01;

    private int A00(C2447fq c2447fq) {
        int i = (c2447fq.A0l()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            c2447fq.A0g(4);
            c2447fq.A0S();
        }
        int result = UQ.A00(c2447fq, i);
        c2447fq.A0f(0);
        return result;
    }

    public static boolean A01(C2447fq c2447fq) {
        if (c2447fq.A07() >= 5) {
            int iA0I = c2447fq.A0I();
            if (A02[1].length() != 28) {
                throw new RuntimeException();
            }
            A02[5] = "CqKN6S";
            if (iA0I == 127 && c2447fq.A0Q() == 1179402563) {
                return true;
            }
        }
        return false;
    }

    public static boolean A02(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2005Wm
    public final long A0E(C2447fq c2447fq) {
        if (!A02(c2447fq.A0l())) {
            return -1L;
        }
        return A00(c2447fq);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2005Wm
    public final void A0I(boolean z) {
        super.A0I(z);
        if (z) {
            this.A00 = null;
            this.A01 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2005Wm
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0J(C2447fq c2447fq, long j, C2004Wl c2004Wl) {
        byte[] bArrA0l = c2447fq.A0l();
        UU uu = this.A00;
        if (uu == null) {
            UU uu2 = new UU(bArrA0l, 17);
            this.A00 = uu2;
            c2004Wl.A00 = uu2.A08(Arrays.copyOfRange(bArrA0l, 9, c2447fq.A0A()), null);
            return true;
        }
        if ((bArrA0l[0] & 127) == 3) {
            UT utA04 = US.A04(c2447fq);
            UU streamMetadata = uu.A09(utA04);
            this.A00 = streamMetadata;
            this.A01 = new TX(streamMetadata, utA04);
            return true;
        }
        if (!A02(bArrA0l)) {
            return true;
        }
        if (this.A01 != null) {
            this.A01.A00(j);
            c2004Wl.A01 = this.A01;
        }
        AbstractC2388es.A01(c2004Wl.A00);
        return false;
    }
}
