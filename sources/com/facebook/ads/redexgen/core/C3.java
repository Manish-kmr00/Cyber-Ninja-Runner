package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3 extends XP {
    public static String[] A0C = {"pU2BOdhHAj4vVLk", "SqaJr7PvUJrWJiLtE8F2ELOrn9uRMJjH", "LPfymQVKtkvR", "LI2Kb", "vbebjuuQuEF8", "7Irzre7pNEC5qaLYBUNEICEmnGy", "ylZFgk3w832qBVGyZ2QCovgM192mvuV9", "k3sRMKXd7NEkS9VGFZj8LcPZ6ZYG0VBY"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public byte[] A07;
    public byte[] A08;
    public final long A09;
    public final long A0A;
    public final short A0B;

    public C3() {
        this(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 20000L, (short) 1024);
    }

    public C3(long j, long j2, short s) {
        AbstractC2388es.A07(j2 <= j);
        this.A09 = j;
        this.A0A = j2;
        this.A0B = s;
        this.A07 = AbstractC2471gE.A07;
        this.A08 = AbstractC2471gE.A07;
    }

    private int A00(long j) {
        return (int) ((((long) super.A05.A03) * j) / 1000000);
    }

    private int A01(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 2; iLimit >= i; iLimit -= 2) {
            int i = byteBuffer.getShort(iLimit);
            int iAbs = Math.abs(i);
            int i2 = this.A0B;
            if (iAbs > i2) {
                int i3 = this.A00;
                int i4 = this.A00;
                int i5 = i3 * (iLimit / i4);
                int i6 = this.A00;
                return i5 + i6;
            }
        }
        int i7 = byteBuffer.position();
        return i7;
    }

    private int A02(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < i; iPosition += 2) {
            int i = byteBuffer.getShort(iPosition);
            int iAbs = Math.abs(i);
            int i2 = this.A0B;
            if (iAbs > i2) {
                int i3 = this.A00;
                int i4 = this.A00;
                return i3 * (iPosition / i4);
            }
        }
        int i5 = byteBuffer.limit();
        return i5;
    }

    private void A03(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        A00(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.A06 = true;
        }
    }

    private void A04(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int maybeSilenceBufferRemaining = A02(byteBuffer);
        int limit = byteBuffer.position();
        int maybeSilenceInputSize = maybeSilenceBufferRemaining - limit;
        int noisePosition = this.A07.length;
        int limit2 = this.A01;
        int noisePosition2 = noisePosition - limit2;
        if (maybeSilenceBufferRemaining < iLimit && maybeSilenceInputSize < noisePosition2) {
            byte[] bArr = this.A07;
            int limit3 = this.A01;
            A08(bArr, limit3);
            this.A01 = 0;
            this.A03 = 0;
            return;
        }
        int maybeSilenceInputSize2 = Math.min(maybeSilenceInputSize, noisePosition2);
        int limit4 = byteBuffer.position();
        byteBuffer.limit(limit4 + maybeSilenceInputSize2);
        byte[] bArr2 = this.A07;
        int limit5 = this.A01;
        byteBuffer.get(bArr2, limit5, maybeSilenceInputSize2);
        int limit6 = this.A01;
        this.A01 = limit6 + maybeSilenceInputSize2;
        int noisePosition3 = this.A01;
        int limit7 = this.A07.length;
        if (noisePosition3 == limit7) {
            if (this.A06) {
                byte[] bArr3 = this.A07;
                int limit8 = this.A02;
                A08(bArr3, limit8);
                long j = this.A04;
                int noisePosition4 = this.A01;
                int limit9 = this.A02;
                int noisePosition5 = noisePosition4 - (limit9 * 2);
                int limit10 = this.A00;
                this.A04 = j + ((long) (noisePosition5 / limit10));
            } else {
                long j2 = this.A04;
                int noisePosition6 = this.A01;
                int limit11 = this.A02;
                int noisePosition7 = noisePosition6 - limit11;
                int limit12 = this.A00;
                this.A04 = j2 + ((long) (noisePosition7 / limit12));
            }
            byte[] bArr4 = this.A07;
            int limit13 = this.A01;
            A07(byteBuffer, bArr4, limit13);
            this.A01 = 0;
            this.A03 = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void A05(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int limit = this.A07.length;
        byteBuffer.limit(Math.min(iLimit, iPosition + limit));
        int noiseLimit = A01(byteBuffer);
        int limit2 = byteBuffer.position();
        if (noiseLimit == limit2) {
            this.A03 = 1;
        } else {
            byteBuffer.limit(noiseLimit);
            A03(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void A06(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iA02 = A02(byteBuffer);
        byteBuffer.limit(iA02);
        long j = this.A04;
        int noisyPosition = byteBuffer.remaining();
        int limit = this.A00;
        this.A04 = j + ((long) (noisyPosition / limit));
        byte[] bArr = this.A08;
        int limit2 = this.A02;
        A07(byteBuffer, bArr, limit2);
        if (iA02 < iLimit) {
            byte[] bArr2 = this.A08;
            int limit3 = this.A02;
            A08(bArr2, limit3);
            this.A03 = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void A07(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.A02);
        int i2 = this.A02 - iMin;
        System.arraycopy(bArr, i - i2, this.A08, 0, i2);
        int fromInputSize = byteBuffer.limit();
        byteBuffer.position(fromInputSize - iMin);
        byteBuffer.get(this.A08, i2, iMin);
    }

    private void A08(byte[] bArr, int i) {
        A00(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.A06 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.XP
    public final RT A09(RT rt) throws RU {
        if (rt.A02 == 2) {
            return this.A05 ? rt : RT.A05;
        }
        throw new RU(rt);
    }

    @Override // com.facebook.ads.redexgen.core.XP
    public final void A0A() {
        if (this.A05) {
            this.A00 = super.A05.A00;
            int iA00 = A00(this.A09) * this.A00;
            int maybeSilenceBufferSize = this.A07.length;
            if (maybeSilenceBufferSize != iA00) {
                this.A07 = new byte[iA00];
            }
            long j = this.A0A;
            String[] strArr = A0C;
            String str = strArr[6];
            String str2 = strArr[1];
            int iCharAt = str.charAt(29);
            int maybeSilenceBufferSize2 = str2.charAt(29);
            if (iCharAt == maybeSilenceBufferSize2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[5] = "TZOI04JP3POno4pBuTGM9q62XWv";
            strArr2[3] = "wBzLD";
            int iA01 = A00(j);
            int maybeSilenceBufferSize3 = this.A00;
            this.A02 = iA01 * maybeSilenceBufferSize3;
            int length = this.A08.length;
            int maybeSilenceBufferSize4 = this.A02;
            if (length != maybeSilenceBufferSize4) {
                int maybeSilenceBufferSize5 = this.A02;
                this.A08 = new byte[maybeSilenceBufferSize5];
            }
        }
        this.A03 = 0;
        this.A04 = 0L;
        this.A01 = 0;
        this.A06 = false;
    }

    @Override // com.facebook.ads.redexgen.core.XP
    public final void A0B() {
        if (this.A01 > 0) {
            A08(this.A07, this.A01);
        }
        if (!this.A06) {
            this.A04 += (long) (this.A02 / this.A00);
        }
    }

    public final long A0C() {
        return this.A04;
    }

    public final void A0D(boolean z) {
        this.A05 = z;
    }

    @Override // com.facebook.ads.redexgen.core.XP, com.facebook.ads.redexgen.core.RV
    public final boolean AAA() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void AGP(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !A01()) {
            switch (this.A03) {
                case 0:
                    A05(byteBuffer);
                    break;
                case 1:
                    A04(byteBuffer);
                    break;
                case 2:
                    A06(byteBuffer);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }
}
