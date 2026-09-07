package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.m5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public class C4282m5 implements Wa, La, InterfaceC4020bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11664a;
    public final C4108f5 b;
    public final Le c;
    public final Oe d;
    public final S6 e;
    public final C4245ki f;
    public final C4062d9 g;
    public final C4053d0 h;
    public final C4078e0 i;
    public final C4521vk j;
    public final Fg k;
    public final Q8 l;
    public final PublicLogger m;
    public final C4386q9 n;
    public final C4158h5 o;
    public final InterfaceC4535w9 p;
    public final G3 q;
    public final TimePassedChecker r;
    public final Cif s;
    public final Un t;
    public final C4322nk u;

    public C4282m5(Context context, Hl hl, C4108f5 c4108f5, F4 f4, Zg zg, AbstractC4232k5 abstractC4232k5) {
        this(context, c4108f5, new C4078e0(), new TimePassedChecker(), new C4406r5(context, c4108f5, f4, abstractC4232k5, hl, zg, C4486ua.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), C4486ua.j().k(), new C4083e5()), f4);
    }

    public final boolean A() {
        Hl hl;
        Cif cif = this.s;
        cif.h.a(cif.f11375a);
        boolean z = ((C4118ff) cif.c()).d;
        Fg fg = this.k;
        synchronized (fg) {
            hl = fg.c.f11402a;
        }
        return !(z && hl.q);
    }

    public void B() {
    }

    @Override // io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.InterfaceC4447sl
    public final void a(EnumC4273ll enumC4273ll, Hl hl) {
    }

    @Override // io.appmetrica.analytics.impl.La
    public final C4108f5 b() {
        return this.b;
    }

    public CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MANUAL;
    }

    public final void d() {
        C4053d0 c4053d0 = this.h;
        synchronized (c4053d0) {
            c4053d0.f11504a = new Lc();
        }
        this.i.a(this.h.a(), this.c);
    }

    public final synchronized void e() {
        ((C4556x5) this.p).c();
    }

    public final G3 f() {
        return this.q;
    }

    public final Le g() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.La
    public final Context getContext() {
        return this.f11664a;
    }

    public final S6 h() {
        return this.e;
    }

    public final Q8 i() {
        return this.l;
    }

    public final C4062d9 j() {
        return this.g;
    }

    public final C4386q9 k() {
        return this.n;
    }

    public final InterfaceC4535w9 l() {
        return this.p;
    }

    public final C4045ch m() {
        return (C4045ch) this.k.a();
    }

    public final String n() {
        return this.c.i();
    }

    public final PublicLogger o() {
        return this.m;
    }

    public final Oe p() {
        return this.d;
    }

    public final C4322nk q() {
        return this.u;
    }

    public final C4521vk r() {
        return this.j;
    }

    public final Hl s() {
        Hl hl;
        Fg fg = this.k;
        synchronized (fg) {
            hl = fg.c.f11402a;
        }
        return hl;
    }

    public final Un t() {
        return this.t;
    }

    public final void u() {
        C4386q9 c4386q9 = this.n;
        int i = c4386q9.k;
        c4386q9.m = i;
        c4386q9.f11734a.a(i).b();
    }

    public final void v() {
        int iOptInt;
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        Un un = this.t;
        synchronized (un) {
            iOptInt = un.f11384a.a().optInt("last_migration_api_level", 0);
        }
        Integer numValueOf = Integer.valueOf(iOptInt);
        if (numValueOf.intValue() < libraryApiLevel) {
            this.o.getClass();
            List listListOf = CollectionsKt.listOf(new C4207j5(this));
            int iIntValue = numValueOf.intValue();
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                ((AbstractC4183i5) it.next()).a(iIntValue);
            }
            this.t.b(libraryApiLevel);
        }
    }

    public final boolean w() {
        C4045ch c4045ch = (C4045ch) this.k.a();
        return c4045ch.n && c4045ch.isIdentifiersValid() && this.r.didTimePassSeconds(this.n.l, c4045ch.s, "need to check permissions");
    }

    public final boolean x() {
        C4386q9 c4386q9 = this.n;
        return c4386q9.m < c4386q9.k && ((C4045ch) this.k.a()).o && ((C4045ch) this.k.a()).isIdentifiersValid();
    }

    public final void y() {
        Fg fg = this.k;
        synchronized (fg) {
            fg.f11071a = null;
        }
    }

    public final boolean z() {
        C4045ch c4045ch = (C4045ch) this.k.a();
        return c4045ch.n && this.r.didTimePassSeconds(this.n.l, c4045ch.t, "should force send permissions");
    }

    public final void b(C3984a6 c3984a6) {
        this.h.a(c3984a6.f);
        C4028c0 c4028c0A = this.h.a();
        C4078e0 c4078e0 = this.i;
        Le le = this.c;
        synchronized (c4078e0) {
            if (c4028c0A.b > le.d().b) {
                le.a(c4028c0A).b();
                this.m.info("Save new app environment for %s. Value: %s", this.b, c4028c0A.f11486a);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Wa
    public final void a(C3984a6 c3984a6) {
        String strA = Df.a("Event received on service", EnumC4164hb.a(c3984a6.d), c3984a6.getName(), c3984a6.getValue());
        if (strA != null) {
            this.m.info(strA, new Object[0]);
        }
        String str = this.b.b;
        if (TextUtils.isEmpty(str) || "-1".equals(str)) {
            return;
        }
        this.f.a(c3984a6, new C4220ji());
    }

    @Override // io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.La
    public synchronized void a(F4 f4) {
        this.k.a(f4);
        if (Boolean.TRUE.equals(f4.h)) {
            this.m.setEnabled(true);
        } else {
            if (Boolean.FALSE.equals(f4.h)) {
                this.m.setEnabled(false);
            }
        }
    }

    public C4282m5(Context context, C4108f5 c4108f5, C4078e0 c4078e0, TimePassedChecker timePassedChecker, C4406r5 c4406r5, F4 f4) {
        this.f11664a = context.getApplicationContext();
        this.b = c4108f5;
        this.i = c4078e0;
        this.r = timePassedChecker;
        Un unF = c4406r5.f();
        this.t = unF;
        this.s = C4486ua.j().s();
        Fg fgA = c4406r5.a(this);
        this.k = fgA;
        PublicLogger publicLoggerA = c4406r5.d().a();
        this.m = publicLoggerA;
        Le leA = c4406r5.e().a();
        this.c = leA;
        this.d = C4486ua.j().x();
        C4053d0 c4053d0A = c4078e0.a(c4108f5, publicLoggerA, leA);
        this.h = c4053d0A;
        this.l = c4406r5.a();
        S6 s6B = c4406r5.b(this);
        this.e = s6B;
        C4295mi c4295miD = c4406r5.d(this);
        this.o = C4406r5.b();
        v();
        C4521vk c4521vkA = C4406r5.a(this, unF, new C4257l5(this));
        this.j = c4521vkA;
        publicLoggerA.info("Read app environment for component %s. Value: %s", c4108f5.toString(), c4053d0A.a().f11486a);
        C4322nk c4322nkC = c4406r5.c();
        this.u = c4322nkC;
        this.n = c4406r5.a(leA, unF, c4521vkA, s6B, c4053d0A, c4322nkC, c4295miD);
        C4062d9 c4062d9C = C4406r5.c(this);
        this.g = c4062d9C;
        this.f = C4406r5.a(this, c4062d9C);
        this.q = c4406r5.a(leA);
        this.p = c4406r5.a(c4295miD, s6B, fgA, f4, c4108f5, leA);
        s6B.d();
    }

    @Override // io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.InterfaceC4447sl
    public synchronized void a(Hl hl) {
        this.k.a(hl);
        ((C4556x5) this.p).d();
    }

    public final void a(String str) {
        this.c.j(str).b();
    }
}
