package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class WV extends ZZv {
    public WV(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        int i;
        int i2;
        this.KZx.setTag(2097610711, Integer.valueOf(this.Og.ZZv()));
        if (this.KZx == null || !com.bytedance.sdk.component.adexpress.ZZv.Og.pA(this.KZx.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "shineValue", i, i2).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        return arrayList;
    }
}
