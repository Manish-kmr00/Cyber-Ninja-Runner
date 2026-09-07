package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1772Mx extends AbstractC2855md {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772012L;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{63, 60, 51, 51, 56, 47};
    }

    public C1772Mx(List<C2T> list) {
        super(list);
    }

    public static C1772Mx A02(JSONObject jSONObject, C2699k1 c2699k1) {
        C1772Mx c1772Mx = new C1772Mx(AbstractC2855md.A08(jSONObject, c2699k1, new C2854mc()));
        c1772Mx.A1k(jSONObject);
        c1772Mx.A10(A03(0, 6, 6));
        return c1772Mx;
    }

    @Override // com.facebook.ads.redexgen.core.C2S
    public final int A0X() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.C2S
    public final int A0Y() {
        return 0;
    }
}
