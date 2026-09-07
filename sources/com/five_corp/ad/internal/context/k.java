package com.five_corp.ad.internal.context;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.util.h f1363a = new com.five_corp.ad.internal.util.h();

    public final synchronized j a(com.five_corp.ad.internal.ad.a aVar) {
        com.five_corp.ad.internal.util.h hVar = this.f1363a;
        hVar.getClass();
        ArrayList<j> arrayList = new ArrayList();
        hVar.a(arrayList);
        for (j jVar : arrayList) {
            if (jVar.a() && jVar.f1362a.b.equals(aVar.b)) {
                return null;
            }
        }
        j jVar2 = new j(aVar);
        this.f1363a.f1561a.add(new WeakReference(jVar2));
        return jVar2;
    }
}
