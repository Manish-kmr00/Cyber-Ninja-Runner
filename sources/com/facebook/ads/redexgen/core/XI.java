package com.facebook.ads.redexgen.core;

import java.math.RoundingMode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XI implements SF {
    public static String[] A06 = {"8PSohjXuSVSSQDPwBEk", "t4Hs7Ww5mO", "dL6tDKFDisbczFE4WAH", "jK", "I2Knu4FHKWmKzAIGocqEGPSIKM5Ebenu", "oU6qdMEFBj7Q", "FG4aNIG5Q1nwekQrW7vkmgtQhCJQAtgs", "L4mxeaWDwRm38CsKuYKoovYUpfK4vvIi"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;

    public XI(SQ sq) {
        this.A02 = sq.A02;
        this.A01 = sq.A01;
        this.A05 = sq.A05;
        this.A04 = sq.A04;
        this.A03 = sq.A03;
        this.A00 = sq.A00;
    }

    public static int A00(int i) {
        switch (i) {
            case 5:
                if (A06[3].length() != 25) {
                    String[] strArr = A06;
                    strArr[4] = "BNG05qyRs2mZV6WD2rmbG5TRvUrt0eGk";
                    strArr[7] = "f7pZeUCsWRm1YQfuocLJBoPFWEnFN5sr";
                    return 80000;
                }
                break;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                if (A06[6].charAt(24) != 'h') {
                    return 8000;
                }
                A06[3] = "hq3SB86D";
                return 8000;
            case 16:
                return 256000;
            case 17:
                String[] strArr2 = A06;
                if (strArr2[0].length() != strArr2[2].length()) {
                    return 336000;
                }
                String[] strArr3 = A06;
                strArr3[4] = "zretzXJHVUmEyYFQ3HsMA6SRviHWyoZI";
                strArr3[7] = "jHwyp2Walmm6958uxilmU8mUGTGi9XkN";
                return 336000;
            case 20:
                if (A06[3].length() != 25) {
                    String[] strArr4 = A06;
                    strArr4[4] = "GG98vWUQIpm81pZ67nhUjotTNKFJDPYc";
                    strArr4[7] = "CM88IZf6dimqvH1qPpXPZSy9yQdWnxZ6";
                    return 63750;
                }
                break;
        }
        throw new RuntimeException();
    }

    private final int A01(int i) {
        int iA00 = A00(i);
        int maxByteRate = this.A03;
        return AbstractC1785Nn.A03((((long) maxByteRate) * ((long) iA00)) / 1000000);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0033  */
    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0078  */
    private final int A02(int i, int i2) {
        int bufferSizeUs;
        int i3 = this.A04;
        if (i == 5) {
            int i4 = this.A00;
            if (A06[3].length() == 25) {
                throw new RuntimeException();
            }
            A06[6] = "HEiFXpgQNZJM438kJFTLfuhxhOYS2rJs";
            i3 *= i4;
        }
        if (A06[3].length() != 25) {
            A06[1] = "5BWcMaWhPC";
            if (i2 == -1) {
                bufferSizeUs = A00(i);
            } else if (A06[3].length() != 25) {
                A06[3] = "oqpBsVMk";
                bufferSizeUs = AbstractC14158d.A00(i2, 8, RoundingMode.CEILING);
            } else {
                String[] strArr = A06;
                strArr[4] = "dB3ZnNprQ3mwz0ovSsH2ppCqzK69Sdyh";
                strArr[7] = "ydi5PNFjFVmG0Dyu8ClJ25s8lXu47j7S";
                bufferSizeUs = AbstractC14158d.A00(i2, 8, RoundingMode.CEILING);
            }
        } else {
            A06[1] = "axfHiDnGFw";
            if (i2 == -1) {
                bufferSizeUs = A00(i);
            } else if (A06[3].length() != 25) {
                A06[3] = "oqpBsVMk";
                bufferSizeUs = AbstractC14158d.A00(i2, 8, RoundingMode.CEILING);
            } else {
                String[] strArr2 = A06;
                strArr2[4] = "dB3ZnNprQ3mwz0ovSsH2ppCqzK69Sdyh";
                strArr2[7] = "ydi5PNFjFVmG0Dyu8ClJ25s8lXu47j7S";
                bufferSizeUs = AbstractC14158d.A00(i2, 8, RoundingMode.CEILING);
            }
        }
        return AbstractC1785Nn.A03((((long) i3) * ((long) bufferSizeUs)) / 1000000);
    }

    public static int A03(int i, int i2, int i3) {
        return AbstractC1785Nn.A03(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    private final int A04(int i, int i2, int i3) {
        int maxAppBufferSize = this.A05 * i;
        int targetBufferSize = this.A02;
        int minAppBufferSize = A03(targetBufferSize, i2, i3);
        int targetBufferSize2 = this.A01;
        return AbstractC2471gE.A07(maxAppBufferSize, minAppBufferSize, A03(targetBufferSize2, i2, i3));
    }

    private final int A05(int i, int i2, int i3, int i4, int i5, int i6) {
        switch (i3) {
            case 0:
                return A04(i, i5, i4);
            case 1:
                return A01(i2);
            case 2:
                return A02(i2, i6);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.SF
    public final int A6v(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int bufferSize = A05(i, i2, i3, i4, i5, i6);
        return (((Math.max(i, (int) (((double) bufferSize) * d)) + i4) - 1) / i4) * i4;
    }
}
