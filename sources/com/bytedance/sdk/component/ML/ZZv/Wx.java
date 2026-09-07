package com.bytedance.sdk.component.ML.ZZv;

import com.bytedance.sdk.component.ML.oX;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class Wx<T> extends pA {
    private boolean KZx;
    private com.bytedance.sdk.component.ML.JG Og;
    private T pA;

    public Wx(T t, com.bytedance.sdk.component.ML.JG jg, boolean z) {
        this.pA = t;
        this.Og = jg;
        this.KZx = z;
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        String strBF = kZx.BF();
        Map<String, List<com.bytedance.sdk.component.ML.KZx.KZx>> mapSD = kZx.yFO().SD();
        List<com.bytedance.sdk.component.ML.KZx.KZx> list = mapSD.get(strBF);
        if (list == null) {
            Og(kZx);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.ML.KZx.KZx> it = list.iterator();
            while (it.hasNext()) {
                Og(it.next());
            }
            list.clear();
            mapSD.remove(strBF);
        }
    }

    private Map<String, String> Og() {
        com.bytedance.sdk.component.ML.JG jg = this.Og;
        if (jg != null) {
            return jg.ML();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "success";
    }

    private void Og(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        oX oXVarBzk = kZx.Bzk();
        if (oXVarBzk != null) {
            oXVarBzk.pA(new com.bytedance.sdk.component.ML.KZx.ZZv().pA(kZx, this.pA, Og(), this.KZx));
        }
    }
}
