package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class Og extends com.bytedance.sdk.component.omh.omh {
    private final List<? extends com.bytedance.sdk.component.omh.omh> pA;

    public Og(String str, List<? extends com.bytedance.sdk.component.omh.omh> list) {
        super(str);
        this.pA = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<? extends com.bytedance.sdk.component.omh.omh> list;
        if (DX.KZx(aBv.pA()) != 0 && (list = this.pA) != null) {
            Iterator<? extends com.bytedance.sdk.component.omh.omh> it = list.iterator();
            while (it.hasNext()) {
                xy.pA(it.next(), 1);
                it.remove();
            }
        }
        try {
            com.bytedance.sdk.component.utils.SD.pA().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
