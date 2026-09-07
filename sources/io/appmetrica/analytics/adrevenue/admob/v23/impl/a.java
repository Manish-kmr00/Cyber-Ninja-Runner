package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ModuleAdRevenueProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f10926a;

    public a(d dVar, ClientContext clientContext) {
        ArrayList arrayList = new ArrayList();
        this.f10926a = arrayList;
        arrayList.add(new f(dVar, clientContext));
        arrayList.add(new h(dVar, clientContext));
        arrayList.add(new i(dVar, clientContext));
        arrayList.add(new j(dVar, clientContext));
        arrayList.add(new k(dVar, clientContext));
        arrayList.add(new e(dVar, clientContext));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return "AdMob";
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        Iterator it = this.f10926a.iterator();
        while (it.hasNext()) {
            if (((ModuleAdRevenueProcessor) it.next()).process(objArr)) {
                return true;
            }
        }
        return false;
    }
}
