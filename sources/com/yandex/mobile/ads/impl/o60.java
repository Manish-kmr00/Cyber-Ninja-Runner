package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes10.dex */
final class o60 extends qk implements k60 {
    private int A;
    private int B;
    private boolean C;
    private int D;
    private by1 E;
    private di1.a F;
    private iw0 G;
    private AudioTrack H;
    private Object I;
    private Surface J;
    private TextureView K;
    private int L;
    private int M;
    private int N;
    private int O;
    private oh P;
    private float Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private f10 U;
    private iw0 V;
    private vh1 W;
    private int X;
    private long Y;
    final z52 b;
    final di1.a c;
    private final gr d;
    private final di1 e;
    private final ro1[] f;
    private final y52 g;
    private final ef0 h;
    private final q60 i;
    private final wr0<di1.b> j;
    private final CopyOnWriteArraySet<k60.a> k;
    private final b52.b l;
    private final ArrayList m;
    private final boolean n;
    private final rw0.a o;
    private final ed p;
    private final Looper q;
    private final vi r;
    private final r32 s;
    private final b t;
    private final ph u;
    private final sh v;
    private final t22 w;
    private final aj2 x;
    private final zj2 y;
    private final long z;

    /* JADX INFO: Access modifiers changed from: private */
    final class b implements nf2, uh, n42, k01, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, j12.b, sh.b, ph.b, t22.a, k60.a {
        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final void d() {
            final f10 f10VarA = o60.a(o60.this.w);
            if (f10VarA.equals(o60.this.U)) {
                return;
            }
            o60 o60Var = o60.this;
            o60Var.U = f10VarA;
            wr0 wr0Var = o60Var.j;
            wr0Var.a(29, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda3
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    ((di1.b) obj).a(f10VarA);
                }
            });
            wr0Var.a();
        }

        public final void e() {
            o60 o60Var = o60.this;
            o60Var.a(1, 2, Float.valueOf(o60Var.Q * o60Var.v.b()));
        }

        private b() {
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void d(my myVar) {
            o60.this.getClass();
            o60.this.p.d(myVar);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void onSkipSilenceEnabledChanged(final boolean z) {
            o60 o60Var = o60.this;
            if (o60Var.R == z) {
                return;
            }
            o60Var.R = z;
            wr0 wr0Var = o60Var.j;
            wr0Var.a(23, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda4
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    ((di1.b) obj).onSkipSilenceEnabledChanged(z);
                }
            });
            wr0Var.a();
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void b(Exception exc) {
            o60.this.p.b(exc);
        }

        @Override // com.yandex.mobile.ads.impl.n42
        public final void onCues(final List<ev> list) {
            wr0 wr0Var = o60.this.j;
            wr0Var.a(27, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda5
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    ((di1.b) obj).onCues(list);
                }
            });
            wr0Var.a();
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            o60.this.getClass();
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            o60.this.a(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            o60.this.getClass();
            o60.this.a(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            o60.this.a(surfaceTexture);
            o60.this.a(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            o60.this.a(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            o60.this.a((Surface) null);
            o60.this.a(0, 0);
            return true;
        }

        public final void a(int i) {
            o60 o60Var = o60.this;
            o60Var.j();
            boolean z = o60Var.W.l;
            o60 o60Var2 = o60.this;
            int i2 = 1;
            if (z && i != 1) {
                i2 = 2;
            }
            o60Var2.a(i, i2, z);
        }

        public final void c() {
            o60.this.a(-1, 3, false);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void b(String str, long j, long j2) {
            o60.this.p.b(str, j, j2);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void c(Exception exc) {
            o60.this.p.c(exc);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void b(String str) {
            o60.this.p.b(str);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void c(my myVar) {
            o60.this.p.c(myVar);
            o60.this.getClass();
            o60.this.getClass();
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void b(my myVar) {
            o60.this.getClass();
            o60.this.p.b(myVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(di1.b bVar) {
            bVar.a(o60.this.G);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void b(int i, long j) {
            o60.this.p.b(i, j);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void b(gc0 gc0Var, qy qyVar) {
            o60.this.getClass();
            o60.this.p.b(gc0Var, qyVar);
        }

        @Override // com.yandex.mobile.ads.impl.j12.b
        public final void b() {
            o60.this.a((Surface) null);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void a(my myVar) {
            o60.this.p.a(myVar);
            o60.this.getClass();
            o60.this.getClass();
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void a(gc0 gc0Var, qy qyVar) {
            o60.this.getClass();
            o60.this.p.a(gc0Var, qyVar);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void a(long j) {
            o60.this.p.a(j);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void a(Exception exc) {
            o60.this.p.a(exc);
        }

        @Override // com.yandex.mobile.ads.impl.uh
        public final void a(int i, long j, long j2) {
            o60.this.p.a(i, j, j2);
        }

        @Override // com.yandex.mobile.ads.impl.n42
        public final void a(final gv gvVar) {
            o60.this.getClass();
            wr0 wr0Var = o60.this.j;
            wr0Var.a(27, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda2
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    ((di1.b) obj).a(gvVar);
                }
            });
            wr0Var.a();
        }

        @Override // com.yandex.mobile.ads.impl.k60.a
        public final void a() {
            o60.this.i();
        }

        @Override // com.yandex.mobile.ads.impl.k01
        public final void a(final g01 g01Var) {
            iw0 iw0VarA;
            o60 o60Var = o60.this;
            iw0.a aVarA = o60Var.V.a();
            for (int i = 0; i < g01Var.c(); i++) {
                g01Var.a(i).a(aVarA);
            }
            o60Var.V = aVarA.a();
            o60 o60Var2 = o60.this;
            o60Var2.j();
            b52 b52Var = o60Var2.W.f10479a;
            if (b52Var.c()) {
                iw0VarA = o60Var2.V;
            } else {
                iw0VarA = o60Var2.V.a().a(b52Var.a(o60Var2.getCurrentMediaItemIndex(), o60Var2.f10026a, 0L).d.e).a();
            }
            if (!iw0VarA.equals(o60.this.G)) {
                o60 o60Var3 = o60.this;
                o60Var3.G = iw0VarA;
                o60Var3.j.a(14, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda0
                    @Override // com.yandex.mobile.ads.impl.wr0.a
                    public final void invoke(Object obj) {
                        this.f$0.a((di1.b) obj);
                    }
                });
            }
            o60.this.j.a(28, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda1
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    ((di1.b) obj).a(g01Var);
                }
            });
            o60.this.j.a();
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void a(Object obj, long j) {
            o60.this.p.a(obj, j);
            o60 o60Var = o60.this;
            if (o60Var.I == obj) {
                wr0 wr0Var = o60Var.j;
                wr0Var.a(26, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda8
                    @Override // com.yandex.mobile.ads.impl.wr0.a
                    public final void invoke(Object obj2) {
                        ((di1.b) obj2).onRenderedFirstFrame();
                    }
                });
                wr0Var.a();
            }
        }

        public final void a(final boolean z, final int i) {
            wr0 wr0Var = o60.this.j;
            wr0Var.a(30, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda6
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    di1.b bVar = (di1.b) obj;
                    bVar.a(z, i);
                }
            });
            wr0Var.a();
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void a(String str, long j, long j2) {
            o60.this.p.a(str, j, j2);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void a(String str) {
            o60.this.p.a(str);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void a(int i, long j) {
            o60.this.p.a(i, j);
        }

        @Override // com.yandex.mobile.ads.impl.nf2
        public final void a(final uf2 uf2Var) {
            o60.this.getClass();
            wr0 wr0Var = o60.this.j;
            wr0Var.a(25, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$b$$ExternalSyntheticLambda7
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    ((di1.b) obj).a(uf2Var);
                }
            });
            wr0Var.a();
        }

        @Override // com.yandex.mobile.ads.impl.j12.b
        public final void a(Surface surface) {
            o60.this.a(surface);
        }
    }

    private static final class d implements tw0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f9785a;
        private b52 b;

        public d(b52 b52Var, Object obj) {
            this.f9785a = obj;
            this.b = b52Var;
        }

        @Override // com.yandex.mobile.ads.impl.tw0
        public final Object a() {
            return this.f9785a;
        }

        @Override // com.yandex.mobile.ads.impl.tw0
        public final b52 b() {
            return this.b;
        }
    }

    static {
        r60.a("goog.exo.exoplayer");
    }

    public o60(k60.b bVar) throws Throwable {
        final o60 o60Var = this;
        gr grVar = new gr();
        o60Var.d = grVar;
        try {
            at0.c("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + x82.e + com.ironsource.b9.i.e);
            Context applicationContext = bVar.f9384a.getApplicationContext();
            ed edVarApply = bVar.h.apply(bVar.b);
            o60Var.p = edVarApply;
            oh ohVar = bVar.j;
            o60Var.P = ohVar;
            o60Var.L = bVar.k;
            o60Var.R = false;
            o60Var.z = bVar.p;
            b bVar2 = new b();
            o60Var.t = bVar2;
            Object cVar = new c();
            Handler handler = new Handler(bVar.i);
            ro1[] ro1VarArrA = bVar.c.get().a(handler, bVar2, bVar2, bVar2, bVar2);
            o60Var.f = ro1VarArrA;
            hg.b(ro1VarArrA.length > 0);
            y52 y52Var = bVar.e.get();
            o60Var.g = y52Var;
            o60Var.o = bVar.d.get();
            vi viVar = bVar.g.get();
            o60Var.r = viVar;
            o60Var.n = bVar.l;
            yw1 yw1Var = bVar.m;
            Looper looper = bVar.i;
            o60Var.q = looper;
            r32 r32Var = bVar.b;
            o60Var.s = r32Var;
            o60Var.e = o60Var;
            o60Var.j = new wr0<>(looper, r32Var, new wr0.b() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda7
                @Override // com.yandex.mobile.ads.impl.wr0.b
                public final void a(Object obj, yb0 yb0Var) {
                    this.f$0.a((di1.b) obj, yb0Var);
                }
            });
            o60Var.k = new CopyOnWriteArraySet<>();
            o60Var.m = new ArrayList();
            o60Var.E = new by1.a();
            z52 z52Var = new z52(new to1[ro1VarArrA.length], new e70[ro1VarArrA.length], u62.c, null);
            o60Var.b = z52Var;
            o60Var.l = new b52.b();
            di1.a aVarA = new di1.a.C0740a().a(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).a(y52Var.c(), 29).a();
            o60Var.c = aVarA;
            o60Var.F = new di1.a.C0740a().a(aVarA).a(4).a(10).a();
            o60Var.h = r32Var.a(looper, null);
            q60.e eVar = new q60.e() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda8
                @Override // com.yandex.mobile.ads.impl.q60.e
                public final void a(q60.d dVar) {
                    this.f$0.b(dVar);
                }
            };
            o60Var.W = vh1.a(z52Var);
            edVarApply.a(o60Var, looper);
            int i = x82.f10629a;
            ii1 ii1Var = i < 31 ? new ii1() : a.a(applicationContext, o60Var, bVar.q);
            try {
                o60Var = this;
                o60Var.i = new q60(ro1VarArrA, y52Var, z52Var, bVar.f.get(), viVar, 0, edVarApply, yw1Var, bVar.n, bVar.o, looper, r32Var, eVar, ii1Var);
                o60Var.Q = 1.0f;
                iw0 iw0Var = iw0.H;
                o60Var.G = iw0Var;
                o60Var.V = iw0Var;
                o60Var.X = -1;
                if (i < 21) {
                    o60Var.O = f();
                } else {
                    o60Var.O = x82.a(applicationContext);
                }
                int i2 = gv.b;
                o60Var.S = true;
                o60Var.b(edVarApply);
                viVar.a(new Handler(looper), edVarApply);
                o60Var.a(bVar2);
                ph phVar = new ph(bVar.f9384a, handler, bVar2);
                o60Var.u = phVar;
                phVar.a();
                sh shVar = new sh(bVar.f9384a, handler, bVar2);
                o60Var.v = shVar;
                shVar.d();
                t22 t22Var = new t22(bVar.f9384a, handler, bVar2);
                o60Var.w = t22Var;
                t22Var.a(x82.c(ohVar.d));
                aj2 aj2Var = new aj2(bVar.f9384a);
                o60Var.x = aj2Var;
                aj2Var.a();
                zj2 zj2Var = new zj2(bVar.f9384a);
                o60Var.y = zj2Var;
                zj2Var.a();
                o60Var.U = a(t22Var);
                int i3 = uf2.f;
                y52Var.a(o60Var.P);
                o60Var.a(1, 10, Integer.valueOf(o60Var.O));
                o60Var.a(2, 10, Integer.valueOf(o60Var.O));
                o60Var.a(1, 3, o60Var.P);
                o60Var.a(2, 4, Integer.valueOf(o60Var.L));
                o60Var.a(2, 5, (Object) 0);
                o60Var.a(1, 9, Boolean.valueOf(o60Var.R));
                o60Var.a(2, 7, cVar);
                o60Var.a(6, 8, cVar);
                grVar.e();
            } catch (Throwable th) {
                th = th;
                o60Var = this;
                o60Var.d.e();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void release() {
        AudioTrack audioTrack;
        at0.c("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + x82.e + "] [" + r60.a() + com.ironsource.b9.i.e);
        j();
        if (x82.f10629a < 21 && (audioTrack = this.H) != null) {
            audioTrack.release();
            this.H = null;
        }
        this.u.a();
        this.w.c();
        this.x.a(false);
        this.y.a(false);
        this.v.c();
        if (!this.i.k()) {
            wr0<di1.b> wr0Var = this.j;
            wr0Var.a(10, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.wr0.a
                public final void invoke(Object obj) {
                    o60.c((di1.b) obj);
                }
            });
            wr0Var.a();
        }
        this.j.b();
        this.h.a();
        this.r.a(this.p);
        vh1 vh1VarA = this.W.a(1);
        this.W = vh1VarA;
        vh1 vh1VarA2 = vh1VarA.a(vh1VarA.b);
        this.W = vh1VarA2;
        vh1VarA2.p = vh1VarA2.r;
        this.W.q = 0L;
        this.p.release();
        this.g.d();
        g();
        Surface surface = this.J;
        if (surface != null) {
            surface.release();
            this.J = null;
        }
        int i = gv.b;
    }

    private int f() {
        AudioTrack audioTrack = this.H;
        if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
            this.H.release();
            this.H = null;
        }
        if (this.H == null) {
            this.H = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
        }
        return this.H.getAudioSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(vh1 vh1Var, di1.b bVar) {
        bVar.onIsPlayingChanged(vh1Var.e == 3 && vh1Var.l && vh1Var.m == 0);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void b(di1.b bVar) {
        bVar.getClass();
        this.j.a(bVar);
    }

    public final void d() {
        j();
    }

    public final void e() {
        j();
    }

    public final void a(k60.a aVar) {
        this.k.add(aVar);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final int getPlaybackState() {
        j();
        return this.W.e;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final int getPlaybackSuppressionReason() {
        j();
        return this.W.m;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void prepare() {
        j();
        j();
        boolean z = this.W.l;
        int iA = this.v.a(z, 2);
        a(iA, (!z || iA == 1) ? 1 : 2, z);
        vh1 vh1Var = this.W;
        if (vh1Var.e != 1) {
            return;
        }
        vh1 vh1VarA = vh1Var.a((j60) null);
        vh1 vh1VarA2 = vh1VarA.a(vh1VarA.f10479a.c() ? 4 : 2);
        this.A++;
        this.i.i();
        a(vh1VarA2, 1, 1, false, 5, -9223372036854775807L);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void setPlayWhenReady(boolean z) {
        j();
        sh shVar = this.v;
        j();
        int iA = shVar.a(z, this.W.e);
        int i = 1;
        if (z && iA != 1) {
            i = 2;
        }
        a(iA, i, z);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean getPlayWhenReady() {
        j();
        return this.W.l;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void stop() {
        j();
        j();
        sh shVar = this.v;
        j();
        shVar.a(this.W.l, 1);
        a((j60) null);
        int i = gv.b;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final int getCurrentPeriodIndex() {
        j();
        if (this.W.f10479a.c()) {
            return 0;
        }
        vh1 vh1Var = this.W;
        return vh1Var.f10479a.a(vh1Var.b.f9759a);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final int getCurrentMediaItemIndex() {
        j();
        int iC = c();
        if (iC == -1) {
            return 0;
        }
        return iC;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final long getDuration() {
        j();
        j();
        if (this.W.b.a()) {
            vh1 vh1Var = this.W;
            rw0.b bVar = vh1Var.b;
            vh1Var.f10479a.a(bVar.f9759a, this.l);
            return x82.b(this.l.a(bVar.b, bVar.c));
        }
        j();
        b52 b52Var = this.W.f10479a;
        if (b52Var.c()) {
            return -9223372036854775807L;
        }
        return x82.b(b52Var.a(getCurrentMediaItemIndex(), this.f10026a, 0L).o);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final long getCurrentPosition() {
        j();
        return x82.b(a(this.W));
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final long getTotalBufferedDuration() {
        j();
        return x82.b(this.W.q);
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final boolean isPlayingAd() {
        j();
        return this.W.b.a();
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final int getCurrentAdGroupIndex() {
        j();
        j();
        if (this.W.b.a()) {
            return this.W.b.b;
        }
        return -1;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final int getCurrentAdIndexInAdGroup() {
        j();
        j();
        if (this.W.b.a()) {
            return this.W.b.c;
        }
        return -1;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final long getContentPosition() {
        j();
        j();
        if (this.W.b.a()) {
            vh1 vh1Var = this.W;
            vh1Var.f10479a.a(vh1Var.b.f9759a, this.l);
            vh1 vh1Var2 = this.W;
            if (vh1Var2.c == -9223372036854775807L) {
                return x82.b(vh1Var2.f10479a.a(getCurrentMediaItemIndex(), this.f10026a, 0L).n);
            }
            return x82.b(this.l.f) + x82.b(this.W.c);
        }
        j();
        return x82.b(a(this.W));
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final u62 getCurrentTracks() {
        j();
        return this.W.i.d;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final b52 getCurrentTimeline() {
        j();
        return this.W.f10479a;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void setVideoTextureView(TextureView textureView) {
        j();
        if (textureView == null) {
            j();
            g();
            a((Surface) null);
            a(0, 0);
            return;
        }
        g();
        this.K = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            at0.d("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.t);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            a((Surface) null);
            a(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            a(surface);
            this.J = surface;
            a(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final void setVolume(float f) {
        j();
        int i = x82.f10629a;
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.Q == fMax) {
            return;
        }
        this.Q = fMax;
        a(1, 2, Float.valueOf(this.v.b() * fMax));
        wr0<di1.b> wr0Var = this.j;
        wr0Var.a(22, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda6
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                ((di1.b) obj).onVolumeChanged(fMax);
            }
        });
        wr0Var.a();
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final float getVolume() {
        j();
        return this.Q;
    }

    private int c() {
        if (this.W.f10479a.c()) {
            return this.X;
        }
        vh1 vh1Var = this.W;
        return vh1Var.f10479a.a(vh1Var.b.f9759a, this.l).d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(vh1 vh1Var, di1.b bVar) {
        bVar.onPlayerStateChanged(vh1Var.l, vh1Var.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(vh1 vh1Var, di1.b bVar) {
        bVar.onPlaybackSuppressionReasonChanged(vh1Var.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(vh1 vh1Var, di1.b bVar) {
        bVar.onPlaybackStateChanged(vh1Var.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(vh1 vh1Var, di1.b bVar) {
        bVar.a(vh1Var.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        j();
        int i = this.W.e;
        if (i != 1) {
            if (i == 2 || i == 3) {
                j();
                boolean z = this.W.o;
                aj2 aj2Var = this.x;
                j();
                aj2Var.a(this.W.l && !z);
                zj2 zj2Var = this.y;
                j();
                zj2Var.a(this.W.l);
                return;
            }
            if (i != 4) {
                throw new IllegalStateException();
            }
        }
        this.x.a(false);
        this.y.a(false);
    }

    private static long b(vh1 vh1Var) {
        b52.d dVar = new b52.d();
        b52.b bVar = new b52.b();
        vh1Var.f10479a.a(vh1Var.b.f9759a, bVar);
        long j = vh1Var.c;
        if (j == -9223372036854775807L) {
            return vh1Var.f10479a.a(bVar.d, dVar, 0L).n;
        }
        return bVar.f + j;
    }

    private void h() {
        di1.a aVar = this.F;
        di1 di1Var = this.e;
        di1.a aVar2 = this.c;
        int i = x82.f10629a;
        boolean zIsPlayingAd = di1Var.isPlayingAd();
        boolean zIsCurrentMediaItemSeekable = di1Var.isCurrentMediaItemSeekable();
        boolean zHasPreviousMediaItem = di1Var.hasPreviousMediaItem();
        boolean zHasNextMediaItem = di1Var.hasNextMediaItem();
        boolean zIsCurrentMediaItemLive = di1Var.isCurrentMediaItemLive();
        boolean zIsCurrentMediaItemDynamic = di1Var.isCurrentMediaItemDynamic();
        boolean zC = di1Var.getCurrentTimeline().c();
        boolean z = !zIsPlayingAd;
        boolean z2 = false;
        di1.a.C0740a c0740aA = new di1.a.C0740a().a(aVar2).a(z, 4).a(zIsCurrentMediaItemSeekable && !zIsPlayingAd, 5).a(zHasPreviousMediaItem && !zIsPlayingAd, 6).a(!zC && (zHasPreviousMediaItem || !zIsCurrentMediaItemLive || zIsCurrentMediaItemSeekable) && !zIsPlayingAd, 7).a(zHasNextMediaItem && !zIsPlayingAd, 8).a(!zC && (zHasNextMediaItem || (zIsCurrentMediaItemLive && zIsCurrentMediaItemDynamic)) && !zIsPlayingAd, 9).a(z, 10).a(zIsCurrentMediaItemSeekable && !zIsPlayingAd, 11);
        if (zIsCurrentMediaItemSeekable && !zIsPlayingAd) {
            z2 = true;
        }
        di1.a aVarA = c0740aA.a(z2, 12).a();
        this.F = aVarA;
        if (aVarA.equals(aVar)) {
            return;
        }
        this.j.a(13, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda10
            @Override // com.yandex.mobile.ads.impl.wr0.a
            public final void invoke(Object obj) {
                this.f$0.d((di1.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(di1.b bVar) {
        bVar.a(this.F);
    }

    private long a(vh1 vh1Var) {
        if (vh1Var.f10479a.c()) {
            return x82.a(this.Y);
        }
        if (vh1Var.b.a()) {
            return vh1Var.r;
        }
        b52 b52Var = vh1Var.f10479a;
        rw0.b bVar = vh1Var.b;
        long j = vh1Var.r;
        b52Var.a(bVar.f9759a, this.l);
        return j + this.l.f;
    }

    @Override // com.yandex.mobile.ads.impl.di1
    public final j60 a() {
        j();
        return this.W.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final q60.d dVar) {
        this.h.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.d.b();
        if (Thread.currentThread() != this.q.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = this.q.getThread().getName();
            int i = x82.f10629a;
            Locale locale = Locale.US;
            String str = "Player is accessed on the wrong thread.\nCurrent thread: '" + name + "'\nExpected thread: '" + name2 + "'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread";
            if (!this.S) {
                at0.b("ExoPlayerImpl", str, this.T ? null : new IllegalStateException());
                this.T = true;
                return;
            }
            throw new IllegalStateException(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(di1.b bVar) {
        bVar.b(j60.a(new d70(1), 1003));
    }

    private static final class c implements ke2, vn, ji1.b {
        private ke2 b;
        private vn c;
        private ke2 d;
        private vn e;

        private c() {
        }

        @Override // com.yandex.mobile.ads.impl.ji1.b
        public final void a(int i, Object obj) {
            if (i == 7) {
                this.b = (ke2) obj;
                return;
            }
            if (i == 8) {
                this.c = (vn) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            j12 j12Var = (j12) obj;
            if (j12Var == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = j12Var.b();
                this.e = j12Var.a();
            }
        }

        @Override // com.yandex.mobile.ads.impl.vn
        public final void f() {
            vn vnVar = this.e;
            if (vnVar != null) {
                vnVar.f();
            }
            vn vnVar2 = this.c;
            if (vnVar2 != null) {
                vnVar2.f();
            }
        }

        @Override // com.yandex.mobile.ads.impl.vn
        public final void a(long j, float[] fArr) {
            vn vnVar = this.e;
            if (vnVar != null) {
                vnVar.a(j, fArr);
            }
            vn vnVar2 = this.c;
            if (vnVar2 != null) {
                vnVar2.a(j, fArr);
            }
        }

        @Override // com.yandex.mobile.ads.impl.ke2
        public final void a(long j, long j2, gc0 gc0Var, MediaFormat mediaFormat) {
            ke2 ke2Var = this.d;
            if (ke2Var != null) {
                ke2Var.a(j, j2, gc0Var, mediaFormat);
            }
            ke2 ke2Var2 = this.b;
            if (ke2Var2 != null) {
                ke2Var2.a(j, j2, gc0Var, mediaFormat);
            }
        }
    }

    private static final class a {
        public static ii1 a(Context context, o60 o60Var, boolean z) {
            jw0 jw0VarA = jw0.a(context);
            if (jw0VarA == null) {
                at0.d("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new ii1(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z) {
                o60Var.getClass();
                o60Var.p.a(jw0VarA);
            }
            return new ii1(jw0VarA.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(vh1 vh1Var, di1.b bVar) {
        boolean z = vh1Var.g;
        bVar.getClass();
        bVar.onIsLoadingChanged(vh1Var.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(vh1 vh1Var, di1.b bVar) {
        bVar.b(vh1Var.f);
    }

    private void g() {
        TextureView textureView = this.K;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.t) {
                at0.d("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.K.setSurfaceTextureListener(null);
            }
            this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(vh1 vh1Var, di1.b bVar) {
        bVar.a(vh1Var.i.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(di1.b bVar, yb0 yb0Var) {
        bVar.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q60.d dVar) {
        boolean z;
        int i = this.A - dVar.c;
        this.A = i;
        boolean z2 = true;
        if (dVar.d) {
            this.B = dVar.e;
            this.C = true;
        }
        if (dVar.f) {
            this.D = dVar.g;
        }
        if (i == 0) {
            b52 b52Var = dVar.b.f10479a;
            if (!this.W.f10479a.c() && b52Var.c()) {
                this.X = -1;
                this.Y = 0L;
            }
            if (!b52Var.c()) {
                List<b52> listD = ((ej1) b52Var).d();
                if (listD.size() == this.m.size()) {
                    for (int i2 = 0; i2 < listD.size(); i2++) {
                        ((d) this.m.get(i2)).b = listD.get(i2);
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            long j = -9223372036854775807L;
            if (this.C) {
                if (dVar.b.b.equals(this.W.b) && dVar.b.d == this.W.r) {
                    z2 = false;
                }
                if (z2) {
                    if (!b52Var.c() && !dVar.b.b.a()) {
                        vh1 vh1Var = dVar.b;
                        rw0.b bVar = vh1Var.b;
                        long j2 = vh1Var.d;
                        b52Var.a(bVar.f9759a, this.l);
                        j = j2 + this.l.f;
                    } else {
                        j = dVar.b.d;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            this.C = false;
            a(dVar.b, 1, this.D, z, this.B, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(vh1 vh1Var, int i, di1.b bVar) {
        bVar.onPlayWhenReadyChanged(vh1Var.l, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(vh1 vh1Var, int i, di1.b bVar) {
        b52 b52Var = vh1Var.f10479a;
        bVar.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, di1.c cVar, di1.c cVar2, di1.b bVar) {
        bVar.getClass();
        bVar.a(cVar, cVar2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(vh1 vh1Var, di1.b bVar) {
        bVar.a(vh1Var.f);
    }

    private vh1 a(vh1 vh1Var, b52 b52Var, Pair<Object, Long> pair) {
        vh1 vh1VarA;
        long jA;
        if (!b52Var.c() && pair == null) {
            throw new IllegalArgumentException();
        }
        b52 b52Var2 = vh1Var.f10479a;
        vh1 vh1VarA2 = vh1Var.a(b52Var);
        if (b52Var.c()) {
            rw0.b bVarA = vh1.a();
            long jA2 = x82.a(this.Y);
            vh1 vh1VarA3 = vh1VarA2.a(bVarA, jA2, jA2, jA2, 0L, s52.e, this.b, hk0.h()).a(bVarA);
            vh1VarA3.p = vh1VarA3.r;
            return vh1VarA3;
        }
        Object obj = vh1VarA2.b.f9759a;
        int i = x82.f10629a;
        boolean zEquals = obj.equals(pair.first);
        rw0.b bVar = !zEquals ? new rw0.b(pair.first) : vh1VarA2.b;
        long jLongValue = ((Long) pair.second).longValue();
        long jA3 = x82.a(getContentPosition());
        if (!b52Var2.c()) {
            jA3 -= b52Var2.a(obj, this.l).f;
        }
        if (!zEquals || jLongValue < jA3) {
            if (!bVar.a()) {
                vh1 vh1VarA4 = vh1VarA2.a(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x015e: INVOKE (r5v1 'vh1VarA4' com.yandex.mobile.ads.impl.vh1) = 
                      (wrap com.yandex.mobile.ads.impl.vh1:0x015a: INVOKE 
                      (r5v0 'vh1VarA2' com.yandex.mobile.ads.impl.vh1)
                      (r0v1 com.yandex.mobile.ads.impl.rw0$b)
                      (r13v0 'jLongValue' long)
                      (r13v0 'jLongValue' long)
                      (r13v0 'jLongValue' long)
                      (0 long)
                      (wrap com.yandex.mobile.ads.impl.s52:0x0136: TERNARY null = ((r6v2 'zEquals' boolean) == false) ? (wrap ??:0x0131: SGET  A[WRAPPED] (LINE:18253) com.yandex.mobile.ads.impl.s52.e com.yandex.mobile.ads.impl.s52) : (wrap ??:0x0134: IGET (r5v0 'vh1VarA2' com.yandex.mobile.ads.impl.vh1) A[WRAPPED] com.yandex.mobile.ads.impl.vh1.h com.yandex.mobile.ads.impl.s52))
                      (wrap com.yandex.mobile.ads.impl.z52:0x0144: TERNARY null = ((r6v2 'zEquals' boolean) == false) ? (wrap ??:0x013c: IGET (r20v0 'this' com.yandex.mobile.ads.impl.o60 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:18254) com.yandex.mobile.ads.impl.o60.b com.yandex.mobile.ads.impl.z52) : (wrap ??:0x0142: IGET (r5v0 'vh1VarA2' com.yandex.mobile.ads.impl.vh1) A[WRAPPED] com.yandex.mobile.ads.impl.vh1.i com.yandex.mobile.ads.impl.z52))
                      (wrap java.util.List<com.yandex.mobile.ads.impl.g01>:?: TERNARY null = ((r6v2 'zEquals' boolean) == false) ? (wrap ??:0x0148: INVOKE  STATIC call: com.yandex.mobile.ads.impl.hk0.h():com.yandex.mobile.ads.impl.hk0 A[MD:<E>:():com.yandex.mobile.ads.impl.hk0<E> (m), WRAPPED] (LINE:18255)) : (wrap ??:0x014d: IGET (r5v0 'vh1VarA2' com.yandex.mobile.ads.impl.vh1) A[WRAPPED] com.yandex.mobile.ads.impl.vh1.j java.util.List))
                     VIRTUAL call: com.yandex.mobile.ads.impl.vh1.a(com.yandex.mobile.ads.impl.rw0$b, long, long, long, long, com.yandex.mobile.ads.impl.s52, com.yandex.mobile.ads.impl.z52, java.util.List):com.yandex.mobile.ads.impl.vh1 A[MD:(com.yandex.mobile.ads.impl.rw0$b, long, long, long, long, com.yandex.mobile.ads.impl.s52, com.yandex.mobile.ads.impl.z52, java.util.List<com.yandex.mobile.ads.impl.g01>):com.yandex.mobile.ads.impl.vh1 (m), WRAPPED] (LINE:18256))
                      (r15v0 'bVar' com.yandex.mobile.ads.impl.rw0$b)
                     VIRTUAL call: com.yandex.mobile.ads.impl.vh1.a(com.yandex.mobile.ads.impl.rw0$b):com.yandex.mobile.ads.impl.vh1 A[DECLARE_VAR, MD:(com.yandex.mobile.ads.impl.rw0$b):com.yandex.mobile.ads.impl.vh1 (m)] (LINE:18265) in method: com.yandex.mobile.ads.impl.o60.a(com.yandex.mobile.ads.impl.vh1, com.yandex.mobile.ads.impl.b52, android.util.Pair<java.lang.Object, java.lang.Long>):com.yandex.mobile.ads.impl.vh1, file: classes10.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 com.yandex.mobile.ads.impl.rw0$b
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    */
                /*
                    Method dump skipped, instruction units count: 367
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.o60.a(com.yandex.mobile.ads.impl.vh1, com.yandex.mobile.ads.impl.b52, android.util.Pair):com.yandex.mobile.ads.impl.vh1");
            }

            private Pair<Object, Long> a(b52 b52Var, int i, long j) {
                if (b52Var.c()) {
                    this.X = i;
                    if (j == -9223372036854775807L) {
                        j = 0;
                    }
                    this.Y = j;
                    return null;
                }
                if (i == -1 || i >= b52Var.b()) {
                    i = b52Var.a(false);
                    j = x82.b(b52Var.a(i, this.f10026a, 0L).n);
                }
                return b52Var.a(this.f10026a, this.l, i, x82.a(j));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(final int i, final int i2) {
                if (i == this.M && i2 == this.N) {
                    return;
                }
                this.M = i;
                this.N = i2;
                wr0<di1.b> wr0Var = this.j;
                wr0Var.a(24, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda12
                    @Override // com.yandex.mobile.ads.impl.wr0.a
                    public final void invoke(Object obj) {
                        ((di1.b) obj).onSurfaceSizeChanged(i, i2);
                    }
                });
                wr0Var.a();
            }

            @Override // com.yandex.mobile.ads.impl.di1
            public final void a(di1.b bVar) {
                bVar.getClass();
                this.j.b(bVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i, int i2, Object obj) {
                for (ro1 ro1Var : this.f) {
                    if (ro1Var.m() == i) {
                        int iC = c();
                        q60 q60Var = this.i;
                        new ji1(q60Var, ro1Var, this.W.f10479a, iC == -1 ? 0 : iC, this.s, q60Var.d()).a(i2).a(obj).e();
                    }
                }
            }

            @Override // com.yandex.mobile.ads.impl.k60
            public final void a(cm1 cm1Var) {
                j();
                List listSingletonList = Collections.singletonList(cm1Var);
                j();
                j();
                c();
                j();
                a(this.W);
                int i = x82.f10629a;
                this.A++;
                if (!this.m.isEmpty()) {
                    int size = this.m.size();
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        this.m.remove(i2);
                    }
                    this.E = this.E.c(size);
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < listSingletonList.size(); i3++) {
                    uw0.c cVar = new uw0.c((rw0) listSingletonList.get(i3), this.n);
                    arrayList.add(cVar);
                    this.m.add(i3, new d(cVar.f10431a.f(), cVar.b));
                }
                this.E = this.E.b(arrayList.size());
                ej1 ej1Var = new ej1(this.m, this.E);
                if (!ej1Var.c() && -1 >= ej1Var.b()) {
                    throw new aj0();
                }
                int iA = ej1Var.a(false);
                vh1 vh1VarA = a(this.W, ej1Var, a(ej1Var, iA, -9223372036854775807L));
                int i4 = vh1VarA.e;
                if (iA != -1 && i4 != 1) {
                    i4 = (ej1Var.c() || iA >= ej1Var.b()) ? 4 : 2;
                }
                vh1 vh1VarA2 = vh1VarA.a(i4);
                this.i.a(iA, x82.a(-9223372036854775807L), this.E, arrayList);
                a(vh1VarA2, 0, 1, (this.W.b.f9759a.equals(vh1VarA2.b.f9759a) || this.W.f10479a.c()) ? false : true, 4, a(vh1VarA2));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(SurfaceTexture surfaceTexture) {
                Surface surface = new Surface(surfaceTexture);
                a(surface);
                this.J = surface;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(Surface surface) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (ro1 ro1Var : this.f) {
                    if (ro1Var.m() == 2) {
                        int iC = c();
                        q60 q60Var = this.i;
                        arrayList.add(new ji1(q60Var, ro1Var, this.W.f10479a, iC == -1 ? 0 : iC, this.s, q60Var.d()).a(1).a(surface).e());
                    }
                }
                Object obj = this.I;
                if (obj != null && obj != surface) {
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ji1) it.next()).a(this.z);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    } catch (TimeoutException unused2) {
                        z = true;
                    }
                    Object obj2 = this.I;
                    Surface surface2 = this.J;
                    if (obj2 == surface2) {
                        surface2.release();
                        this.J = null;
                    }
                }
                this.I = surface;
                if (z) {
                    a(j60.a(new d70(3), 1003));
                }
            }

            private void a(j60 j60Var) {
                vh1 vh1Var = this.W;
                vh1 vh1VarA = vh1Var.a(vh1Var.b);
                vh1VarA.p = vh1VarA.r;
                vh1VarA.q = 0L;
                vh1 vh1VarA2 = vh1VarA.a(1);
                if (j60Var != null) {
                    vh1VarA2 = vh1VarA2.a(j60Var);
                }
                vh1 vh1Var2 = vh1VarA2;
                this.A++;
                this.i.p();
                a(vh1Var2, 0, 1, vh1Var2.f10479a.c() && !this.W.f10479a.c(), 4, a(vh1Var2));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i, int i2, boolean z) {
                int i3 = 0;
                boolean z2 = z && i != -1;
                if (z2 && i != 1) {
                    i3 = 1;
                }
                vh1 vh1Var = this.W;
                if (vh1Var.l == z2 && vh1Var.m == i3) {
                    return;
                }
                this.A++;
                vh1 vh1Var2 = new vh1(vh1Var.f10479a, vh1Var.b, vh1Var.c, vh1Var.d, vh1Var.e, vh1Var.f, vh1Var.g, vh1Var.h, vh1Var.i, vh1Var.j, vh1Var.k, z2, i3, vh1Var.n, vh1Var.p, vh1Var.q, vh1Var.r, vh1Var.o);
                this.i.a(z2, i3);
                a(vh1Var2, 0, i2, false, 5, -9223372036854775807L);
            }

            private void a(final vh1 vh1Var, final int i, final int i2, boolean z, final int i3, long j) {
                Pair pair;
                int i4;
                final fw0 fw0Var;
                boolean z2;
                Object obj;
                int i5;
                fw0 fw0Var2;
                Object obj2;
                int i6;
                long j2;
                long j3;
                long jB;
                long jB2;
                Object obj3;
                fw0 fw0Var3;
                Object obj4;
                int iA;
                vh1 vh1Var2 = this.W;
                this.W = vh1Var;
                boolean zEquals = vh1Var2.f10479a.equals(vh1Var.f10479a);
                b52 b52Var = vh1Var2.f10479a;
                b52 b52Var2 = vh1Var.f10479a;
                if (b52Var2.c() && b52Var.c()) {
                    pair = new Pair(Boolean.FALSE, -1);
                } else if (b52Var2.c() != b52Var.c()) {
                    pair = new Pair(Boolean.TRUE, 3);
                } else if (!b52Var.a(b52Var.a(vh1Var2.b.f9759a, this.l).d, this.f10026a, 0L).b.equals(b52Var2.a(b52Var2.a(vh1Var.b.f9759a, this.l).d, this.f10026a, 0L).b)) {
                    if (z && i3 == 0) {
                        i4 = 1;
                    } else if (z && i3 == 1) {
                        i4 = 2;
                    } else {
                        if (zEquals) {
                            throw new IllegalStateException();
                        }
                        i4 = 3;
                    }
                    pair = new Pair(Boolean.TRUE, Integer.valueOf(i4));
                } else if (z && i3 == 0 && vh1Var2.b.d < vh1Var.b.d) {
                    pair = new Pair(Boolean.TRUE, 0);
                } else {
                    pair = new Pair(Boolean.FALSE, -1);
                }
                boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
                final int iIntValue = ((Integer) pair.second).intValue();
                iw0 iw0VarA = this.G;
                if (zBooleanValue) {
                    fw0Var = vh1Var.f10479a.c() ? null : vh1Var.f10479a.a(vh1Var.f10479a.a(vh1Var.b.f9759a, this.l).d, this.f10026a, 0L).d;
                    this.V = iw0.H;
                } else {
                    fw0Var = null;
                }
                if (zBooleanValue || !vh1Var2.j.equals(vh1Var.j)) {
                    iw0.a aVarA = this.V.a();
                    List<g01> list = vh1Var.j;
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        g01 g01Var = list.get(i7);
                        for (int i8 = 0; i8 < g01Var.c(); i8++) {
                            g01Var.a(i8).a(aVarA);
                        }
                    }
                    this.V = aVarA.a();
                    j();
                    b52 b52Var3 = this.W.f10479a;
                    if (b52Var3.c()) {
                        iw0VarA = this.V;
                    } else {
                        iw0VarA = this.V.a().a(b52Var3.a(getCurrentMediaItemIndex(), this.f10026a, 0L).d.e).a();
                    }
                }
                boolean zEquals2 = iw0VarA.equals(this.G);
                this.G = iw0VarA;
                boolean z3 = vh1Var2.l != vh1Var.l;
                boolean z4 = vh1Var2.e != vh1Var.e;
                if (z4 || z3) {
                    i();
                }
                boolean z5 = vh1Var2.g != vh1Var.g;
                if (!vh1Var2.f10479a.equals(vh1Var.f10479a)) {
                    this.j.a(0, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda11
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj5) {
                            o60.a(vh1Var, i, (di1.b) obj5);
                        }
                    });
                }
                if (z) {
                    b52.b bVar = new b52.b();
                    if (vh1Var2.f10479a.c()) {
                        obj = null;
                        i5 = -1;
                        fw0Var2 = null;
                        obj2 = null;
                        i6 = -1;
                    } else {
                        Object obj5 = vh1Var2.b.f9759a;
                        vh1Var2.f10479a.a(obj5, bVar);
                        int i9 = bVar.d;
                        int iA2 = vh1Var2.f10479a.a(obj5);
                        obj2 = obj5;
                        obj = vh1Var2.f10479a.a(i9, this.f10026a, 0L).b;
                        fw0Var2 = this.f10026a.d;
                        i5 = i9;
                        i6 = iA2;
                    }
                    if (i3 == 0) {
                        if (vh1Var2.b.a()) {
                            rw0.b bVar2 = vh1Var2.b;
                            jB = bVar.a(bVar2.b, bVar2.c);
                            jB2 = b(vh1Var2);
                        } else {
                            if (vh1Var2.b.e != -1) {
                                jB = b(this.W);
                            } else {
                                j2 = bVar.f;
                                j3 = bVar.e;
                                jB = j2 + j3;
                            }
                            jB2 = jB;
                        }
                    } else if (vh1Var2.b.a()) {
                        jB = vh1Var2.r;
                        jB2 = b(vh1Var2);
                    } else {
                        j2 = bVar.f;
                        j3 = vh1Var2.r;
                        jB = j2 + j3;
                        jB2 = jB;
                    }
                    long jB3 = x82.b(jB);
                    long jB4 = x82.b(jB2);
                    rw0.b bVar3 = vh1Var2.b;
                    final di1.c cVar = new di1.c(obj, i5, fw0Var2, obj2, i6, jB3, jB4, bVar3.b, bVar3.c);
                    int currentMediaItemIndex = getCurrentMediaItemIndex();
                    if (this.W.f10479a.c()) {
                        obj3 = null;
                        fw0Var3 = null;
                        obj4 = null;
                        iA = -1;
                    } else {
                        vh1 vh1Var3 = this.W;
                        Object obj6 = vh1Var3.b.f9759a;
                        vh1Var3.f10479a.a(obj6, this.l);
                        iA = this.W.f10479a.a(obj6);
                        obj3 = this.W.f10479a.a(currentMediaItemIndex, this.f10026a, 0L).b;
                        fw0Var3 = this.f10026a.d;
                        obj4 = obj6;
                    }
                    long jB5 = x82.b(j);
                    long jB6 = this.W.b.a() ? x82.b(b(this.W)) : jB5;
                    rw0.b bVar4 = this.W.b;
                    final di1.c cVar2 = new di1.c(obj3, currentMediaItemIndex, fw0Var3, obj4, iA, jB5, jB6, bVar4.b, bVar4.c);
                    this.j.a(11, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda17
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.a(i3, cVar, cVar2, (di1.b) obj7);
                        }
                    });
                } else {
                    zEquals2 = zEquals2;
                    z4 = z4;
                }
                if (zBooleanValue) {
                    wr0<di1.b> wr0Var = this.j;
                    wr0.a<di1.b> aVar = new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda18
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            ((di1.b) obj7).a(fw0Var, iIntValue);
                        }
                    };
                    z2 = true;
                    wr0Var.a(1, aVar);
                } else {
                    z2 = true;
                }
                if (vh1Var2.f != vh1Var.f) {
                    this.j.a(10, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda19
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.a(vh1Var, (di1.b) obj7);
                        }
                    });
                    if (vh1Var.f != null) {
                        this.j.a(10, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda20
                            @Override // com.yandex.mobile.ads.impl.wr0.a
                            public final void invoke(Object obj7) {
                                o60.b(vh1Var, (di1.b) obj7);
                            }
                        });
                    }
                }
                z52 z52Var = vh1Var2.i;
                z52 z52Var2 = vh1Var.i;
                if (z52Var != z52Var2) {
                    this.g.a(z52Var2.e);
                    this.j.a(2, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda1
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.c(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                if (!zEquals2) {
                    final iw0 iw0Var = this.G;
                    this.j.a(14, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda2
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            ((di1.b) obj7).a(iw0Var);
                        }
                    });
                }
                if (z5) {
                    this.j.a(3, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda3
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.d(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                if (z4 || z3) {
                    this.j.a(-1, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda4
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.e(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                if (z4) {
                    this.j.a(4, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda5
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.f(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                if (z3) {
                    this.j.a(5, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda13
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.b(vh1Var, i2, (di1.b) obj7);
                        }
                    });
                }
                if (vh1Var2.m != vh1Var.m) {
                    this.j.a(6, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda14
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.g(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                if (((vh1Var2.e == 3 && vh1Var2.l && vh1Var2.m == 0) ? z2 : false) != ((vh1Var.e == 3 && vh1Var.l && vh1Var.m == 0) ? z2 : false)) {
                    this.j.a(7, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda15
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.h(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                if (!vh1Var2.n.equals(vh1Var.n)) {
                    this.j.a(12, new wr0.a() { // from class: com.yandex.mobile.ads.impl.o60$$ExternalSyntheticLambda16
                        @Override // com.yandex.mobile.ads.impl.wr0.a
                        public final void invoke(Object obj7) {
                            o60.i(vh1Var, (di1.b) obj7);
                        }
                    });
                }
                h();
                this.j.a();
                if (vh1Var2.o != vh1Var.o) {
                    Iterator<k60.a> it = this.k.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static f10 a(t22 t22Var) {
                return new f10(0, t22Var.b(), t22Var.a());
            }
        }
