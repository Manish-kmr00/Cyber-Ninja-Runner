package com.facebook.ads.redexgen.core;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class UM {
    public static int A00(WJ wj, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int totalBytesPeeked = i2 - i3;
            int bytesPeeked = wj.AG0(bArr, i + i3, totalBytesPeeked);
            if (bytesPeeked == -1) {
                break;
            }
            i3 += bytesPeeked;
        }
        return i3;
    }

    @Pure
    public static void A01(boolean z, String str) throws Q6 {
        if (z) {
        } else {
            throw Q6.A01(str, null);
        }
    }

    public static boolean A02(WJ wj, int i) throws IOException {
        try {
            wj.AJ9(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean A03(WJ wj, byte[] bArr, int i, int i2) throws IOException {
        try {
            wj.readFully(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean A04(WJ wj, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return wj.AG2(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }
}
