package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pA extends ZZv {
    public pA(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        float fXT = this.Og.XT() / 100.0f;
        float fYFO = this.Og.yFO() / 100.0f;
        if ("reverse".equals(this.Og.oX()) && this.Og.Sn() <= 0.0d) {
            fYFO = fXT;
            fXT = fYFO;
        }
        this.KZx.setAlpha(fXT);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "alpha", fXT, fYFO).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        return arrayList;
    }
}
