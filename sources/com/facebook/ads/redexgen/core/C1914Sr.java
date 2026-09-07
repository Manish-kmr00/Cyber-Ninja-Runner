package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1914Sr implements Y7 {
    public static byte[] A06;
    public int A00;
    public int A01;
    public InterfaceC1957Uo A03;
    public boolean A04;
    public final C2447fq A05 = new C2447fq(10);
    public long A02 = -9223372036854775807L;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{4, 41, 51, 35, 33, 50, 36, 41, 46, 39, 96, 41, 46, 54, 33, 44, 41, 36, 96, 9, 4, 115, 96, 52, 33, 39, 88, 117, 34, 67, 116, 112, 117, 116, 99, 65, 80, 80, 76, 73, 67, 65, 84, 73, 79, 78, Ascii.SI, 73, 68, 19};
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A50(C2447fq c2447fq) {
        AbstractC2388es.A02(this.A03);
        if (!this.A04) {
            return;
        }
        int iA07 = c2447fq.A07();
        int bytesAvailable = this.A00;
        if (bytesAvailable < 10) {
            int bytesAvailable2 = this.A00;
            int iMin = Math.min(iA07, 10 - bytesAvailable2);
            byte[] bArrA0l = c2447fq.A0l();
            int iA09 = c2447fq.A09();
            byte[] bArrA0l2 = this.A05.A0l();
            int bytesAvailable3 = this.A00;
            System.arraycopy(bArrA0l, iA09, bArrA0l2, bytesAvailable3, iMin);
            int bytesAvailable4 = this.A00;
            if (bytesAvailable4 + iMin == 10) {
                this.A05.A0f(0);
                int headerBytesAvailable = this.A05.A0I();
                if (73 == headerBytesAvailable) {
                    int headerBytesAvailable2 = this.A05.A0I();
                    if (68 == headerBytesAvailable2) {
                        int headerBytesAvailable3 = this.A05.A0I();
                        if (51 == headerBytesAvailable3) {
                            this.A05.A0g(3);
                            int bytesAvailable5 = this.A05.A0H();
                            this.A01 = bytesAvailable5 + 10;
                        }
                    }
                }
                AbstractC2432fb.A07(A00(26, 9, 109), A00(0, 26, 60));
                this.A04 = false;
                return;
            }
        }
        int headerBytesAvailable4 = this.A01;
        int bytesAvailable6 = this.A00;
        int bytesToWrite = Math.min(iA07, headerBytesAvailable4 - bytesAvailable6);
        this.A03.AHx(c2447fq, bytesToWrite);
        int bytesAvailable7 = this.A00;
        this.A00 = bytesAvailable7 + bytesToWrite;
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A5S(UL ul, YS ys) {
        ys.A05();
        this.A03 = ul.AJX(ys.A03(), 5);
        this.A03.A6U(new P5().A0y(ys.A04()).A11(A00(35, 15, 92)).A14());
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFx() {
        AbstractC2388es.A02(this.A03);
        if (!this.A04 || this.A01 == 0 || this.A00 != this.A01) {
            return;
        }
        if (this.A02 != -9223372036854775807L) {
            this.A03.AI0(this.A02, 1, this.A01, 0, null);
        }
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFy(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.A04 = true;
        if (j != -9223372036854775807L) {
            this.A02 = j;
        }
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AIB() {
        this.A04 = false;
        this.A02 = -9223372036854775807L;
    }
}
