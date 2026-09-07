package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Il implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4316ne f11200a = new C4316ne();
    public final C4287ma b = new C4287ma();
    public final C4249km c = new C4249km();
    public final C4428s2 d = new C4428s2();
    public final C4604z3 e = new C4604z3();
    public final C4379q2 f = new C4379q2();
    public final D6 g = new D6();
    public final C4150gm h = new C4150gm();
    public final C4365pd i = new C4365pd();
    public final J9 j = new J9();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Zl fromModel(Ll ll) {
        Zl zl = new Zl();
        zl.s = ll.u;
        zl.t = ll.v;
        String str = ll.f11248a;
        if (str != null) {
            zl.f11452a = str;
        }
        List list = ll.f;
        if (list != null) {
            zl.f = (String[]) list.toArray(new String[list.size()]);
        }
        List list2 = ll.g;
        if (list2 != null) {
            zl.g = (String[]) list2.toArray(new String[list2.size()]);
        }
        List list3 = ll.b;
        if (list3 != null) {
            zl.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List list4 = ll.h;
        if (list4 != null) {
            zl.o = (String[]) list4.toArray(new String[list4.size()]);
        }
        Map<String, ? extends List<String>> map = ll.i;
        if (map != null) {
            zl.h = this.g.fromModel(map);
        }
        C4291me c4291me = ll.s;
        if (c4291me != null) {
            zl.v = this.f11200a.fromModel(c4291me);
        }
        String str2 = ll.j;
        if (str2 != null) {
            zl.j = str2;
        }
        String str3 = ll.c;
        if (str3 != null) {
            zl.d = str3;
        }
        String str4 = ll.d;
        if (str4 != null) {
            zl.e = str4;
        }
        String str5 = ll.e;
        if (str5 != null) {
            zl.r = str5;
        }
        zl.i = this.b.fromModel(ll.m);
        String str6 = ll.k;
        if (str6 != null) {
            zl.k = str6;
        }
        String str7 = ll.l;
        if (str7 != null) {
            zl.l = str7;
        }
        zl.m = ll.p;
        zl.b = ll.n;
        zl.q = ll.o;
        RetryPolicyConfig retryPolicyConfig = ll.t;
        zl.w = retryPolicyConfig.maxIntervalSeconds;
        zl.x = retryPolicyConfig.exponentialMultiplier;
        String str8 = ll.q;
        if (str8 != null) {
            zl.n = str8;
        }
        C4224jm c4224jm = ll.r;
        if (c4224jm != null) {
            this.c.getClass();
            Yl yl = new Yl();
            yl.f11441a = c4224jm.f11623a;
            zl.p = yl;
        }
        zl.u = ll.w;
        BillingConfig billingConfig = ll.x;
        if (billingConfig != null) {
            zl.z = this.d.fromModel(billingConfig);
        }
        C4554x3 c4554x3 = ll.y;
        if (c4554x3 != null) {
            this.e.getClass();
            Rl rl = new Rl();
            rl.f11336a = c4554x3.f11839a;
            zl.y = rl;
        }
        C4354p2 c4354p2 = ll.z;
        if (c4354p2 != null) {
            zl.A = this.f.fromModel(c4354p2);
        }
        zl.B = this.h.fromModel(ll.A);
        zl.C = this.i.fromModel(ll.B);
        zl.D = this.j.fromModel(ll.C);
        return zl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ll toModel(Zl zl) {
        Kl kl = new Kl(this.b.toModel(zl.i));
        kl.f11230a = zl.f11452a;
        kl.j = zl.j;
        kl.c = zl.d;
        kl.b = Arrays.asList(zl.c);
        kl.g = Arrays.asList(zl.g);
        kl.f = Arrays.asList(zl.f);
        kl.d = zl.e;
        kl.e = zl.r;
        kl.h = Arrays.asList(zl.o);
        kl.k = zl.k;
        kl.l = zl.l;
        kl.q = zl.m;
        kl.o = zl.b;
        kl.p = zl.q;
        kl.t = zl.s;
        kl.u = zl.t;
        kl.r = zl.n;
        kl.v = zl.u;
        kl.w = new RetryPolicyConfig(zl.w, zl.x);
        kl.i = this.g.toModel(zl.h);
        Wl wl = zl.v;
        if (wl != null) {
            this.f11200a.getClass();
            kl.n = new C4291me(wl.f11408a, wl.b);
        }
        Yl yl = zl.p;
        if (yl != null) {
            this.c.getClass();
            kl.s = new C4224jm(yl.f11441a);
        }
        Ql ql = zl.z;
        if (ql != null) {
            this.d.getClass();
            kl.x = new BillingConfig(ql.f11318a, ql.b);
        }
        Rl rl = zl.y;
        if (rl != null) {
            this.e.getClass();
            kl.y = new C4554x3(rl.f11336a);
        }
        Pl pl = zl.A;
        if (pl != null) {
            kl.z = this.f.toModel(pl);
        }
        Xl xl = zl.B;
        if (xl != null) {
            this.h.getClass();
            kl.A = new C4125fm(xl.f11423a);
        }
        kl.B = this.i.toModel(zl.C);
        Tl tl = zl.D;
        if (tl != null) {
            this.j.getClass();
            kl.C = new I9(tl.f11368a);
        }
        return new Ll(kl);
    }
}
