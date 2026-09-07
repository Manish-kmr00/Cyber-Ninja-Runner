package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.IReporter;

/* JADX INFO: loaded from: classes2.dex */
public final class P5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4351p f11291a;
    public final IReporter b;
    public Context c;
    public final InterfaceC4301n d;

    public P5(C4351p c4351p) {
        this(c4351p, 0);
    }

    public static final void a(P5 p5, Activity activity, EnumC4276m enumC4276m) {
        int iOrdinal = enumC4276m.ordinal();
        if (iOrdinal == 1) {
            p5.b.resumeSession();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            p5.b.pauseSession();
        }
    }

    public P5(C4351p c4351p, IReporter iReporter) {
        this.f11291a = c4351p;
        this.b = iReporter;
        this.d = new InterfaceC4301n() { // from class: io.appmetrica.analytics.impl.P5$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC4301n
            public final void a(Activity activity, EnumC4276m enumC4276m) {
                P5.a(this.f$0, activity, enumC4276m);
            }
        };
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f11291a.a(applicationContext);
            this.f11291a.a(this.d, EnumC4276m.RESUMED, EnumC4276m.PAUSED);
            this.c = applicationContext;
        }
    }

    public /* synthetic */ P5(C4351p c4351p, int i) {
        this(c4351p, AbstractC4378q1.a());
    }
}
