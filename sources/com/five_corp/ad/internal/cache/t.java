package com.five_corp.ad.internal.cache;

import com.five_corp.ad.internal.C2974a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class t implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1351a;
    public final /* synthetic */ List b;
    public final /* synthetic */ w c;

    public t(w wVar, ArrayList arrayList, List list) {
        this.c = wVar;
        this.f1351a = arrayList;
        this.b = list;
    }

    @Override // com.five_corp.ad.internal.cache.r
    public final x a(x xVar) {
        ArrayList<com.five_corp.ad.internal.ad.a> arrayList = new ArrayList(xVar.f1355a.f1265a);
        this.f1351a.clear();
        for (com.five_corp.ad.internal.ad.a aVar : arrayList) {
            if (this.b.contains(aVar.d)) {
                this.f1351a.add(aVar);
            }
        }
        arrayList.removeAll(this.f1351a);
        C2974a c2974a = new C2974a(arrayList);
        com.five_corp.ad.internal.media_config.a aVar2 = xVar.b;
        com.five_corp.ad.internal.time.a aVar3 = this.c.d;
        return new x(c2974a, aVar2, System.currentTimeMillis());
    }
}
