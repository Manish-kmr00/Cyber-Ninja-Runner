package com.yandex.mobile.ads.impl;

import android.util.Pair;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes12.dex */
public final class fu0 extends dr<Void> {
    private final rw0 k;
    private final boolean l;
    private final b52.d m;
    private final b52.b n;
    private a o;
    private eu0 p;
    private boolean q;
    private boolean r;
    private boolean s;

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void maybeThrowSourceInfoRefreshError() {
    }

    public fu0(rw0 rw0Var, boolean z) {
        boolean z2;
        this.k = rw0Var;
        if (z) {
            rw0Var.getClass();
            z2 = true;
        } else {
            z2 = false;
        }
        this.l = z2;
        this.m = new b52.d();
        this.n = new b52.b();
        rw0Var.getClass();
        this.o = a.a(rw0Var.getMediaItem());
    }

    public final b52 f() {
        return this.o;
    }

    @Override // com.yandex.mobile.ads.impl.dr
    protected final rw0.b a(Void r2, rw0.b bVar) {
        Object obj = bVar.f9759a;
        Object obj2 = this.o.e;
        if (obj2 != null && obj2.equals(obj)) {
            obj = a.f;
        }
        return new rw0.b(bVar.a(obj));
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final fw0 getMediaItem() {
        return this.k.getMediaItem();
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final eu0 a(rw0.b bVar, cd cdVar, long j) {
        eu0 eu0Var = new eu0(bVar, cdVar, j);
        eu0Var.a(this.k);
        if (this.r) {
            Object obj = bVar.f9759a;
            if (this.o.e != null && obj.equals(a.f)) {
                obj = this.o.e;
            }
            eu0Var.a(new rw0.b(bVar.a(obj)));
        } else {
            this.p = eu0Var;
            if (!this.q) {
                this.q = true;
                a((Object) null, this.k);
            }
        }
        return eu0Var;
    }

    @Override // com.yandex.mobile.ads.impl.dr, com.yandex.mobile.ads.impl.ok
    public final void e() {
        this.r = false;
        this.q = false;
        super.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.yandex.mobile.ads.impl.fu0-IA] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
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
    @Override // com.yandex.mobile.ads.impl.dr
    /* JADX INFO: renamed from: b */
    public final void a(Void r16, rw0 rw0Var, b52 b52Var) {
        a aVar;
        a aVar2;
        rw0.b bVar = 0;
        bVar = 0;
        bVar = 0;
        bVar = 0;
        if (this.r) {
            a aVar3 = this.o;
            this.o = new a(b52Var, aVar3.d, aVar3.e);
            eu0 eu0Var = this.p;
            if (eu0Var != null) {
                a(eu0Var.a());
            }
        } else if (b52Var.c()) {
            if (this.s) {
                a aVar4 = this.o;
                aVar2 = new a(b52Var, aVar4.d, aVar4.e);
            } else {
                aVar2 = new a(b52Var, b52.d.s, a.f);
            }
            this.o = aVar2;
        } else {
            b52Var.a(0, this.m, 0L);
            b52.d dVar = this.m;
            long j = dVar.n;
            Object obj = dVar.b;
            eu0 eu0Var2 = this.p;
            if (eu0Var2 != null) {
                long jB = eu0Var2.b();
                a aVar5 = this.o;
                Object obj2 = this.p.b.f9759a;
                aVar5.a(aVar5.a(obj2), this.n, true);
                long j2 = this.n.f + jB;
                if (j2 != this.o.a(0, this.m, 0L).n) {
                    j = j2;
                }
            }
            Pair<Object, Long> pairA = b52Var.a(this.m, this.n, 0, j);
            Object obj3 = pairA.first;
            long jLongValue = ((Long) pairA.second).longValue();
            if (this.s) {
                a aVar6 = this.o;
                aVar = new a(b52Var, aVar6.d, aVar6.e);
            } else {
                aVar = new a(b52Var, obj, obj3);
            }
            this.o = aVar;
            eu0 eu0Var3 = this.p;
            if (eu0Var3 != null) {
                a(jLongValue);
                rw0.b bVar2 = eu0Var3.b;
                Object obj4 = bVar2.f9759a;
                if (this.o.e != null && obj4.equals(a.f)) {
                    obj4 = this.o.e;
                }
                bVar = new rw0.b(bVar2.a(obj4));
            }
        }
        this.s = true;
        this.r = true;
        a(this.o);
        if (bVar != 0) {
            eu0 eu0Var4 = this.p;
            eu0Var4.getClass();
            eu0Var4.a(bVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.dr, com.yandex.mobile.ads.impl.ok
    public final void a(w62 w62Var) {
        super.a(w62Var);
        if (this.l) {
            return;
        }
        this.q = true;
        a((Object) null, this.k);
    }

    private static final class a extends lc0 {
        public static final Object f = new Object();
        private final Object d;
        private final Object e;

        private a(b52 b52Var, Object obj, Object obj2) {
            super(b52Var);
            this.d = obj;
            this.e = obj2;
        }

        @Override // com.yandex.mobile.ads.impl.lc0, com.yandex.mobile.ads.impl.b52
        public final int a(Object obj) {
            Object obj2;
            b52 b52Var = this.c;
            if (f.equals(obj) && (obj2 = this.e) != null) {
                obj = obj2;
            }
            return b52Var.a(obj);
        }

        @Override // com.yandex.mobile.ads.impl.b52
        public final b52.b a(int i, b52.b bVar, boolean z) {
            this.c.a(i, bVar, z);
            if (x82.a(bVar.c, this.e) && z) {
                bVar.c = f;
            }
            return bVar;
        }

        @Override // com.yandex.mobile.ads.impl.lc0, com.yandex.mobile.ads.impl.b52
        public final Object a(int i) {
            Object objA = this.c.a(i);
            return x82.a(objA, this.e) ? f : objA;
        }

        @Override // com.yandex.mobile.ads.impl.lc0, com.yandex.mobile.ads.impl.b52
        public final b52.d a(int i, b52.d dVar, long j) {
            this.c.a(i, dVar, j);
            if (x82.a(dVar.b, this.d)) {
                dVar.b = b52.d.s;
            }
            return dVar;
        }

        public static a a(fw0 fw0Var) {
            return new a(new b(fw0Var), b52.d.s, f);
        }
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(lw0 lw0Var) {
        ((eu0) lw0Var).c();
        if (lw0Var == this.p) {
            this.p = null;
        }
    }

    public static final class b extends b52 {
        private final fw0 c;

        @Override // com.yandex.mobile.ads.impl.b52
        public final int a() {
            return 1;
        }

        @Override // com.yandex.mobile.ads.impl.b52
        public final int b() {
            return 1;
        }

        public b(fw0 fw0Var) {
            this.c = fw0Var;
        }

        @Override // com.yandex.mobile.ads.impl.b52
        public final int a(Object obj) {
            return obj == a.f ? 0 : -1;
        }

        @Override // com.yandex.mobile.ads.impl.b52
        public final b52.b a(int i, b52.b bVar, boolean z) {
            bVar.a(z ? 0 : null, z ? a.f : null, 0, -9223372036854775807L, 0L, n5.h, true);
            return bVar;
        }

        @Override // com.yandex.mobile.ads.impl.b52
        public final b52.d a(int i, b52.d dVar, long j) {
            dVar.a(b52.d.s, this.c, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.m = true;
            return dVar;
        }

        @Override // com.yandex.mobile.ads.impl.b52
        public final Object a(int i) {
            return a.f;
        }
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void a(long j) {
        eu0 eu0Var = this.p;
        int iA = this.o.a(eu0Var.b.f9759a);
        if (iA == -1) {
            return;
        }
        long j2 = this.o.a(iA, this.n, false).e;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        eu0Var.a(j);
    }
}
