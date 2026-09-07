package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class fo2 implements on2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final on2 f8916a;

    @Override // com.yandex.mobile.ads.impl.on2
    public final JSONObject a(View view) {
        return zn2.a(0, 0, 0, 0);
    }

    public fo2(jo2 jo2Var) {
        this.f8916a = jo2Var;
    }

    @Override // com.yandex.mobile.ads.impl.on2
    public final void a(View view, JSONObject jSONObject, on2.a aVar, boolean z, boolean z2) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        nn2 nn2VarA = nn2.a();
        if (nn2VarA != null) {
            Collection<mn2> collectionC = nn2VarA.c();
            IdentityHashMap identityHashMap = new IdentityHashMap((collectionC.size() * 2) + 3);
            Iterator<mn2> it = collectionC.iterator();
            while (it.hasNext()) {
                View viewF = it.next().f();
                if (viewF != null && ro2.b(viewF) && (rootView = viewF.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float fA = ro2.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && ro2.a((View) arrayList.get(size - 1)) > fA) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((z62) aVar).a((View) it2.next(), this.f8916a, jSONObject, z2);
        }
    }
}
