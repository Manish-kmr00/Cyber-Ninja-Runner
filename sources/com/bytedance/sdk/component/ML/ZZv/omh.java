package com.bytedance.sdk.component.ML.ZZv;

import com.bytedance.sdk.component.ML.oX;
import com.json.b9;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class omh extends pA {
    private String KZx;
    private int Og;
    private Throwable pA;

    public omh(int i, String str, Throwable th) {
        this.Og = i;
        this.KZx = str;
        this.pA = th;
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        kZx.pA(new com.bytedance.sdk.component.ML.KZx.pA(this.Og, this.KZx, this.pA));
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

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return b9.h.t;
    }

    private void Og(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        oX oXVarBzk = kZx.Bzk();
        if (oXVarBzk != null) {
            oXVarBzk.pA(this.Og, this.KZx, this.pA);
        }
    }
}
