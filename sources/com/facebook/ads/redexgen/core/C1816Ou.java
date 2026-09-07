package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.view.WindowManager;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1816Ou implements InterfaceC2503gl {
    public static byte[] A01;
    public final WindowManager A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-21, -35, -30, -40, -29, -21};
    }

    public C1816Ou(WindowManager windowManager) {
        this.A00 = windowManager;
    }

    public static C1816Ou A00(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(A01(0, 6, 94));
        if (windowManager != null) {
            return new C1816Ou(windowManager);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2503gl
    public final void AGf(InterfaceC2502gk interfaceC2502gk) {
        interfaceC2502gk.ACs(this.A00.getDefaultDisplay());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2503gl
    public final void AJb() {
    }
}
