package com.five_corp.ad.internal.cache;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes13.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.storage.d f1348a;
    public final com.five_corp.ad.internal.util.h b = new com.five_corp.ad.internal.util.h();

    public p(com.five_corp.ad.internal.storage.d dVar) {
        this.f1348a = dVar;
    }

    public final synchronized void a(HashSet hashSet) {
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(hashSet);
        com.five_corp.ad.internal.util.h hVar = this.b;
        hVar.getClass();
        ArrayList<q> arrayList = new ArrayList();
        hVar.a(arrayList);
        for (q qVar : arrayList) {
            if (qVar.b) {
                hashSet2.addAll(qVar.f1349a.keySet());
            }
        }
        this.f1348a.a(hashSet2);
    }
}
