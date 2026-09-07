package com.facebook.ads.redexgen.core;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SY {
    public static String[] A0M = {"YHmtT3GFYdUF87wnaK0kzK9mOTxZmLbv", "xcHmGgjhzC9joQpYTgW9a0TQ1Yxx", "TIux5IxHvr99Q0bGMBYzDoHBpeImyuC5", "F", "ZAaNVnfMKdz195Fkc2S8Hlb6NWUfbPVe", "i8GmYFF2CID1aE2EtPVLW4OiDAvik4C7", "TvmikcDlN7gf3aG4ICUCQdSpeRef9N68", "sMLwg818KTPPZ2ESZgmiO24cwEP9o7TE"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public short[] A0A;
    public short[] A0B;
    public short[] A0C;
    public final float A0D;
    public final float A0E;
    public final float A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final short[] A0L;

    public SY(int i, int i2, float f, float f2, int i3) {
        this.A0H = i;
        this.A0G = i2;
        this.A0F = f;
        this.A0D = f2;
        this.A0E = i / i3;
        this.A0K = i / 400;
        this.A0I = i / 65;
        this.A0J = this.A0I * 2;
        this.A0L = new short[this.A0J];
        this.A0A = new short[this.A0J * i2];
        this.A0B = new short[this.A0J * i2];
        this.A0C = new short[this.A0J * i2];
    }

    private int A00(int i) {
        int iMin = Math.min(this.A0J, this.A09);
        A0D(this.A0A, i, iMin);
        int frameCount = this.A09;
        this.A09 = frameCount - iMin;
        return iMin;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060  */
    /* JADX WARN: Code duplicated, block: B:23:0x0090  */
    private int A01(short[] sArr, int i) {
        int i2;
        int minP;
        int i3;
        if (this.A0H > 4000) {
            int i4 = this.A0H;
            String[] strArr = A0M;
            if (strArr[5].charAt(14) == strArr[2].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[6] = "iRmgjShaaw1sm3udODFNn2e0bKNj8EZU";
            strArr2[0] = "9WmESFVRlvNr2dpeI7WR7OdKwlQav9FK";
            i2 = i4 / 4000;
        } else {
            i2 = 1;
        }
        int skip = this.A0G;
        if (skip == 1 && i2 == 1) {
            int i5 = this.A0K;
            int skip2 = this.A0I;
            minP = A04(sArr, i, i5, skip2);
        } else {
            A0E(sArr, i, i2);
            short[] sArr2 = this.A0L;
            int i6 = this.A0K / i2;
            int skip3 = this.A0I;
            minP = A04(sArr2, 0, i6, skip3 / i2);
            if (i2 != 1) {
                int minP2 = minP * i2;
                int skip4 = i2 * 4;
                int period = minP2 - skip4;
                int i7 = (i2 * 4) + minP2;
                int skip5 = this.A0K;
                if (period < skip5) {
                    period = this.A0K;
                }
                int skip6 = this.A0I;
                if (i7 > skip6) {
                    i7 = this.A0I;
                }
                int skip7 = this.A0G;
                if (skip7 == 1) {
                    minP = A04(sArr, i, period, i7);
                } else {
                    A0E(sArr, i, 1);
                    minP = A04(this.A0L, 0, period, i7);
                }
            }
        }
        int i8 = this.A02;
        int i9 = this.A01;
        String[] strArr3 = A0M;
        String str = strArr3[1];
        String str2 = strArr3[3];
        int period2 = str.length();
        int skip8 = str2.length();
        if (period2 != skip8) {
            String[] strArr4 = A0M;
            strArr4[1] = "LoOMyfdVj0AnniYCysqFPvgGdyMa";
            strArr4[3] = InneractiveMediationDefs.GENDER_FEMALE;
            if (A0F(i8, i9)) {
                i3 = this.A08;
            } else {
                i3 = minP;
            }
        } else if (A0F(i8, i9)) {
            i3 = this.A08;
        } else {
            i3 = minP;
        }
        int maxP = this.A02;
        String[] strArr5 = A0M;
        String str3 = strArr5[4];
        String str4 = strArr5[7];
        int period3 = str3.charAt(16);
        int skip9 = str4.charAt(16);
        if (period3 != skip9) {
            String[] strArr6 = A0M;
            strArr6[4] = "R9SrYNdGALqFcYh840FYavtkH9aBkNb2";
            strArr6[7] = "xqV5UMAQpj40aqc8P06ikFm0mF88wNdT";
            this.A07 = maxP;
            this.A08 = minP;
            return i3;
        }
        String[] strArr7 = A0M;
        strArr7[1] = "psXfuU1S4uW98rCe9FXIJv1V5RCM";
        strArr7[3] = "O";
        this.A07 = maxP;
        this.A08 = minP;
        return i3;
    }

    private int A02(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            float f2 = (i2 * f) / (1.0f - f);
            String[] strArr = A0M;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[6] = "K5m6aGWcLq3rgbiPwQQLX59JZaITOBon";
            strArr2[0] = "LsmWvOtDmwibEtQwbar92p2hWPRdmQNn";
            i3 = (int) f2;
        } else {
            i3 = i2;
            int newFrameCount = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            this.A09 = newFrameCount;
        }
        int newFrameCount2 = i2 + i3;
        this.A0B = A0G(this.A0B, this.A05, newFrameCount2);
        int i4 = this.A0G * i;
        short[] sArr2 = this.A0B;
        int i5 = this.A05;
        int newFrameCount3 = this.A0G;
        int i6 = i5 * newFrameCount3;
        int newFrameCount4 = this.A0G;
        System.arraycopy(sArr, i4, sArr2, i6, newFrameCount4 * i2);
        A0C(i3, this.A0G, this.A0B, this.A05 + i2, sArr, i + i2, sArr, i);
        int newFrameCount5 = this.A05;
        this.A05 = newFrameCount5 + i2 + i3;
        return i3;
    }

    private int A03(short[] sArr, int i, float f, int i2) {
        int newFrameCount;
        if (f >= 2.0f) {
            newFrameCount = (int) (i2 / (f - 1.0f));
        } else {
            this.A09 = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            newFrameCount = i2;
        }
        short[] sArr2 = this.A0B;
        int newFrameCount2 = this.A05;
        this.A0B = A0G(sArr2, newFrameCount2, newFrameCount);
        A0C(newFrameCount, this.A0G, this.A0B, this.A05, sArr, i, sArr, i + i2);
        int newFrameCount3 = this.A05;
        this.A05 = newFrameCount3 + newFrameCount;
        return newFrameCount;
    }

    private int A04(short[] sArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 255;
        int period = 1;
        int maxDiff = 0;
        int bestPeriod = this.A0G;
        int i6 = i * bestPeriod;
        while (i2 <= i3) {
            int diff = 0;
            for (int minDiff = 0; minDiff < i2; minDiff++) {
                int bestPeriod2 = i6 + minDiff;
                short s = sArr[bestPeriod2];
                int bestPeriod3 = i6 + i2;
                int worstPeriod = s - sArr[bestPeriod3 + minDiff];
                int bestPeriod4 = Math.abs(worstPeriod);
                diff += bestPeriod4;
            }
            int worstPeriod2 = diff * i4;
            int bestPeriod5 = period * i2;
            if (worstPeriod2 < bestPeriod5) {
                period = diff;
                i4 = i2;
            }
            int worstPeriod3 = diff * i5;
            int bestPeriod6 = maxDiff * i2;
            if (worstPeriod3 > bestPeriod6) {
                maxDiff = diff;
                i5 = i2;
            }
            i2++;
        }
        this.A02 = period / i4;
        this.A01 = maxDiff / i5;
        return i4;
    }

    private short A05(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.A0G + i];
        int leftPosition = this.A03 * i2;
        int i4 = this.A04 * i3;
        int position = (this.A04 + 1) * i3;
        int i5 = position - leftPosition;
        int position2 = position - i4;
        short left = (short) (((i5 * s) + ((position2 - i5) * s2)) / position2);
        return left;
    }

    private void A06() {
        int i = this.A05;
        float f = this.A0F / this.A0D;
        float f2 = this.A0E * this.A0D;
        if (f > 1.00001d || f < 0.99999d) {
            A07(f);
        } else {
            A0D(this.A0A, 0, this.A00);
            this.A00 = 0;
        }
        if (f2 != 1.0f) {
            A08(f2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x0085  */
    private void A07(float f) {
        int frameCount;
        if (this.A00 < this.A0J) {
            return;
        }
        int i = this.A00;
        int i2 = 0;
        do {
            int i3 = this.A09;
            String[] strArr = A0M;
            String str = strArr[5];
            String str2 = strArr[2];
            int positionFrames = str.charAt(14);
            int frameCount2 = str2.charAt(14);
            if (positionFrames == frameCount2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[1] = "scjeX6US3ZHLg2z2iUc3vQRSHPhA";
            strArr2[3] = "Z";
            if (i3 > 0) {
                int frameCount3 = A00(i2);
                i2 += frameCount3;
            } else {
                int iA01 = A01(this.A0A, i2);
                String[] strArr3 = A0M;
                String str3 = strArr3[6];
                String str4 = strArr3[0];
                int positionFrames2 = str3.charAt(2);
                int frameCount4 = str4.charAt(2);
                if (positionFrames2 != frameCount4) {
                    String[] strArr4 = A0M;
                    strArr4[6] = "xuma6ybetVHFpOM3ZgtMVw3Ab3NyEq3r";
                    strArr4[0] = "7pmqk4VYWOpVB9E55Zklf5LwzHUsUloa";
                    if (f > 1.0d) {
                        int frameCount5 = A03(this.A0A, i2, f, iA01);
                        i2 += frameCount5 + iA01;
                    } else {
                        int frameCount6 = A02(this.A0A, i2, f, iA01);
                        i2 += frameCount6;
                    }
                } else {
                    String[] strArr5 = A0M;
                    strArr5[5] = "wUwDrg56jnH9JJOTFVTDM6fH5N4GxsKJ";
                    strArr5[2] = "6qCXcPZgRDinLxbiwDUx4Lym6mPEzEwx";
                    if (f > 1.0d) {
                        int frameCount7 = A03(this.A0A, i2, f, iA01);
                        i2 += frameCount7 + iA01;
                    } else {
                        int frameCount8 = A02(this.A0A, i2, f, iA01);
                        i2 += frameCount8;
                    }
                }
            }
            frameCount = this.A0J;
        } while (frameCount + i2 <= i);
        A0B(i2);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
    private void A08(float f, int i) {
        if (this.A05 == i) {
            return;
        }
        int i2 = (int) (this.A0H / f);
        int i3 = this.A0H;
        while (true) {
            if (i2 <= 16384 && i3 <= 16384) {
                break;
            }
            i2 /= 2;
            i3 /= 2;
        }
        A09(i);
        int i4 = 0;
        while (true) {
            int newSampleRate = this.A06;
            if (i4 < newSampleRate - 1) {
                while (true) {
                    int i5 = (this.A04 + 1) * i2;
                    int i6 = this.A03;
                    String[] strArr = A0M;
                    String str = strArr[5];
                    String str2 = strArr[2];
                    int oldSampleRate = str.charAt(14);
                    int newSampleRate2 = str2.charAt(14);
                    if (oldSampleRate == newSampleRate2) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0M;
                    strArr2[1] = "tRR48L0LxsmsHajeI0QXqTSJZJLI";
                    strArr2[3] = "Y";
                    if (i5 > i6 * i3) {
                        short[] sArr = this.A0B;
                        int newSampleRate3 = this.A05;
                        this.A0B = A0G(sArr, newSampleRate3, 1);
                        for (int i7 = 0; i7 < newSampleRate; i7++) {
                            short[] sArr2 = this.A0B;
                            int position = this.A05;
                            int newSampleRate4 = this.A0G;
                            int position2 = (position * newSampleRate4) + i7;
                            short[] sArr3 = this.A0C;
                            int newSampleRate5 = this.A0G;
                            sArr2[position2] = A05(sArr3, (newSampleRate5 * i4) + i7, i3, i2);
                        }
                        int newSampleRate6 = this.A03;
                        this.A03 = newSampleRate6 + 1;
                        int newSampleRate7 = this.A05;
                        this.A05 = newSampleRate7 + 1;
                    }
                }
                int i8 = this.A04 + 1;
                String[] strArr3 = A0M;
                String str3 = strArr3[1];
                String str4 = strArr3[3];
                int oldSampleRate2 = str3.length();
                int newSampleRate8 = str4.length();
                if (oldSampleRate2 != newSampleRate8) {
                    String[] strArr4 = A0M;
                    strArr4[5] = "kDaEzZElnOFQMAMJwWxti37YUPYjrInx";
                    strArr4[2] = "OX0JIbuly1Y9DotOXhwmXUl8HdrOPVUG";
                    this.A04 = i8;
                    int newSampleRate9 = this.A04;
                    if (newSampleRate9 == i3) {
                        this.A04 = 0;
                        int newSampleRate10 = this.A03;
                        AbstractC2388es.A08(newSampleRate10 == i2);
                        this.A03 = 0;
                    }
                } else {
                    String[] strArr5 = A0M;
                    strArr5[4] = "k5CMBLvzUinTucSIgvM2ofDUgwgNJhuf";
                    strArr5[7] = "0hvoh8RRl8vog5e2liIHSOPz5wyjvijZ";
                    this.A04 = i8;
                    int newSampleRate11 = this.A04;
                    if (newSampleRate11 == i3) {
                        this.A04 = 0;
                        int newSampleRate12 = this.A03;
                        AbstractC2388es.A08(newSampleRate12 == i2);
                        this.A03 = 0;
                    }
                }
                i4++;
            } else {
                int newSampleRate13 = this.A06;
                A0A(newSampleRate13 - 1);
                return;
            }
        }
    }

    private void A09(int i) {
        int i2 = this.A05 - i;
        short[] sArr = this.A0C;
        int frameCount = this.A06;
        this.A0C = A0G(sArr, frameCount, i2);
        short[] sArr2 = this.A0B;
        int i3 = this.A0G * i;
        short[] sArr3 = this.A0C;
        int i4 = this.A06;
        int frameCount2 = this.A0G;
        int i5 = i4 * frameCount2;
        int frameCount3 = this.A0G;
        System.arraycopy(sArr2, i3, sArr3, i5, frameCount3 * i2);
        this.A05 = i;
        int frameCount4 = this.A06;
        this.A06 = frameCount4 + i2;
    }

    private void A0A(int i) {
        if (i == 0) {
            return;
        }
        System.arraycopy(this.A0C, this.A0G * i, this.A0C, 0, (this.A06 - i) * this.A0G);
        this.A06 -= i;
    }

    private void A0B(int i) {
        int i2 = this.A00 - i;
        System.arraycopy(this.A0A, this.A0G * i, this.A0A, 0, this.A0G * i2);
        this.A00 = i2;
    }

    public static void A0C(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int t = (i5 * i2) + i6;
            int d = (i4 * i2) + i6;
            for (int u = 0; u < i; u++) {
                int i8 = i - u;
                int o = sArr2[d] * i8;
                int i9 = sArr3[t] * u;
                sArr[i7] = (short) ((o + i9) / i);
                i7 += i2;
                d += i2;
                t += i2;
            }
        }
    }

    private void A0D(short[] sArr, int i, int i2) {
        this.A0B = A0G(this.A0B, this.A05, i2);
        System.arraycopy(sArr, this.A0G * i, this.A0B, this.A05 * this.A0G, this.A0G * i2);
        this.A05 += i2;
    }

    private void A0E(short[] sArr, int i, int i2) {
        int i3 = this.A0J / i2;
        int j = this.A0G * i2;
        int frameCount = this.A0G;
        int i4 = i * frameCount;
        for (int value = 0; value < i3; value++) {
            int i5 = 0;
            for (int samplesPerValue = 0; samplesPerValue < j; samplesPerValue++) {
                int frameCount2 = value * j;
                i5 += sArr[frameCount2 + i4 + samplesPerValue];
            }
            this.A0L[value] = (short) (i5 / j);
        }
    }

    private boolean A0F(int i, int i2) {
        if (i != 0) {
            int i3 = this.A08;
            String[] strArr = A0M;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[1] = "1idtnhWPxnw4XJ1NpfbvLRsBiVrx";
            strArr2[3] = "1";
            if (i3 == 0 || i2 > i * 3 || i * 2 <= this.A07 * 3) {
                return false;
            }
            return true;
        }
        return false;
    }

    private short[] A0G(short[] sArr, int i, int i2) {
        int length = sArr.length / this.A0G;
        if (i + i2 <= length) {
            return sArr;
        }
        int currentCapacityFrames = length * 3;
        int i3 = (currentCapacityFrames / 2) + i2;
        int i4 = this.A0G;
        String[] strArr = A0M;
        String str = strArr[4];
        String str2 = strArr[7];
        int newCapacityFrames = str.charAt(16);
        int currentCapacityFrames2 = str2.charAt(16);
        if (newCapacityFrames == currentCapacityFrames2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0M;
        strArr2[6] = "dZm6Ae9J9bKjxiNtqzervrTMrx3o3qym";
        strArr2[0] = "fymny454LVZnv8QoAjBzuSSckcTlUd7Z";
        return Arrays.copyOf(sArr, i4 * i3);
    }

    public final int A0H() {
        return this.A05 * this.A0G * 2;
    }

    public final int A0I() {
        return this.A00 * this.A0G * 2;
    }

    public final void A0J() {
        this.A00 = 0;
        this.A05 = 0;
        this.A06 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A09 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0K() {
        int i = this.A00;
        float f = this.A0F / this.A0D;
        float r = this.A0E * this.A0D;
        int i2 = this.A05;
        float s = i;
        int remainingFrameCount = this.A06;
        int i3 = i2 + ((int) ((((s / f) + remainingFrameCount) / r) + 0.5f));
        short[] sArr = this.A0A;
        int i4 = this.A00;
        int remainingFrameCount2 = this.A0J;
        this.A0A = A0G(sArr, i4, (remainingFrameCount2 * 2) + i);
        int expectedOutputFrames = 0;
        while (true) {
            int remainingFrameCount3 = this.A0J;
            int i5 = remainingFrameCount3 * 2;
            int remainingFrameCount4 = this.A0G;
            if (expectedOutputFrames >= i5 * remainingFrameCount4) {
                break;
            }
            short[] sArr2 = this.A0A;
            int remainingFrameCount5 = this.A0G;
            sArr2[(remainingFrameCount5 * i) + expectedOutputFrames] = 0;
            expectedOutputFrames++;
        }
        int i6 = this.A00;
        int remainingFrameCount6 = this.A0J;
        this.A00 = i6 + (remainingFrameCount6 * 2);
        A06();
        int remainingFrameCount7 = this.A05;
        if (remainingFrameCount7 > i3) {
            this.A05 = i3;
        }
        this.A00 = 0;
        this.A09 = 0;
        this.A06 = 0;
    }

    public final void A0L(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.A0G, this.A05);
        short[] sArr = this.A0B;
        int framesToRead = this.A0G;
        shortBuffer.put(sArr, 0, framesToRead * iMin);
        int framesToRead2 = this.A05;
        this.A05 = framesToRead2 - iMin;
        short[] sArr2 = this.A0B;
        int i = this.A0G * iMin;
        short[] sArr3 = this.A0B;
        int i2 = this.A05;
        int framesToRead3 = this.A0G;
        System.arraycopy(sArr2, i, sArr3, 0, i2 * framesToRead3);
    }

    public final void A0M(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining() / this.A0G;
        int framesToWrite = this.A0G;
        int i = framesToWrite * iRemaining * 2;
        short[] sArr = this.A0A;
        int framesToWrite2 = this.A00;
        this.A0A = A0G(sArr, framesToWrite2, iRemaining);
        short[] sArr2 = this.A0A;
        int bytesToWrite = this.A00;
        int framesToWrite3 = this.A0G;
        int bytesToWrite2 = bytesToWrite * framesToWrite3;
        int framesToWrite4 = i / 2;
        shortBuffer.get(sArr2, bytesToWrite2, framesToWrite4);
        int framesToWrite5 = this.A00;
        this.A00 = framesToWrite5 + iRemaining;
        A06();
    }
}
