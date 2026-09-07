package io.appmetrica.analytics.impl;

import android.app.Activity;

/* JADX INFO: loaded from: classes13.dex */
public final class Ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4351p f11062a;
    public final C4606z5 b;
    public final InterfaceC4301n c;
    public final InterfaceC4301n d;
    public final r e;
    public final C4251l f;
    public boolean g;

    public Ak(C4351p c4351p, C4251l c4251l) {
        this(c4351p, c4251l, new C4606z5(), new r());
    }

    public final void a(final Activity activity, EnumC4276m enumC4276m) {
        synchronized (this) {
            if (this.g) {
                C4606z5 c4606z5 = this.b;
                Sd sd = new Sd() { // from class: io.appmetrica.analytics.impl.Ak$$ExternalSyntheticLambda3
                    @Override // io.appmetrica.analytics.impl.Sd
                    public final void consume(Object obj) {
                        this.f$0.a(activity, (C4314nc) obj);
                    }
                };
                c4606z5.getClass();
                C4455t4.i().c.a().execute(new RunnableC4581y5(c4606z5, sd));
            }
        }
    }

    public final void b(final Activity activity, EnumC4276m enumC4276m) {
        synchronized (this) {
            if (this.g) {
                C4606z5 c4606z5 = this.b;
                Sd sd = new Sd() { // from class: io.appmetrica.analytics.impl.Ak$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.Sd
                    public final void consume(Object obj) {
                        this.f$0.b(activity, (C4314nc) obj);
                    }
                };
                c4606z5.getClass();
                C4455t4.i().c.a().execute(new RunnableC4581y5(c4606z5, sd));
            }
        }
    }

    public Ak(C4351p c4351p, C4251l c4251l, C4606z5 c4606z5, r rVar) {
        this.g = false;
        this.f11062a = c4351p;
        this.f = c4251l;
        this.b = c4606z5;
        this.e = rVar;
        this.c = new InterfaceC4301n() { // from class: io.appmetrica.analytics.impl.Ak$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC4301n
            public final void a(Activity activity, EnumC4276m enumC4276m) {
                this.f$0.a(activity, enumC4276m);
            }
        };
        this.d = new InterfaceC4301n() { // from class: io.appmetrica.analytics.impl.Ak$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.InterfaceC4301n
            public final void a(Activity activity, EnumC4276m enumC4276m) {
                this.f$0.b(activity, enumC4276m);
            }
        };
    }

    public final void b(Activity activity, C4314nc c4314nc) {
        if (this.e.a(activity, EnumC4376q.PAUSED)) {
            c4314nc.b(activity);
        }
    }

    public final synchronized EnumC4326o a() {
        if (!this.g) {
            this.f11062a.a(this.c, EnumC4276m.RESUMED);
            this.f11062a.a(this.d, EnumC4276m.PAUSED);
            this.g = true;
        }
        return this.f11062a.b;
    }

    public final void a(Activity activity, C4314nc c4314nc) {
        if (this.e.a(activity, EnumC4376q.RESUMED)) {
            c4314nc.a(activity);
        }
    }
}
