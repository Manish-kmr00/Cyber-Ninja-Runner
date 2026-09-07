package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.g7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4135g7 {
    public static volatile C4135g7 t;
    public final Context e;
    public C4110f7 f;
    public C4110f7 g;
    public C4280m3 h;
    public C4305n3 i;
    public C4280m3 j;
    public C4305n3 k;
    public C4562xb l;
    public C4587yb m;
    public Pm n;
    public Qm o;
    public C4562xb p;
    public C4587yb q;
    public C4090ec r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11564a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final T6 d = J5.a();
    public final C4185i7 s = new C4185i7();

    public C4135g7(Context context) {
        this.e = context;
    }

    public static C4135g7 a(Context context) {
        if (t == null) {
            synchronized (C4135g7.class) {
                if (t == null) {
                    t = new C4135g7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized Oa b(C4108f5 c4108f5) {
        Oa c4562xb;
        String str = new Y4(c4108f5).f11430a;
        c4562xb = (Oa) this.b.get(str);
        if (c4562xb == null) {
            c4562xb = new C4562xb(new Sk(c(c4108f5)));
            this.b.put(str, c4562xb);
        }
        return c4562xb;
    }

    public final synchronized C4110f7 c(C4108f5 c4108f5) {
        C4110f7 c4110f7;
        Y4 y4 = new Y4(c4108f5);
        c4110f7 = (C4110f7) this.f11564a.get(y4.f11430a);
        if (c4110f7 == null) {
            Context context = this.e;
            C4185i7 c4185i7 = this.s;
            String strA = new C4160h7(c4185i7.f11597a, c4185i7.b, false).a(context, y4);
            T6 t6 = this.d;
            t6.getClass();
            String str = c4108f5.b;
            if (str == null) {
                str = com.ironsource.b9.h.Z;
            }
            String str2 = String.format("component-%s", str);
            Gm gm = t6.c;
            C4060d7 c4060d7 = t6.f11361a;
            V6 v6 = c4060d7.f11511a;
            W6 w6 = c4060d7.b;
            C4536wa c4536wa = new C4536wa(false);
            c4536wa.a(112, new C4008b5());
            Im im = new Im(str2, t6.b.f11085a);
            gm.getClass();
            c4110f7 = new C4110f7(context, strA, new Hm(v6, w6, c4536wa, im), PublicLogger.getAnonymousInstance());
            this.f11564a.put(y4.f11430a, c4110f7);
        }
        return c4110f7;
    }

    public final synchronized Oa d() {
        if (this.l == null) {
            this.l = new C4562xb(new Sk(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                C4185i7 c4185i7 = this.s;
                String strA = new C4160h7(c4185i7.f11597a, c4185i7.b, false).a(context, new C4603z2());
                T6 t6 = this.d;
                t6.getClass();
                HashMap map = new HashMap();
                map.put("binary_data", E5.f11116a);
                Gm gm = t6.c;
                C4060d7 c4060d7 = t6.f11361a;
                X6 x6 = c4060d7.g;
                Y6 y6 = c4060d7.h;
                C4536wa c4536wa = new C4536wa(false);
                Im im = new Im("auto_inapp", map);
                gm.getClass();
                this.g = new C4110f7(context, strA, new Hm(x6, y6, c4536wa, im), PublicLogger.getAnonymousInstance());
            }
            this.j = new C4280m3(new Sk(this.g));
        }
        return this.j;
    }

    public final Oa f() {
        C4090ec c4090ec;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    C4185i7 c4185i7 = this.s;
                    String strA = new C4160h7(c4185i7.f11597a, c4185i7.b, true).a(this.e, new C4107f4());
                    Context context = this.e;
                    T6 t6 = this.d;
                    t6.getClass();
                    HashMap map = new HashMap();
                    map.put("preferences", G5.f11155a);
                    Gm gm = t6.c;
                    C4060d7 c4060d7 = t6.f11361a;
                    Z6 z6 = c4060d7.c;
                    C3985a7 c3985a7 = c4060d7.d;
                    C4536wa c4536wa = new C4536wa(false);
                    c4536wa.a(112, new C4132g4());
                    Im im = new Im("service database", map);
                    gm.getClass();
                    this.r = new C4090ec(context, strA, new C4113fa(strA), new Hm(z6, c3985a7, c4536wa, im));
                }
                c4090ec = this.r;
            }
            this.p = new C4562xb(c4090ec);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C4280m3(new Sk(h()));
        }
        return this.h;
    }

    public final synchronized C4110f7 h() {
        if (this.f == null) {
            Context context = this.e;
            C4185i7 c4185i7 = this.s;
            String strA = new C4160h7(c4185i7.f11597a, c4185i7.b, true).a(context, new Qj());
            T6 t6 = this.d;
            t6.getClass();
            HashMap map = new HashMap();
            map.put("preferences", G5.f11155a);
            map.put("binary_data", E5.f11116a);
            map.put("temp_cache", Sm.f11354a);
            Iterator<ModuleServicesDatabase> it = C4486ua.E.o().b().iterator();
            while (it.hasNext()) {
                for (TableDescription tableDescription : it.next().getTables()) {
                    map.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            Gm gm = t6.c;
            C4060d7 c4060d7 = t6.f11361a;
            C4010b7 c4010b7 = c4060d7.e;
            C4035c7 c4035c7 = c4060d7.f;
            C4536wa c4536wa = new C4536wa(false);
            c4536wa.a(114, new Rj());
            Iterator<ModuleServicesDatabase> it2 = C4486ua.E.o().b().iterator();
            while (it2.hasNext()) {
                Iterator<TableDescription> it3 = it2.next().getTables().iterator();
                while (it3.hasNext()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : it3.next().getDatabaseProviderUpgradeScript().entrySet()) {
                        c4536wa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            Im im = new Im("service database", map);
            gm.getClass();
            this.f = new C4110f7(context, strA, new Hm(c4010b7, c4035c7, c4536wa, im), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized Oa b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C4108f5 c4108f5) {
        IBinaryDataHelper c4280m3;
        String str = new Y4(c4108f5).f11430a;
        c4280m3 = (IBinaryDataHelper) this.c.get(str);
        if (c4280m3 == null) {
            c4280m3 = new C4280m3(new Sk(c(c4108f5)));
            this.c.put(str, c4280m3);
        }
        return c4280m3;
    }

    public final synchronized Oa a() {
        if (this.q == null) {
            this.q = new C4587yb(f());
        }
        return this.q;
    }

    public final synchronized Oa c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new C4562xb(new Sk(h()));
            }
            this.m = new C4587yb(this.l);
        }
        return this.m;
    }
}
