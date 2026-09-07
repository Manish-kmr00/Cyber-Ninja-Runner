package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RN {
    public static byte[] A02;
    public static String[] A03 = {"1US6jaMoLfGpUdFO5rmDhf8munMUTyyz", "AzwI5NnaLsYDkqk6vxyc9X5ibAo0j", "bfG8XRn5J4pxnZSTuSdJkmLDCGbun", "LGZKMOIwxUGb9Sa7WaeOQBxAqlkUXRPJ", "XIuy9XHvCvNpm8zIV9Uh3cYy8m4OrBcf", "c9D7XteEnB8TAAjE3iP2V", "fGg6yWitVF0MkDupRdkubu1xmLHdltJo", "145wIaprs64LJ0mAZomk5qtDjlaPGJU6"};
    public static final RN A04;
    public static final RN A05;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Prevent throwing when building the map")
    public static final AbstractC2804lm<Integer, Integer> A06;
    public final int A00;
    public final int[] A01;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{-61, -73, 10, Ascii.FF, 7, 7, 6, 9, Ascii.VT, -4, -5, -36, 5, -6, 6, -5, 0, 5, -2, 10, -44, -17, Ascii.ESC, Ascii.SI, 40, Ascii.GS, Ascii.FS, -69, -17, -34, -29, -23, -67, -37, -22, -37, -36, -29, -26, -29, -18, -29, -33, -19, -43, -25, -37, -14, -67, -30, -37, -24, -24, -33, -26, -67, -23, -17, -24, -18, -73, -53, -36, -44, -30, -32, -36, -38, Ascii.DC4, 33, Ascii.ETB, 37, 34, Ascii.FS, Ascii.ETB, -31, 32, Ascii.CAN, Ascii.ETB, Ascii.FS, Ascii.DC4, -31, Ascii.DC4, Ascii.SYN, 39, Ascii.FS, 34, 33, -31, -5, -9, 0, -4, Ascii.DC2, -12, 8, -9, -4, 2, Ascii.DC2, 3, -1, 8, -6, 33, 46, 36, 50, 47, 41, 36, -18, 45, 37, 36, 41, 33, -18, 37, 56, 52, 50, 33, -18, 1, Ascii.NAK, 4, 9, Ascii.SI, Ascii.US, Ascii.DLE, Ascii.FF, Ascii.NAK, 7, Ascii.US, 19, Ascii.DC4, 1, Ascii.DC4, 5, -46, -33, -43, -29, -32, -38, -43, -97, -34, -42, -43, -38, -46, -97, -42, -23, -27, -29, -46, -97, -74, -65, -76, -64, -75, -70, -65, -72, -60, -25, -12, -22, -8, -11, -17, -22, -76, -13, -21, -22, -17, -25, -76, -21, -2, -6, -8, -25, -76, -45, -57, -34, -27, -55, -50, -57, -44, -44, -53, -46, -27, -55, -43, -37, -44, -38, -12, 7, 3, -12, 1, -3, -16, -5, -18, 2, 4, 1, 1, -2, 4, -3, -13, -18, 2, -2, 4, -3, -13, -18, -12, -3, -16, -15, -5, -12, -13, Ascii.SUB, 41, Ascii.ESC, 41};
    }

    static {
        A06();
        A04 = new RN(new int[]{2}, 8);
        A05 = new RN(new int[]{2, 5, 6}, 8);
        A06 = new C2802lk().A05(5, 6).A05(17, 6).A05(7, 6).A05(18, 6).A05(6, 8).A05(8, 8).A05(14, 8).A07();
    }

    public RN(int[] iArr, int i) {
        if (iArr != null) {
            this.A01 = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.A01);
        } else {
            this.A01 = new int[0];
        }
        this.A00 = i;
    }

    public static int A00(int i) {
        if (AbstractC2471gE.A02 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        int i2 = AbstractC2471gE.A02;
        if (A03[7].charAt(31) == '6') {
            A03[3] = "PjNVoBzctyN0TP5o6Ocm4zn0aB65285e";
            if (i2 <= 26 && A05(237, 4, 84).equals(AbstractC2471gE.A03) && i == 1) {
                i = 2;
            }
            int iA01 = AbstractC2471gE.A01(i);
            if (A03[4].charAt(9) == 'v') {
                A03[6] = "O";
                return iA01;
            }
        }
        throw new RuntimeException();
    }

    public static int A01(int i, int i2) {
        if (AbstractC2471gE.A02 >= 29) {
            return RM.A00(i, i2);
        }
        Integer num = (Integer) AbstractC2388es.A01(A06.getOrDefault(Integer.valueOf(i), 0));
        if (A03[4].charAt(9) != 'v') {
            throw new RuntimeException();
        }
        A03[3] = "I3z5XyDQc75s0TeotCQipoKgEG1EPBKw";
        return num.intValue();
    }

    public static RN A02(Context context) {
        Intent intent = context.registerReceiver(null, new IntentFilter(A05(68, 36, 83)));
        return A03(context, intent);
    }

    public static RN A03(Context context, Intent intent) {
        if (A07() && Settings.Global.getInt(context.getContentResolver(), A05(206, 31, 47), 0) == 1) {
            RN rn = A05;
            String[] strArr = A03;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A03[7] = "dk3tU0JE1Vng71STUEPysAijWx9OcFI6";
            return rn;
        }
        if (AbstractC2471gE.A02 >= 29 && (AbstractC2471gE.A18(context) || AbstractC2471gE.A17(context))) {
            return new RN(RM.A01(), 8);
        }
        if (intent == null || intent.getIntExtra(A05(104, 36, 96), 0) == 0) {
            return A04;
        }
        return new RN(intent.getIntArrayExtra(A05(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 29, 17)), intent.getIntExtra(A05(169, 37, 38), 8));
    }

    public static boolean A07() {
        if (AbstractC2471gE.A02 >= 17) {
            if (A05(21, 6, 78).equals(AbstractC2471gE.A05) || A05(61, 6, 19).equals(AbstractC2471gE.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int A08() {
        return this.A00;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    public final Pair<Integer, Integer> A09(ZM zm) {
        int channelCount;
        int channelConfig = Q2.A03((String) AbstractC2388es.A01(zm.A0W), zm.A0R);
        if (!A06.containsKey(Integer.valueOf(channelConfig))) {
            return null;
        }
        if (channelConfig == 18 && !A0A(18)) {
            channelConfig = 6;
        } else if (A03[3].charAt(20) != 'y') {
            A03[4] = "wFhbJKy58v40Wk4KrqBPUxM5TkQcpYqq";
            if (channelConfig == 8) {
                if (!A0A(8)) {
                    channelConfig = 7;
                }
            }
        } else {
            A03[6] = "OgOTkedCY92WT2lC7F95vgytrFI";
            if (channelConfig == 8) {
                if (!A0A(8)) {
                    channelConfig = 7;
                }
            }
        }
        boolean zA0A = A0A(channelConfig);
        if (A03[6].length() == 21) {
            throw new RuntimeException();
        }
        A03[6] = "DjCP";
        if (!zA0A) {
            return null;
        }
        int encoding = zm.A06;
        if (encoding == -1 || channelConfig == 18) {
            int encoding2 = zm.A0G;
            int encoding3 = encoding2 != -1 ? zm.A0G : 48000;
            channelCount = A01(channelConfig, encoding3);
        } else {
            channelCount = zm.A06;
            int encoding4 = this.A00;
            if (channelCount > encoding4) {
                return null;
            }
        }
        int iA00 = A00(channelCount);
        int channelCount2 = A03[3].charAt(20);
        if (channelCount2 == 121) {
            throw new RuntimeException();
        }
        A03[7] = "Fa5CSkaQAVHEu7AwmMZt6eZBU8hEd6h6";
        if (iA00 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(channelConfig), Integer.valueOf(iA00));
    }

    public final boolean A0A(int i) {
        return Arrays.binarySearch(this.A01, i) >= 0;
    }

    public final boolean A0B(ZM zm) {
        return A09(zm) != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RN)) {
            return false;
        }
        RN rn = (RN) obj;
        return Arrays.equals(this.A01, rn.A01) && this.A00 == rn.A00;
    }

    public final int hashCode() {
        return this.A00 + (Arrays.hashCode(this.A01) * 31);
    }

    public final String toString() {
        return A05(27, 34, 26) + this.A00 + A05(0, 21, 55) + Arrays.toString(this.A01) + A05(67, 1, 29);
    }
}
