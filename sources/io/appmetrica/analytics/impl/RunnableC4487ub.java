package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Set;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ub, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class RunnableC4487ub implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f11798a;
    public final WeakReference b;

    public RunnableC4487ub(Handler handler, T2 t2) {
        this.f11798a = new WeakReference(handler);
        this.b = new WeakReference(t2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.f11798a.get();
        T2 t2 = (T2) this.b.get();
        if (handler == null || t2 == null) {
            return;
        }
        boolean zF = t2.b.f();
        if (!zF) {
            PublicLogger publicLogger = t2.c;
            Set set = C9.f11086a;
            EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
            C4082e4 c4082e4 = new C4082e4("", "", 3, 0, publicLogger);
            C4320ni c4320ni = t2.h;
            C4568xh c4568xh = t2.b;
            c4320ni.getClass();
            c4320ni.a(C4320ni.a(c4082e4, c4568xh), c4568xh, 1, null);
        }
        if (zF) {
            return;
        }
        C4462tb.a(handler, t2, this);
    }
}
