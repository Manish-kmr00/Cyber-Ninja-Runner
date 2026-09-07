package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import io.appmetrica.analytics.locationapi.internal.LocationClient;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ua, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4486ua {
    public static volatile C4486ua E;
    public volatile T9 C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11797a;
    public volatile C3994ag b;
    public volatile L6 c;
    public volatile C4031c3 e;
    public volatile C4047cj f;
    public volatile Q g;
    public volatile C4080e2 h;
    public volatile PlatformIdentifiers i;
    public volatile Cif j;
    public volatile T3 k;
    public volatile Oe l;
    public volatile Xn m;
    public volatile Ui n;
    public volatile Kb o;
    public C4049cl p;
    public volatile C4023bk r;
    public volatile Pb w;
    public volatile Lm x;
    public volatile Vk y;
    public volatile C4489ud z;
    public final C4461ta q = new C4461ta();
    public final Xc s = new Xc();
    public final Zc t = new Zc();
    public final Jl u = new Jl();
    public final Pj v = new Pj();
    public final Id A = new Id();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final Wj D = new Wj();
    public final Uj d = new Uj();

    public C4486ua(Context context) {
        this.f11797a = context;
    }

    public static void a(Context context) {
        if (E == null) {
            synchronized (C4486ua.class) {
                if (E == null) {
                    E = new C4486ua(context.getApplicationContext());
                }
            }
        }
    }

    public static C4486ua j() {
        return E;
    }

    public final Lm A() {
        Lm lm = this.x;
        if (lm == null) {
            synchronized (this) {
                lm = this.x;
                if (lm == null) {
                    lm = new Lm(this.f11797a);
                    this.x = lm;
                }
            }
        }
        return lm;
    }

    public final synchronized Xn B() {
        if (this.m == null) {
            this.m = new Xn(this.f11797a);
        }
        return this.m;
    }

    public final void C() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    AbstractC4473tm abstractC4473tmA = C4448sm.a(Se.class);
                    Context context = this.f11797a;
                    ProtobufStateStorage<Object> protobufStateStorageA = abstractC4473tmA.a(context, abstractC4473tmA.c(context));
                    Se se = (Se) protobufStateStorageA.read();
                    this.j = new Cif(this.f11797a, protobufStateStorageA, new Ze(), new Qe(se), new C4168hf(), new Ye(this.f11797a), new C4068df(j().x()), new Te(), se, "[PreloadInfoStorage]");
                }
            }
        }
    }

    public final Q b() {
        Q q = this.g;
        if (q == null) {
            synchronized (this) {
                q = this.g;
                if (q == null) {
                    q = new Q(this.f11797a, this.d.a(), this.u.b());
                    this.u.a(q);
                    this.g = q;
                }
            }
        }
        return q;
    }

    public final C4080e2 c() {
        C4080e2 c4080e2 = this.h;
        if (c4080e2 == null) {
            synchronized (this) {
                c4080e2 = this.h;
                if (c4080e2 == null) {
                    c4080e2 = new C4080e2(this.f11797a, AbstractC4105f2.a());
                    this.h = c4080e2;
                }
            }
        }
        return c4080e2;
    }

    public final C4229k2 d() {
        return k().b;
    }

    public final T3 e() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    AbstractC4473tm abstractC4473tmA = C4448sm.a(M3.class);
                    Context context = this.f11797a;
                    ProtobufStateStorage<Object> protobufStateStorageA = abstractC4473tmA.a(context, abstractC4473tmA.c(context));
                    this.k = new T3(this.f11797a, protobufStateStorageA, new U3(), new H3(), new X3(), new Ji(this.f11797a), new V3(x()), new I3(), (M3) protobufStateStorageA.read(), "[ClidsInfoStorage]");
                }
            }
        }
        return this.k;
    }

    public final Context f() {
        return this.f11797a;
    }

    public final L6 g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new L6(new K6(x()));
                }
            }
        }
        return this.c;
    }

    public final T9 h() {
        T9 t9 = this.C;
        if (t9 == null) {
            synchronized (this) {
                t9 = this.C;
                if (t9 == null) {
                    t9 = new T9(this.f11797a);
                    this.C = t9;
                }
            }
        }
        return t9;
    }

    public final PermissionExtractor i() {
        Vk vk = this.y;
        if (vk != null) {
            return vk;
        }
        synchronized (this) {
            Vk vk2 = this.y;
            if (vk2 != null) {
                return vk2;
            }
            Vk vk3 = new Vk(o().c.getAskForPermissionStrategy());
            this.y = vk3;
            return vk3;
        }
    }

    public final Kb k() {
        Kb kb = this.o;
        if (kb == null) {
            synchronized (this) {
                kb = this.o;
                if (kb == null) {
                    kb = new Kb(new Z2(this.f11797a, this.d.a()), new C4229k2());
                    this.o = kb;
                }
            }
        }
        return kb;
    }

    public final Pb l() {
        Pb rb = this.w;
        if (rb == null) {
            synchronized (this) {
                rb = this.w;
                if (rb == null) {
                    Context context = this.f11797a;
                    ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                    LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                    rb = locationClient == null ? new Rb() : new Qb(context, new Xb(), locationClient);
                    this.w = rb;
                }
            }
        }
        return rb;
    }

    public final Pb m() {
        return l();
    }

    public final Zc n() {
        return this.t;
    }

    public final C4023bk o() {
        C4023bk c4023bk = this.r;
        if (c4023bk == null) {
            synchronized (this) {
                c4023bk = this.r;
                if (c4023bk == null) {
                    c4023bk = new C4023bk();
                    this.r = c4023bk;
                }
            }
        }
        return c4023bk;
    }

    public final C4489ud p() {
        C4489ud c4489ud = this.z;
        if (c4489ud == null) {
            synchronized (this) {
                c4489ud = this.z;
                if (c4489ud == null) {
                    c4489ud = new C4489ud(this.f11797a, new Kn());
                    this.z = c4489ud;
                }
            }
        }
        return c4489ud;
    }

    public final Id q() {
        return this.A;
    }

    public final PlatformIdentifiers r() {
        PlatformIdentifiers platformIdentifiers = this.i;
        if (platformIdentifiers == null) {
            synchronized (this) {
                platformIdentifiers = this.i;
                if (platformIdentifiers == null) {
                    platformIdentifiers = new PlatformIdentifiers(b(), c());
                    this.i = platformIdentifiers;
                }
            }
        }
        return platformIdentifiers;
    }

    public final Cif s() {
        C();
        return this.j;
    }

    public final C3994ag t() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new C3994ag(this.f11797a, E.B().c);
                }
            }
        }
        return this.b;
    }

    public final Ui u() {
        Ui ui = this.n;
        if (ui == null) {
            synchronized (this) {
                ui = this.n;
                if (ui == null) {
                    ui = new Ui(this.f11797a);
                    this.n = ui;
                }
            }
        }
        return ui;
    }

    public final synchronized C4047cj v() {
        return this.f;
    }

    public final Uj w() {
        return this.d;
    }

    public final Oe x() {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = new Oe(C4135g7.a(this.f11797a).c());
                }
            }
        }
        return this.l;
    }

    public final synchronized V2 y() {
        if (this.p == null) {
            C4049cl c4049cl = new C4049cl(this.f11797a);
            this.p = c4049cl;
            this.u.a(c4049cl);
        }
        return this.p;
    }

    public final Jl z() {
        return this.u;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}
