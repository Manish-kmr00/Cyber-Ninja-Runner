package com.bytedance.sdk.component.ML.ZZv;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class SD extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        List<com.bytedance.sdk.component.ML.KZx.KZx> linkedList;
        String strBF = kZx.BF();
        Map<String, List<com.bytedance.sdk.component.ML.KZx.KZx>> mapSD = kZx.yFO().SD();
        synchronized (mapSD) {
            linkedList = mapSD.get(strBF);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(kZx);
            mapSD.put(strBF, linkedList);
            if (linkedList.size() <= 1) {
                kZx.pA(new ZZv());
            }
        }
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "check_duplicate";
    }
}
