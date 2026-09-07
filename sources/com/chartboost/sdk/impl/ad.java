package com.chartboost.sdk.impl;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ad implements cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f971a = new int[2];

    @Override // com.chartboost.sdk.impl.cc
    public JSONObject a(View view) {
        if (view == null) {
            return vc.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f971a);
        int[] iArr = this.f971a;
        return vc.a(iArr[0], iArr[1], width, height);
    }

    public final void b(ViewGroup viewGroup, JSONObject jSONObject, cc.a aVar, boolean z) {
        HashMap map = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(map.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) map.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.a((View) it2.next(), this, jSONObject, z);
            }
        }
    }

    @Override // com.chartboost.sdk.impl.cc
    public void a(View view, JSONObject jSONObject, cc.a aVar, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z) {
                b(viewGroup, jSONObject, aVar, z2);
            } else {
                a(viewGroup, jSONObject, aVar, z2);
            }
        }
    }

    public final void a(ViewGroup viewGroup, JSONObject jSONObject, cc.a aVar, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.a(viewGroup.getChildAt(i), this, jSONObject, z);
        }
    }
}
