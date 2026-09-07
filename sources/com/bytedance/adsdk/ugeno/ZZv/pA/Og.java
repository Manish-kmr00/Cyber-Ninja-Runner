package com.bytedance.adsdk.ugeno.ZZv.pA;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Og implements KZx {
    private List<ZZv> pA = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.ZZv.pA.KZx
    public void pA(ZZv zZv) {
        this.pA.add(zZv);
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.pA.KZx
    public void pA(String str) {
        if (this.pA.isEmpty()) {
            return;
        }
        Iterator<ZZv> it = this.pA.iterator();
        while (it.hasNext()) {
            it.next().pA(str);
        }
    }
}
