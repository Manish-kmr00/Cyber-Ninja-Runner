package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.36, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass36 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 76, 80, 73, 72, 121, 126, 100, 117, 98, 99, 100, 121, 100, 121, 113, 124, 101, 114, 96, 118, 101, 115, 114, 115, 72, 97, 126, 115, 114, 120};
    }

    public static void A02(C2699k1 c2699k1, C14067t c14067t, C1769Mu c1769Mu) {
        c14067t.A0c(new C14047r(c1769Mu.A1e().A01(), C1628Hb.A04, C1628Hb.A04, c1769Mu.A0r(), A00(17, 14, 113)));
        boolean zA1F = c1769Mu.A1F();
        if (zA1F) {
            C14027p c14027p = new C14027p(c1769Mu.A0f(), c1769Mu.A0r(), A00(17, 14, 113));
            c14027p.A04 = true;
            c14027p.A03 = A00(0, 5, 66);
            c14067t.A0X(c14027p);
        }
        boolean isDSL = J3.A03();
        boolean zA2q = C14499m.A2q(c2699k1, isDSL);
        C14027p c14027p2 = new C14027p(c1769Mu.A1b().A0F().A09(), c1769Mu.A0r(), A00(17, 14, 113), c1769Mu.A1b().A0F().A06());
        if (zA1F && !zA2q) {
            c14067t.A0X(c14027p2);
        } else {
            c14067t.A0a(c14027p2);
        }
        c14067t.A0c(new C14047r(c1769Mu.A1b().A0F().A08(), AnonymousClass31.A00(c1769Mu.A1b().A0F()), AnonymousClass31.A01(c1769Mu.A1b().A0F()), c1769Mu.A0r(), A00(17, 14, 113)));
        Iterator<String> it = c1769Mu.A1b().A0I().A02().iterator();
        while (isDSL) {
            String url = it.next();
            c14067t.A0c(new C14047r(url, -1, -1, c1769Mu.A0r(), A00(17, 14, 113)));
        }
    }

    public static void A03(C2699k1 c2699k1, C14067t c14067t, C1769Mu c1769Mu) {
        int i = 0;
        for (C2T c2t : c1769Mu.A1i()) {
            C14047r c14047r = new C14047r(c2t.A0F().A08(), AnonymousClass31.A00(c2t.A0F()), AnonymousClass31.A01(c2t.A0F()), c1769Mu.A0r(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
            if (i == 0) {
                c14067t.A0b(c14047r);
            } else {
                c14067t.A0c(c14047r);
            }
            Iterator<String> it = c2t.A0I().A02().iterator();
            while (it.hasNext()) {
                c14067t.A0c(new C14047r(it.next(), -1, -1, c1769Mu.A0r(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)));
            }
            if (!TextUtils.isEmpty(c2t.A0F().A09())) {
                new C14027p(c2t.A0F().A09(), c1769Mu.A0r(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), c2t.A0F().A06()).A04 = false;
            }
            i++;
        }
    }
}
