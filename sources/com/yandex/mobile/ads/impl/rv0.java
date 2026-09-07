package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.amazon.device.ads.DtbConstants;
import com.google.android.gms.common.Scopes;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.core.di.ServiceProvider;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class rv0 extends iv0 {
    private static final sv0 q1 = jm1.h();
    private static final int[] r1 = {1920, IronSourceConstants.RV_OPERATIONAL_LOAD_AD, 1440, 1280, 960, 854, 640, 540, DtbConstants.DEFAULT_PLAYER_HEIGHT};
    private static boolean s1;
    private static boolean t1;
    private final Context H0;
    private final le2 I0;
    private final nf2.a J0;
    private final long K0;
    private final int L0;
    private final boolean M0;
    private a N0;
    private boolean O0;
    private boolean P0;
    private Surface Q0;
    private kh1 R0;
    private boolean S0;
    private int T0;
    private boolean U0;
    private boolean V0;
    private boolean W0;
    private long X0;
    private long Y0;
    private long Z0;
    private int a1;
    private int b1;
    private int c1;
    private long d1;
    private long e1;
    private long f1;
    private int g1;
    private int h1;
    private int i1;
    private int j1;
    private float k1;
    private uf2 l1;
    private boolean m1;
    private int n1;
    b o1;
    private ke2 p1;

    private static boolean V() {
        return q1.Z0().equals(x82.c);
    }

    private static boolean W() {
        int i = x82.f10629a;
        if (i <= 28) {
            sv0 sv0Var = q1;
            String strR = sv0Var.r();
            String str = x82.b;
            if (strR.equals(str) || sv0Var.I().equals(str) || sv0Var.K().equals(str) || sv0Var.J().equals(str) || sv0Var.Q0().equals(str) || sv0Var.P0().equals(str) || sv0Var.d1().equals(str) || sv0Var.e1().equals(str)) {
                return true;
            }
        }
        if (i <= 27 && q1.w0().equals(x82.b)) {
            return true;
        }
        if (i > 26) {
            return false;
        }
        sv0 sv0Var2 = q1;
        String strA = sv0Var2.a();
        String str2 = x82.b;
        if (!strA.equals(str2) && !sv0Var2.b().equals(str2) && !sv0Var2.c().equals(str2) && !sv0Var2.d().equals(str2) && !sv0Var2.e().equals(str2) && !sv0Var2.f().equals(str2) && !sv0Var2.g().equals(str2) && !sv0Var2.h().equals(str2) && !sv0Var2.i().equals(str2) && !sv0Var2.j().equals(str2) && !sv0Var2.k().equals(str2) && !sv0Var2.l().equals(str2) && !sv0Var2.m().equals(str2) && !sv0Var2.s().equals(str2) && !sv0Var2.t().equals(str2) && !sv0Var2.u().equals(str2) && !sv0Var2.v().equals(str2) && !sv0Var2.w().equals(str2) && !sv0Var2.y().equals(str2) && !sv0Var2.z().equals(str2) && !sv0Var2.A().equals(str2) && !sv0Var2.B().equals(str2) && !sv0Var2.C().equals(str2) && !sv0Var2.D().equals(str2) && !sv0Var2.E().equals(str2) && !sv0Var2.F().equals(str2) && !sv0Var2.G().equals(str2) && !sv0Var2.H().equals(str2) && !sv0Var2.L().equals(str2) && !sv0Var2.M().equals(str2) && !sv0Var2.N().equals(str2) && !sv0Var2.O().equals(str2) && !sv0Var2.P().equals(str2) && !sv0Var2.Q().equals(str2) && !sv0Var2.R().equals(str2) && !sv0Var2.S().equals(str2) && !sv0Var2.T().equals(str2) && !sv0Var2.U().equals(str2) && !sv0Var2.V().equals(str2) && !sv0Var2.W().equals(str2) && !sv0Var2.X().equals(str2) && !sv0Var2.Y().equals(str2) && !sv0Var2.Z().equals(str2) && !sv0Var2.a0().equals(str2) && !sv0Var2.b0().equals(str2) && !sv0Var2.c0().equals(str2) && !sv0Var2.d0().equals(str2) && !sv0Var2.e0().equals(str2) && !sv0Var2.f0().equals(str2) && !sv0Var2.g0().equals(str2) && !sv0Var2.h0().equals(str2) && !sv0Var2.i0().equals(str2) && !sv0Var2.j0().equals(str2) && !sv0Var2.k0().equals(str2) && !sv0Var2.l0().equals(str2) && !sv0Var2.m0().equals(str2) && !sv0Var2.n0().equals(str2) && !sv0Var2.o0().equals(str2) && !sv0Var2.p0().equals(str2) && !sv0Var2.q0().equals(str2) && !sv0Var2.r0().equals(str2) && !sv0Var2.s0().equals(str2) && !sv0Var2.t0().equals(str2) && !sv0Var2.u0().equals(str2) && !sv0Var2.v0().equals(str2) && !sv0Var2.x0().equals(str2) && !sv0Var2.y0().equals(str2) && !sv0Var2.z0().equals(str2) && !sv0Var2.A0().equals(str2) && !sv0Var2.B0().equals(str2) && !sv0Var2.C0().equals(str2) && !sv0Var2.D0().equals(str2) && !sv0Var2.E0().equals(str2) && !sv0Var2.F0().equals(str2) && !sv0Var2.H0().equals(str2) && !sv0Var2.I0().equals(str2) && !sv0Var2.K0().equals(str2) && !sv0Var2.L0().equals(str2) && !sv0Var2.M0().equals(str2) && !sv0Var2.N0().equals(str2) && !sv0Var2.O0().equals(str2) && !sv0Var2.R0().equals(str2) && !sv0Var2.S0().equals(str2) && !sv0Var2.T0().equals(str2) && !sv0Var2.U0().equals(str2) && !sv0Var2.V0().equals(str2) && !sv0Var2.W0().equals(str2) && !sv0Var2.X0().equals(str2) && !sv0Var2.Y0().equals(str2) && !sv0Var2.a1().equals(str2) && !sv0Var2.b1().equals(str2) && !sv0Var2.f1().equals(str2) && !sv0Var2.g1().equals(str2) && !sv0Var2.h1().equals(str2) && !sv0Var2.i1().equals(str2) && !sv0Var2.j1().equals(str2) && !sv0Var2.k1().equals(str2) && !sv0Var2.l1().equals(str2) && !sv0Var2.m1().equals(str2) && !sv0Var2.n1().equals(str2) && !sv0Var2.o1().equals(str2) && !sv0Var2.p1().equals(str2) && !sv0Var2.q1().equals(str2) && !sv0Var2.r1().equals(str2) && !sv0Var2.s1().equals(str2) && !sv0Var2.t1().equals(str2) && !sv0Var2.u1().equals(str2) && !sv0Var2.v1().equals(str2) && !sv0Var2.w1().equals(str2) && !sv0Var2.x1().equals(str2) && !sv0Var2.y1().equals(str2) && !sv0Var2.z1().equals(str2) && !sv0Var2.A1().equals(str2) && !sv0Var2.B1().equals(str2) && !sv0Var2.C1().equals(str2) && !sv0Var2.D1().equals(str2) && !sv0Var2.E1().equals(str2) && !sv0Var2.G1().equals(str2) && !sv0Var2.H1().equals(str2) && !sv0Var2.I1().equals(str2) && !sv0Var2.F1().equals(str2) && !sv0Var2.J1().equals(str2) && !sv0Var2.K1().equals(str2) && !sv0Var2.L1().equals(str2) && !sv0Var2.M1().equals(str2) && !sv0Var2.N1().equals(str2) && !sv0Var2.O1().equals(str2) && !sv0Var2.P1().equals(str2) && !sv0Var2.Q1().equals(str2) && !sv0Var2.R1().equals(str2) && !sv0Var2.S1().equals(str2) && !sv0Var2.T1().equals(str2) && !sv0Var2.U1().equals(str2) && !sv0Var2.V1().equals(str2) && !sv0Var2.W1().equals(str2) && !sv0Var2.X1().equals(str2) && !sv0Var2.Y1().equals(str2) && !sv0Var2.Z1().equals(str2) && !sv0Var2.a2().equals(str2) && !sv0Var2.b2().equals(str2)) {
            String strN = sv0Var2.n();
            String str3 = x82.d;
            if (!strN.equals(str3) && !sv0Var2.o().equals(str3) && !sv0Var2.G0().equals(str3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ro1, com.yandex.mobile.ads.impl.so1
    public final String getName() {
        return "MediaCodecVideoRenderer";
    }

    public rv0(Context context, c00 c00Var, kv0 kv0Var, Handler handler, nf2 nf2Var) {
        super(2, c00Var, kv0Var, 30.0f);
        this.K0 = 5000L;
        this.L0 = 50;
        Context applicationContext = context.getApplicationContext();
        this.H0 = applicationContext;
        this.I0 = new le2(applicationContext);
        this.J0 = new nf2.a(handler, nf2Var);
        this.M0 = V();
        this.Y0 = -9223372036854775807L;
        this.h1 = -1;
        this.i1 = -1;
        this.k1 = -1.0f;
        this.T0 = 1;
        this.n1 = 0;
        U();
    }

    protected static boolean b(String str) {
        if (str.startsWith(q1.c1())) {
            return false;
        }
        synchronized (rv0.class) {
            if (!s1) {
                t1 = W();
                s1 = true;
            }
        }
        return t1;
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void u() {
        this.l1 = null;
        T();
        this.S0 = false;
        this.o1 = null;
        try {
            super.u();
        } finally {
            this.J0.a(this.B0);
        }
    }

    protected static int b(gc0 gc0Var, gv0 gv0Var) {
        if (gc0Var.n != -1) {
            int size = gc0Var.o.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += gc0Var.o.get(i).length;
            }
            return gc0Var.n + length;
        }
        return a(gc0Var, gv0Var);
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.ro1
    public final boolean d() {
        kh1 kh1Var;
        if (super.d() && (this.U0 || (((kh1Var = this.R0) != null && this.Q0 == kh1Var) || E() == null || this.m1))) {
            this.Y0 = -9223372036854775807L;
            return true;
        }
        if (this.Y0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Y0) {
            return true;
        }
        this.Y0 = -9223372036854775807L;
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void w() {
        this.a1 = 0;
        this.Z0 = SystemClock.elapsedRealtime();
        this.e1 = SystemClock.elapsedRealtime() * 1000;
        this.f1 = 0L;
        this.g1 = 0;
        this.I0.b();
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void x() {
        this.Y0 = -9223372036854775807L;
        if (this.a1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.J0.a(this.a1, jElapsedRealtime - this.Z0);
            this.a1 = 0;
            this.Z0 = jElapsedRealtime;
        }
        int i = this.g1;
        if (i != 0) {
            this.J0.c(i, this.f1);
            this.f1 = 0L;
            this.g1 = 0;
        }
        this.I0.c();
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void v() {
        kh1 kh1Var;
        try {
            super.v();
            kh1Var = this.R0;
            if (kh1Var != null) {
                if (this.Q0 == kh1Var) {
                    this.Q0 = null;
                }
            }
        } finally {
            if (this.R0 != null) {
                Surface surface = this.Q0;
                kh1Var = this.R0;
                if (surface == kh1Var) {
                    this.Q0 = null;
                }
                kh1Var.release();
                this.R0 = null;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final boolean G() {
        return this.m1 && x82.f10629a < 23;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void P() {
        super.P();
        this.c1 = 0;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final qy a(gv0 gv0Var, gc0 gc0Var, gc0 gc0Var2) {
        qy qyVarA = gv0Var.a(gc0Var, gc0Var2);
        int i = qyVarA.e;
        int i2 = gc0Var2.r;
        a aVar = this.N0;
        if (i2 > aVar.f10144a || gc0Var2.s > aVar.b) {
            i |= 256;
        }
        if (b(gc0Var2, gv0Var) > this.N0.c) {
            i |= 64;
        }
        int i3 = i;
        return new qy(gv0Var.f9037a, gc0Var, gc0Var2, i3 != 0 ? 0 : qyVarA.d, i3);
    }

    public static int a(gc0 gc0Var, gv0 gv0Var) {
        int i;
        int iIntValue;
        int i2 = gc0Var.r;
        int i3 = gc0Var.s;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        String str = gc0Var.m;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairB = ov0.b(gc0Var);
            str = (pairB == null || !((iIntValue = ((Integer) pairB.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.getClass();
        str.hashCode();
        int i4 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                i = i3 * i2;
                i4 = 2;
                return (i * 3) / (i4 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                i = i3 * i2;
                return (i * 3) / (i4 * 2);
            case "video/avc":
                sv0 sv0Var = q1;
                String strX = sv0Var.x();
                String str2 = x82.d;
                if (strX.equals(str2) || (sv0Var.q().equals(x82.c) && (sv0Var.J0().equals(str2) || (sv0Var.p().equals(str2) && gv0Var.f)))) {
                    return -1;
                }
                i = ((i3 + 15) / 16) * ((i2 + 15) / 16) * 256;
                i4 = 2;
                return (i * 3) / (i4 * 2);
            default:
                return -1;
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final float a(float f, gc0[] gc0VarArr) {
        float fMax = -1.0f;
        for (gc0 gc0Var : gc0VarArr) {
            float f2 = gc0Var.t;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    private static hk0 a(kv0 kv0Var, gc0 gc0Var, boolean z, boolean z2) throws ov0.b {
        String str = gc0Var.m;
        if (str == null) {
            return hk0.h();
        }
        List<gv0> listA = kv0Var.a(str, z, z2);
        String strA = ov0.a(gc0Var);
        if (strA == null) {
            return hk0.a((Collection) listA);
        }
        List<gv0> listA2 = kv0Var.a(strA, z, z2);
        int i = hk0.d;
        return new hk0.a().b((List) listA).b((List) listA2).a();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final ArrayList a(kv0 kv0Var, gc0 gc0Var, boolean z) throws ov0.b {
        return ov0.a(a(kv0Var, gc0Var, z, this.m1), gc0Var);
    }

    protected final void e(long j) throws j60 {
        d(j);
        X();
        this.B0.e++;
        this.W0 = true;
        if (!this.U0) {
            this.U0 = true;
            this.J0.a(this.Q0);
            this.S0 = true;
        }
        c(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        R();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void c(long j) {
        super.c(j);
        if (this.m1) {
            return;
        }
        this.c1--;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void L() {
        T();
    }

    protected final boolean b(long j, boolean z) throws j60 {
        int iB = b(j);
        if (iB == 0) {
            return false;
        }
        if (z) {
            my myVar = this.B0;
            myVar.d += iB;
            myVar.f += this.c1;
        } else {
            this.B0.j++;
            a(iB, this.c1);
        }
        C();
        return true;
    }

    protected final void f(long j) {
        my myVar = this.B0;
        myVar.k += j;
        myVar.l++;
        this.f1 += j;
        this.g1++;
    }

    private void T() {
        cv0 cv0VarE;
        this.U0 = false;
        if (x82.f10629a < 23 || !this.m1 || (cv0VarE = E()) == null) {
            return;
        }
        this.o1 = new b(cv0VarE);
    }

    private void U() {
        this.l1 = null;
    }

    private void X() {
        int i = this.h1;
        if (i == -1 && this.i1 == -1) {
            return;
        }
        uf2 uf2Var = this.l1;
        if (uf2Var != null && uf2Var.b == i && uf2Var.c == this.i1 && uf2Var.d == this.j1 && uf2Var.e == this.k1) {
            return;
        }
        uf2 uf2Var2 = new uf2(this.h1, this.i1, this.j1, this.k1);
        this.l1 = uf2Var2;
        this.J0.b(uf2Var2);
    }

    /* JADX WARN: Code duplicated, block: B:78:0x0141  */
    @Override // com.yandex.mobile.ads.impl.iv0
    protected final cv0.a a(gv0 gv0Var, gc0 gc0Var, MediaCrypto mediaCrypto, float f) {
        String str;
        a aVar;
        Point point;
        boolean z;
        Pair<Integer, Integer> pairB;
        int iA;
        kh1 kh1Var = this.R0;
        if (kh1Var != null && kh1Var.b != gv0Var.f) {
            if (this.Q0 == kh1Var) {
                this.Q0 = null;
            }
            kh1Var.release();
            this.R0 = null;
        }
        String str2 = gv0Var.c;
        gc0[] gc0VarArrS = s();
        int iMax = gc0Var.r;
        int iMax2 = gc0Var.s;
        int iB = b(gc0Var, gv0Var);
        if (gc0VarArrS.length == 1) {
            if (iB != -1 && (iA = a(gc0Var, gv0Var)) != -1) {
                iB = Math.min((int) (iB * 1.5f), iA);
            }
            aVar = new a(iMax, iMax2, iB);
            str = str2;
        } else {
            int length = gc0VarArrS.length;
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                gc0 gc0VarA = gc0VarArrS[i];
                if (gc0Var.y != null && gc0VarA.y == null) {
                    gc0VarA = gc0VarA.a().a(gc0Var.y).a();
                }
                if (gv0Var.a(gc0Var, gc0VarA).d != 0) {
                    int i2 = gc0VarA.r;
                    z2 |= i2 == -1 || gc0VarA.s == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, gc0VarA.s);
                    iB = Math.max(iB, b(gc0VarA, gv0Var));
                }
            }
            if (z2) {
                at0.d("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + VastAttributes.HORIZONTAL_POSITION + iMax2);
                int i3 = gc0Var.s;
                int i4 = gc0Var.r;
                boolean z3 = i3 > i4;
                int i5 = z3 ? i3 : i4;
                if (z3) {
                    i3 = i4;
                }
                float f2 = i3 / i5;
                int[] iArr = r1;
                int length2 = iArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length2) {
                        int i7 = length2;
                        int i8 = iArr[i6];
                        int[] iArr2 = iArr;
                        int i9 = (int) (i8 * f2);
                        if (i8 > i5 && i9 > i3) {
                            int i10 = i3;
                            float f3 = f2;
                            if (x82.f10629a >= 21) {
                                int i11 = z3 ? i9 : i8;
                                if (!z3) {
                                    i8 = i9;
                                }
                                Point pointA = gv0Var.a(i11, i8);
                                str = str2;
                                if (gv0Var.a(pointA.x, pointA.y, gc0Var.t)) {
                                    point = pointA;
                                } else {
                                    i6++;
                                    length2 = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f2 = f3;
                                    str2 = str;
                                }
                            } else {
                                str = str2;
                                try {
                                    int i12 = ((i8 + 15) / 16) * 16;
                                    int i13 = ((i9 + 15) / 16) * 16;
                                    if (i12 * i13 <= ov0.a()) {
                                        int i14 = z3 ? i13 : i12;
                                        if (!z3) {
                                            i12 = i13;
                                        }
                                        point = new Point(i14, i12);
                                    } else {
                                        i6++;
                                        length2 = i7;
                                        iArr = iArr2;
                                        i3 = i10;
                                        f2 = f3;
                                        str2 = str;
                                    }
                                } catch (ov0.b unused) {
                                    point = null;
                                }
                            }
                        }
                        if (point != null) {
                            iMax = Math.max(iMax, point.x);
                            iMax2 = Math.max(iMax2, point.y);
                            iB = Math.max(iB, a(gc0Var.a().o(iMax).f(iMax2).a(), gv0Var));
                            at0.d("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + VastAttributes.HORIZONTAL_POSITION + iMax2);
                        }
                    }
                    str = str2;
                    point = null;
                    if (point != null) {
                        iMax = Math.max(iMax, point.x);
                        iMax2 = Math.max(iMax2, point.y);
                        iB = Math.max(iB, a(gc0Var.a().o(iMax).f(iMax2).a(), gv0Var));
                        at0.d("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + VastAttributes.HORIZONTAL_POSITION + iMax2);
                    }
                }
            } else {
                str = str2;
            }
            aVar = new a(iMax, iMax2, iB);
        }
        this.N0 = aVar;
        boolean z4 = this.M0;
        int i15 = this.m1 ? this.n1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", gc0Var.r);
        mediaFormat.setInteger("height", gc0Var.s);
        List<byte[]> list = gc0Var.o;
        for (int i16 = 0; i16 < list.size(); i16++) {
            mediaFormat.setByteBuffer(oe.a("csd-", i16), ByteBuffer.wrap(list.get(i16)));
        }
        float f4 = gc0Var.t;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        ew0.a(mediaFormat, "rotation-degrees", gc0Var.u);
        pq pqVar = gc0Var.y;
        if (pqVar != null) {
            ew0.a(mediaFormat, "color-transfer", pqVar.d);
            ew0.a(mediaFormat, "color-standard", pqVar.b);
            ew0.a(mediaFormat, "color-range", pqVar.c);
            byte[] bArr = pqVar.e;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(gc0Var.m) && (pairB = ov0.b(gc0Var)) != null) {
            ew0.a(mediaFormat, Scopes.PROFILE, ((Integer) pairB.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f10144a);
        mediaFormat.setInteger("max-height", aVar.b);
        ew0.a(mediaFormat, "max-input-size", aVar.c);
        if (x82.f10629a >= 23) {
            mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z4) {
            z = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z = true;
        }
        if (i15 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z);
            mediaFormat.setInteger("audio-session-id", i15);
        }
        if (this.Q0 == null) {
            if (b(gv0Var)) {
                if (this.R0 == null) {
                    this.R0 = kh1.a(this.H0, gv0Var.f);
                }
                this.Q0 = this.R0;
            } else {
                throw new IllegalStateException();
            }
        }
        return cv0.a.a(gv0Var, mediaFormat, gc0Var, this.Q0, mediaCrypto);
    }

    protected static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10144a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.f10144a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    private final class b implements cv0.c, Handler.Callback {
        private final Handler b;

        @Override // com.yandex.mobile.ads.impl.cv0.c
        public final void a(long j) {
            if (x82.f10629a < 30) {
                this.b.sendMessageAtFrontOfQueue(Message.obtain(this.b, 0, (int) (j >> 32), (int) j));
                return;
            }
            rv0 rv0Var = rv0.this;
            if (this != rv0Var.o1) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                rv0Var.Y();
                return;
            }
            try {
                rv0Var.e(j);
            } catch (j60 e) {
                rv0.this.a(e);
            }
        }

        public b(cv0 cv0Var) {
            Handler handlerA = x82.a((Handler.Callback) this);
            this.b = handlerA;
            cv0Var.a(this, handlerA);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            int i = message.arg1;
            int i2 = message.arg2;
            int i3 = x82.f10629a;
            long j = ((((long) i) & 4294967295L) << 32) | (4294967295L & ((long) i2));
            rv0 rv0Var = rv0.this;
            if (this != rv0Var.o1) {
                return true;
            }
            if (j == Long.MAX_VALUE) {
                rv0Var.Y();
                return true;
            }
            try {
                rv0Var.e(j);
                return true;
            } catch (j60 e) {
                rv0.this.a(e);
                return true;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void b(oy oyVar) throws j60 {
        boolean z = this.m1;
        if (!z) {
            this.c1++;
        }
        if (x82.f10629a >= 23 || !z) {
            return;
        }
        e(oyVar.f);
    }

    private boolean b(gv0 gv0Var) {
        return x82.f10629a >= 23 && !this.m1 && !b(gv0Var.f9037a) && (!gv0Var.f || kh1.a(this.H0));
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(oy oyVar) throws j60 {
        if (this.P0) {
            ByteBuffer byteBuffer = oyVar.g;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    cv0 cv0VarE = E();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    cv0VarE.a(bundle);
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ji1.b
    public final void a(int i, Object obj) throws j60 {
        if (i == 1) {
            a(obj);
            return;
        }
        if (i == 7) {
            this.p1 = (ke2) obj;
            return;
        }
        if (i == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.n1 != iIntValue) {
                this.n1 = iIntValue;
                if (this.m1) {
                    N();
                    return;
                }
                return;
            }
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            this.I0.a(((Integer) obj).intValue());
        } else {
            this.T0 = ((Integer) obj).intValue();
            cv0 cv0VarE = E();
            if (cv0VarE != null) {
                cv0VarE.a(this.T0);
            }
        }
    }

    private void a(long j, long j2, gc0 gc0Var) {
        ke2 ke2Var = this.p1;
        if (ke2Var != null) {
            ke2Var.a(j, j2, gc0Var, H());
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(Exception exc) {
        at0.a("MediaCodecVideoRenderer", "Video codec error", exc);
        this.J0.b(exc);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(String str, long j, long j2) {
        this.J0.a(str, j, j2);
        this.O0 = b(str);
        gv0 gv0VarF = F();
        gv0VarF.getClass();
        this.P0 = gv0VarF.a();
        if (x82.f10629a < 23 || !this.m1) {
            return;
        }
        cv0 cv0VarE = E();
        cv0VarE.getClass();
        this.o1 = new b(cv0VarE);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(String str) {
        this.J0.a(str);
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void a(boolean z, boolean z2) throws j60 {
        super.a(z, z2);
        boolean z3 = p().f10323a;
        if (z3 && this.n1 == 0) {
            throw new IllegalStateException();
        }
        if (this.m1 != z3) {
            this.m1 = z3;
            N();
        }
        this.J0.b(this.B0);
        this.V0 = z2;
        this.W0 = false;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final qy a(hc0 hc0Var) throws j60 {
        qy qyVarA = super.a(hc0Var);
        this.J0.a(hc0Var.b, qyVarA);
        return qyVarA;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(gc0 gc0Var, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        cv0 cv0VarE = E();
        if (cv0VarE != null) {
            cv0VarE.a(this.T0);
        }
        if (this.m1) {
            this.h1 = gc0Var.r;
            this.i1 = gc0Var.s;
        } else {
            mediaFormat.getClass();
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.h1 = integer;
            if (z) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.i1 = integer2;
        }
        float f = gc0Var.v;
        this.k1 = f;
        if (x82.f10629a >= 21) {
            int i = gc0Var.u;
            if (i == 90 || i == 270) {
                int i2 = this.h1;
                this.h1 = this.i1;
                this.i1 = i2;
                this.k1 = 1.0f / f;
            }
        } else {
            this.j1 = gc0Var.u;
        }
        this.I0.a(gc0Var.t);
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void a(long j, boolean z) throws j60 {
        super.a(j, z);
        T();
        this.I0.a();
        this.d1 = -9223372036854775807L;
        this.X0 = -9223372036854775807L;
        this.b1 = 0;
        if (z) {
            this.Y0 = this.K0 > 0 ? SystemClock.elapsedRealtime() + this.K0 : -9223372036854775807L;
        } else {
            this.Y0 = -9223372036854775807L;
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final boolean a(long j, long j2, cv0 cv0Var, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, gc0 gc0Var) throws j60 {
        boolean z3;
        cv0Var.getClass();
        if (this.X0 == -9223372036854775807L) {
            this.X0 = j;
        }
        if (j3 != this.d1) {
            this.I0.b(j3);
            this.d1 = j3;
        }
        long jI = I();
        long j4 = j3 - jI;
        if (z && !z2) {
            n52.a("skipVideoBuffer");
            cv0Var.a(false, i);
            n52.a();
            this.B0.f++;
            return true;
        }
        double dJ = J();
        boolean z4 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j5 = (long) ((j3 - j) / dJ);
        if (z4) {
            j5 -= jElapsedRealtime - j2;
        }
        if (this.Q0 == this.R0) {
            if (j5 >= -30000) {
                return false;
            }
            n52.a("skipVideoBuffer");
            cv0Var.a(false, i);
            n52.a();
            this.B0.f++;
            f(j5);
            return true;
        }
        long j6 = jElapsedRealtime - this.e1;
        boolean z5 = this.W0 ? !this.U0 : z4 || this.V0;
        if (this.Y0 == -9223372036854775807L && j >= jI && (z5 || (z4 && j5 < -30000 && j6 > 100000))) {
            long jNanoTime = System.nanoTime();
            a(j4, jNanoTime, gc0Var);
            if (x82.f10629a >= 21) {
                a(cv0Var, i, jNanoTime);
            } else {
                a(cv0Var, i);
            }
            f(j5);
            return true;
        }
        if (!z4 || j == this.X0) {
            return false;
        }
        long jNanoTime2 = System.nanoTime();
        long jA = this.I0.a((j5 * 1000) + jNanoTime2);
        long j7 = (jA - jNanoTime2) / 1000;
        boolean z6 = this.Y0 != -9223372036854775807L;
        if (j7 < -500000 && !z2 && b(j, z6)) {
            return false;
        }
        if (j7 < -30000 && !z2) {
            if (z6) {
                n52.a("skipVideoBuffer");
                cv0Var.a(false, i);
                n52.a();
                z3 = true;
                this.B0.f++;
            } else {
                z3 = true;
                n52.a("dropVideoBuffer");
                cv0Var.a(false, i);
                n52.a();
                a(0, 1);
            }
            f(j7);
            return z3;
        }
        if (x82.f10629a >= 21) {
            if (j7 >= ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) {
                return false;
            }
            a(j4, jA, gc0Var);
            a(cv0Var, i, jA);
            f(j7);
            return true;
        }
        if (j7 >= 30000) {
            return false;
        }
        if (j7 > 11000) {
            try {
                Thread.sleep((j7 - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        a(j4, jA, gc0Var);
        a(cv0Var, i);
        f(j7);
        return true;
    }

    protected final void a(cv0 cv0Var, int i) {
        X();
        n52.a("releaseOutputBuffer");
        cv0Var.a(true, i);
        n52.a();
        this.e1 = SystemClock.elapsedRealtime() * 1000;
        this.B0.e++;
        this.b1 = 0;
        this.W0 = true;
        if (this.U0) {
            return;
        }
        this.U0 = true;
        this.J0.a(this.Q0);
        this.S0 = true;
    }

    protected final void a(cv0 cv0Var, int i, long j) {
        X();
        n52.a("releaseOutputBuffer");
        cv0Var.a(i, j);
        n52.a();
        this.e1 = SystemClock.elapsedRealtime() * 1000;
        this.B0.e++;
        this.b1 = 0;
        this.W0 = true;
        if (this.U0) {
            return;
        }
        this.U0 = true;
        this.J0.a(this.Q0);
        this.S0 = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.yandex.mobile.ads.impl.le2] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.yandex.mobile.ads.impl.cv0] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.yandex.mobile.ads.impl.kh1] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(Object obj) throws j60 {
        ?? A;
        Surface surface;
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            A = 0;
        }
        if (A == 0) {
            kh1 kh1Var = this.R0;
            if (kh1Var != null) {
                A = surface;
                A = kh1Var;
            } else {
                gv0 gv0VarF = F();
                if (gv0VarF != null && b(gv0VarF)) {
                    A = surface;
                    A = kh1.a(this.H0, gv0VarF.f);
                    this.R0 = A;
                }
            }
        }
        A = surface;
        A = surface;
        A = surface;
        if (this.Q0 != A) {
            this.Q0 = A;
            this.I0.a(A);
            this.S0 = false;
            int state = getState();
            ?? E = E();
            if (E != 0) {
                if (x82.f10629a >= 23 && A != 0 && !this.O0) {
                    E.a(A);
                } else {
                    N();
                    K();
                }
            }
            if (A != 0 && A != this.R0) {
                uf2 uf2Var = this.l1;
                if (uf2Var != null) {
                    this.J0.b(uf2Var);
                }
                T();
                if (state == 2) {
                    this.Y0 = this.K0 > 0 ? SystemClock.elapsedRealtime() + this.K0 : -9223372036854775807L;
                    return;
                }
                return;
            }
            this.l1 = null;
            T();
            return;
        }
        if (A == 0 || A == this.R0) {
            return;
        }
        uf2 uf2Var2 = this.l1;
        if (uf2Var2 != null) {
            this.J0.b(uf2Var2);
        }
        if (this.S0) {
            this.J0.a(this.Q0);
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.ro1
    public final void a(float f, float f2) throws j60 {
        super.a(f, f2);
        this.I0.b(f);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final boolean a(gv0 gv0Var) {
        return this.Q0 != null || b(gv0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.iv0
    protected final int a(kv0 kv0Var, gc0 gc0Var) throws ov0.b {
        boolean z;
        int i = 0;
        if (!s01.f(gc0Var.m)) {
            return so1.a(0, 0, 0);
        }
        boolean z2 = gc0Var.p != null;
        hk0 hk0VarA = a(kv0Var, gc0Var, z2, false);
        if (z2 && hk0VarA.isEmpty()) {
            hk0VarA = a(kv0Var, gc0Var, false, false);
        }
        if (hk0VarA.isEmpty()) {
            return so1.a(1, 0, 0);
        }
        int i2 = gc0Var.F;
        if (i2 != 0 && i2 != 2) {
            return so1.a(2, 0, 0);
        }
        gv0 gv0Var = (gv0) hk0VarA.get(0);
        boolean zA = gv0Var.a(gc0Var);
        if (!zA) {
            int i3 = 1;
            while (true) {
                if (i3 >= hk0VarA.size()) {
                    z = true;
                    break;
                }
                gv0 gv0Var2 = (gv0) hk0VarA.get(i3);
                if (gv0Var2.a(gc0Var)) {
                    z = false;
                    zA = true;
                    gv0Var = gv0Var2;
                    break;
                }
                i3++;
            }
        } else {
            z = true;
            break;
        }
        int i4 = zA ? 4 : 3;
        int i5 = gv0Var.b(gc0Var) ? 16 : 8;
        int i6 = gv0Var.g ? 64 : 0;
        int i7 = z ? 128 : 0;
        if (zA) {
            hk0 hk0VarA2 = a(kv0Var, gc0Var, z2, true);
            if (!hk0VarA2.isEmpty()) {
                gv0 gv0Var3 = (gv0) ov0.a(hk0VarA2, gc0Var).get(0);
                if (gv0Var3.a(gc0Var) && gv0Var3.b(gc0Var)) {
                    i = 32;
                }
            }
        }
        return i4 | i5 | i | i6 | i7;
    }

    protected final void a(int i, int i2) {
        int i3;
        my myVar = this.B0;
        myVar.h += i;
        int i4 = i + i2;
        myVar.g += i4;
        this.a1 += i4;
        int i5 = this.b1 + i4;
        this.b1 = i5;
        myVar.i = Math.max(i5, myVar.i);
        int i6 = this.L0;
        if (i6 <= 0 || (i3 = this.a1) < i6 || i3 <= 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.J0.a(this.a1, jElapsedRealtime - this.Z0);
        this.a1 = 0;
        this.Z0 = jElapsedRealtime;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final fv0 a(IllegalStateException illegalStateException, gv0 gv0Var) {
        return new qv0(illegalStateException, gv0Var, this.Q0);
    }
}
