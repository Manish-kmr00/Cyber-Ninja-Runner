package com.facebook.ads.redexgen.core;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S1 implements YX {
    public static byte[] A0C;
    public static String[] A0D = {"GlNYRdnBxpEZJHTmMw8HueWs8TUgF8mx", "DZB0tNKpfPCQm9F58sqvYmE8zou9iH17", "vxjUGxAul7dZiFBoxlBvfuM1YbshqPrL", "fX3qtCJcU4RF1QOu4NrXdj2JBifTXmfF", "1OTGwlxmQxEP4IoFSBbVBHiS7Xa3eUxq", "EC9WmiNEUEi6mM3sm24w10cpBWlJZ6V6", "2eAqdYDcmn5PCvNLyzkv4hU0NwVBiYXy", "KQaEe8"};
    public static final int[] A0E;
    public static final int[] A0F;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public final int A04;
    public final int A05;
    public final ZM A06;
    public final UL A07;
    public final InterfaceC1957Uo A08;
    public final YZ A09;
    public final C2447fq A0A;
    public final byte[] A0B;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{3, -24, 47, 55, 60, 2, -24, -99, -48, -56, -67, -69, -52, -67, -68, 120, -66, -54, -71, -59, -67, -53, 120, -56, -67, -54, 120, -70, -60, -57, -69, -61, -110, 120, -55, -35, -52, -47, -41, -105, -38, -55, -33};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = this.A09.A02;
        int i4 = this.A09.A05;
        int i5 = (i2 * 4) + (i * i3);
        int i6 = (i4 * 4) + i5;
        int i7 = (i3 / i4) - 4;
        int iA07 = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
        int iMin = Math.min(bArr[i5 + 2] & 255, 88);
        int i8 = A0F[iMin];
        int i9 = ((this.A04 * i * i4) + i2) * 2;
        bArr2[i9] = (byte) (iA07 & 255);
        bArr2[i9 + 1] = (byte) (iA07 >> 8);
        for (int i10 = 0; i10 < i7 * 2; i10++) {
            int i11 = bArr[((i10 / 8) * i4 * 4) + i6 + ((i10 / 2) % 4)] & 255;
            int i12 = i10 % 2;
            if (A0D[4].charAt(3) != 'a') {
                A0D[4] = "VWjYtUhpws3Seo7KXu2jCuIUARlH7Z52";
                int i13 = i12 == 0 ? i11 & 15 : i11 >> 4;
                int i14 = i13 & 7;
                if (A0D[7].length() == 6) {
                    A0D[7] = "1zSQp8";
                    int i15 = (((i14 * 2) + 1) * i8) >> 3;
                    if ((i13 & 8) != 0) {
                        i15 = -i15;
                    }
                    iA07 = AbstractC2471gE.A07(iA07 + i15, -32768, 32767);
                    i9 += i4 * 2;
                    bArr2[i9] = (byte) (iA07 & 255);
                    bArr2[i9 + 1] = (byte) (iA07 >> 8);
                    iMin = AbstractC2471gE.A07(iMin + A0E[i13], 0, A0F.length - 1);
                    i8 = A0F[iMin];
                    if (A0D[4].charAt(3) == 'a') {
                        throw new RuntimeException();
                    }
                    A0D[7] = "lPO6i5";
                }
            }
            throw new RuntimeException();
        }
    }

    static {
        A04();
        A0E = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        A0F = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    }

    public S1(UL ul, InterfaceC1957Uo interfaceC1957Uo, YZ yz) throws Q6 {
        this.A07 = ul;
        this.A08 = interfaceC1957Uo;
        this.A09 = yz;
        this.A05 = Math.max(1, yz.A04 / 10);
        C2447fq scratch = new C2447fq(yz.A06);
        scratch.A0G();
        this.A04 = scratch.A0G();
        int i = yz.A05;
        int i2 = (((yz.A02 - (i * 4)) * 8) / (yz.A01 * i)) + 1;
        if (this.A04 == i2) {
            int numChannels = AbstractC2471gE.A05(this.A05, this.A04);
            this.A0B = new byte[yz.A02 * numChannels];
            int maxBlocksToDecode = A02(this.A04, i);
            this.A0A = new C2447fq(maxBlocksToDecode * numChannels);
            int maxBlocksToDecode2 = yz.A04;
            int constantBitrate = ((maxBlocksToDecode2 * yz.A02) * 8) / this.A04;
            this.A06 = new P5().A11(A03(34, 9, 18)).A0a(constantBitrate).A0j(constantBitrate).A0h(A02(this.A05, i)).A0b(yz.A05).A0m(yz.A04).A0i(2).A14();
            return;
        }
        throw Q6.A01(A03(7, 27, 2) + i2 + A03(0, 7, 114) + this.A04, null);
    }

    private int A00(int i) {
        return i / (this.A09.A05 * 2);
    }

    private int A01(int i) {
        return A02(i, this.A09.A05);
    }

    public static int A02(int i, int i2) {
        return i * 2 * i2;
    }

    private void A05(int i) {
        long jA0U = this.A03 + AbstractC2471gE.A0U(this.A02, 1000000L, this.A09.A04);
        int iA01 = A01(i);
        this.A08.AI0(jA0U, 1, iA01, this.A01 - iA01, null);
        long timeUs = i;
        this.A02 += timeUs;
        this.A01 -= iA01;
    }

    private void A07(byte[] bArr, int i, C2447fq c2447fq) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int channelIndex = 0; channelIndex < blockIndex; channelIndex++) {
                A06(bArr, i2, channelIndex, c2447fq.A0l());
            }
        }
        int blockIndex = this.A04;
        int iA01 = A01(blockIndex * i);
        c2447fq.A0f(0);
        c2447fq.A0e(iA01);
    }

    @Override // com.facebook.ads.redexgen.core.YX
    public final void A9y(int i, long j) {
        this.A07.AID(new C1887Rq(this.A09, this.A04, i, j));
        this.A08.A6U(this.A06);
    }

    @Override // com.facebook.ads.redexgen.core.YX
    public final void AHq(long j) {
        this.A00 = 0;
        this.A03 = j;
        this.A01 = 0;
        this.A02 = 0L;
    }

    @Override // com.facebook.ads.redexgen.core.YX
    public final boolean AHz(WJ wj, long j) throws IOException {
        int iA00 = this.A05 - A00(this.A01);
        int targetFramesRemaining = this.A04;
        int blocksToDecode = AbstractC2471gE.A05(iA00, targetFramesRemaining);
        int i = this.A09.A02 * blocksToDecode;
        boolean z = j == 0;
        while (!z) {
            int targetFramesRemaining2 = this.A00;
            if (targetFramesRemaining2 >= i) {
                break;
            }
            int targetFramesRemaining3 = this.A00;
            int targetReadBytes = (int) Math.min(i - targetFramesRemaining3, j);
            byte[] bArr = this.A0B;
            int targetFramesRemaining4 = this.A00;
            int blocksToDecode2 = wj.read(bArr, targetFramesRemaining4, targetReadBytes);
            if (blocksToDecode2 == -1) {
                z = true;
            } else {
                int targetFramesRemaining5 = this.A00;
                this.A00 = targetFramesRemaining5 + blocksToDecode2;
            }
        }
        int targetReadBytes2 = this.A00;
        int targetFramesRemaining6 = this.A09.A02;
        int targetReadBytes3 = targetReadBytes2 / targetFramesRemaining6;
        if (targetReadBytes3 > 0) {
            A07(this.A0B, targetReadBytes3, this.A0A);
            int blocksToDecode3 = this.A00;
            int targetFramesRemaining7 = this.A09.A02;
            this.A00 = blocksToDecode3 - (targetFramesRemaining7 * targetReadBytes3);
            int targetReadBytes4 = this.A0A.A0A();
            this.A08.AHx(this.A0A, targetReadBytes4);
            int targetFramesRemaining8 = this.A01;
            this.A01 = targetFramesRemaining8 + targetReadBytes4;
            int targetFramesRemaining9 = this.A01;
            int blocksToDecode4 = A00(targetFramesRemaining9);
            int targetFramesRemaining10 = this.A05;
            if (blocksToDecode4 >= targetFramesRemaining10) {
                int targetFramesRemaining11 = this.A05;
                A05(targetFramesRemaining11);
            }
        }
        if (z) {
            int targetFramesRemaining12 = this.A01;
            int targetFramesRemaining13 = A00(targetFramesRemaining12);
            if (targetFramesRemaining13 > 0) {
                A05(targetFramesRemaining13);
            }
        }
        return z;
    }
}
