package com.chartboost.sdk.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class uc implements cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc f1158a;

    public uc(cc ccVar) {
        this.f1158a = ccVar;
    }

    public ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        tc tcVarC = tc.c();
        if (tcVarC != null) {
            Collection<zb> collectionA = tcVarC.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((collectionA.size() * 2) + 3);
            Iterator<zb> it = collectionA.iterator();
            while (it.hasNext()) {
                View viewG = it.next().g();
                if (viewG != null && od.g(viewG) && (rootView = viewG.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float fD = od.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && od.d(arrayList.get(size - 1)) > fD) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    @Override // com.chartboost.sdk.impl.cc
    public JSONObject a(View view) {
        JSONObject jSONObjectA = vc.a(0, 0, 0, 0);
        vc.a(jSONObjectA, ed.a());
        return jSONObjectA;
    }

    @Override // com.chartboost.sdk.impl.cc
    public void a(View view, JSONObject jSONObject, cc.a aVar, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            aVar.a(it.next(), this.f1158a, jSONObject, z2);
        }
    }
}
