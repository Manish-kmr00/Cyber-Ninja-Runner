package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: loaded from: classes8.dex */
public final class ax {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private final Lazy J;
    private final Lazy K;
    private final Lazy L;
    private final Lazy M;
    private final Lazy N;
    private final Lazy O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f8450a;
    private final Lazy b;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;
    private final Lazy m;
    private final Lazy n;
    private final Lazy o;
    private final Lazy p;
    private final Lazy q;
    private final Lazy r;
    private final Lazy s;
    private final Lazy t;
    private final Lazy u;
    private final Lazy v;
    private final Lazy w;
    private final Lazy x;
    private final Lazy y;
    private final Lazy z;

    static final class a extends Lambda implements Function0<fa> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final fa invoke() {
            return new fa();
        }
    }

    static final class a0 extends Lambda implements Function0<nz0> {
        public static final a0 b = new a0();

        a0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final nz0 invoke() {
            return new nz0();
        }
    }

    static final class b extends Lambda implements Function0<ia> {
        public static final b b = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ia invoke() {
            return new ia();
        }
    }

    static final class b0 extends Lambda implements Function0<tz0> {
        public static final b0 b = new b0();

        b0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final tz0 invoke() {
            return new tz0();
        }
    }

    static final class c extends Lambda implements Function0<la> {
        public static final c b = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final la invoke() {
            return new la();
        }
    }

    static final class c0 extends Lambda implements Function0<vz0> {
        c0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final vz0 invoke() {
            return new vz0(ax.s(ax.this));
        }
    }

    static final class d extends Lambda implements Function0<tw> {
        public static final d b = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final tw invoke() {
            return new tw();
        }
    }

    static final class d0 extends Lambda implements Function0<wz0> {
        public static final d0 b = new d0();

        d0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final wz0 invoke() {
            return new wz0();
        }
    }

    static final class e extends Lambda implements Function0<qe> {
        final /* synthetic */ Context b;
        final /* synthetic */ ax c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Context context, ax axVar) {
            super(0);
            this.b = context;
            this.c = axVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final qe invoke() {
            return new qe(this.b, ax.h(this.c));
        }
    }

    static final class e0 extends Lambda implements Function0<xz0> {
        e0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final xz0 invoke() {
            return new xz0(ax.s(ax.this));
        }
    }

    static final class f extends Lambda implements Function0<rr> {
        final /* synthetic */ ax b;
        final /* synthetic */ Context c;

        @Override // kotlin.jvm.functions.Function0
        public final rr invoke() {
            iw1 iw1VarA = ax.A(this.b);
            gq.a aVar = gq.f9028a;
            Context context = this.c;
            aVar.getClass();
            return new rr(iw1VarA, gq.a.a(context));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Context context, ax axVar) {
            super(0);
            this.b = axVar;
            this.c = context;
        }
    }

    static final class f0 extends Lambda implements Function0<e11> {
        public static final f0 b = new f0();

        f0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final e11 invoke() {
            return new e11();
        }
    }

    static final class g extends Lambda implements Function0<yv> {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final yv invoke() {
            return new yv(ax.A(ax.this));
        }
    }

    static final class g0 extends Lambda implements Function0<sz0> {
        public static final g0 b = new g0();

        g0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final sz0 invoke() {
            return new sz0();
        }
    }

    static final class h extends Lambda implements Function0<zw> {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final zw invoke() {
            return new zw(ax.q(ax.this), ax.r(ax.this), ax.a(ax.this), ax.v(ax.this));
        }
    }

    static final class h0 extends Lambda implements Function0<io1> {
        final /* synthetic */ Context b;
        final /* synthetic */ ax c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h0(Context context, ax axVar) {
            super(0);
            this.b = context;
            this.c = axVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final io1 invoke() {
            return new io1(this.b, ax.x(this.c), ax.B(this.c), new ll0());
        }
    }

    static final class i extends Lambda implements Function0<hx> {
        final /* synthetic */ Context b;
        final /* synthetic */ ax c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Context context, ax axVar) {
            super(0);
            this.b = context;
            this.c = axVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final hx invoke() {
            return new hx(this.b, ax.p(this.c), new pz0(this.b));
        }
    }

    static final class i0 extends Lambda implements Function0<zo0> {
        i0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final zo0 invoke() {
            return new zo0(ax.y(ax.this));
        }
    }

    static final class j extends Lambda implements Function0<rx> {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final rx invoke() {
            return new rx(ax.n(ax.this), ax.k(ax.this), ax.l(ax.this), Dispatchers.getIO());
        }
    }

    static final class j0 extends Lambda implements Function0<ap0> {
        j0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ap0 invoke() {
            return new ap0(new y22(), ax.m(ax.this), new mi2());
        }
    }

    static final class k extends Lambda implements Function0<ux> {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ux invoke() {
            return new ux(ax.n(ax.this), ax.w(ax.this), ax.e(ax.this), Dispatchers.getIO());
        }
    }

    static final class k0 extends Lambda implements Function0<qv1> {
        final /* synthetic */ Context b;
        final /* synthetic */ ax c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k0(Context context, ax axVar) {
            super(0);
            this.b = context;
            this.c = axVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final qv1 invoke() {
            return new qv1(this.b, ax.u(this.c));
        }
    }

    static final class l extends Lambda implements Function0<g10> {
        public static final l b = new l();

        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final g10 invoke() {
            return new g10(0);
        }
    }

    static final class l0 extends Lambda implements Function0<iw1> {
        public static final l0 b = new l0();

        l0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final iw1 invoke() {
            int i = iw1.l;
            return iw1.a.a();
        }
    }

    static final class m extends Lambda implements Function0<m50> {
        final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Context context) {
            super(0);
            this.b = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final m50 invoke() {
            int i = m50.e;
            return m50.a.a(this.b);
        }
    }

    static final class m0 extends Lambda implements Function0<o32> {
        m0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final o32 invoke() {
            return new o32(ax.g(ax.this));
        }
    }

    static final class n extends Lambda implements Function0<he0> {
        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final he0 invoke() {
            return new he0(ax.g(ax.this));
        }
    }

    static final class n0 extends Lambda implements Function0<gy> {
        n0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final gy invoke() {
            return new gy(ax.i(ax.this).c());
        }
    }

    static final class o extends Lambda implements Function0<ie0> {
        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ie0 invoke() {
            return new ie0(ax.g(ax.this));
        }
    }

    static final class o0 extends Lambda implements Function0<ab2> {
        public static final o0 b = new o0();

        o0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ab2 invoke() {
            return new ab2();
        }
    }

    static final class p extends Lambda implements Function0<je0> {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final je0 invoke() {
            return new je0(ax.g(ax.this));
        }
    }

    static final class q extends Lambda implements Function0<ke0> {
        q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ke0 invoke() {
            return new ke0(ax.f(ax.this));
        }
    }

    static final class r extends Lambda implements Function0<le0> {
        r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final le0 invoke() {
            return new le0(ax.g(ax.this));
        }
    }

    static final class s extends Lambda implements Function0<ix> {
        final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(Context context) {
            super(0);
            this.b = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ix invoke() {
            return new ix(ed1.c.a(this.b).b(), new ArrayList());
        }
    }

    static final class t extends Lambda implements Function0<gl0> {
        final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(Context context) {
            super(0);
            this.b = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final gl0 invoke() {
            return new gl0(this.b);
        }
    }

    static final class u extends Lambda implements Function0<hl0> {
        u() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final hl0 invoke() {
            return new hl0(ax.m(ax.this), new tj());
        }
    }

    static final class v extends Lambda implements Function0<jl0> {
        final /* synthetic */ Context b;
        final /* synthetic */ ax c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(Context context, ax axVar) {
            super(0);
            this.b = context;
            this.c = axVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final jl0 invoke() {
            return new jl0(this.b, ax.j(this.c));
        }
    }

    static final class w extends Lambda implements Function0<Json> {
        public static final w b = new w();

        w() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Json invoke() {
            return JsonKt.Json$default(null, bx.b, 1, null);
        }
    }

    static final class x extends Lambda implements Function0<ks0> {
        x() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ks0 invoke() {
            return new ks0(ax.b(ax.this), ax.z(ax.this), ax.t(ax.this), ax.c(ax.this), ax.d(ax.this), ax.o(ax.this));
        }
    }

    static final class y extends Lambda implements Function0<bt0> {
        public static final y b = new y();

        y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final bt0 invoke() {
            return new bt0(0);
        }
    }

    static final class z extends Lambda implements Function0<bz0> {
        z() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final bz0 invoke() {
            return new bz0(ax.C(ax.this));
        }
    }

    public ax(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8450a = LazyKt.lazy(new m(context));
        this.b = LazyKt.lazy(l0.b);
        this.c = LazyKt.lazy(l.b);
        this.d = LazyKt.lazy(o0.b);
        this.e = LazyKt.lazy(new z());
        this.f = LazyKt.lazy(a0.b);
        this.g = LazyKt.lazy(d0.b);
        this.h = LazyKt.lazy(new c0());
        this.i = LazyKt.lazy(d.b);
        this.j = LazyKt.lazy(g0.b);
        this.k = LazyKt.lazy(f0.b);
        this.l = LazyKt.lazy(new g());
        this.m = LazyKt.lazy(y.b);
        this.n = LazyKt.lazy(new e(context, this));
        this.o = LazyKt.lazy(new f(context, this));
        this.p = LazyKt.lazy(new e0());
        this.q = LazyKt.lazy(new k0(context, this));
        this.r = LazyKt.lazy(new s(context));
        this.s = LazyKt.lazy(w.b);
        this.t = LazyKt.lazy(new j0());
        this.u = LazyKt.lazy(new i0());
        this.v = LazyKt.lazy(new n0());
        this.w = LazyKt.lazy(new x());
        this.x = LazyKt.lazy(new h0(context, this));
        this.y = LazyKt.lazy(new t(context));
        this.z = LazyKt.lazy(new v(context, this));
        this.A = LazyKt.lazy(new u());
        this.B = LazyKt.lazy(new h());
        this.C = LazyKt.lazy(new k());
        this.D = LazyKt.lazy(new j());
        this.E = LazyKt.lazy(new q());
        this.F = LazyKt.lazy(new m0());
        this.G = LazyKt.lazy(new p());
        this.H = LazyKt.lazy(new o());
        this.I = LazyKt.lazy(new n());
        this.J = LazyKt.lazy(new r());
        this.K = LazyKt.lazy(new i(context, this));
        this.L = LazyKt.lazy(c.b);
        this.M = LazyKt.lazy(b.b);
        this.N = LazyKt.lazy(a.b);
        this.O = LazyKt.lazy(b0.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bp0 D(ax this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new bp0((ke0) this$0.E.getValue(), (o32) this$0.F.getValue(), (je0) this$0.G.getValue(), (ie0) this$0.H.getValue(), (he0) this$0.I.getValue(), (le0) this$0.J.getValue(), (hx) this$0.K.getValue(), (la) this$0.L.getValue(), (ia) this$0.M.getValue(), (fa) this$0.N.getValue(), (tz0) this$0.O.getValue());
    }

    public static final iw1 A(ax axVar) {
        return (iw1) axVar.b.getValue();
    }

    public static final gy B(ax axVar) {
        return (gy) axVar.v.getValue();
    }

    public static final ab2 C(ax axVar) {
        return (ab2) axVar.d.getValue();
    }

    public static final tw a(ax axVar) {
        return (tw) axVar.i.getValue();
    }

    public static final qe b(ax axVar) {
        return (qe) axVar.n.getValue();
    }

    public static final rr c(ax axVar) {
        return (rr) axVar.o.getValue();
    }

    public static final yv d(ax axVar) {
        return (yv) axVar.l.getValue();
    }

    public static final zw e(ax axVar) {
        return (zw) axVar.B.getValue();
    }

    public static final qx f(ax axVar) {
        return (qx) axVar.D.getValue();
    }

    public static final sx g(ax axVar) {
        return (sx) axVar.C.getValue();
    }

    public static final g10 h(ax axVar) {
        return (g10) axVar.c.getValue();
    }

    public static final m50 i(ax axVar) {
        return (m50) axVar.f8450a.getValue();
    }

    public static final gl0 j(ax axVar) {
        return (gl0) axVar.y.getValue();
    }

    public static final hl0 k(ax axVar) {
        return (hl0) axVar.A.getValue();
    }

    public static final jl0 l(ax axVar) {
        return (jl0) axVar.z.getValue();
    }

    public static final Json m(ax axVar) {
        return (Json) axVar.s.getValue();
    }

    public static final js0 n(ax axVar) {
        return (js0) axVar.w.getValue();
    }

    public static final bt0 o(ax axVar) {
        return (bt0) axVar.m.getValue();
    }

    public static final bz0 p(ax axVar) {
        return (bz0) axVar.e.getValue();
    }

    public static final nz0 q(ax axVar) {
        return (nz0) axVar.f.getValue();
    }

    public static final vz0 r(ax axVar) {
        return (vz0) axVar.h.getValue();
    }

    public static final wz0 s(ax axVar) {
        return (wz0) axVar.g.getValue();
    }

    public static final xz0 t(ax axVar) {
        return (xz0) axVar.p.getValue();
    }

    public static final e11 u(ax axVar) {
        return (e11) axVar.k.getValue();
    }

    public static final sz0 v(ax axVar) {
        return (sz0) axVar.j.getValue();
    }

    public static final ho1 w(ax axVar) {
        return (ho1) axVar.x.getValue();
    }

    public static final aq1 x(ax axVar) {
        return (aq1) axVar.u.getValue();
    }

    public static final si2 y(ax axVar) {
        return (si2) axVar.t.getValue();
    }

    public static final qv1 z(ax axVar) {
        return (qv1) axVar.q.getValue();
    }

    public final ix a() {
        return (ix) this.r.getValue();
    }

    public final bh2<bp0> b() {
        return new bh2() { // from class: com.yandex.mobile.ads.impl.ax$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.bh2
            public final ah2 a() {
                return ax.D(this.f$0);
            }
        };
    }
}
