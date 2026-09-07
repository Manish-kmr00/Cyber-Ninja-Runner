package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class JG extends ZZv {
    public JG(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        float f = this.KZx.getLayoutParams().width;
        this.KZx.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "translationX", f, 0.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.KZx, "alpha", 0.0f, 1.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        arrayList.add(pA(duration2));
        return arrayList;
    }
}
