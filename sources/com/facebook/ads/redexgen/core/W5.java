package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class W5 {
    public static byte[] A01;
    public static String[] A02 = {"bvAS8QhIU7qqjqNMCjD9geIBvVoX0Pps", "PGhTsFvHLKznT2fZPwhTMN8QuFwrxLpQ", "N9iEossqYVTzMdjm65ztuAuPEECgk5EO", "XY3ggvLUm8fGZbCvDlHWybnwi0bIrXlg", "lzQX0UbHRchKxyOFx5EOrRh159SzwIfb", "WWHV0rYuZLTZYcSwde", "BW6FotkyWlgx1AZkz7", "8wWVk3PL6rIpIXoIc0zLzjQyxyw5ZOGX"};

    @MetaExoPlayerCustomization("Adding TYPE_xml")
    public static final int A03;
    public final int A00;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[1].charAt(2) == '8') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[6] = "FM9oOeknYlLzqm7lR3";
            strArr[5] = "RfrWPDoB2UFGqrI69O";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 20);
            i4++;
        }
    }

    public static void A06() {
        A01 = new byte[]{104, 125, 124, 48};
    }

    static {
        A06();
        A03 = AbstractC2471gE.A0D(A05(0, 4, 4));
    }

    public W5(int i) {
        this.A00 = i;
    }

    public static int A02(int i) {
        return 16777215 & i;
    }

    public static int A03(int i) {
        return (i >> 24) & 255;
    }

    public static String A04(int i) {
        return A05(0, 0, 100) + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public String toString() {
        return A04(this.A00);
    }
}
