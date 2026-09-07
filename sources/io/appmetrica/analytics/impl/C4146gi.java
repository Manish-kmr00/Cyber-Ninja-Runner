package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4146gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11571a = new HashMap();
    public final C4377q0 b;

    public C4146gi(C4377q0 c4377q0) {
        this.b = c4377q0;
    }

    public static C4146gi a() {
        return AbstractC4121fi.f11553a;
    }

    public final Yh a(Context context, String str) {
        Yh yh = (Yh) this.f11571a.get(str);
        if (yh == null) {
            synchronized (this.f11571a) {
                yh = (Yh) this.f11571a.get(str);
                if (yh == null) {
                    IHandlerExecutor iHandlerExecutorA = C4455t4.i().c.a();
                    this.b.getClass();
                    if (C4352p0.e == null) {
                        ((G9) iHandlerExecutorA).b.post(new RunnableC4096ei(this, context));
                    }
                    yh = new Yh(context.getApplicationContext(), str, new C4377q0());
                    this.f11571a.put(str, yh);
                    yh.c(str);
                }
            }
        }
        return yh;
    }
}
