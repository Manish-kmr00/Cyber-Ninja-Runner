package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UY {
    public static String[] A07 = {"6lKD24rvA6twWAFCuJqLDndMy0MEJo", "fwW4l2njQMgwVF41THZpCuESW8WVOZss", "5HhdI5c5s9rdpF4P3cRZ0qP6CxCYrAd", "t2WB", "sDUMSVERNdaSzfrLvCzOgzt0UbxdCP", "cjk5xNWIWWK82xnznD733V6szPPR61", "OmoA69jtcEojmviRP3sKzbDSnT02", "4KPERwnIePM4i70x2ttJPrTSzfmQ"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public String A06;

    public final boolean A00(int i) {
        int i2;
        int padding;
        int samplingRateIndex;
        int i3;
        int version;
        int version2;
        if (!UZ.A06(i) || (i2 = (i >>> 19) & 3) == 1 || (padding = (i >>> 17) & 3) == 0 || (samplingRateIndex = (i >>> 12) & 15) == 0 || samplingRateIndex == 15 || (i3 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.A05 = i2;
        int version3 = 3 - padding;
        this.A06 = UZ.A08[version3];
        int version4 = UZ.A07[i3];
        this.A03 = version4;
        if (i2 == 2) {
            int version5 = this.A03;
            this.A03 = version5 / 2;
        } else if (i2 == 0) {
            int version6 = this.A03;
            this.A03 = version6 / 4;
        }
        int i4 = (i >>> 9) & 1;
        int version7 = UZ.A02(i2, padding);
        this.A04 = version7;
        if (padding == 3) {
            if (i2 == 3) {
                int version8 = samplingRateIndex - 1;
                version2 = UZ.A02[version8];
            } else {
                int version9 = samplingRateIndex - 1;
                version2 = UZ.A06[version9];
            }
            this.A00 = version2;
            int version10 = this.A00;
            int i5 = version10 * 12;
            int version11 = this.A03;
            this.A02 = ((i5 / version11) + i4) * 4;
        } else {
            if (i2 == 3) {
                if (padding == 2) {
                    int version12 = samplingRateIndex - 1;
                    version = UZ.A03[version12];
                } else {
                    int[] iArr = UZ.A04;
                    int samplingRateIndex2 = samplingRateIndex - 1;
                    if (A07[3].length() != 4) {
                        throw new RuntimeException();
                    }
                    A07[5] = "zIrhILeZHWAQOm3qlpNs0lQL3EWYD1";
                    version = iArr[samplingRateIndex2];
                }
                this.A00 = version;
                int version13 = this.A00;
                int i6 = version13 * 144;
                int version14 = this.A03;
                this.A02 = (i6 / version14) + i4;
            } else {
                int version15 = samplingRateIndex - 1;
                this.A00 = UZ.A05[version15];
                int i7 = padding == 1 ? 72 : 144;
                int version16 = this.A00;
                int i8 = i7 * version16;
                int version17 = this.A03;
                this.A02 = (i8 / version17) + i4;
            }
        }
        int version18 = i >> 6;
        this.A01 = (version18 & 3) == 3 ? 1 : 2;
        return true;
    }
}
