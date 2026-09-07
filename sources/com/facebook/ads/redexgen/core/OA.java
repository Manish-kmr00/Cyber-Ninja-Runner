package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OA {
    public static byte[] A0G;

    @MetaExoPlayerCustomization("The average time that it takes to decode frames expressed in milliseconds")
    public int A00;

    @MetaExoPlayerCustomization("The average time that it takes to render frames expressed in milliseconds")
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;

    @MetaExoPlayerCustomization("Total number of samples used to calculate average decode and render times")
    public int A0C;
    public int A0D;

    @MetaExoPlayerCustomization("The number of frames that were in a gap and skipped as a result of it")
    public int A0E;
    public long A0F;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 5);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0G = new byte[]{-58, -25, -27, -15, -26, -25, -12, -59, -15, -9, -16, -10, -25, -12, -11, -94, -3, -116, -94, -26, -25, -27, -15, -26, -25, -12, -53, -16, -21, -10, -11, -65, -89, -11, -82, -116, -94, -26, -25, -27, -15, -26, -25, -12, -44, -25, -18, -25, -29, -11, -25, -11, -65, -89, -11, -116, -94, -13, -9, -25, -9, -25, -26, -53, -16, -14, -9, -10, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -11, -19, -21, -14, -14, -25, -26, -53, -16, -14, -9, -10, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -12, -25, -16, -26, -25, -12, -25, -26, -47, -9, -10, -14, -9, -10, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -11, -19, -21, -14, -14, -25, -26, -47, -9, -10, -14, -9, -10, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -26, -12, -15, -14, -14, -25, -26, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -26, -12, -15, -14, -14, -25, -26, -53, -16, -14, -9, -10, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -17, -29, -6, -59, -15, -16, -11, -25, -27, -9, -10, -21, -8, -25, -58, -12, -15, -14, -14, -25, -26, -60, -9, -24, -24, -25, -12, -11, -65, -89, -11, -116, -94, -26, -12, -15, -14, -14, -25, -26, -42, -15, -51, -25, -5, -24, -12, -29, -17, -25, -57, -8, -25, -16, -10, -11, -65, -89, -11, -116, -94, -10, -15, -10, -29, -18, -40, -21, -26, -25, -15, -56, -12, -29, -17, -25, -46, -12, -15, -27, -25, -11, -11, -21, -16, -23, -47, -24, -24, -11, -25, -10, -41, -11, -65, -89, -11, -116, -94, -8, -21, -26, -25, -15, -56, -12, -29, -17, -25, -46, -12, -15, -27, -25, -11, -11, -21, -16, -23, -47, -24, -24, -11, -25, -10, -59, -15, -9, -16, -10, -65, -89, -11, -116, -1};
    }

    public final synchronized void A02() {
    }

    @MetaExoPlayerCustomization
    public final void A03(long j) {
        int i;
        if (this.A09 == 0) {
            i = -1;
        } else {
            i = (int) (j / ((long) this.A09));
        }
        this.A01 = i;
    }

    @MetaExoPlayerCustomization
    public final void A04(Pair<Long, Integer> newSamplePerFrameDecodeTimeAndCount) {
        int i;
        long j = ((long) this.A0C) * ((long) this.A00);
        this.A0C += ((Integer) newSamplePerFrameDecodeTimeAndCount.second).intValue();
        long updatedTotalDecodeTime = ((Long) newSamplePerFrameDecodeTimeAndCount.first).longValue() + j;
        if (this.A0C == 0) {
            i = -1;
        } else {
            long currentTotalDecodeTime = this.A0C;
            i = (int) (updatedTotalDecodeTime / currentTotalDecodeTime);
        }
        this.A00 = i;
    }

    public final String toString() {
        return AbstractC2471gE.A0n(A00(0, 333, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), Integer.valueOf(this.A02), Integer.valueOf(this.A03), Integer.valueOf(this.A08), Integer.valueOf(this.A0A), Integer.valueOf(this.A09), Integer.valueOf(this.A0B), Integer.valueOf(this.A04), Integer.valueOf(this.A05), Integer.valueOf(this.A07), Integer.valueOf(this.A06), Long.valueOf(this.A0F), Integer.valueOf(this.A0D));
    }
}
