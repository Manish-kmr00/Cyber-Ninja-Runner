package com.facebook.ads.redexgen.core;

import java.io.IOException;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W0 {
    public static String[] A02 = {"", "x6sQOPKcKrQATs1e", Protocol.VAST_1_0_WRAPPER, "nFmEZNjWaB0a2IvFYrUZsxH0HRcIIjns", "KdBqiPPuwTbWvCYwQhXPEgpWDeH", "", "URGp4hdCrsvY44ewIJdlcJbH7089xYie", "vybRPLtlTpN7zYOCBleuQhDw65w5f0Px"};
    public int A00;
    public final C2447fq A01 = new C2447fq(8);

    private long A00(WJ wj) throws IOException {
        wj.AG1(this.A01.A0l(), 0, 1);
        int i = this.A01.A0l()[0] & 255;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int mask = 128;
        int length = 0;
        while (value == 0) {
            mask >>= 1;
            length++;
        }
        int value = ~mask;
        int i2 = i & value;
        wj.AG1(this.A01.A0l(), 1, length);
        for (int i3 = 0; i3 < length; i3++) {
            int value2 = i3 + 1;
            i2 = (i2 << 8) + (this.A01.A0l()[value2] & 255);
        }
        int mask2 = this.A00;
        int value3 = length + 1;
        this.A00 = mask2 + value3;
        return i2;
    }

    public final boolean A01(WJ wj) throws IOException {
        long jA8E = wj.A8E();
        long j = 1024;
        if (jA8E != -1 && jA8E <= 1024) {
            j = jA8E;
        }
        int i = (int) j;
        boolean z = false;
        wj.AG1(this.A01.A0l(), 0, 4);
        long tag = this.A01.A0Q();
        this.A00 = 4;
        while (tag != 440786851) {
            int i2 = this.A00 + 1;
            this.A00 = i2;
            if (i2 == i) {
                return false;
            }
            wj.AG1(this.A01.A0l(), 0, 1);
            tag = ((tag << 8) & (-256)) | ((long) (this.A01.A0l()[0] & 255));
        }
        long headerStart = A00(wj);
        long inputLength = this.A00;
        if (headerStart == Long.MIN_VALUE) {
            return false;
        }
        if (jA8E != -1 && inputLength + headerStart >= jA8E) {
            return false;
        }
        while (this.A00 < inputLength + headerStart) {
            if (A00(wj) == Long.MIN_VALUE) {
                return z;
            }
            long jA00 = A00(wj);
            if (jA00 < 0 || jA00 > 2147483647L) {
                return false;
            }
            if (jA00 != 0) {
                int i3 = (int) jA00;
                String[] strArr = A02;
                if (strArr[3].charAt(28) == strArr[6].charAt(28)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[3] = "qrC6yzEziiSPgV4ghxfhfUqRXLL1eowI";
                strArr2[6] = "vK5NU4VGpe446g90Il0q7V20wV4rPa1C";
                wj.A3x(i3);
                this.A00 += i3;
            }
            z = false;
        }
        return ((long) this.A00) == inputLength + headerStart;
    }
}
