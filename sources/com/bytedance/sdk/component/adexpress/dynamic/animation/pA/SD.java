package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class SD extends ZZv {
    public SD(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        this.KZx.setTag(2097610709, Integer.valueOf(this.Og.KZx()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        return arrayList;
    }
}
