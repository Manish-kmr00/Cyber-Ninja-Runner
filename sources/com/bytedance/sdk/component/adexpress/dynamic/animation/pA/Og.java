package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gbA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class Og implements gbA {
    List<ZZv> pA = new ArrayList();

    public Og(View view, List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA> it = list.iterator();
        while (it.hasNext()) {
            ZZv zZvPA = KZx.pA().pA(view, it.next());
            if (zZvPA != null) {
                this.pA.add(zZvPA);
            }
        }
    }

    public void pA() {
        Iterator<ZZv> it = this.pA.iterator();
        while (it.hasNext()) {
            try {
                it.next().KZx();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gbA
    public void Og() {
        Iterator<ZZv> it = this.pA.iterator();
        while (it.hasNext()) {
            try {
                it.next().Og();
            } catch (Exception unused) {
            }
        }
    }
}
