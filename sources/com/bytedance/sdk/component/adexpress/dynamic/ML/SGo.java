package com.bytedance.sdk.component.adexpress.dynamic.ML;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class SGo {
    public static float pA(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<Og.pA> pA(float f, List<Og.pA> list) {
        ArrayList<Og.pA> arrayList = new ArrayList();
        Iterator<Og.pA> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Og.pA) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (Og.pA pAVar : arrayList) {
            if (pAVar.Og) {
                i = (int) (i + pAVar.pA);
            } else {
                i2 = (int) (i2 + pAVar.pA);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (Og.pA pAVar2 : arrayList) {
                if (!pAVar2.Og && pAVar2.KZx != 0.0f && pAVar2.pA * f4 > pAVar2.KZx) {
                    pAVar2.pA = pAVar2.KZx;
                    pAVar2.Og = true;
                    z2 = true;
                }
                arrayList2.add(pAVar2);
            }
            if (z2) {
                return pA(f, arrayList2);
            }
        }
        int i3 = 0;
        for (Og.pA pAVar3 : arrayList) {
            if (pAVar3.Og) {
                pAVar3.pA = pA(pAVar3.pA * f3);
            } else {
                pAVar3.pA = pA(pAVar3.pA * f4);
            }
            i3 = (int) (i3 + pAVar3.pA);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                Og.pA pAVar4 = (Og.pA) arrayList.get(size);
                if ((f < f2 && pAVar4.Og) || (f > f2 && !pAVar4.Og)) {
                    pAVar4.pA += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
