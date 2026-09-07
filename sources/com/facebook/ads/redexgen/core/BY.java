package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class BY implements Runnable {
    public static byte[] A01;
    public static final AtomicBoolean A02;
    public static final AtomicBoolean A03;
    public static final AtomicReference<BO> A04;
    public final BM A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{44, Ascii.VT, Ascii.DLE, Ascii.DLE, Ascii.US, Ascii.FS, Ascii.DC2, Ascii.ESC, 94, Ascii.GS, Ascii.FF, Ascii.ESC, Ascii.US, 10, Ascii.ESC, Ascii.SUB, 80, 94, 42, Ascii.SYN, Ascii.FF, Ascii.ESC, Ascii.US, Ascii.SUB, 68, 94};
    }

    public abstract void A05();

    static {
        A01();
        A02 = new AtomicBoolean();
        A03 = new AtomicBoolean(false);
        A04 = new AtomicReference<>();
    }

    public BY() {
        if (A03.get()) {
            this.A00 = C1482Bd.A01(new C1481Bc(A00(0, 26, 94) + Thread.currentThread().getName()));
        } else {
            this.A00 = null;
        }
    }

    public static void A02(boolean z) {
        A03.set(z);
    }

    public static void A03(boolean z, BO bo) {
        A02.set(z);
        A04.set(bo);
    }

    public final BM A04() {
        return this.A00;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (A03.get()) {
                C1482Bd.A03(this);
            }
            try {
                A05();
            } catch (Throwable th) {
                if (A02.get()) {
                    Bf.A00().AAm(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR, th);
                    BO bo = A04.get();
                    if (bo != null) {
                        bo.AHf(th, this);
                    }
                } else {
                    throw th;
                }
            }
            if (A03.get()) {
                C1482Bd.A04(this);
            }
        } catch (Throwable th2) {
            BQ.A00(th2, this);
        }
    }
}
