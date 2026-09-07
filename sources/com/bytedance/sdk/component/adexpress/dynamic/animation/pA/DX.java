package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class DX extends ZZv {
    public DX(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        float f;
        float fPA = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.Og.JG());
        float fPA2 = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.Og.SD());
        float f2 = 0.0f;
        if ("reverse".equals(this.Og.oX())) {
            f = fPA2;
            fPA2 = 0.0f;
            f2 = fPA;
            fPA = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.ZZv.Og.pA(this.KZx.getContext())) {
            fPA = -fPA;
            f2 = -f2;
        }
        this.KZx.setTranslationX(fPA);
        this.KZx.setTranslationY(fPA2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "translationX", fPA, f2).setDuration((int) (this.Og.SGo() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.KZx, "translationY", fPA2, f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        arrayList.add(pA(duration2));
        return arrayList;
    }
}
