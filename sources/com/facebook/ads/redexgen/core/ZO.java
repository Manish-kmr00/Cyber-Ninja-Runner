package com.facebook.ads.redexgen.core;

import android.media.MediaFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZO implements InterfaceC2500gi, InterfaceC2528hA, QS {
    public static byte[] A04;
    public InterfaceC2500gi A00;
    public InterfaceC2500gi A01;
    public InterfaceC2528hA A02;
    public InterfaceC2528hA A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 27);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{100, 102, 119, 85, 106, 103, 102, 108, 69, 113, 98, 110, 102, 78, 102, 119, 98, 103, 98, 119, 98, 79, 106, 112, 119, 102, 109, 102, 113};
    }

    public ZO() {
    }

    public /* synthetic */ ZO(HandlerC1798Oa handlerC1798Oa) {
        this();
    }

    @Override // com.facebook.ads.redexgen.core.QS
    public final void A9Y(int i, Object obj) {
        switch (i) {
            case 7:
                this.A01 = (InterfaceC2500gi) obj;
                return;
            case 8:
                this.A02 = (InterfaceC2528hA) obj;
                return;
            case 10000:
                if (0 == 0) {
                    this.A00 = null;
                    this.A03 = null;
                    return;
                }
                throw new NullPointerException(A00(0, 29, 24));
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2500gi
    public final void AFa(long j, long j2, ZM zm, MediaFormat mediaFormat) {
        if (this.A00 != null) {
            this.A00.AFa(j, j2, zm, mediaFormat);
        }
        if (this.A01 != null) {
            this.A01.AFa(j, j2, zm, mediaFormat);
        }
    }
}
