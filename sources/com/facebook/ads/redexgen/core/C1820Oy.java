package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1820Oy implements InterfaceC2423fS {
    public static final List<C1821Oz> A01 = new ArrayList(50);
    public final Handler A00;

    public C1820Oy(Handler handler) {
        this.A00 = handler;
    }

    public static C1821Oz A00() {
        C1821Oz c1821Oz;
        synchronized (A01) {
            c1821Oz = A01.isEmpty() ? new C1821Oz() : A01.remove(A01.size() - 1);
        }
        return c1821Oz;
    }

    public static void A01(C1821Oz c1821Oz) {
        synchronized (A01) {
            if (A01.size() < 50) {
                A01.add(c1821Oz);
            }
        }
    }

    public final boolean A03(Runnable runnable) {
        return this.A00.post(runnable);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final Looper A8H() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final boolean A9d(int i) {
        return this.A00.hasMessages(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final C1821Oz AC1(int i) {
        return A00().A01(this.A00.obtainMessage(i), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final C1821Oz AC2(int i, int i2, int i3) {
        return A00().A01(this.A00.obtainMessage(i, i2, i3), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final C1821Oz AC3(int i, int i2, int i3, Object obj) {
        return A00().A01(this.A00.obtainMessage(i, i2, i3, obj), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final C1821Oz AC4(int i, Object obj) {
        return A00().A01(this.A00.obtainMessage(i, obj), this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final void AHZ(int i) {
        this.A00.removeMessages(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final boolean AIG(int i) {
        return this.A00.sendEmptyMessage(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final boolean AIH(int i, long j) {
        return this.A00.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2423fS
    public final boolean AIJ(InterfaceC2422fR interfaceC2422fR) {
        return ((C1821Oz) interfaceC2422fR).A03(this.A00);
    }
}
