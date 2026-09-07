package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.executors.SynchronizedBlockingExecutor;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.FinalConfigProvider;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.dm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4075dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4100em f11521a;
    public volatile NetworkTask b;

    public C4075dm(C4100em c4100em) {
        this.f11521a = c4100em;
    }

    public final Context b() {
        return this.f11521a.f11537a;
    }

    public final synchronized NetworkTask c() {
        NetworkTask networkTask;
        if (g()) {
            networkTask = this.b;
            if (networkTask == null || networkTask.isRemoved()) {
                Dl dlD = d();
                Nd nd = Nd.f11267a;
                C4622zl c4622zl = new C4622zl(new Yd(), C4486ua.E.o());
                FinalConfigProvider finalConfigProvider = new FinalConfigProvider(dlD);
                networkTask = new NetworkTask(new SynchronizedBlockingExecutor(), new E9(this.f11521a.f11537a), new AllHostsExponentialBackoffPolicy(Nd.f11267a.a(Ld.STARTUP)), new C4025bm(this, new C4472tl(), new FullUrlFormer(c4622zl, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), Nd.c);
                this.b = networkTask;
            }
        } else {
            networkTask = null;
        }
        return networkTask;
    }

    public final Dl d() {
        return (Dl) this.f11521a.l.a();
    }

    public final Hl e() {
        Hl hl;
        C4248kl c4248kl = this.f11521a.l;
        synchronized (c4248kl) {
            hl = c4248kl.c.f11402a;
        }
        return hl;
    }

    public final void f() {
        Hl hl;
        C4248kl c4248kl = this.f11521a.l;
        synchronized (c4248kl) {
            hl = c4248kl.c.f11402a;
        }
        Ll ll = hl.c;
        Kl klA = ll.a(ll.m);
        String strA = hl.f11181a;
        String str = hl.b;
        Mn mn = this.f11521a.n;
        String str2 = hl.d;
        mn.getClass();
        if (!Mn.a(str2)) {
            klA.f11230a = this.f11521a.m.a().id;
        }
        String str3 = hl.f11181a;
        if (str3 == null || str3.length() == 0) {
            strA = this.f11521a.h.a();
            str = "";
        }
        List<String> list = this.f11521a.c.e;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        klA.g = list;
        Hl hl2 = new Hl(strA, str, new Ll(klA));
        b(hl2);
        a(hl2);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a A[PHI: r1
  0x005a: PHI (r1v4 boolean) = (r1v3 boolean), (r1v7 boolean), (r1v7 boolean) binds: [B:10:0x0023, B:19:0x0055, B:20:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    public final synchronized boolean g() {
        boolean z;
        boolean z2;
        Hl hlE = e();
        Set set = El.f11127a;
        boolean z3 = false;
        if (!hlE.w) {
            z = El.b.currentTimeSeconds() > hlE.o + ((long) hlE.A.f11557a);
        }
        if (!z) {
            if (El.a(hlE.d) && El.a(hlE.f11181a) && El.a(hlE.b)) {
                z3 = true;
            }
            z = !z3;
            W3 w3 = this.f11521a.k;
            Map map = d().h;
            T3 t3 = this.f11521a.j;
            w3.getClass();
            z2 = (!z3 || W3.a(map, hlE, t3)) ? z : true;
        }
        return z2;
    }

    public final synchronized void h() {
        this.b = null;
    }

    public final C4108f5 a() {
        return this.f11521a.f;
    }

    public final synchronized void b(Hl hl) {
        this.f11521a.l.a(hl);
        Gl gl = this.f11521a.g;
        gl.b.a(hl.f11181a);
        gl.b.b(hl.b);
        gl.f11167a.save(hl.c);
        this.f11521a.e.a(hl);
    }

    public final synchronized boolean a(List<String> list, Map<String, String> map) {
        return !El.a(e(), list, map, new C4050cm(this));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    public final Hl a(Fl fl, Dl dl, long j) {
        String str;
        boolean zEquals;
        String strA = AbstractC4199im.a(dl.h);
        Map map = dl.i.f11236a;
        String str2 = fl.j;
        String str3 = e().k;
        if (!AbstractC4199im.a(AbstractC4199im.a(str2))) {
            str2 = AbstractC4199im.a(AbstractC4199im.a(str3)) ? str3 : null;
        }
        String str4 = e().f11181a;
        if (str4 != null) {
            str = StringsKt.isBlank(str4) ? null : str4;
            if (str == null) {
                str = fl.h;
            }
        } else {
            str = fl.h;
        }
        Kl kl = new Kl(fl.b);
        String str5 = fl.i;
        kl.o = this.f11521a.i.currentTimeSeconds();
        kl.f11230a = e().d;
        kl.c = fl.d;
        kl.f = fl.c;
        kl.g = dl.e;
        kl.b = fl.e;
        kl.d = fl.f;
        kl.e = fl.g;
        kl.h = fl.n;
        kl.i = fl.o;
        kl.j = str2;
        kl.k = strA;
        this.f11521a.k.getClass();
        HashMap mapA = AbstractC4199im.a(str2);
        if (In.a(map)) {
            zEquals = In.a((Map) mapA);
        } else {
            zEquals = mapA.equals(map);
        }
        kl.q = zEquals;
        kl.l = AbstractC4199im.a(map);
        kl.r = fl.m;
        kl.n = fl.k;
        kl.s = fl.p;
        kl.p = true;
        kl.t = j;
        Dl dlD = d();
        if (dlD.n == 0) {
            dlD.n = j;
        }
        kl.u = dlD.n;
        kl.v = false;
        kl.w = fl.q;
        kl.y = fl.s;
        kl.x = fl.r;
        kl.z = fl.t;
        kl.A = fl.u;
        kl.B = fl.v;
        kl.C = fl.w;
        return new Hl(str, str5, new Ll(kl));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0032  */
    public final void a(Fl fl, Dl dl, Map<String, ? extends List<String>> map) {
        Long lValueOf;
        Hl hlA;
        synchronized (this) {
            if (In.a((Map) map)) {
                lValueOf = null;
            } else {
                List list = (List) CollectionUtils.getFromMapIgnoreCase(map, "Date");
                if (In.a((Collection) list)) {
                    lValueOf = null;
                } else {
                    try {
                        lValueOf = Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse((String) list.get(0)).getTime());
                    } catch (Throwable unused) {
                        lValueOf = null;
                    }
                }
            }
            long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
            Jj.f11212a.a(jLongValue, fl.l);
            hlA = a(fl, dl, jLongValue);
            h();
            b(hlA);
            Unit unit = Unit.INSTANCE;
        }
        a(hlA);
    }

    public final void a(Hl hl) {
        ArrayList arrayList;
        C4100em c4100em = this.f11521a;
        C4174hl c4174hl = c4100em.d;
        String str = c4100em.b;
        synchronized (c4174hl.f11588a.b) {
            C4223jl c4223jl = c4174hl.f11588a;
            c4223jl.c = hl;
            Collection collection = (Collection) c4223jl.f11622a.f11830a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC4447sl) it.next()).a(hl);
        }
    }

    public final void a(EnumC4273ll enumC4273ll) {
        synchronized (this) {
            this.b = null;
        }
        C4100em c4100em = this.f11521a;
        c4100em.d.a(c4100em.f.f11544a, enumC4273ll, e());
    }

    public final synchronized void a(Bl bl) {
        this.f11521a.l.a(bl);
        Dl dlD = d();
        if (dlD.k) {
            List list = dlD.j;
            if (list != null && !list.isEmpty()) {
                if (!In.a(list, dlD.e)) {
                    Hl hlE = e();
                    Ll ll = hlE.c;
                    Kl klA = ll.a(ll.m);
                    String str = hlE.f11181a;
                    String str2 = hlE.b;
                    klA.g = list;
                    Hl hl = new Hl(str, str2, new Ll(klA));
                    b(hl);
                    a(hl);
                }
            } else {
                List list2 = dlD.e;
                if (list2 != null && (!list2.isEmpty())) {
                    Hl hlE2 = e();
                    Ll ll2 = hlE2.c;
                    Kl klA2 = ll2.a(ll2.m);
                    String str3 = hlE2.f11181a;
                    String str4 = hlE2.b;
                    klA2.g = null;
                    Hl hl2 = new Hl(str3, str4, new Ll(klA2));
                    b(hl2);
                    a(hl2);
                }
            }
        }
    }
}
