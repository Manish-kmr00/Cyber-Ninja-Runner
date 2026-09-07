package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class O4 implements La, InterfaceC4447sl, Na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11277a;
    public final C4108f5 b;
    public final C4075dm c;
    public final C4418rh d;
    public final V4 e;
    public final Jm f;
    public ArrayList g;
    public final C4133g5 h;
    public final C3994ag i;
    public final C4256l4 j;
    public final C4119fg k;
    public final Object l;

    public O4(Context context, C4223jl c4223jl, C4108f5 c4108f5, G4 g4, C3994ag c3994ag) {
        this(context, c4223jl, c4108f5, g4, new C4418rh(g4.b), c3994ag, new C4133g5(), new Q4(), new C4119fg());
    }

    public static void b(G4 g4) {
        C4486ua.E.b().b(!Boolean.FALSE.equals(g4.b.n));
    }

    @Override // io.appmetrica.analytics.impl.La
    public final void a(F4 f4) {
        C4418rh c4418rh = this.d;
        c4418rh.f11752a = c4418rh.f11752a.mergeFrom(f4);
    }

    @Override // io.appmetrica.analytics.impl.La
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final F4 d() {
        return this.d.f11752a;
    }

    public final C3994ag e() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.impl.La
    public final Context getContext() {
        return this.f11277a;
    }

    public O4(Context context, C4223jl c4223jl, C4108f5 c4108f5, G4 g4, C4418rh c4418rh, C3994ag c3994ag, C4133g5 c4133g5, Q4 q4, C4119fg c4119fg) {
        this.g = new ArrayList();
        this.l = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f11277a = applicationContext;
        this.b = c4108f5;
        this.d = c4418rh;
        this.h = c4133g5;
        this.e = Q4.a(this);
        b(g4);
        C4075dm c4075dmA = c4223jl.a(applicationContext, c4108f5, g4.f11154a);
        this.c = c4075dmA;
        this.j = AbstractC4281m4.a(c4075dmA, C4486ua.j().b());
        this.f = q4.a(this, c4075dmA);
        this.i = c3994ag;
        this.k = c4119fg;
        c4223jl.a(c4108f5, this);
    }

    public final synchronized void a(L4 l4) {
        this.h.f11562a.add(l4);
        I6.a(l4.c, this.j.a(AbstractC4199im.a(this.c.e().l)));
    }

    public final synchronized void b(L4 l4) {
        this.h.f11562a.remove(l4);
    }

    @Override // io.appmetrica.analytics.impl.La
    public final C4108f5 b() {
        return this.b;
    }

    public final void a(C3984a6 c3984a6, L4 l4) {
        V4 v4 = this.e;
        v4.getClass();
        v4.a(c3984a6, new U4(l4));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4447sl
    public final void a(EnumC4273ll enumC4273ll, Hl hl) {
        synchronized (this.l) {
            for (C4089eb c4089eb : this.g) {
                I6.a(c4089eb.f11530a, enumC4273ll, this.j.a(c4089eb.c));
            }
            this.g.clear();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4447sl
    public final void a(Hl hl) {
        synchronized (this.l) {
            for (L4 l4 : this.h.f11562a) {
                I6.a(l4.c, this.j.a(AbstractC4199im.a(hl.l)));
            }
            ArrayList arrayList = new ArrayList();
            for (C4089eb c4089eb : this.g) {
                if (El.a(hl, c4089eb.b, c4089eb.c, new C4039cb())) {
                    I6.a(c4089eb.f11530a, this.j.a(c4089eb.c));
                } else {
                    arrayList.add(c4089eb);
                }
            }
            this.g = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.f.b();
            }
        }
    }

    public final void a(C4089eb c4089eb) {
        ResultReceiver resultReceiver;
        HashMap map;
        List<String> list;
        HashMap map2 = new HashMap();
        if (c4089eb != null) {
            list = c4089eb.b;
            resultReceiver = c4089eb.f11530a;
            map = c4089eb.c;
        } else {
            resultReceiver = null;
            map = map2;
            list = null;
        }
        boolean zA = this.c.a(list, map);
        if (!zA) {
            I6.a(resultReceiver, this.j.a(map));
        }
        if (!this.c.g()) {
            if (zA) {
                I6.a(resultReceiver, this.j.a(map));
            }
        } else {
            synchronized (this.l) {
                if (zA && c4089eb != null) {
                    this.g.add(c4089eb);
                }
            }
            this.f.b();
        }
    }

    public final void a(ResultReceiver resultReceiver) {
        this.k.a(new N4(resultReceiver));
    }

    public final C4256l4 a() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.Na
    public final void a(G4 g4) {
        this.c.a(g4.f11154a);
        a(g4.b);
    }
}
