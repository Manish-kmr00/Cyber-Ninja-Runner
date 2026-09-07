package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class LC extends AbstractC2212c1 {
    public static byte[] A01;
    public final /* synthetic */ C1610Gj A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{19, 4, 4, Ascii.EM, 4};
    }

    public LC(C1610Gj c1610Gj) {
        this.A00 = c1610Gj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(C2213c2 c2213c2) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1608Gh(this));
        this.A00.A0B.AFZ(A00(0, 5, 126), this.A00.A03());
    }
}
