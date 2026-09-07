package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
final class q60 implements Handler.Callback, lw0.a, y52.a, uw0.d, b00.a, ji1.a {
    private boolean A;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private g L;
    private long M;
    private int N;
    private boolean O;
    private j60 P;
    private final ro1[] b;
    private final Set<ro1> c;
    private final so1[] d;
    private final y52 e;
    private final z52 f;
    private final yr0 g;
    private final vi h;
    private final ef0 i;
    private final HandlerThread j;
    private final Looper k;
    private final b52.d l;
    private final b52.b m;
    private final long n;
    private final boolean o;
    private final b00 p;
    private final ArrayList<c> q;
    private final hp r;
    private final e s;
    private final pw0 t;
    private final uw0 u;
    private final xr0 v;
    private final long w;
    private yw1 x;
    private vh1 y;
    private d z;
    private boolean G = false;
    private boolean B = false;
    private long Q = -9223372036854775807L;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<uw0.c> f9985a;
        private final by1 b;
        private final int c;
        private final long d;

        private a(int i, long j, by1 by1Var, ArrayList arrayList) {
            this.f9985a = arrayList;
            this.b = by1Var;
            this.c = i;
            this.d = j;
        }
    }

    private static class b {
    }

    public interface e {
        void a(d dVar);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        mw0 mw0VarF;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    j();
                    break;
                case 1:
                    a(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    b();
                    break;
                case 3:
                    a((g) message.obj);
                    break;
                case 4:
                    b((xh1) message.obj);
                    break;
                case 5:
                    this.x = (yw1) message.obj;
                    break;
                case 6:
                    a(false, true);
                    break;
                case 7:
                    l();
                    return true;
                case 8:
                    c((lw0) message.obj);
                    break;
                case 9:
                    b((lw0) message.obj);
                    break;
                case 10:
                    m();
                    break;
                case 11:
                    a(message.arg1);
                    break;
                case 12:
                    e(message.arg1 != 0);
                    break;
                case 13:
                    a(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    ji1 ji1Var = (ji1) message.obj;
                    ji1Var.getClass();
                    if (ji1Var.a() != this.k) {
                        this.i.a(15, ji1Var).a();
                    } else {
                        a(ji1Var);
                        int i2 = this.y.e;
                        if (i2 == 3 || i2 == 2) {
                            this.i.a(2);
                        }
                    }
                    break;
                case 15:
                    d((ji1) message.obj);
                    break;
                case 16:
                    xh1 xh1Var = (xh1) message.obj;
                    a(xh1Var, xh1Var.b, true, false);
                    break;
                case 17:
                    a((a) message.obj);
                    break;
                case 18:
                    a((a) message.obj, message.arg1);
                    break;
                case 19:
                    a((b) message.obj);
                    break;
                case 20:
                    a(message.arg1, message.arg2, (by1) message.obj);
                    break;
                case 21:
                    a((by1) message.obj);
                    break;
                case 22:
                    g();
                    break;
                case 23:
                    d(message.arg1 != 0);
                    break;
                case 24:
                    c(message.arg1 == 1);
                    break;
                case 25:
                    b(true);
                    break;
                default:
                    return false;
            }
        } catch (ag1 e2) {
            int i3 = e2.c;
            if (i3 == 1) {
                i = e2.b ? 3001 : 3003;
            } else if (i3 == 4) {
                i = e2.b ? 3002 : 3004;
            }
            a(e2, i);
        } catch (d40.a e3) {
            a(e3, e3.b);
        } catch (j60 e4) {
            e = e4;
            if (e.d == 1 && (mw0VarF = this.t.f()) != null) {
                e = e.a(mw0VarF.f.f9869a);
            }
            if (e.j && this.P == null) {
                at0.b("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.P = e;
                ef0 ef0Var = this.i;
                ef0Var.a(ef0Var.a(25, e));
            } else {
                j60 j60Var = this.P;
                if (j60Var != null) {
                    j60Var.addSuppressed(e);
                    e = this.P;
                }
                at0.a("ExoPlayerImplInternal", "Playback error", e);
                a(true, false);
                this.y = this.y.a(e);
            }
        } catch (rv e5) {
            a(e5, e5.b);
        } catch (IOException e6) {
            a(e6, 2000);
        } catch (RuntimeException e7) {
            j60 j60VarA = j60.a(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? 1004 : 1000);
            at0.a("ExoPlayerImplInternal", "Playback error", j60VarA);
            a(true, false);
            this.y = this.y.a(j60VarA);
        }
        d dVar = this.z;
        vh1 vh1Var = this.y;
        boolean z = dVar.f9986a | (dVar.b != vh1Var);
        dVar.f9986a = z;
        dVar.b = vh1Var;
        if (z) {
            this.s.a(dVar);
            this.z = new d(this.y);
        }
        return true;
    }

    public q60(ro1[] ro1VarArr, y52 y52Var, z52 z52Var, yr0 yr0Var, vi viVar, int i, ed edVar, yw1 yw1Var, yz yzVar, long j, Looper looper, r32 r32Var, e eVar, ii1 ii1Var) {
        this.s = eVar;
        this.b = ro1VarArr;
        this.e = y52Var;
        this.f = z52Var;
        this.g = yr0Var;
        this.h = viVar;
        this.F = i;
        this.x = yw1Var;
        this.v = yzVar;
        this.w = j;
        this.r = r32Var;
        this.n = yr0Var.e();
        this.o = yr0Var.a();
        vh1 vh1VarA = vh1.a(z52Var);
        this.y = vh1VarA;
        this.z = new d(vh1VarA);
        this.d = new so1[ro1VarArr.length];
        for (int i2 = 0; i2 < ro1VarArr.length; i2++) {
            ro1VarArr[i2].a(i2, ii1Var);
            this.d[i2] = ro1VarArr[i2].n();
        }
        this.p = new b00(this, r32Var);
        this.q = new ArrayList<>();
        this.c = px1.a();
        this.l = new b52.d();
        this.m = new b52.b();
        y52Var.a(this, viVar);
        this.O = true;
        Handler handler = new Handler(looper);
        this.t = new pw0(edVar, handler);
        this.u = new uw0(this, edVar, handler, ii1Var);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.j = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.k = looper2;
        this.i = r32Var.a(looper2, this);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    private void f() {
        boolean zA;
        mw0 mw0VarD = this.t.d();
        if (mw0VarD == null) {
            zA = false;
        } else {
            if ((!mw0VarD.d ? 0L : mw0VarD.f9674a.getNextLoadPositionUs()) == Long.MIN_VALUE) {
                zA = false;
            } else {
                mw0 mw0VarD2 = this.t.d();
                long jA = a(mw0VarD2.d ? mw0VarD2.f9674a.getNextLoadPositionUs() : 0L);
                if (mw0VarD2 != this.t.e()) {
                    long j = mw0VarD2.f.b;
                }
                zA = this.g.a(jA, this.p.getPlaybackParameters().b);
            }
        }
        this.E = zA;
        if (zA) {
            this.t.d().a(this.M);
        }
        r();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9986a;
        public vh1 b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public d(vh1 vh1Var) {
            this.b = vh1Var;
        }

        public final void a(int i) {
            this.f9986a |= i > 0;
            this.c += i;
        }
    }

    public final void i() {
        this.i.b(0).a();
    }

    public final void p() {
        this.i.b(6).a();
    }

    public final synchronized boolean k() {
        if (!this.A && this.j.isAlive()) {
            this.i.a(7);
            a(new m32() { // from class: com.yandex.mobile.ads.impl.q60$$ExternalSyntheticLambda1
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return this.f$0.e();
                }
            }, this.w);
            return this.A;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean e() {
        return Boolean.valueOf(this.A);
    }

    public final Looper d() {
        return this.k;
    }

    public final void h() {
        this.i.a(22);
    }

    private void j() {
        this.z.a(1);
        a(false, false, false, true);
        this.g.f();
        b(this.y.f10479a.c() ? 4 : 2);
        this.u.a(this.h.a());
        this.i.a(2);
    }

    private void a(a aVar, int i) throws j60 {
        this.z.a(1);
        uw0 uw0Var = this.u;
        if (i == -1) {
            i = uw0Var.b();
        }
        a(uw0Var.a(i, aVar.f9985a, aVar.b), false);
    }

    private static void a(ji1 ji1Var) throws j60 {
        synchronized (ji1Var) {
        }
        try {
            ji1Var.c().a(ji1Var.d(), ji1Var.b());
        } finally {
            ji1Var.a(true);
        }
    }

    private void g() throws j60 {
        a(this.u.a(), true);
    }

    private void q() throws j60 {
        this.p.b();
        for (ro1 ro1Var : this.b) {
            if (b(ro1Var) && ro1Var.getState() == 2) {
                ro1Var.stop();
            }
        }
    }

    private void s() throws j60 {
        long j;
        mw0 mw0VarE = this.t.e();
        if (mw0VarE == null) {
            return;
        }
        long discontinuity = mw0VarE.d ? mw0VarE.f9674a.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            b(discontinuity);
            if (discontinuity != this.y.r) {
                vh1 vh1Var = this.y;
                this.y = a(vh1Var.b, discontinuity, vh1Var.c, discontinuity, true, 5);
            }
        } else {
            long jA = this.p.a(mw0VarE != this.t.f());
            this.M = jA;
            long jC = mw0VarE.c(jA);
            long j2 = this.y.r;
            if (!this.q.isEmpty() && !this.y.b.a()) {
                if (this.O) {
                    j2--;
                    this.O = false;
                }
                vh1 vh1Var2 = this.y;
                int iA = vh1Var2.f10479a.a(vh1Var2.b.f9759a);
                int iMin = Math.min(this.N, this.q.size());
                c cVar = iMin > 0 ? this.q.get(iMin - 1) : null;
                while (cVar != null) {
                    cVar.getClass();
                    if (iA >= 0) {
                        if (iA != 0) {
                            break;
                        }
                        cVar.getClass();
                        if (0 <= j2) {
                            break;
                        }
                    }
                    int i = iMin - 1;
                    cVar = i > 0 ? this.q.get(iMin - 2) : null;
                    iMin = i;
                }
                c cVar2 = iMin < this.q.size() ? this.q.get(iMin) : null;
                if (cVar2 != null) {
                    cVar2.getClass();
                }
                if (cVar2 != null) {
                    cVar2.getClass();
                }
                this.N = iMin;
            }
            this.y.r = jC;
        }
        mw0 mw0VarD = this.t.d();
        vh1 vh1Var3 = this.y;
        if (!mw0VarD.d) {
            j = mw0VarD.f.b;
        } else {
            long bufferedPositionUs = mw0VarD.e ? mw0VarD.f9674a.getBufferedPositionUs() : Long.MIN_VALUE;
            j = bufferedPositionUs == Long.MIN_VALUE ? mw0VarD.f.e : bufferedPositionUs;
        }
        vh1Var3.p = j;
        vh1 vh1Var4 = this.y;
        vh1Var4.q = a(vh1Var4.p);
        vh1 vh1Var5 = this.y;
        if (vh1Var5.l && vh1Var5.e == 3 && a(vh1Var5.f10479a, vh1Var5.b)) {
            vh1 vh1Var6 = this.y;
            if (vh1Var6.n.b == 1.0f) {
                float fA = ((yz) this.v).a(a(vh1Var6.f10479a, vh1Var6.b.f9759a, vh1Var6.r), a(this.y.p));
                if (this.p.getPlaybackParameters().b != fA) {
                    this.p.a(new xh1(fA, this.y.n.c));
                    a(this.y.n, this.p.getPlaybackParameters().b, false, false);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:191:0x0338  */
    /* JADX WARN: Code duplicated, block: B:258:0x043d  */
    /* JADX WARN: Code duplicated, block: B:264:0x0450  */
    /* JADX WARN: Code duplicated, block: B:266:0x0456  */
    /* JADX WARN: Code duplicated, block: B:268:0x045a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0099  */
    /* JADX WARN: Code duplicated, block: B:270:0x0468  */
    /* JADX WARN: Code duplicated, block: B:277:0x047c  */
    /* JADX WARN: Code duplicated, block: B:279:0x0480  */
    /* JADX WARN: Code duplicated, block: B:282:0x0486  */
    /* JADX WARN: Code duplicated, block: B:284:0x0498  */
    /* JADX WARN: Code duplicated, block: B:285:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:288:0x04af  */
    /* JADX WARN: Code duplicated, block: B:295:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:298:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:301:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:303:0x04d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:308:0x0507  */
    /* JADX WARN: Code duplicated, block: B:310:0x0514  */
    /* JADX WARN: Code duplicated, block: B:312:0x051c  */
    /* JADX WARN: Code duplicated, block: B:314:0x0522  */
    /* JADX WARN: Code duplicated, block: B:316:0x0528  */
    /* JADX WARN: Code duplicated, block: B:318:0x052c  */
    /* JADX WARN: Code duplicated, block: B:320:0x053a  */
    /* JADX WARN: Code duplicated, block: B:327:0x054d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:328:0x054f  */
    /* JADX WARN: Code duplicated, block: B:330:0x055c  */
    /* JADX WARN: Code duplicated, block: B:332:0x0564  */
    /* JADX WARN: Code duplicated, block: B:334:0x056e  */
    /* JADX WARN: Code duplicated, block: B:336:0x0572  */
    /* JADX WARN: Code duplicated, block: B:343:0x058d  */
    /* JADX WARN: Code duplicated, block: B:346:0x0593  */
    /* JADX WARN: Code duplicated, block: B:374:0x0604  */
    /* JADX WARN: Code duplicated, block: B:380:0x0614  */
    /* JADX WARN: Code duplicated, block: B:387:0x0621  */
    /* JADX WARN: Code duplicated, block: B:390:0x0628  */
    /* JADX WARN: Code duplicated, block: B:451:0x05b3 A[EDGE_INSN: B:451:0x05b3->B:352:0x05b3 BREAK  A[LOOP:8: B:344:0x058e->B:351:0x05b0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:457:0x051f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:461:0x0575 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [int] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    private void b() throws j60, IOException {
        boolean z;
        boolean z2;
        long j;
        boolean z3;
        boolean z4;
        vh1 vh1Var;
        mw0 mw0VarE;
        e70[] e70VarArr;
        int length;
        ?? r5;
        e70 e70Var;
        mw0 mw0VarE2;
        long jA;
        mw0 mw0VarD;
        boolean z5;
        boolean z6;
        ro1[] ro1VarArr;
        int length2;
        ?? r6;
        ro1 ro1Var;
        mw0 mw0VarE3;
        boolean z7;
        boolean z8;
        vh1 vh1Var2;
        int i;
        ?? r7;
        ro1[] ro1VarArr2;
        vh1 vh1Var3;
        mw0 mw0VarD2;
        mw0 mw0VarE4;
        mw0 mw0VarB;
        boolean z9;
        ro1[] ro1VarArr3;
        boolean z10;
        ow0 ow0VarA;
        long jA2 = this.r.a();
        this.i.c();
        if (!this.y.f10479a.c() && this.u.c()) {
            this.t.a(this.M);
            if (this.t.h() && (ow0VarA = this.t.a(this.M, this.y)) != null) {
                mw0 mw0VarA = this.t.a(this.d, this.e, this.g.c(), this.u, ow0VarA, this.f);
                mw0VarA.f9674a.a(this, ow0VarA.b);
                if (this.t.e() == mw0VarA) {
                    b(ow0VarA.b);
                }
                a(false);
            }
            if (this.E) {
                mw0 mw0VarD3 = this.t.d();
                if (mw0VarD3 == null) {
                    z10 = false;
                } else if ((!mw0VarD3.d ? 0L : mw0VarD3.f9674a.getNextLoadPositionUs()) == Long.MIN_VALUE) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                this.E = z10;
                r();
            } else {
                f();
            }
            mw0 mw0VarF = this.t.f();
            if (mw0VarF != null) {
                if (mw0VarF.b() != null && !this.C) {
                    mw0 mw0VarF2 = this.t.f();
                    if (mw0VarF2.d) {
                        int i2 = 0;
                        while (true) {
                            ro1[] ro1VarArr4 = this.b;
                            if (i2 < ro1VarArr4.length) {
                                ro1 ro1Var2 = ro1VarArr4[i2];
                                et1 et1Var = mw0VarF2.c[i2];
                                if (ro1Var2.g() != et1Var) {
                                    break;
                                }
                                if (et1Var != null && !ro1Var2.e()) {
                                    mw0 mw0VarB2 = mw0VarF2.b();
                                    if (!mw0VarF2.f.f || !mw0VarB2.d || (!(ro1Var2 instanceof o42) && !(ro1Var2 instanceof l01) && ro1Var2.j() < mw0VarB2.d())) {
                                        break;
                                    }
                                }
                                i2++;
                            } else {
                                if (!mw0VarF.b().d && this.M < mw0VarF.b().d()) {
                                    break;
                                }
                                z52 z52VarF = mw0VarF.f();
                                mw0 mw0VarB3 = this.t.b();
                                z52 z52VarF2 = mw0VarB3.f();
                                b52 b52Var = this.y.f10479a;
                                a(b52Var, mw0VarB3.f.f9869a, b52Var, mw0VarF.f.f9869a, -9223372036854775807L);
                                if (mw0VarB3.d && mw0VarB3.f9674a.readDiscontinuity() != -9223372036854775807L) {
                                    long jD = mw0VarB3.d();
                                    for (ro1 ro1Var3 : this.b) {
                                        if (ro1Var3.g() != null) {
                                            ro1Var3.h();
                                            if (ro1Var3 instanceof o42) {
                                                ((o42) ro1Var3).c(jD);
                                            }
                                        }
                                    }
                                    break;
                                }
                                for (int i3 = 0; i3 < this.b.length; i3++) {
                                    boolean zA = z52VarF.a(i3);
                                    boolean zA2 = z52VarF2.a(i3);
                                    if (zA && !this.b[i3].k()) {
                                        boolean z11 = ((rk) this.d[i3]).m() == -2;
                                        to1 to1Var = z52VarF.b[i3];
                                        to1 to1Var2 = z52VarF2.b[i3];
                                        if (!zA2 || !to1Var2.equals(to1Var) || z11) {
                                            ro1 ro1Var4 = this.b[i3];
                                            long jD2 = mw0VarB3.d();
                                            ro1Var4.h();
                                            if (ro1Var4 instanceof o42) {
                                                ((o42) ro1Var4).c(jD2);
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else if (mw0VarF.f.i || this.C) {
                    int i4 = 0;
                    while (true) {
                        ro1[] ro1VarArr5 = this.b;
                        if (i4 >= ro1VarArr5.length) {
                            break;
                        }
                        ro1 ro1Var5 = ro1VarArr5[i4];
                        et1 et1Var2 = mw0VarF.c[i4];
                        if (et1Var2 != null && ro1Var5.g() == et1Var2 && ro1Var5.e()) {
                            long j2 = mw0VarF.f.e;
                            long jC = (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? -9223372036854775807L : mw0VarF.c() + mw0VarF.f.e;
                            ro1Var5.h();
                            if (ro1Var5 instanceof o42) {
                                ((o42) ro1Var5).c(jC);
                            }
                        }
                        i4++;
                    }
                }
            }
            mw0 mw0VarF3 = this.t.f();
            if (mw0VarF3 != null && this.t.e() != mw0VarF3 && !mw0VarF3.g) {
                mw0 mw0VarF4 = this.t.f();
                z52 z52VarF3 = mw0VarF4.f();
                boolean z12 = false;
                int i5 = 0;
                while (true) {
                    ro1VarArr3 = this.b;
                    if (i5 >= ro1VarArr3.length) {
                        break;
                    }
                    ro1 ro1Var6 = ro1VarArr3[i5];
                    if (b(ro1Var6)) {
                        boolean z13 = ro1Var6.g() != mw0VarF4.c[i5];
                        if (!z52VarF3.a(i5) || z13) {
                            if (!ro1Var6.k()) {
                                e70 e70Var2 = z52VarF3.c[i5];
                                int iB = e70Var2 != null ? e70Var2.b() : 0;
                                gc0[] gc0VarArr = new gc0[iB];
                                for (int i6 = 0; i6 < iB; i6++) {
                                    gc0VarArr[i6] = e70Var2.a(i6);
                                }
                                ro1Var6.a(gc0VarArr, mw0VarF4.c[i5], mw0VarF4.d(), mw0VarF4.c());
                            } else if (ro1Var6.a()) {
                                a(ro1Var6);
                            } else {
                                z12 = true;
                            }
                        }
                    }
                    i5++;
                }
                if (!z12) {
                    a(new boolean[ro1VarArr3.length]);
                }
            }
            boolean z14 = false;
            while (o() && !this.C && (mw0VarE4 = this.t.e()) != null && (mw0VarB = mw0VarE4.b()) != null && this.M >= mw0VarB.d() && mw0VarB.g) {
                if (z14) {
                    d dVar = this.z;
                    vh1 vh1Var4 = this.y;
                    boolean z15 = dVar.f9986a | (dVar.b != vh1Var4);
                    dVar.f9986a = z15;
                    dVar.b = vh1Var4;
                    if (z15) {
                        this.s.a(dVar);
                        this.z = new d(this.y);
                    }
                }
                mw0 mw0VarA2 = this.t.a();
                mw0VarA2.getClass();
                if (this.y.b.f9759a.equals(mw0VarA2.f.f9869a.f9759a)) {
                    rw0.b bVar = this.y.b;
                    if (bVar.b == -1) {
                        rw0.b bVar2 = mw0VarA2.f.f9869a;
                        if (bVar2.b != -1 || bVar.e == bVar2.e) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                    } else {
                        z9 = false;
                    }
                } else {
                    z9 = false;
                }
                ow0 ow0Var = mw0VarA2.f;
                rw0.b bVar3 = ow0Var.f9869a;
                long j3 = ow0Var.b;
                this.y = a(bVar3, j3, ow0Var.c, j3, !z9, 0);
                n();
                s();
                z14 = true;
            }
        }
        int i7 = this.y.e;
        if (i7 == 1 || i7 == 4) {
            return;
        }
        mw0 mw0VarE5 = this.t.e();
        if (mw0VarE5 == null) {
            this.i.a(jA2 + 10);
            return;
        }
        n52.a("doSomeWork");
        s();
        if (mw0VarE5.d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            mw0VarE5.f9674a.discardBuffer(this.y.r - this.n, this.o);
            int i8 = 0;
            boolean z16 = true;
            z = true;
            while (true) {
                ro1[] ro1VarArr6 = this.b;
                if (i8 >= ro1VarArr6.length) {
                    break;
                }
                ro1 ro1Var7 = ro1VarArr6[i8];
                if (b(ro1Var7)) {
                    ro1Var7.a(this.M, jElapsedRealtime);
                    z16 = z16 && ro1Var7.a();
                    boolean z17 = mw0VarE5.c[i8] != ro1Var7.g();
                    boolean z18 = z17 || (!z17 && ro1Var7.e()) || ro1Var7.d() || ro1Var7.a();
                    z = z && z18;
                    if (!z18) {
                        ro1Var7.i();
                    }
                }
                i8++;
            }
            z2 = z16;
        } else {
            mw0VarE5.f9674a.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j4 = mw0VarE5.f.e;
        if (z2 && mw0VarE5.d) {
            j = -9223372036854775807L;
            z3 = j4 == -9223372036854775807L || j4 <= this.y.r;
            if (z3 || !this.C) {
                z4 = false;
            } else {
                z4 = false;
                this.C = false;
                a(false, this.y.m, false, 5);
            }
            if (!z3 && mw0VarE5.f.i) {
                b(4);
                q();
            } else {
                vh1Var = this.y;
                if (vh1Var.e == 2) {
                    if (this.K == 0) {
                        mw0VarE3 = this.t.e();
                        long j5 = mw0VarE3.f.e;
                        if (!mw0VarE3.d && (j5 == j || this.y.r < j5 || !o())) {
                            b(3);
                            this.P = null;
                            if (o()) {
                                this.D = z4;
                                this.p.a();
                                ro1VarArr = this.b;
                                length2 = ro1VarArr.length;
                                for (r6 = z4; r6 < length2; r6++) {
                                    ro1Var = ro1VarArr[r6];
                                    if (b(ro1Var)) {
                                        ro1Var.start();
                                    }
                                }
                            }
                        } else if (this.y.e == 3) {
                            if (this.K == 0) {
                                mw0VarE2 = this.t.e();
                                long j6 = mw0VarE2.f.e;
                                if (mw0VarE2.d) {
                                    this.D = o();
                                    b(2);
                                    if (this.D) {
                                        for (mw0VarE = this.t.e(); mw0VarE != null; mw0VarE = mw0VarE.b()) {
                                            e70VarArr = mw0VarE.f().c;
                                            length = e70VarArr.length;
                                            for (r5 = z4; r5 < length; r5++) {
                                                e70Var = e70VarArr[r5];
                                                if (e70Var != null) {
                                                    e70Var.g();
                                                }
                                            }
                                        }
                                        ((yz) this.v).c();
                                    }
                                    q();
                                } else {
                                    this.D = o();
                                    b(2);
                                    if (this.D) {
                                        while (mw0VarE != null) {
                                            e70VarArr = mw0VarE.f().c;
                                            length = e70VarArr.length;
                                            while (r5 < length) {
                                                e70Var = e70VarArr[r5];
                                                if (e70Var != null) {
                                                    e70Var.g();
                                                }
                                            }
                                        }
                                        ((yz) this.v).c();
                                    }
                                    q();
                                }
                            } else if (!z) {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            }
                        }
                    } else {
                        if (z) {
                            if (vh1Var.g) {
                                if (a(vh1Var.f10479a, this.t.e().f.f9869a)) {
                                    jA = ((yz) this.v).a();
                                } else {
                                    jA = j;
                                }
                                mw0VarD = this.t.d();
                                if (mw0VarD.d || ((mw0VarD.e && mw0VarD.f9674a.getBufferedPositionUs() != Long.MIN_VALUE) || !mw0VarD.f.i)) {
                                    z5 = z4;
                                } else {
                                    z5 = true;
                                }
                                if (mw0VarD.f.f9869a.a() || mw0VarD.d) {
                                    z6 = z4;
                                } else {
                                    z6 = true;
                                }
                                if (!z5 || z6 || this.g.a(a(this.y.p), this.p.getPlaybackParameters().b, this.D, jA)) {
                                }
                            }
                            b(3);
                            this.P = null;
                            if (o()) {
                                this.D = z4;
                                this.p.a();
                                ro1VarArr = this.b;
                                length2 = ro1VarArr.length;
                                while (r6 < length2) {
                                    ro1Var = ro1VarArr[r6];
                                    if (b(ro1Var)) {
                                        ro1Var.start();
                                    }
                                }
                            }
                        }
                        if (this.y.e == 3) {
                            if (this.K == 0) {
                                mw0VarE2 = this.t.e();
                                long j7 = mw0VarE2.f.e;
                                if (mw0VarE2.d) {
                                    this.D = o();
                                    b(2);
                                    if (this.D) {
                                        while (mw0VarE != null) {
                                            e70VarArr = mw0VarE.f().c;
                                            length = e70VarArr.length;
                                            while (r5 < length) {
                                                e70Var = e70VarArr[r5];
                                                if (e70Var != null) {
                                                    e70Var.g();
                                                }
                                            }
                                        }
                                        ((yz) this.v).c();
                                    }
                                    q();
                                } else {
                                    this.D = o();
                                    b(2);
                                    if (this.D) {
                                        while (mw0VarE != null) {
                                            e70VarArr = mw0VarE.f().c;
                                            length = e70VarArr.length;
                                            while (r5 < length) {
                                                e70Var = e70VarArr[r5];
                                                if (e70Var != null) {
                                                    e70Var.g();
                                                }
                                            }
                                        }
                                        ((yz) this.v).c();
                                    }
                                    q();
                                }
                            } else if (!z) {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            }
                        }
                    }
                } else if (this.y.e == 3) {
                    if (this.K == 0) {
                        mw0VarE2 = this.t.e();
                        long j8 = mw0VarE2.f.e;
                        if (mw0VarE2.d || (j8 != j && this.y.r >= j8 && o())) {
                            this.D = o();
                            b(2);
                            if (this.D) {
                                while (mw0VarE != null) {
                                    e70VarArr = mw0VarE.f().c;
                                    length = e70VarArr.length;
                                    while (r5 < length) {
                                        e70Var = e70VarArr[r5];
                                        if (e70Var != null) {
                                            e70Var.g();
                                        }
                                    }
                                }
                                ((yz) this.v).c();
                            }
                            q();
                        }
                    } else if (!z) {
                        this.D = o();
                        b(2);
                        if (this.D) {
                            while (mw0VarE != null) {
                                e70VarArr = mw0VarE.f().c;
                                length = e70VarArr.length;
                                while (r5 < length) {
                                    e70Var = e70VarArr[r5];
                                    if (e70Var != null) {
                                        e70Var.g();
                                    }
                                }
                            }
                            ((yz) this.v).c();
                        }
                        q();
                    }
                }
            }
            if (this.y.e == 2) {
                r7 = z4;
                while (true) {
                    ro1VarArr2 = this.b;
                    if (r7 < ro1VarArr2.length) {
                        break;
                    }
                    if (!b(ro1VarArr2[r7]) && this.b[r7].g() == mw0VarE5.c[r7]) {
                        this.b[r7].i();
                    }
                    r7++;
                }
                vh1Var3 = this.y;
                if (!vh1Var3.g || vh1Var3.q >= 500000 || (mw0VarD2 = this.t.d()) == null) {
                    this.Q = j;
                } else if ((!mw0VarD2.d ? 0L : mw0VarD2.f9674a.getNextLoadPositionUs()) == Long.MIN_VALUE) {
                    this.Q = j;
                } else if (this.Q == j) {
                    this.Q = this.r.b();
                } else if (this.r.b() - this.Q >= 4000) {
                    throw new IllegalStateException("Playback stuck buffering and not loading");
                }
            } else {
                this.Q = j;
            }
            if (o() || this.y.e != 3) {
                z7 = z4;
            } else {
                z7 = true;
            }
            if (!this.J && this.I && z7) {
                z8 = true;
            } else {
                z8 = z4;
            }
            vh1Var2 = this.y;
            if (vh1Var2.o != z8) {
                this.y = new vh1(vh1Var2.f10479a, vh1Var2.b, vh1Var2.c, vh1Var2.d, vh1Var2.e, vh1Var2.f, vh1Var2.g, vh1Var2.h, vh1Var2.i, vh1Var2.j, vh1Var2.k, vh1Var2.l, vh1Var2.m, vh1Var2.n, vh1Var2.p, vh1Var2.q, vh1Var2.r, z8);
            }
            this.I = z4;
            if (!z8 || (i = this.y.e) == 4) {
            }
            if (!z7 && i != 2) {
                if (i == 3 && this.K != 0) {
                    this.i.a(jA2 + 1000);
                }
            } else {
                this.i.a(jA2 + 10);
            }
            n52.a();
            return;
        }
        j = -9223372036854775807L;
        if (z3) {
            z4 = false;
        } else {
            z4 = false;
        }
        if (!z3) {
            vh1Var = this.y;
            if (vh1Var.e == 2) {
                if (this.K == 0) {
                    mw0VarE3 = this.t.e();
                    long j9 = mw0VarE3.f.e;
                    if (!mw0VarE3.d) {
                    }
                    if (this.y.e == 3) {
                        if (this.K == 0) {
                            mw0VarE2 = this.t.e();
                            long j10 = mw0VarE2.f.e;
                            if (mw0VarE2.d) {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            } else {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            }
                        } else if (!z) {
                            this.D = o();
                            b(2);
                            if (this.D) {
                                while (mw0VarE != null) {
                                    e70VarArr = mw0VarE.f().c;
                                    length = e70VarArr.length;
                                    while (r5 < length) {
                                        e70Var = e70VarArr[r5];
                                        if (e70Var != null) {
                                            e70Var.g();
                                        }
                                    }
                                }
                                ((yz) this.v).c();
                            }
                            q();
                        }
                    }
                } else {
                    if (z) {
                        if (vh1Var.g) {
                            if (a(vh1Var.f10479a, this.t.e().f.f9869a)) {
                                jA = ((yz) this.v).a();
                            } else {
                                jA = j;
                            }
                            mw0VarD = this.t.d();
                            if (mw0VarD.d) {
                                z5 = z4;
                            } else {
                                z5 = z4;
                            }
                            if (mw0VarD.f.f9869a.a()) {
                                z6 = z4;
                            } else {
                                z6 = z4;
                            }
                            if (!z5) {
                            }
                        }
                        b(3);
                        this.P = null;
                        if (o()) {
                            this.D = z4;
                            this.p.a();
                            ro1VarArr = this.b;
                            length2 = ro1VarArr.length;
                            while (r6 < length2) {
                                ro1Var = ro1VarArr[r6];
                                if (b(ro1Var)) {
                                    ro1Var.start();
                                }
                            }
                        }
                    }
                    if (this.y.e == 3) {
                        if (this.K == 0) {
                            mw0VarE2 = this.t.e();
                            long j11 = mw0VarE2.f.e;
                            if (mw0VarE2.d) {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            } else {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            }
                        } else if (!z) {
                            this.D = o();
                            b(2);
                            if (this.D) {
                                while (mw0VarE != null) {
                                    e70VarArr = mw0VarE.f().c;
                                    length = e70VarArr.length;
                                    while (r5 < length) {
                                        e70Var = e70VarArr[r5];
                                        if (e70Var != null) {
                                            e70Var.g();
                                        }
                                    }
                                }
                                ((yz) this.v).c();
                            }
                            q();
                        }
                    }
                }
            } else if (this.y.e == 3) {
                if (this.K == 0) {
                    mw0VarE2 = this.t.e();
                    long j12 = mw0VarE2.f.e;
                    if (mw0VarE2.d) {
                        this.D = o();
                        b(2);
                        if (this.D) {
                            while (mw0VarE != null) {
                                e70VarArr = mw0VarE.f().c;
                                length = e70VarArr.length;
                                while (r5 < length) {
                                    e70Var = e70VarArr[r5];
                                    if (e70Var != null) {
                                        e70Var.g();
                                    }
                                }
                            }
                            ((yz) this.v).c();
                        }
                        q();
                    } else {
                        this.D = o();
                        b(2);
                        if (this.D) {
                            while (mw0VarE != null) {
                                e70VarArr = mw0VarE.f().c;
                                length = e70VarArr.length;
                                while (r5 < length) {
                                    e70Var = e70VarArr[r5];
                                    if (e70Var != null) {
                                        e70Var.g();
                                    }
                                }
                            }
                            ((yz) this.v).c();
                        }
                        q();
                    }
                } else if (!z) {
                    this.D = o();
                    b(2);
                    if (this.D) {
                        while (mw0VarE != null) {
                            e70VarArr = mw0VarE.f().c;
                            length = e70VarArr.length;
                            while (r5 < length) {
                                e70Var = e70VarArr[r5];
                                if (e70Var != null) {
                                    e70Var.g();
                                }
                            }
                        }
                        ((yz) this.v).c();
                    }
                    q();
                }
            }
        } else {
            vh1Var = this.y;
            if (vh1Var.e == 2) {
                if (this.K == 0) {
                    mw0VarE3 = this.t.e();
                    long j13 = mw0VarE3.f.e;
                    if (!mw0VarE3.d) {
                    }
                    if (this.y.e == 3) {
                        if (this.K == 0) {
                            mw0VarE2 = this.t.e();
                            long j14 = mw0VarE2.f.e;
                            if (mw0VarE2.d) {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            } else {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            }
                        } else if (!z) {
                            this.D = o();
                            b(2);
                            if (this.D) {
                                while (mw0VarE != null) {
                                    e70VarArr = mw0VarE.f().c;
                                    length = e70VarArr.length;
                                    while (r5 < length) {
                                        e70Var = e70VarArr[r5];
                                        if (e70Var != null) {
                                            e70Var.g();
                                        }
                                    }
                                }
                                ((yz) this.v).c();
                            }
                            q();
                        }
                    }
                } else {
                    if (z) {
                        if (vh1Var.g) {
                            if (a(vh1Var.f10479a, this.t.e().f.f9869a)) {
                                jA = ((yz) this.v).a();
                            } else {
                                jA = j;
                            }
                            mw0VarD = this.t.d();
                            if (mw0VarD.d) {
                                z5 = z4;
                            } else {
                                z5 = z4;
                            }
                            if (mw0VarD.f.f9869a.a()) {
                                z6 = z4;
                            } else {
                                z6 = z4;
                            }
                            if (!z5) {
                            }
                        }
                        b(3);
                        this.P = null;
                        if (o()) {
                            this.D = z4;
                            this.p.a();
                            ro1VarArr = this.b;
                            length2 = ro1VarArr.length;
                            while (r6 < length2) {
                                ro1Var = ro1VarArr[r6];
                                if (b(ro1Var)) {
                                    ro1Var.start();
                                }
                            }
                        }
                    }
                    if (this.y.e == 3) {
                        if (this.K == 0) {
                            mw0VarE2 = this.t.e();
                            long j15 = mw0VarE2.f.e;
                            if (mw0VarE2.d) {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            } else {
                                this.D = o();
                                b(2);
                                if (this.D) {
                                    while (mw0VarE != null) {
                                        e70VarArr = mw0VarE.f().c;
                                        length = e70VarArr.length;
                                        while (r5 < length) {
                                            e70Var = e70VarArr[r5];
                                            if (e70Var != null) {
                                                e70Var.g();
                                            }
                                        }
                                    }
                                    ((yz) this.v).c();
                                }
                                q();
                            }
                        } else if (!z) {
                            this.D = o();
                            b(2);
                            if (this.D) {
                                while (mw0VarE != null) {
                                    e70VarArr = mw0VarE.f().c;
                                    length = e70VarArr.length;
                                    while (r5 < length) {
                                        e70Var = e70VarArr[r5];
                                        if (e70Var != null) {
                                            e70Var.g();
                                        }
                                    }
                                }
                                ((yz) this.v).c();
                            }
                            q();
                        }
                    }
                }
            } else if (this.y.e == 3) {
                if (this.K == 0) {
                    mw0VarE2 = this.t.e();
                    long j16 = mw0VarE2.f.e;
                    if (mw0VarE2.d) {
                        this.D = o();
                        b(2);
                        if (this.D) {
                            while (mw0VarE != null) {
                                e70VarArr = mw0VarE.f().c;
                                length = e70VarArr.length;
                                while (r5 < length) {
                                    e70Var = e70VarArr[r5];
                                    if (e70Var != null) {
                                        e70Var.g();
                                    }
                                }
                            }
                            ((yz) this.v).c();
                        }
                        q();
                    } else {
                        this.D = o();
                        b(2);
                        if (this.D) {
                            while (mw0VarE != null) {
                                e70VarArr = mw0VarE.f().c;
                                length = e70VarArr.length;
                                while (r5 < length) {
                                    e70Var = e70VarArr[r5];
                                    if (e70Var != null) {
                                        e70Var.g();
                                    }
                                }
                            }
                            ((yz) this.v).c();
                        }
                        q();
                    }
                } else if (!z) {
                    this.D = o();
                    b(2);
                    if (this.D) {
                        while (mw0VarE != null) {
                            e70VarArr = mw0VarE.f().c;
                            length = e70VarArr.length;
                            while (r5 < length) {
                                e70Var = e70VarArr[r5];
                                if (e70Var != null) {
                                    e70Var.g();
                                }
                            }
                        }
                        ((yz) this.v).c();
                    }
                    q();
                }
            }
        }
        if (this.y.e == 2) {
            r7 = z4;
            while (true) {
                ro1VarArr2 = this.b;
                if (r7 < ro1VarArr2.length) {
                    break;
                    break;
                } else {
                    if (!b(ro1VarArr2[r7])) {
                    }
                    r7++;
                }
            }
            vh1Var3 = this.y;
            if (vh1Var3.g) {
                this.Q = j;
            } else {
                this.Q = j;
            }
        } else {
            this.Q = j;
        }
        if (o()) {
            z7 = z4;
        } else {
            z7 = z4;
        }
        if (!this.J) {
            z8 = z4;
        } else {
            z8 = z4;
        }
        vh1Var2 = this.y;
        if (vh1Var2.o != z8) {
            this.y = new vh1(vh1Var2.f10479a, vh1Var2.b, vh1Var2.c, vh1Var2.d, vh1Var2.e, vh1Var2.f, vh1Var2.g, vh1Var2.h, vh1Var2.i, vh1Var2.j, vh1Var2.k, vh1Var2.l, vh1Var2.m, vh1Var2.n, vh1Var2.p, vh1Var2.q, vh1Var2.r, z8);
        }
        this.I = z4;
        if (z8) {
        }
    }

    private void e(boolean z) throws j60 {
        this.G = z;
        if (!this.t.a(this.y.f10479a, z)) {
            b(true);
        }
        a(false);
    }

    private void l() {
        a(true, false, true, false);
        this.g.b();
        b(1);
        this.j.quit();
        synchronized (this) {
            this.A = true;
            notifyAll();
        }
    }

    private void m() throws j60 {
        float f2 = this.p.getPlaybackParameters().b;
        mw0 mw0VarF = this.t.f();
        boolean z = true;
        for (mw0 mw0VarE = this.t.e(); mw0VarE != null && mw0VarE.d; mw0VarE = mw0VarE.b()) {
            z52 z52VarB = mw0VarE.b(f2, this.y.f10479a);
            z52 z52VarF = mw0VarE.f();
            if (z52VarF != null && z52VarF.c.length == z52VarB.c.length) {
                int i = 0;
                while (true) {
                    if (i < z52VarB.c.length) {
                        if (x82.a(z52VarB.b[i], z52VarF.b[i]) && x82.a(z52VarB.c[i], z52VarF.c[i])) {
                            i++;
                        }
                    } else {
                        if (mw0VarE == mw0VarF) {
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                mw0 mw0VarE2 = this.t.e();
                boolean zA = this.t.a(mw0VarE2);
                boolean[] zArr = new boolean[this.b.length];
                long jA = mw0VarE2.a(z52VarB, this.y.r, zA, zArr);
                vh1 vh1Var = this.y;
                boolean z2 = (vh1Var.e == 4 || jA == vh1Var.r) ? false : true;
                vh1 vh1Var2 = this.y;
                this.y = a(vh1Var2.b, jA, vh1Var2.c, vh1Var2.d, z2, 5);
                if (z2) {
                    b(jA);
                }
                boolean[] zArr2 = new boolean[this.b.length];
                int i2 = 0;
                while (true) {
                    ro1[] ro1VarArr = this.b;
                    if (i2 >= ro1VarArr.length) {
                        break;
                    }
                    ro1 ro1Var = ro1VarArr[i2];
                    boolean zB = b(ro1Var);
                    zArr2[i2] = zB;
                    et1 et1Var = mw0VarE2.c[i2];
                    if (zB) {
                        if (et1Var != ro1Var.g()) {
                            a(ro1Var);
                        } else if (zArr[i2]) {
                            ro1Var.a(this.M);
                        }
                    }
                    i2++;
                }
                a(zArr2);
            } else {
                this.t.a(mw0VarE);
                if (mw0VarE.d) {
                    mw0VarE.a(z52VarB, Math.max(mw0VarE.f.b, mw0VarE.c(this.M)));
                }
            }
            a(true);
            if (this.y.e != 4) {
                f();
                s();
                this.i.a(2);
                return;
            }
            return;
        }
    }

    private long c() {
        mw0 mw0VarF = this.t.f();
        if (mw0VarF == null) {
            return 0L;
        }
        long jC = mw0VarF.c();
        if (!mw0VarF.d) {
            return jC;
        }
        int i = 0;
        while (true) {
            ro1[] ro1VarArr = this.b;
            if (i >= ro1VarArr.length) {
                return jC;
            }
            if (b(ro1VarArr[i]) && this.b[i].g() == mw0VarF.c[i]) {
                long j = this.b[i].j();
                if (j == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jC = Math.max(j, jC);
            }
            i++;
        }
    }

    private void d(final ji1 ji1Var) {
        Looper looperA = ji1Var.a();
        if (!looperA.getThread().isAlive()) {
            at0.d("TAG", "Trying to send message on a dead thread.");
            ji1Var.a(false);
        } else {
            this.r.a(looperA, null).a(new Runnable() { // from class: com.yandex.mobile.ads.impl.q60$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(ji1Var);
                }
            });
        }
    }

    private void n() {
        mw0 mw0VarE = this.t.e();
        this.C = mw0VarE != null && mw0VarE.f.h && this.B;
    }

    private void r() {
        mw0 mw0VarD = this.t.d();
        boolean z = this.E || (mw0VarD != null && mw0VarD.f9674a.isLoading());
        vh1 vh1Var = this.y;
        if (z != vh1Var.g) {
            this.y = new vh1(vh1Var.f10479a, vh1Var.b, vh1Var.c, vh1Var.d, vh1Var.e, vh1Var.f, z, vh1Var.h, vh1Var.i, vh1Var.j, vh1Var.k, vh1Var.l, vh1Var.m, vh1Var.n, vh1Var.p, vh1Var.q, vh1Var.r, vh1Var.o);
        }
    }

    private void a(ro1 ro1Var) throws j60 {
        if (b(ro1Var)) {
            this.p.a(ro1Var);
            if (ro1Var.getState() == 2) {
                ro1Var.stop();
            }
            ro1Var.c();
            this.K--;
        }
    }

    private boolean o() {
        vh1 vh1Var = this.y;
        return vh1Var.l && vh1Var.m == 0;
    }

    private void d(boolean z) throws j60 {
        this.B = z;
        n();
        if (!this.C || this.t.f() == this.t.e()) {
            return;
        }
        b(true);
        a(false);
    }

    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b52 f9988a;
        public final int b;
        public final long c;

        public g(b52 b52Var, int i, long j) {
            this.f9988a = b52Var;
            this.b = i;
            this.c = j;
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw0.b f9987a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public f(rw0.b bVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.f9987a = bVar;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }
    }

    private static final class c implements Comparable<c> {
        @Override // java.lang.Comparable
        public final int compareTo(c cVar) {
            cVar.getClass();
            return 0;
        }
    }

    private void b(lw0 lw0Var) {
        if (this.t.a(lw0Var)) {
            this.t.a(this.M);
            f();
        }
    }

    private void c(lw0 lw0Var) throws j60 {
        if (this.t.a(lw0Var)) {
            mw0 mw0VarD = this.t.d();
            mw0VarD.a(this.p.getPlaybackParameters().b, this.y.f10479a);
            this.g.a(this.b, mw0VarD.f().c);
            if (mw0VarD == this.t.e()) {
                b(mw0VarD.f.b);
                a(new boolean[this.b.length]);
                vh1 vh1Var = this.y;
                rw0.b bVar = vh1Var.b;
                long j = mw0VarD.f.b;
                this.y = a(bVar, j, vh1Var.c, j, false, 5);
            }
            f();
        }
    }

    public final synchronized void c(ji1 ji1Var) {
        if (!this.A && this.j.isAlive()) {
            this.i.a(14, ji1Var).a();
            return;
        }
        at0.d("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        ji1Var.a(false);
    }

    private void a(boolean[] zArr) throws j60 {
        mw0 mw0VarF = this.t.f();
        z52 z52VarF = mw0VarF.f();
        for (int i = 0; i < this.b.length; i++) {
            if (!z52VarF.a(i) && this.c.remove(this.b[i])) {
                this.b[i].b();
            }
        }
        for (int i2 = 0; i2 < this.b.length; i2++) {
            if (z52VarF.a(i2)) {
                boolean z = zArr[i2];
                ro1 ro1Var = this.b[i2];
                if (!b(ro1Var)) {
                    mw0 mw0VarF2 = this.t.f();
                    boolean z2 = mw0VarF2 == this.t.e();
                    z52 z52VarF2 = mw0VarF2.f();
                    to1 to1Var = z52VarF2.b[i2];
                    e70 e70Var = z52VarF2.c[i2];
                    int iB = e70Var != null ? e70Var.b() : 0;
                    gc0[] gc0VarArr = new gc0[iB];
                    for (int i3 = 0; i3 < iB; i3++) {
                        gc0VarArr[i3] = e70Var.a(i3);
                    }
                    boolean z3 = o() && this.y.e == 3;
                    boolean z4 = !z && z3;
                    this.K++;
                    this.c.add(ro1Var);
                    ro1Var.a(to1Var, gc0VarArr, mw0VarF2.c[i2], this.M, z4, z2, mw0VarF2.d(), mw0VarF2.c());
                    ro1Var.a(11, new p60(this));
                    this.p.b(ro1Var);
                    if (z3) {
                        ro1Var.start();
                    }
                }
            }
        }
        mw0VarF.g = true;
    }

    private void c(boolean z) {
        if (z == this.J) {
            return;
        }
        this.J = z;
        if (z || !this.y.o) {
            return;
        }
        this.i.a(2);
    }

    private long a(b52 b52Var, Object obj, long j) {
        long jElapsedRealtime;
        b52Var.a(b52Var.a(obj, this.m).d, this.l, 0L);
        b52.d dVar = this.l;
        if (dVar.g != -9223372036854775807L && dVar.a()) {
            b52.d dVar2 = this.l;
            if (dVar2.j) {
                long j2 = dVar2.h;
                int i = x82.f10629a;
                if (j2 == -9223372036854775807L) {
                    jElapsedRealtime = System.currentTimeMillis();
                } else {
                    jElapsedRealtime = j2 + SystemClock.elapsedRealtime();
                }
                return x82.a(jElapsedRealtime - this.l.g) - (j + this.m.f);
            }
        }
        return -9223372036854775807L;
    }

    private static boolean b(ro1 ro1Var) {
        return ro1Var.getState() != 0;
    }

    private Pair<rw0.b, Long> a(b52 b52Var) {
        long jB = 0;
        if (b52Var.c()) {
            return Pair.create(vh1.a(), 0L);
        }
        Pair<Object, Long> pairA = b52Var.a(this.l, this.m, b52Var.a(this.G), -9223372036854775807L);
        rw0.b bVarA = this.t.a(b52Var, pairA.first, 0L);
        long jLongValue = ((Long) pairA.second).longValue();
        if (bVarA.a()) {
            b52Var.a(bVarA.f9759a, this.m);
            if (bVarA.c == this.m.d(bVarA.b)) {
                jB = this.m.b();
            }
        } else {
            jB = jLongValue;
        }
        return Pair.create(bVarA, Long.valueOf(jB));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ji1 ji1Var) {
        try {
            a(ji1Var);
        } catch (j60 e2) {
            at0.a("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void b(long j) throws j60 {
        mw0 mw0VarE = this.t.e();
        long jD = mw0VarE == null ? j + 1000000000000L : mw0VarE.d(j);
        this.M = jD;
        this.p.a(jD);
        for (ro1 ro1Var : this.b) {
            if (b(ro1Var)) {
                ro1Var.a(this.M);
            }
        }
        for (mw0 mw0VarE2 = this.t.e(); mw0VarE2 != null; mw0VarE2 = mw0VarE2.b()) {
            for (e70 e70Var : mw0VarE2.f().c) {
                if (e70Var != null) {
                    e70Var.f();
                }
            }
        }
    }

    private long a(long j) {
        mw0 mw0VarD = this.t.d();
        if (mw0VarD == null) {
            return 0L;
        }
        return Math.max(0L, j - mw0VarD.c(this.M));
    }

    private void b(boolean z) throws j60 {
        rw0.b bVar = this.t.e().f.f9869a;
        long jA = a(bVar, this.y.r, true, false);
        if (jA != this.y.r) {
            vh1 vh1Var = this.y;
            this.y = a(bVar, jA, vh1Var.c, vh1Var.d, z, 5);
        }
    }

    private void a(IOException iOException, int i) {
        j60 j60VarA = j60.a(iOException, i);
        mw0 mw0VarE = this.t.e();
        if (mw0VarE != null) {
            j60VarA = j60VarA.a(mw0VarE.f.f9869a);
        }
        at0.a("ExoPlayerImplInternal", "Playback error", j60VarA);
        a(false, false);
        this.y = this.y.a(j60VarA);
    }

    private void b(xh1 xh1Var) throws j60 {
        this.p.a(xh1Var);
        xh1 playbackParameters = this.p.getPlaybackParameters();
        a(playbackParameters, playbackParameters.b, true, true);
    }

    private void b(int i) {
        vh1 vh1Var = this.y;
        if (vh1Var.e != i) {
            if (i != 2) {
                this.Q = -9223372036854775807L;
            }
            this.y = vh1Var.a(i);
        }
    }

    private void a(boolean z) {
        long j;
        mw0 mw0VarD = this.t.d();
        rw0.b bVar = mw0VarD == null ? this.y.b : mw0VarD.f.f9869a;
        boolean zEquals = this.y.k.equals(bVar);
        if (!zEquals) {
            this.y = this.y.a(bVar);
        }
        vh1 vh1Var = this.y;
        if (mw0VarD == null) {
            j = vh1Var.r;
        } else if (!mw0VarD.d) {
            j = mw0VarD.f.b;
        } else {
            long bufferedPositionUs = mw0VarD.e ? mw0VarD.f9674a.getBufferedPositionUs() : Long.MIN_VALUE;
            j = bufferedPositionUs == Long.MIN_VALUE ? mw0VarD.f.e : bufferedPositionUs;
        }
        vh1Var.p = j;
        vh1 vh1Var2 = this.y;
        vh1Var2.q = a(vh1Var2.p);
        if ((!zEquals || z) && mw0VarD != null && mw0VarD.d) {
            this.g.a(this.b, mw0VarD.f().c);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v49 ??, still in use, count: 1, list:
          (r0v49 ?? I:??[OBJECT, ARRAY]) from 0x0036: MOVE (r7v26 ?? I:??[OBJECT, ARRAY]) = (r0v49 ?? I:??[OBJECT, ARRAY])
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private void a(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v49 ??, still in use, count: 1, list:
          (r0v49 ?? I:??[OBJECT, ARRAY]) from 0x0036: MOVE (r7v26 ?? I:??[OBJECT, ARRAY]) = (r0v49 ?? I:??[OBJECT, ARRAY])
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r39v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
        */

    private void a(xh1 xh1Var, float f2, boolean z, boolean z2) throws j60 {
        int i;
        q60 q60Var = this;
        if (z) {
            if (z2) {
                q60Var.z.a(1);
            }
            vh1 vh1Var = q60Var.y;
            q60Var = this;
            q60Var.y = new vh1(vh1Var.f10479a, vh1Var.b, vh1Var.c, vh1Var.d, vh1Var.e, vh1Var.f, vh1Var.g, vh1Var.h, vh1Var.i, vh1Var.j, vh1Var.k, vh1Var.l, vh1Var.m, xh1Var, vh1Var.p, vh1Var.q, vh1Var.r, vh1Var.o);
        }
        float f3 = xh1Var.b;
        mw0 mw0VarE = q60Var.t.e();
        while (true) {
            i = 0;
            if (mw0VarE == null) {
                break;
            }
            e70[] e70VarArr = mw0VarE.f().c;
            int length = e70VarArr.length;
            while (i < length) {
                e70 e70Var = e70VarArr[i];
                if (e70Var != null) {
                    e70Var.a(f3);
                }
                i++;
            }
            mw0VarE = mw0VarE.b();
        }
        ro1[] ro1VarArr = q60Var.b;
        int length2 = ro1VarArr.length;
        while (i < length2) {
            ro1 ro1Var = ro1VarArr[i];
            if (ro1Var != null) {
                ro1Var.a(f2, xh1Var.b);
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
    private vh1 a(rw0.b bVar, long j, long j2, long j3, boolean z, int i) {
        List<g01> listH;
        s52 s52Var;
        z52 z52Var;
        s52 s52VarE;
        z52 z52VarF;
        this.O = (!this.O && j == this.y.r && bVar.equals(this.y.b)) ? false : true;
        n();
        vh1 vh1Var = this.y;
        s52 s52Var2 = vh1Var.h;
        z52 z52Var2 = vh1Var.i;
        List<g01> list = vh1Var.j;
        if (this.u.c()) {
            mw0 mw0VarE = this.t.e();
            if (mw0VarE == null) {
                s52VarE = s52.e;
            } else {
                s52VarE = mw0VarE.e();
            }
            s52 s52Var3 = s52VarE;
            if (mw0VarE == null) {
                z52VarF = this.f;
            } else {
                z52VarF = mw0VarE.f();
            }
            z52 z52Var3 = z52VarF;
            e70[] e70VarArr = z52Var3.c;
            hk0.a aVar = new hk0.a();
            boolean z2 = false;
            for (e70 e70Var : e70VarArr) {
                if (e70Var != null) {
                    g01 g01Var = e70Var.a(0).k;
                    if (g01Var == null) {
                        aVar.b(new g01(new g01.b[0]));
                    } else {
                        aVar.b(g01Var);
                        z2 = true;
                    }
                }
            }
            hk0 hk0VarA = z2 ? aVar.a() : hk0.h();
            if (mw0VarE != null) {
                ow0 ow0Var = mw0VarE.f;
                long j4 = ow0Var.c;
                if (j4 != j2) {
                    if (j2 != j4) {
                        ow0Var = new ow0(ow0Var.f9869a, ow0Var.b, j2, ow0Var.d, ow0Var.e, ow0Var.f, ow0Var.g, ow0Var.h, ow0Var.i);
                    }
                    mw0VarE.f = ow0Var;
                } else {
                    z52Var3 = z52Var3;
                }
            } else {
                z52Var3 = z52Var3;
            }
            s52Var = s52Var3;
            listH = hk0VarA;
            z52Var = z52Var3;
        } else if (bVar.equals(this.y.b)) {
            listH = list;
            s52Var = s52Var2;
            z52Var = z52Var2;
        } else {
            s52Var = s52.e;
            z52Var = this.f;
            listH = hk0.h();
        }
        if (z) {
            d dVar = this.z;
            if (!dVar.d || dVar.e == 5) {
                dVar.f9986a = true;
                dVar.d = true;
                dVar.e = i;
            } else if (i != 5) {
                throw new IllegalArgumentException();
            }
        }
        vh1 vh1Var2 = this.y;
        return vh1Var2.a(bVar, j, j2, j3, a(vh1Var2.p), s52Var, z52Var, listH);
    }

    private void a(b bVar) throws j60 {
        this.z.a(1);
        uw0 uw0Var = this.u;
        bVar.getClass();
        a(uw0Var.d(), false);
    }

    @Override // com.yandex.mobile.ads.impl.fx1.a
    public final void a(fx1 fx1Var) {
        this.i.a(9, (lw0) fx1Var).a();
    }

    public final void a(xh1 xh1Var) {
        this.i.a(16, xh1Var).a();
    }

    @Override // com.yandex.mobile.ads.impl.lw0.a
    public final void a(lw0 lw0Var) {
        this.i.a(8, lw0Var).a();
    }

    @Override // com.yandex.mobile.ads.impl.y52.a
    public final void a() {
        this.i.a(10);
    }

    private void a(int i, int i2, by1 by1Var) throws j60 {
        this.z.a(1);
        a(this.u.a(i, i2, by1Var), false);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af A[PHI: r4 r5 r7
  0x00af: PHI (r4v3 com.yandex.mobile.ads.impl.rw0$b) = (r4v2 com.yandex.mobile.ads.impl.rw0$b), (r4v9 com.yandex.mobile.ads.impl.rw0$b) binds: [B:32:0x0086, B:34:0x00ab] A[DONT_GENERATE, DONT_INLINE]
  0x00af: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:32:0x0086, B:34:0x00ab] A[DONT_GENERATE, DONT_INLINE]
  0x00af: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:32:0x0086, B:34:0x00ab] A[DONT_GENERATE, DONT_INLINE]] */
    private void a(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        boolean z5;
        this.i.c();
        this.P = null;
        this.D = false;
        this.p.b();
        this.M = 1000000000000L;
        for (ro1 ro1Var : this.b) {
            try {
                a(ro1Var);
            } catch (j60 | RuntimeException e2) {
                at0.a("ExoPlayerImplInternal", "Disable failed.", e2);
            }
        }
        if (z) {
            for (ro1 ro1Var2 : this.b) {
                if (this.c.remove(ro1Var2)) {
                    try {
                        ro1Var2.b();
                    } catch (RuntimeException e3) {
                        at0.a("ExoPlayerImplInternal", "Reset failed.", e3);
                    }
                }
            }
        }
        this.K = 0;
        vh1 vh1Var = this.y;
        rw0.b bVar = vh1Var.b;
        long jLongValue = vh1Var.r;
        if (!this.y.b.a()) {
            vh1 vh1Var2 = this.y;
            b52.b bVar2 = this.m;
            rw0.b bVar3 = vh1Var2.b;
            b52 b52Var = vh1Var2.f10479a;
            if (!b52Var.c() && !b52Var.a(bVar3.f9759a, bVar2).g) {
                j = this.y.r;
            } else {
                j = this.y.c;
            }
        } else {
            j = this.y.c;
        }
        if (z2) {
            this.L = null;
            Pair<rw0.b, Long> pairA = a(this.y.f10479a);
            bVar = (rw0.b) pairA.first;
            jLongValue = ((Long) pairA.second).longValue();
            j = -9223372036854775807L;
            if (bVar.equals(this.y.b)) {
                z5 = false;
            } else {
                z5 = true;
            }
        } else {
            z5 = false;
        }
        rw0.b bVar4 = bVar;
        long j2 = jLongValue;
        this.t.c();
        this.E = false;
        vh1 vh1Var3 = this.y;
        b52 b52Var2 = vh1Var3.f10479a;
        int i = vh1Var3.e;
        j60 j60Var = z4 ? null : vh1Var3.f;
        s52 s52Var = z5 ? s52.e : vh1Var3.h;
        z52 z52Var = z5 ? this.f : vh1Var3.i;
        List listH = z5 ? hk0.h() : vh1Var3.j;
        vh1 vh1Var4 = this.y;
        this.y = new vh1(b52Var2, bVar4, j, j2, i, j60Var, false, s52Var, z52Var, listH, bVar4, vh1Var4.l, vh1Var4.m, vh1Var4.n, j2, 0L, j2, false);
        if (z3) {
            this.u.e();
        }
    }

    private void a(b52 b52Var, b52 b52Var2) {
        if (b52Var.c() && b52Var2.c()) {
            return;
        }
        int size = this.q.size() - 1;
        if (size < 0) {
            Collections.sort(this.q);
        } else {
            this.q.get(size).getClass();
            throw null;
        }
    }

    private static Pair<Object, Long> a(b52 b52Var, g gVar, boolean z, int i, boolean z2, b52.d dVar, b52.b bVar) {
        Object objA;
        b52 b52Var2 = gVar.f9988a;
        if (b52Var.c()) {
            return null;
        }
        b52 b52Var3 = b52Var2.c() ? b52Var : b52Var2;
        try {
            Pair<Object, Long> pairA = b52Var3.a(dVar, bVar, gVar.b, gVar.c);
            if (b52Var.equals(b52Var3)) {
                return pairA;
            }
            if (b52Var.a(pairA.first) != -1) {
                return (b52Var3.a(pairA.first, bVar).g && b52Var3.a(bVar.d, dVar, 0L).p == b52Var3.a(pairA.first)) ? b52Var.a(dVar, bVar, b52Var.a(pairA.first, bVar).d, gVar.c) : pairA;
            }
            if (z && (objA = a(dVar, bVar, i, z2, pairA.first, b52Var3, b52Var)) != null) {
                return b52Var.a(dVar, bVar, b52Var.a(objA, bVar).d, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    static Object a(b52.d dVar, b52.b bVar, int i, boolean z, Object obj, b52 b52Var, b52 b52Var2) {
        int iA = b52Var.a(obj);
        int iA2 = b52Var.a();
        int iA3 = iA;
        int iA4 = -1;
        for (int i2 = 0; i2 < iA2 && iA4 == -1; i2++) {
            iA3 = b52Var.a(iA3, bVar, dVar, i, z);
            if (iA3 == -1) {
                break;
            }
            iA4 = b52Var2.a(b52Var.a(iA3));
        }
        if (iA4 == -1) {
            return null;
        }
        return b52Var2.a(iA4);
    }

    private void a(g gVar) throws Throwable {
        long j;
        long j2;
        rw0.b bVar;
        boolean z;
        long j3;
        long j4;
        long j5;
        vh1 vh1Var;
        int i;
        this.z.a(1);
        Pair<Object, Long> pairA = a(this.y.f10479a, gVar, true, this.F, this.G, this.l, this.m);
        if (pairA == null) {
            Pair<rw0.b, Long> pairA2 = a(this.y.f10479a);
            bVar = (rw0.b) pairA2.first;
            long jLongValue = ((Long) pairA2.second).longValue();
            z = !this.y.f10479a.c();
            j = jLongValue;
            j2 = -9223372036854775807L;
        } else {
            Object obj = pairA.first;
            long jLongValue2 = ((Long) pairA.second).longValue();
            long j6 = gVar.c == -9223372036854775807L ? -9223372036854775807L : jLongValue2;
            rw0.b bVarA = this.t.a(this.y.f10479a, obj, jLongValue2);
            if (bVarA.a()) {
                this.y.f10479a.a(bVarA.f9759a, this.m);
                jLongValue2 = this.m.d(bVarA.b) == bVarA.c ? this.m.b() : 0L;
            } else if (gVar.c != -9223372036854775807L) {
                j = jLongValue2;
                j2 = j6;
                bVar = bVarA;
                z = false;
            }
            j = jLongValue2;
            j2 = j6;
            bVar = bVarA;
            z = true;
        }
        try {
            if (this.y.f10479a.c()) {
                this.L = gVar;
            } else {
                if (pairA == null) {
                    if (this.y.e != 1) {
                        b(4);
                    }
                    a(false, true, false, true);
                } else {
                    if (bVar.equals(this.y.b)) {
                        mw0 mw0VarE = this.t.e();
                        long jA = (mw0VarE == null || !mw0VarE.d || j == 0) ? j : mw0VarE.f9674a.a(j, this.x);
                        if (x82.b(jA) == x82.b(this.y.r) && ((i = (vh1Var = this.y).e) == 2 || i == 3)) {
                            long j7 = vh1Var.r;
                            this.y = a(bVar, j7, j2, j7, z, 2);
                            return;
                        }
                        j4 = jA;
                    } else {
                        j4 = j;
                    }
                    long jA2 = a(bVar, j4, this.t.e() != this.t.f(), this.y.e == 4);
                    boolean z2 = (j != jA2) | z;
                    try {
                        vh1 vh1Var2 = this.y;
                        b52 b52Var = vh1Var2.f10479a;
                        a(b52Var, bVar, b52Var, vh1Var2.b, j2);
                        z = z2;
                        j5 = jA2;
                    } catch (Throwable th) {
                        th = th;
                        z = z2;
                        j3 = jA2;
                        this.y = a(bVar, j3, j2, j3, z, 2);
                        throw th;
                    }
                }
                this.y = a(bVar, j5, j2, j5, z, 2);
            }
            j5 = j;
            this.y = a(bVar, j5, j2, j5, z, 2);
        } catch (Throwable th2) {
            th = th2;
            j3 = j;
        }
    }

    private long a(rw0.b bVar, long j, boolean z, boolean z2) throws j60 {
        long jSeekToUs;
        q();
        this.D = false;
        if (z2 || this.y.e == 3) {
            b(2);
        }
        mw0 mw0VarE = this.t.e();
        mw0 mw0VarB = mw0VarE;
        while (mw0VarB != null && !bVar.equals(mw0VarB.f.f9869a)) {
            mw0VarB = mw0VarB.b();
        }
        if (z || mw0VarE != mw0VarB || (mw0VarB != null && mw0VarB.d(j) < 0)) {
            for (ro1 ro1Var : this.b) {
                a(ro1Var);
            }
            if (mw0VarB != null) {
                while (this.t.e() != mw0VarB) {
                    this.t.a();
                }
                this.t.a(mw0VarB);
                mw0VarB.h();
                a(new boolean[this.b.length]);
            }
        }
        if (mw0VarB != null) {
            this.t.a(mw0VarB);
            if (!mw0VarB.d) {
                ow0 ow0Var = mw0VarB.f;
                if (j != ow0Var.b) {
                    ow0Var = new ow0(ow0Var.f9869a, j, ow0Var.c, ow0Var.d, ow0Var.e, ow0Var.f, ow0Var.g, ow0Var.h, ow0Var.i);
                }
                mw0VarB.f = ow0Var;
            } else {
                mw0 mw0Var = mw0VarB;
                if (mw0Var.e) {
                    jSeekToUs = mw0Var.f9674a.seekToUs(j);
                    mw0Var.f9674a.discardBuffer(jSeekToUs - this.n, this.o);
                }
                b(jSeekToUs);
                f();
            }
            jSeekToUs = j;
            b(jSeekToUs);
            f();
        } else {
            this.t.c();
            b(j);
            jSeekToUs = j;
        }
        a(false);
        this.i.a(2);
        return jSeekToUs;
    }

    private void a(boolean z, AtomicBoolean atomicBoolean) {
        if (this.H != z) {
            this.H = z;
            if (!z) {
                for (ro1 ro1Var : this.b) {
                    if (!b(ro1Var) && this.c.remove(ro1Var)) {
                        ro1Var.b();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void a(a aVar) throws j60 {
        this.z.a(1);
        if (aVar.c != -1) {
            this.L = new g(new ej1(aVar.f9985a, aVar.b), aVar.c, aVar.d);
        }
        a(this.u.a(aVar.f9985a, aVar.b), false);
    }

    public final void a(int i, long j, by1 by1Var, ArrayList arrayList) {
        this.i.a(17, new a(i, j, by1Var, arrayList)).a();
    }

    public final void a(boolean z, int i) {
        this.i.a(z ? 1 : 0, i).a();
    }

    private void a(boolean z, int i, boolean z2, int i2) throws j60 {
        this.z.a(z2 ? 1 : 0);
        d dVar = this.z;
        dVar.f9986a = true;
        dVar.f = true;
        dVar.g = i2;
        vh1 vh1Var = this.y;
        this.y = new vh1(vh1Var.f10479a, vh1Var.b, vh1Var.c, vh1Var.d, vh1Var.e, vh1Var.f, vh1Var.g, vh1Var.h, vh1Var.i, vh1Var.j, vh1Var.k, z, i, vh1Var.n, vh1Var.p, vh1Var.q, vh1Var.r, vh1Var.o);
        this.D = false;
        for (mw0 mw0VarE = this.t.e(); mw0VarE != null; mw0VarE = mw0VarE.b()) {
            for (e70 e70Var : mw0VarE.f().c) {
                if (e70Var != null) {
                    e70Var.a(z);
                }
            }
        }
        if (!o()) {
            q();
            s();
            return;
        }
        int i3 = this.y.e;
        if (i3 != 3) {
            if (i3 == 2) {
                this.i.a(2);
                return;
            }
            return;
        }
        this.D = false;
        this.p.a();
        for (ro1 ro1Var : this.b) {
            if (b(ro1Var)) {
                ro1Var.start();
            }
        }
        this.i.a(2);
    }

    private void a(int i) throws j60 {
        this.F = i;
        if (!this.t.a(this.y.f10479a, i)) {
            b(true);
        }
        a(false);
    }

    private void a(by1 by1Var) throws j60 {
        this.z.a(1);
        a(this.u.a(by1Var), false);
    }

    private boolean a(b52 b52Var, rw0.b bVar) {
        if (bVar.a() || b52Var.c()) {
            return false;
        }
        b52Var.a(b52Var.a(bVar.f9759a, this.m).d, this.l, 0L);
        if (!this.l.a()) {
            return false;
        }
        b52.d dVar = this.l;
        return dVar.j && dVar.g != -9223372036854775807L;
    }

    private void a(boolean z, boolean z2) {
        a(z || !this.H, false, true, false);
        this.z.a(z2 ? 1 : 0);
        this.g.d();
        b(1);
    }

    private void a(b52 b52Var, rw0.b bVar, b52 b52Var2, rw0.b bVar2, long j) {
        if (!a(b52Var, bVar)) {
            xh1 xh1Var = bVar.a() ? xh1.e : this.y.n;
            if (this.p.getPlaybackParameters().equals(xh1Var)) {
                return;
            }
            this.p.a(xh1Var);
            return;
        }
        b52Var.a(b52Var.a(bVar.f9759a, this.m).d, this.l, 0L);
        xr0 xr0Var = this.v;
        fw0.e eVar = this.l.l;
        int i = x82.f10629a;
        ((yz) xr0Var).a(eVar);
        if (j != -9223372036854775807L) {
            ((yz) this.v).a(a(b52Var, bVar.f9759a, j));
            return;
        }
        if (x82.a(!b52Var2.c() ? b52Var2.a(b52Var2.a(bVar2.f9759a, this.m).d, this.l, 0L).b : null, this.l.b)) {
            return;
        }
        ((yz) this.v).a(-9223372036854775807L);
    }

    private synchronized void a(m32<Boolean> m32Var, long j) {
        long jB = this.r.b() + j;
        boolean z = false;
        while (!m32Var.get().booleanValue() && j > 0) {
            try {
                this.r.getClass();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jB - this.r.b();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }
}
