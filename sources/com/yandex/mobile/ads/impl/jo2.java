package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class jo2 implements on2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f9341a = new int[2];

    @Override // com.yandex.mobile.ads.impl.on2
    public final JSONObject a(View view) {
        if (view == null) {
            return zn2.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f9341a);
        int[] iArr = this.f9341a;
        return zn2.a(iArr[0], iArr[1], width, height);
    }

    @Override // com.yandex.mobile.ads.impl.on2
    public final void a(View view, JSONObject jSONObject, on2.a aVar, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            if (!z) {
                while (i < viewGroup.getChildCount()) {
                    ((z62) aVar).a(viewGroup.getChildAt(i), this, jSONObject, z2);
                    i++;
                }
                return;
            }
            HashMap map = new HashMap();
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
                i++;
            }
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) map.get((Float) it.next())).iterator();
                while (it2.hasNext()) {
                    ((z62) aVar).a((View) it2.next(), this, jSONObject, z2);
                }
            }
        }
    }
}
