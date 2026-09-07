package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ml, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2863ml extends AnonymousClass25 {
    public static byte[] A02;
    public final C2860mi A00;
    public final A7 A01;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 69, 74, 74, 65, 86};
    }

    public C2863ml(C2699k1 c2699k1, AnonymousClass26 anonymousClass26, JL jl, A7 a7, C2860mi c2860mi) {
        super(c2699k1, anonymousClass26, jl);
        this.A01 = a7;
        this.A00 = c2860mi;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass25
    public final void A08(Map<String, String> map) {
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7E())) {
            this.A02.A0F().A3B();
            AbstractC12863a.A02(this.A00.A0X(), AbstractC1501Ce.A00(A01(0, 6, 62)));
            this.A01.AB0(this.A00.A7E(), map);
            if (C14499m.A18(this.A02)) {
                String string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                C1485Bh c1485BhA00 = C1485Bh.A00(this.A02);
                String placementType = this.A00.A7E();
                c1485BhA00.A0E(string, placementType);
            }
        }
    }
}
