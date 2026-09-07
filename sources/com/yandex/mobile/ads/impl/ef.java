package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8793a = new Object();
    private final ArrayList b = new ArrayList();

    public final void a(df appMetricaIdentifiers) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(appMetricaIdentifiers, "appMetricaIdentifiers");
        synchronized (this.f8793a) {
            arrayList = new ArrayList(this.b);
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((xi0) it.next()).a(appMetricaIdentifiers);
        }
    }

    public final void a() {
        synchronized (this.f8793a) {
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(xi0 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.f8793a) {
            this.b.add(observer);
        }
    }
}
