package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.r5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public class C4406r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4357p5 f11744a;
    public final C4382q5 b;
    protected final Context c;
    public final C4108f5 d;
    public final F4 e;
    public final AbstractC4232k5 f;
    protected final Hl g;
    public final Zg h;
    public final L8 i;
    public final ICommonExecutor j;
    public final Kb k;
    public final InterfaceC4585y9 l;
    public final int m;

    public C4406r5(Context context, C4108f5 c4108f5, F4 f4, AbstractC4232k5 abstractC4232k5, Hl hl, Zg zg, ICommonExecutor iCommonExecutor, int i, Kb kb, InterfaceC4585y9 interfaceC4585y9) {
        this(context, c4108f5, f4, abstractC4232k5, hl, zg, iCommonExecutor, new L8(), i, new C4357p5(f4.f11134a), new C4382q5(context, c4108f5), kb, interfaceC4585y9);
    }

    public static C4062d9 c(C4282m5 c4282m5) {
        return new C4062d9(c4282m5);
    }

    public final Q8 a() {
        Context context = this.c;
        C4108f5 c4108f5 = this.d;
        return new Q8(new V8(context, c4108f5), this.m);
    }

    public final S6 b(C4282m5 c4282m5) {
        return new S6(c4282m5, C4135g7.a(this.c).c(this.d), new O6(c4282m5.c()), new C4309n7());
    }

    public final C4357p5 d() {
        return this.f11744a;
    }

    public final C4382q5 e() {
        return this.b;
    }

    public final Un f() {
        Un un;
        Yn c4188ia;
        Xn xnB = C4486ua.E.B();
        C4108f5 c4108f5 = this.d;
        synchronized (xnB) {
            String strValueOf = String.valueOf(c4108f5);
            LinkedHashMap linkedHashMap = xnB.b;
            Object un2 = linkedHashMap.get(strValueOf);
            if (un2 == null) {
                Le le = new Le(C4135g7.a(xnB.f11424a).b(c4108f5));
                if (c4108f5.d()) {
                    String str = "appmetrica_vital_" + c4108f5.b + ".dat";
                    c4188ia = new C4456t5(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(str, new C4188ia(xnB.f11424a, str)), TuplesKt.to("appmetrica_vital_main.dat", new C4188ia(xnB.f11424a, "appmetrica_vital_main.dat"))}));
                } else {
                    c4188ia = new C4188ia(xnB.f11424a, "appmetrica_vital_" + c4108f5.b + ".dat");
                }
                un2 = new Un(le, c4188ia, strValueOf);
                linkedHashMap.put(strValueOf, un2);
            }
            un = (Un) un2;
        }
        return un;
    }

    public C4406r5(Context context, C4108f5 c4108f5, F4 f4, AbstractC4232k5 abstractC4232k5, Hl hl, Zg zg, ICommonExecutor iCommonExecutor, L8 l8, int i, C4357p5 c4357p5, C4382q5 c4382q5, Kb kb, InterfaceC4585y9 interfaceC4585y9) {
        this.c = context;
        this.d = c4108f5;
        this.e = f4;
        this.f = abstractC4232k5;
        this.g = hl;
        this.h = zg;
        this.j = iCommonExecutor;
        this.i = l8;
        this.m = i;
        this.f11744a = c4357p5;
        this.b = c4382q5;
        this.k = kb;
        this.l = interfaceC4585y9;
    }

    public final C4322nk c() {
        return new C4322nk(this.c, this.d);
    }

    public final C4295mi d(C4282m5 c4282m5) {
        C4295mi c4295mi = new C4295mi(c4282m5, this.f.a(), this.j);
        Kb kb = this.k;
        synchronized (kb) {
            kb.c.add(c4295mi);
        }
        return c4295mi;
    }

    public final Fg a(C4282m5 c4282m5) {
        return new Fg(new C3995ah(c4282m5, this.h, new W3()), this.g, new Xg(this.e));
    }

    public static C4521vk a(C4282m5 c4282m5, Un un, C4257l5 c4257l5) {
        C4496uk c4496uk = new C4496uk(un);
        return new C4521vk(c4282m5, c4496uk, c4257l5, new C4337oa(c4282m5, c4496uk, new C4596yk(c4282m5.g(), "foreground"), AbstractC4378q1.a(), new SystemTimeProvider()), new J2(c4282m5, c4496uk, new C4596yk(c4282m5.g(), J2.g), AbstractC4378q1.a(), new SystemTimeProvider()));
    }

    public static C4158h5 b() {
        return new C4158h5();
    }

    public final C4386q9 a(Le le, Un un, C4521vk c4521vk, S6 s6, C4053d0 c4053d0, C4322nk c4322nk, C4295mi c4295mi) {
        return new C4386q9(le, un, c4521vk, s6, c4053d0, this.i, c4322nk, this.m, new C4332o5(c4295mi), new X8(un, new Y8(un)), new SystemTimeProvider());
    }

    public static C4245ki a(C4282m5 c4282m5, C4062d9 c4062d9) {
        return new C4245ki(c4062d9, c4282m5);
    }

    public InterfaceC4535w9 a(B9 b9, S6 s6, Fg fg, F4 f4, C4108f5 c4108f5, Le le) {
        return this.l.a(b9, s6, fg, f4, c4108f5, le).a();
    }

    public final G3 a(Le le) {
        Context context = this.c;
        return new G3(context, le, context.getPackageName(), new SafePackageManager());
    }
}
