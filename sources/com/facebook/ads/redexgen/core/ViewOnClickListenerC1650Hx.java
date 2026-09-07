package com.facebook.ads.redexgen.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1650Hx implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1652Hz A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.EM, Ascii.SYN, Ascii.DC2, Ascii.NAK, Ascii.SYN, 35};
    }

    public ViewOnClickListenerC1650Hx(C1652Hz c1652Hz) {
        this.A00 = c1652Hz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0b == null) {
                return;
            }
            this.A00.A0b.A0A(A00(0, 6, 115));
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
