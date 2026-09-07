package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.35, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass35 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.VT, 77, 81, 72, 73};
    }

    public static void A02(C2699k1 c2699k1, AbstractC2855md abstractC2855md, boolean z, AnonymousClass33 anonymousClass33) {
        if (!C14499m.A25(c2699k1)) {
            C14067t c14067t = new C14067t(c2699k1);
            C12752p c12752pA07 = abstractC2855md.A1b().A0F().A07();
            c14067t.A0d(new AF(abstractC2855md.A1g(), c2699k1.A0A()));
            if (c12752pA07 == null) {
                anonymousClass33.AET(AdError.CACHE_ERROR);
                return;
            }
            if (c12752pA07.A0O()) {
                anonymousClass33.AEU();
                return;
            }
            C14027p c14027p = new C14027p(c12752pA07.A0F(), abstractC2855md.A0r(), abstractC2855md.A0i());
            c14027p.A04 = true;
            c14027p.A03 = A00(0, 5, 86);
            switch (AnonymousClass32.A00[c12752pA07.A0A().ordinal()]) {
                case 1:
                case 2:
                    c14067t.A0X(c14027p);
                    break;
            }
            c14067t.A0b(new C14047r(abstractC2855md.A1e().A01(), -1, -1, abstractC2855md.A0r(), abstractC2855md.A0i()));
            c14067t.A0b(new C14047r(c12752pA07.A0E(), -1, -1, abstractC2855md.A0r(), abstractC2855md.A0i()));
            c14067t.A0W(new mQ(c2699k1, anonymousClass33, c14067t, c12752pA07, z), new C13997m(abstractC2855md.A0r(), abstractC2855md.A0i()));
            return;
        }
        anonymousClass33.AEU();
    }
}
