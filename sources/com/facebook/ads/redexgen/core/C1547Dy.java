package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.Timeline;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1547Dy extends AbstractC2079Zl implements ZQ {
    public static byte[] A0N;
    public float A00;
    public int A01;
    public int A02;
    public Surface A03;
    public SurfaceHolder A04;
    public TextureView A05;
    public C2080Zm A06;
    public OA A07;
    public OA A08;
    public ZM A09;
    public ZM A0A;
    public InterfaceC2151az A0B;
    public boolean A0C;
    public final Handler A0D;
    public final E9 A0E;
    public final SurfaceHolderCallbackC2057Yo A0F;
    public final InterfaceC2041Xx A0G;
    public final CopyOnWriteArraySet<InterfaceC1886Rp> A0H;
    public final CopyOnWriteArraySet<QJ> A0I;
    public final CopyOnWriteArraySet<InterfaceC2073Ze> A0J;
    public final CopyOnWriteArraySet<InterfaceC2526h8> A0K;
    public final CopyOnWriteArraySet<InterfaceC2056Yn> A0L;
    public final InterfaceC2059Yq[] A0M;

    static {
        A0E();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C1547Dy(Context context, InterfaceC1858Qm interfaceC1858Qm, AbstractC2289dG abstractC2289dG, PC pc, InterfaceC2301dS interfaceC2301dS, TO to, InterfaceC2570hs<InterfaceC2395ez, InterfaceC2041Xx> interfaceC2570hs, InterfaceC2395ez interfaceC2395ez) {
        this.A0F = new SurfaceHolderCallbackC2057Yo(this);
        this.A0L = new CopyOnWriteArraySet<>();
        this.A0J = new CopyOnWriteArraySet<>();
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0H = new CopyOnWriteArraySet<>();
        Looper looperMyLooper = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
        this.A0D = new Handler(looperMyLooper);
        this.A0M = interfaceC1858Qm.A5O(this.A0D, this.A0F, this.A0F, this.A0F, this.A0F, to);
        this.A00 = 1.0f;
        this.A01 = 0;
        this.A06 = C2080Zm.A07;
        this.A02 = 1;
        this.A0E = A04(this.A0M, abstractC2289dG, pc, interfaceC2301dS, interfaceC2395ez);
        this.A0G = interfaceC2570hs.A41(interfaceC2395ez);
        this.A0G.AIl(this.A0E, looperMyLooper);
        this.A0I = new CopyOnWriteArraySet<>();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0N, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0N = new byte[]{Ascii.EM, 47, 51, 54, 50, 43, Ascii.VT, 62, 53, Ascii.SYN, 50, 39, 63, 43, 56, -3, Ascii.US, Ascii.FS, Ascii.DLE, Ascii.VT, Ascii.CR, Ascii.SI, -2, Ascii.SI, 34, Ascii.RS, Ascii.US, Ascii.FS, Ascii.SI, -10, 19, Ascii.GS, Ascii.RS, Ascii.SI, Ascii.CAN, Ascii.SI, Ascii.FS, -54, Ascii.VT, Ascii.SYN, Ascii.FS, Ascii.SI, Ascii.VT, Ascii.SO, 35, -54, Ascii.US, Ascii.CAN, Ascii.GS, Ascii.SI, Ascii.RS, -54, Ascii.EM, Ascii.FS, -54, Ascii.FS, Ascii.SI, Ascii.SUB, Ascii.SYN, Ascii.VT, Ascii.CR, Ascii.SI, Ascii.SO, -40};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.hs != com.google.common.base.Function<com.google.android.exoplayer2.util.Clock, com.google.android.exoplayer2.analytics.AnalyticsCollector> */
    public C1547Dy(Context context, InterfaceC1858Qm interfaceC1858Qm, AbstractC2289dG abstractC2289dG, PC pc, InterfaceC2301dS interfaceC2301dS, TO to, InterfaceC2570hs<InterfaceC2395ez, InterfaceC2041Xx> interfaceC2570hs) {
        this(context, interfaceC1858Qm, abstractC2289dG, pc, interfaceC2301dS, to, interfaceC2570hs, InterfaceC2395ez.A00);
    }

    @Deprecated
    public C1547Dy(InterfaceC1858Qm interfaceC1858Qm, AbstractC2289dG abstractC2289dG, PC pc, InterfaceC2301dS interfaceC2301dS, TO to) {
        this(null, interfaceC1858Qm, abstractC2289dG, pc, interfaceC2301dS, to, new InterfaceC2570hs() { // from class: com.facebook.ads.redexgen.X.ZP
            @Override // com.facebook.ads.redexgen.core.InterfaceC2570hs
            public final Object A41(Object obj) {
                return new C1519Cw((InterfaceC2395ez) obj);
            }
        });
    }

    private final E9 A04(InterfaceC2059Yq[] interfaceC2059YqArr, AbstractC2289dG abstractC2289dG, PC pc, InterfaceC2301dS interfaceC2301dS, InterfaceC2395ez interfaceC2395ez) {
        return new E9(interfaceC2059YqArr, abstractC2289dG, pc, interfaceC2301dS, interfaceC2395ez);
    }

    private void A0D() {
        if (this.A05 != null) {
            if (this.A05.getSurfaceTextureListener() != this.A0F) {
                Log.w(A07(0, 15, 83), A07(15, 49, 55));
            } else {
                this.A05.setSurfaceTextureListener(null);
            }
            this.A05 = null;
        }
        if (this.A04 != null) {
            this.A04.removeCallback(this.A0F);
            this.A04 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(Surface surface, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2059Yq interfaceC2059Yq : this.A0M) {
            if (interfaceC2059Yq.A9D() == 2) {
                arrayList.add(this.A0E.A0L(interfaceC2059Yq).A06(1).A07(surface).A05());
            }
        }
        if (this.A03 != null && this.A03 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((QT) it.next()).A0C();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.A0C) {
                this.A03.release();
            }
        }
        this.A03 = surface;
        this.A0C = z;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2079Zl
    public final void A0H(int i, long j) {
        this.A0G.ABz();
        this.A0E.A0H(i, j);
    }

    public final int A0I() {
        return this.A01;
    }

    public final ZM A0J() {
        return this.A09;
    }

    public final ZM A0K() {
        return this.A0A;
    }

    public final void A0L() {
        this.A0E.A0M();
        A0D();
        if (this.A03 != null) {
            if (this.A0C) {
                this.A03.release();
            }
            this.A03 = null;
        }
        if (this.A0B != null) {
            this.A0B.AHY(this.A0G);
            this.A0B = null;
        }
    }

    public final void A0M(float f) {
        float fA00 = AbstractC2471gE.A00(f, 0.0f, 1.0f);
        if (this.A00 == fA00) {
            return;
        }
        this.A00 = fA00;
        for (InterfaceC2059Yq interfaceC2059Yq : this.A0M) {
            if (interfaceC2059Yq.A9D() == 1) {
                this.A0E.A0L(interfaceC2059Yq).A06(2).A07(Float.valueOf(fA00)).A05();
            }
        }
    }

    public final void A0N(Surface surface) {
        A0D();
        A0F(surface, false);
    }

    public final void A0O(QJ qj) {
        this.A0E.A0O(qj);
        this.A0I.add(qj);
    }

    public final void A0P(InterfaceC2056Yn interfaceC2056Yn) {
        this.A0L.add(interfaceC2056Yn);
    }

    public final void A0Q(InterfaceC2151az interfaceC2151az) {
        A0R(interfaceC2151az, true, true);
    }

    public final void A0R(InterfaceC2151az interfaceC2151az, boolean z, boolean z2) {
        if (this.A0B != null) {
            this.A0B.AHY(this.A0G);
        }
        this.A0B = interfaceC2151az;
        interfaceC2151az.A3p(this.A0D, this.A0G);
        this.A0E.A0P(interfaceC2151az, z, z2);
    }

    public final void A0S(boolean z) {
        this.A0E.A0Q(z);
    }

    public final boolean A0T() {
        return this.A0E.A0R();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A6x() {
        return this.A0E.A6x();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A7J() {
        return this.A0E.A7J();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7O() {
        return this.A0E.A7O();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7P() {
        return this.A0E.A7P();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7R() {
        return this.A0E.A7R();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7S() {
        return this.A0E.A7S();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A7U() {
        return this.A0E.A7U();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final Timeline A7W() {
        return this.A0E.A7W();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7X() {
        return this.A0E.A7X();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A7i() {
        return this.A0E.A7i();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A99() {
        return this.A0E.A99();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final boolean AAS() {
        return this.A0E.AAS();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final void AJL(boolean z) {
        this.A0E.AJL(z);
        if (this.A0B != null) {
            this.A0B.AHY(this.A0G);
            this.A0B = null;
            if (z) {
                this.A0B = null;
            }
        }
    }
}
