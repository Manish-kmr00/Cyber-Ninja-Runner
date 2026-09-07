package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.a9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3987a9 {
    public static final Map h;
    public static final C3987a9 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4539wd f11460a;
    public final Qn b;
    public final D8 c;
    public final InterfaceC4610z9 d;
    public final InterfaceC3990ac e;
    public final Md f;
    public final U9 g;

    static {
        HashMap map = new HashMap();
        map.put(EnumC4237ka.FIRST_OCCURRENCE, 1);
        map.put(EnumC4237ka.NON_FIRST_OCCURENCE, 0);
        map.put(EnumC4237ka.UNKNOWN, -1);
        h = Collections.unmodifiableMap(map);
        i = new C3987a9(new Hi(), new Am(), new Ud(), new Gi(), new C4387qa(), new C4411ra(), new C4362pa());
    }

    public C3987a9(Z8 z8) {
        this(z8.f11447a, z8.b, z8.c, z8.d, z8.e, z8.f, z8.g);
    }

    public final C4236k9 a(R8 r8, C4045ch c4045ch) {
        C4236k9 c4236k9 = new C4236k9();
        C4211j9 c4211j9A = this.f.a(r8.l, r8.m);
        C4112f9 c4112f9A = this.e.a(r8.g);
        if (c4211j9A != null) {
            c4236k9.g = c4211j9A;
        }
        if (c4112f9A != null) {
            c4236k9.f = c4112f9A;
        }
        String strA = this.f11460a.a(r8.f11326a);
        if (strA != null) {
            c4236k9.d = strA;
        }
        c4236k9.e = this.b.a(r8, c4045ch);
        String str = r8.j;
        if (str != null) {
            c4236k9.h = str;
        }
        Integer numA = this.d.a(r8);
        if (numA != null) {
            c4236k9.c = numA.intValue();
        }
        Long l = r8.c;
        if (l != null) {
            c4236k9.f11634a = l.longValue();
        }
        Long l2 = r8.d;
        if (l2 != null) {
            c4236k9.n = l2.longValue();
        }
        Long l3 = r8.e;
        if (l3 != null) {
            c4236k9.o = l3.longValue();
        }
        Long l4 = r8.f;
        if (l4 != null) {
            c4236k9.b = l4.longValue();
        }
        Integer num = r8.k;
        if (num != null) {
            c4236k9.i = num.intValue();
        }
        c4236k9.j = this.c.a(r8.o);
        C4384q7 c4384q7 = r8.g;
        c4236k9.k = c4384q7 != null ? new C4407r6().a(c4384q7.f11732a) : -1;
        String str2 = r8.n;
        if (str2 != null) {
            c4236k9.l = str2.getBytes();
        }
        EnumC4237ka enumC4237ka = r8.p;
        Integer num2 = enumC4237ka != null ? (Integer) h.get(enumC4237ka) : null;
        if (num2 != null) {
            c4236k9.m = num2.intValue();
        }
        EnumC4435s9 enumC4435s9 = r8.q;
        if (enumC4435s9 != null) {
            c4236k9.p = enumC4435s9.f11762a;
        }
        Boolean bool = r8.r;
        if (bool != null) {
            c4236k9.q = bool.booleanValue();
        }
        Integer num3 = r8.s;
        if (num3 != null) {
            c4236k9.r = num3.intValue();
        }
        c4236k9.s = ((C4362pa) this.g).a(r8.t);
        return c4236k9;
    }

    public C3987a9(InterfaceC4539wd interfaceC4539wd, Qn qn, D8 d8, InterfaceC4610z9 interfaceC4610z9, InterfaceC3990ac interfaceC3990ac, Md md, U9 u9) {
        this.f11460a = interfaceC4539wd;
        this.b = qn;
        this.c = d8;
        this.d = interfaceC4610z9;
        this.e = interfaceC3990ac;
        this.f = md;
        this.g = u9;
    }

    public static Z8 a() {
        return new Z8(i);
    }
}
