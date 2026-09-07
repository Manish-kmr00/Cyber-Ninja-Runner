package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13917e {
    public static InterfaceC13927f A00;
    public static boolean A01;
    public static byte[] A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-91, -88, -79, -90, -85, -80, -92, -75, -82};
    }

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (C13917e.class) {
            if (A00 == null) {
                return;
            }
            C14138b c14138b = new C14138b(A00.AHh());
            c14138b.A05(1);
            C2698k0 c2698k0A00 = AnonymousClass84.A00();
            if (c2698k0A00 != null) {
                c2698k0A00.A08().AAu(A00(0, 9, 49), 3401, c14138b);
            }
            A00.reset();
        }
    }

    public static void A03(final long j) {
        if (j > 0) {
            A00 = new C2708kA();
            new Thread(j) { // from class: com.facebook.ads.redexgen.X.7g
                public final long A00;

                {
                    this.A00 = j;
                    start();
                }

                /* JADX WARN: Bottom block not found for handler: all -> 0x0011 */
                @Override // java.lang.Thread, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() throws java.lang.Throwable {
                    /*
                        r3 = this;
                        boolean r0 = com.facebook.ads.redexgen.core.BQ.A02(r3)
                        if (r0 == 0) goto L7
                        return
                    L7:
                        r2 = r3
                    L8:
                        long r0 = r2.A00     // Catch: java.lang.InterruptedException -> Ld java.lang.Throwable -> L11
                        java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> Ld java.lang.Throwable -> L11
                    Ld:
                        com.facebook.ads.redexgen.core.C13917e.A01()     // Catch: java.lang.Throwable -> L11
                        goto L8
                    L11:
                        r0 = move-exception
                        com.facebook.ads.redexgen.core.BQ.A00(r0, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C13937g.run():void");
                }
            };
        }
    }
}
