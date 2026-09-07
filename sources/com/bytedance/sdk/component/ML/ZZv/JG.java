package com.bytedance.sdk.component.ML.ZZv;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class JG extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        byte[] bArrPA;
        String strSGo = kZx.SGo();
        if (kZx.Sd() || kZx.vZF().JG()) {
            bArrPA = pA(kZx, strSGo);
        } else {
            bArrPA = Og(kZx, strSGo);
        }
        if (bArrPA == null) {
            kZx.pA(new BSW());
        } else {
            kZx.pA(new Og(bArrPA, null));
            kZx.yFO().Og(kZx.vZF()).pA(strSGo, bArrPA);
        }
    }

    private byte[] pA(com.bytedance.sdk.component.ML.KZx.KZx kZx, String str) {
        kZx.yFO().KZx(kZx.vZF());
        Collection<com.bytedance.sdk.component.ML.KZx> collectionKZx = kZx.yFO().KZx();
        if (collectionKZx == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.ML.KZx> it = collectionKZx.iterator();
        while (it.hasNext()) {
            byte[] bArrPA = it.next().pA(str);
            if (bArrPA != null) {
                return bArrPA;
            }
        }
        return null;
    }

    private byte[] Og(com.bytedance.sdk.component.ML.KZx.KZx kZx, String str) {
        com.bytedance.sdk.component.ML.KZx KZx = kZx.yFO().KZx(kZx.vZF());
        if (KZx == null) {
            return null;
        }
        return KZx.pA(str);
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "disk_cache";
    }
}
