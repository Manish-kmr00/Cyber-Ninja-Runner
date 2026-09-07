package com.facebook.ads.redexgen.core;

import android.animation.ObjectAnimator;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FN implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C1732Lb A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.FF, 1, Ascii.GS, 5, Ascii.FF};
    }

    public FN(C1732Lb c1732Lb) {
        this.A00 = c1732Lb;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strA00 = A00(0, 5, 64);
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A0O.A0F().AJm();
            ObjectAnimator.ofFloat(this.A00.A0L, strA00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator.ofFloat(this.A00.A0K, strA00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator duration = ObjectAnimator.ofFloat(((FH) this.A00).A09, strA00, 1.0f, 0.0f).setDuration(100L);
            duration.addListener(new FM(this));
            duration.start();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
