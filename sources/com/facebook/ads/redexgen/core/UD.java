package com.facebook.ads.redexgen.core;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class UD {
    public static byte[] A04;
    public static String[] A05 = {"Jhtx178IMq23kUOoozNXaD96RNDNMeq9", "NXhQPuYygPgm13XpxQ6AVC", "XbCWuI93AbcXpCtq0Lv1ECs2MHmDiQGb", "aRhX3Yl5xHIR8cXYecvLqc0GN0gWfEUM", "JHpIfdiDfTmDtpI00YF6gvRZqtNWaTR9", "DSplChZ5H8QsGzGk5GdQZeMEULlwRRZg", "aSNduxc9zJN0oIXdD27ucq", "ha0k4MwTTu0lAZTs7ugoKqlV19asfAad"};
    public U7 A00;
    public final int A01;
    public final C1998Wf A02;
    public final UC A03;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A05;
            if (strArr[4].charAt(6) == strArr[3].charAt(6)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[1] = "SInKRwdAdChGNPlHrJmpFI";
            strArr2[6] = "BMskWzHkRy94e6Jaaiv6Vn";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 104);
            i4++;
        }
    }

    public static void A05() {
        A04 = new byte[]{-48, -11, -3, -24, -13, -16, -21, -89, -22, -24, -6, -20};
    }

    static {
        A05();
    }

    public UD(U8 u8, UC uc, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.A03 = uc;
        this.A01 = i;
        this.A02 = new C1998Wf(u8, j, j2, j3, j4, j5, j6);
    }

    private final int A02(WJ wj, long j, C1952Ug c1952Ug) {
        if (j == wj.A8d()) {
            return 0;
        }
        c1952Ug.A00 = j;
        return 1;
    }

    private final U7 A03(long j) {
        return new U7(j, this.A02.A05(j), this.A02.A05, this.A02.A02, this.A02.A04, this.A02.A01, this.A02.A00);
    }

    private final void A06(boolean z, long j) {
        this.A00 = null;
        this.A03.AF2();
    }

    private final boolean A07(WJ wj, long j) throws IOException {
        long jA8d = j - wj.A8d();
        if (jA8d >= 0 && jA8d <= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            wj.AJ9((int) jA8d);
            return true;
        }
        return false;
    }

    public final int A08(WJ wj, C1952Ug c1952Ug) throws IOException {
        while (true) {
            U7 u7 = (U7) AbstractC2388es.A02(this.A00);
            long jA01 = u7.A01();
            long jA00 = u7.A00();
            long jA02 = u7.A02();
            if (jA00 - jA01 <= this.A01) {
                A06(false, jA01);
                return A02(wj, jA01, c1952Ug);
            }
            if (!A07(wj, jA02)) {
                return A02(wj, jA02, c1952Ug);
            }
            wj.AHr();
            UA uaAI2 = this.A03.AI2(wj, u7.A04());
            switch (uaAI2.A00) {
                case -3:
                    A06(false, jA02);
                    return A02(wj, jA02, c1952Ug);
                case -2:
                    u7.A0D(uaAI2.A02, uaAI2.A01);
                    break;
                case -1:
                    u7.A0C(uaAI2.A02, uaAI2.A01);
                    break;
                case 0:
                    A07(wj, uaAI2.A01);
                    long floorPosition = uaAI2.A01;
                    A06(true, floorPosition);
                    return A02(wj, uaAI2.A01, c1952Ug);
                default:
                    throw new IllegalStateException(A04(0, 12, 31));
            }
        }
    }

    public final C1998Wf A09() {
        return this.A02;
    }

    public final void A0A(long j) {
        if (this.A00 != null && this.A00.A03() == j) {
            return;
        }
        this.A00 = A03(j);
    }

    public final boolean A0B() {
        return this.A00 != null;
    }
}
