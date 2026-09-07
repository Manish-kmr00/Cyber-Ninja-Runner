package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Wo implements InterfaceC1903Sg {
    public static byte[] A00;
    public static String[] A01 = {"zYSyEqcvaKV9i5JfBsvNMejzZnWwKZR3", "M8CuSGHxp8ic3JsizurZMVcnnPDQ9pmz", "xLEL8QPiXNMCDPpowBG1Vnyk8ZxoKJUt", "VIbb5MTSuNDmS63TxgLhr1mV0LI6YyHu", "u1XlITDExvj1CYspmNtrg0bpZ8SJM6N7", "33Nt3dJnNLiG", "MI0Hm6FG52L4I0qBYyTGCl5CoD7zBQVp", "2gvDlJ5BR9WkzqxRYaOUWhlyqmMyAQbM"};
    public static final boolean A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[5].length() == 23) {
                throw new RuntimeException();
            }
            A01[5] = "Qj5aQ5xVHIIg7KkhjSRWqKJqCBPzgW";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-45, -40, -26, -44, -62, -57, -43, -50, -63, -19, -31, -6, -17, -18};
    }

    static {
        A01();
        A02 = A00(8, 6, 7).equals(AbstractC2471gE.A05) && (A00(4, 4, 8).equals(AbstractC2471gE.A06) || A00(0, 4, 25).equals(AbstractC2471gE.A06));
    }
}
