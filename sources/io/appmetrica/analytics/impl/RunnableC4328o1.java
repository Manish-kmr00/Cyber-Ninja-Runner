package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.o1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC4328o1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11693a;

    public RunnableC4328o1(Context context) {
        this.f11693a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Fj fj = AbstractC4097ej.f11536a;
        Context context = this.f11693a;
        synchronized (fj) {
            if (fj.b == null) {
                fj.b = AbstractC4121fi.f11553a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = fj.f11144a.iterator();
                while (it.hasNext()) {
                    ((Xa) it.next()).a(fj.b);
                }
                fj.f11144a.clear();
            }
        }
    }
}
