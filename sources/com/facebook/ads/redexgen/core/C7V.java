package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C7V {
    public static byte[] A00;
    public static String[] A01 = {"T8", "", "As3hIStO2xNa0GSSHrkEVjQu", "DXoFAMJTZKDaTyX0if7pZrkyLA7XvGsC", "niDMG5wZxQy0H8acRFWa8hH2XuraMrTN", "878XRXnWNCNw6FCwqGtfz4QO6Hd03tfb", "ID5FT62NpqbpmPra08cWCCHJVsi2pDHC", "txdj"};
    public static final AtomicReference<C7T> A02;
    public static final AtomicReference<String> A03;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[7].length() != 4) {
                throw new RuntimeException();
            }
            A01[6] = "PcSdqCtN9qYKSfDsPVWrfTZjyuiu0dLa";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
            i4++;
        }
    }

    public static void A05() {
        A00 = new byte[]{19, Ascii.ESC, Ascii.SYN, 17, 33, 40, Ascii.ETB, 36, 36, Ascii.ESC, Ascii.SYN, Ascii.ETB, 17, Ascii.SI, Ascii.CAN, Ascii.SI, Ascii.FS, 19, Ascii.CR, 43, 38, 40, 35, 33, 49, 56, 39, 52, 52, 43, 38, 39};
    }

    static {
        A05();
        A02 = new AtomicReference<>();
        A03 = new AtomicReference<>(A04(0, 0, 12));
    }

    public static C7T A00() {
        C7T advertisingIdInfo = A02.get();
        if (advertisingIdInfo == null) {
            return C7T.A00();
        }
        return advertisingIdInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.A03()) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C7T A01(com.facebook.ads.redexgen.core.AnonymousClass85 r5, com.facebook.ads.redexgen.core.C7T r6) {
        /*
            if (r6 == 0) goto Lc
            java.lang.String r0 = r6.A03()     // Catch: java.lang.Throwable -> L11
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L29
        Lc:
            com.facebook.ads.redexgen.X.7T r0 = com.facebook.ads.redexgen.core.AbstractC13887b.A00(r5)     // Catch: java.lang.Throwable -> L11
            return r0
        L11:
            r0 = move-exception
            com.facebook.ads.redexgen.X.8Z r5 = r5.A08()
            int r4 = com.facebook.ads.redexgen.core.AbstractC14128a.A1Q
            com.facebook.ads.redexgen.X.8b r3 = new com.facebook.ads.redexgen.X.8b
            r3.<init>(r0)
            r2 = 12
            r1 = 7
            r0 = 84
            java.lang.String r0 = A04(r2, r1, r0)
            r5.AAu(r0, r4, r3)
        L29:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C7V.A01(com.facebook.ads.redexgen.X.85, com.facebook.ads.redexgen.X.7T):com.facebook.ads.redexgen.X.7T");
    }

    public static C7T A02(AnonymousClass85 anonymousClass85, C7T c7t, C7U c7u) {
        C7W c7wA00 = null;
        try {
            if (AbstractC14489l.A06(anonymousClass85) && (c7t == null || TextUtils.isEmpty(c7t.A03()))) {
                c7wA00 = C7X.A00(anonymousClass85.getContentResolver());
            }
        } catch (Throwable th) {
            anonymousClass85.A08().AAu(A04(12, 7, 84), AbstractC14128a.A1S, new C14138b(th));
        }
        if (c7wA00 != null && c7wA00.A01 != null) {
            A03.set(c7wA00.A01);
            c7u.A05(c7wA00.A01);
        }
        if (c7t == null && c7wA00 != null && !TextUtils.isEmpty(c7wA00.A00)) {
            return new C7T(c7wA00.A00, c7wA00.A02, C7S.A04);
        }
        return c7t;
    }

    public static String A03() {
        String attributionId = A03.get();
        if (attributionId == null) {
            return A04(0, 0, 12);
        }
        return attributionId;
    }

    public static void A06(C7U c7u) {
        A02.set(c7u.A02());
        A03.set(c7u.A03());
    }

    public static void A07(AnonymousClass85 anonymousClass85) {
        long jA01;
        C7T advertisingIdInfo;
        try {
            C7U c7u = new C7U(anonymousClass85);
            A06(c7u);
            if (A08()) {
                return;
            }
            C7T advertisingIdInfo2 = A02.get();
            if (advertisingIdInfo2 != null && !TextUtils.isEmpty(advertisingIdInfo2.A03())) {
                jA01 = advertisingIdInfo2.A01();
            } else {
                jA01 = -1;
            }
            if (jA01 > 0 && System.currentTimeMillis() - jA01 < AbstractC14489l.A00(anonymousClass85)) {
                return;
            }
            if (AbstractC14489l.A07(anonymousClass85)) {
                advertisingIdInfo = A01(anonymousClass85, A02(anonymousClass85, null, c7u));
            } else {
                advertisingIdInfo = A02(anonymousClass85, A01(anonymousClass85, null), c7u);
            }
            if (advertisingIdInfo != null && !TextUtils.isEmpty(advertisingIdInfo.A03())) {
                A02.set(advertisingIdInfo);
                c7u.A04(advertisingIdInfo);
            }
        } catch (Throwable t) {
            anonymousClass85.A08().AAu(A04(12, 7, 84), AbstractC14128a.A1R, new C14138b(t));
        }
    }

    public static boolean A08() {
        boolean z = false;
        boolean updated = C7.A04();
        if (updated) {
            String strA04 = A04(0, 12, 92);
            boolean updated2 = C7.A05(strA04);
            if (updated2) {
                A03.set(C7.A01(strA04));
                z = true;
            }
        }
        boolean zA04 = C7.A04();
        if (A01[7].length() != 4) {
            throw new RuntimeException();
        }
        A01[6] = "Cpq5b7Aomj18wFHDN8BPNJlk9AiHAVMm";
        if (!zA04) {
            return z;
        }
        String strA05 = A04(19, 13, 108);
        boolean updated3 = C7.A05(strA05);
        if (updated3) {
            String strA01 = C7.A01(strA05);
            AtomicReference<C7T> atomicReference = A02;
            if (strA01 == null) {
                if (A01[7].length() != 4) {
                    A01[7] = "Ywke";
                    strA01 = A04(0, 0, 2);
                } else {
                    A01[5] = "aB8iQRCNNWTx0AWcZvgXlT81SikGsrWB";
                    strA01 = A04(0, 0, 12);
                }
            }
            atomicReference.set(new C7T(strA01, false, C7S.A03));
            return true;
        }
        return z;
    }
}
