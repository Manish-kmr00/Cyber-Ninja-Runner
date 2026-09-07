package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class UZ {
    public static byte[] A00;
    public static String[] A01 = {"M7wI3H9FKzyXVcVHGmWAFEry0q8odmLA", "o2SZ1XZGvIBjcWLMlCSx1X7Fx3wtWrqZ", "TserLfyOTj8VBRtLTJ5dR", "zLaWO7ikrlhAyuDayzui0JFw5msxIogc", "nPEYcqSgayQktn2vQb4aQlCK0KOLR3q4", "yb5C2oRIBk14u", "EK9vLgIU0kFgoLLRCkDXyLA1czjYHcFq", "QtuV0fNvLWrUpfezcoySJHCiZo0jn0hl"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;
    public static final String[] A08;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-125, -105, -122, -117, -111, 81, -113, -110, -121, -119, -91, -71, -88, -83, -77, 115, -79, -76, -87, -85, 113, -112, 117, -4, Ascii.DLE, -1, 4, 10, -54, 8, Ascii.VT, 0, 2, -56, -25, -51};
    }

    static {
        A05();
        A08 = new String[]{A04(10, 13, 40), A04(23, 13, 127), A04(0, 10, 6)};
        A07 = new int[]{44100, 48000, 32000};
        A02 = new int[]{32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
        A06 = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
        A03 = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
        A04 = new int[]{32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
        A05 = new int[]{8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};
    }

    public static int A00(int i) {
        int i2;
        int layer;
        int padding;
        int i3;
        int version;
        int version2;
        if (!A06(i) || (i2 = (i >>> 19) & 3) == 1 || (layer = (i >>> 17) & 3) == 0 || (padding = (i >>> 12) & 15) == 0 || padding == 15 || (i3 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i4 = A07[i3];
        if (i2 == 2) {
            i4 /= 2;
        } else if (i2 == 0) {
            i4 /= 4;
        }
        int i5 = (i >>> 9) & 1;
        if (layer == 3) {
            if (i2 == 3) {
                int version3 = padding - 1;
                version2 = A02[version3];
            } else {
                int[] iArr = A06;
                int layer2 = padding - 1;
                String[] strArr = A01;
                String str = strArr[6];
                String str2 = strArr[1];
                int samplingRate = str.charAt(14);
                int version4 = str2.charAt(14);
                if (samplingRate != version4) {
                    throw new RuntimeException();
                }
                A01[2] = "CnikfV3xS98UFi7I8CE6P";
                version2 = iArr[layer2];
            }
            return (((version2 * 12) / i4) + i5) * 4;
        }
        if (i2 == 3) {
            if (layer == 2) {
                int version5 = padding - 1;
                version = A03[version5];
            } else {
                int[] iArr2 = A04;
                int samplingRate2 = A01[5].length();
                if (samplingRate2 == 6) {
                    throw new RuntimeException();
                }
                A01[5] = "f7Zn6tT0yAQk6";
                int version6 = padding - 1;
                version = iArr2[version6];
            }
        } else {
            int version7 = padding - 1;
            version = A05[version7];
        }
        if (i2 == 3) {
            return ((version * 144) / i4) + i5;
        }
        int layer3 = (layer == 1 ? 72 : 144) * version;
        String[] strArr2 = A01;
        String str3 = strArr2[6];
        String str4 = strArr2[1];
        int samplingRate3 = str3.charAt(14);
        int version8 = str4.charAt(14);
        if (samplingRate3 != version8) {
            return (layer3 / i4) + i5;
        }
        String[] strArr3 = A01;
        strArr3[6] = "urVogKFAAE6EvZLSoKvQaC7d0asbupVR";
        strArr3[1] = "LF10raY6BFoWKGLxej2lL3VHQWOSRWl3";
        return (layer3 / i4) + i5;
    }

    public static int A01(int i) {
        int i2;
        int layer;
        if (!A06(i) || (i2 = (i >>> 19) & 3) == 1 || (layer = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i3 = (i >>> 12) & 15;
        int version = i >>> 10;
        int version2 = version & 3;
        if (i3 == 0 || i3 == 15 || version2 == 3) {
            return -1;
        }
        int version3 = A02(i2, layer);
        return version3;
    }

    public static int A02(int i, int i2) {
        switch (i2) {
            case 1:
                return i == 3 ? 1152 : 576;
            case 2:
                return 1152;
            case 3:
                return 384;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static boolean A06(int i) {
        return (i & (-2097152)) == -2097152;
    }
}
