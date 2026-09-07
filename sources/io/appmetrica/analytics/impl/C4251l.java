package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4251l implements InterfaceC4301n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f11640a = new HashSet();

    public C4251l(C4351p c4351p) {
        c4351p.a(this, new EnumC4276m[0]);
    }

    public final synchronized void a(InterfaceC4226k interfaceC4226k) {
        this.f11640a.add(interfaceC4226k);
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f11640a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((Ri) ((InterfaceC4226k) it.next())).a(activity);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4301n
    public final void a(Activity activity, EnumC4276m enumC4276m) {
        C4455t4.i().c.a().execute(new RunnableC4201j(this, activity));
    }
}
