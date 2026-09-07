package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes10.dex */
public interface k60 extends di1 {

    public interface a {
        default void a() {
        }
    }

    void a(cm1 cm1Var);

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f9384a;
        r32 b;
        m32<uo1> c;
        m32<rw0.a> d;
        m32<y52> e;
        m32<yr0> f;
        m32<vi> g;
        ce0<hp, ed> h;
        Looper i;
        oh j;
        int k;
        boolean l;
        yw1 m;
        yz n;
        long o;
        long p;
        boolean q;
        boolean r;

        /* JADX INFO: Access modifiers changed from: private */
        public static rw0.a b(Context context) {
            return new d00(new lz.a(context, new vz.a()), new uz());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static y52 c(Context context) {
            return new p00(context, p00.c.a(context), new za.b(0));
        }

        public b(final Context context) {
            this(context, new m32() { // from class: com.yandex.mobile.ads.impl.k60$b$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return k60.b.a(context);
                }
            }, new m32() { // from class: com.yandex.mobile.ads.impl.k60$b$$ExternalSyntheticLambda1
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return k60.b.b(context);
                }
            });
        }

        public final k60 a() {
            if (!this.r) {
                this.r = true;
                return new o60(this);
            }
            throw new IllegalStateException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ uo1 a(Context context) {
            return new i00(context);
        }

        private b(final Context context, m32<uo1> m32Var, m32<rw0.a> m32Var2) {
            this(context, m32Var, m32Var2, new m32() { // from class: com.yandex.mobile.ads.impl.k60$b$$ExternalSyntheticLambda2
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return k60.b.c(context);
                }
            }, new m32() { // from class: com.yandex.mobile.ads.impl.k60$b$$ExternalSyntheticLambda3
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return new zz();
                }
            }, new m32() { // from class: com.yandex.mobile.ads.impl.k60$b$$ExternalSyntheticLambda4
                @Override // com.yandex.mobile.ads.impl.m32
                public final Object get() {
                    return gz.a(context);
                }
            }, new ce0() { // from class: com.yandex.mobile.ads.impl.k60$b$$ExternalSyntheticLambda5
                @Override // com.yandex.mobile.ads.impl.ce0
                public final Object apply(Object obj) {
                    return new bz((hp) obj);
                }
            });
        }

        private b(Context context, m32<uo1> m32Var, m32<rw0.a> m32Var2, m32<y52> m32Var3, m32<yr0> m32Var4, m32<vi> m32Var5, ce0<hp, ed> ce0Var) {
            this.f9384a = context;
            this.c = m32Var;
            this.d = m32Var2;
            this.e = m32Var3;
            this.f = m32Var4;
            this.g = m32Var5;
            this.h = ce0Var;
            this.i = x82.c();
            this.j = oh.h;
            this.k = 1;
            this.l = true;
            this.m = yw1.c;
            this.n = new yz.a().a();
            this.b = hp.f9123a;
            this.o = 500L;
            this.p = 2000L;
            this.q = true;
        }
    }
}
