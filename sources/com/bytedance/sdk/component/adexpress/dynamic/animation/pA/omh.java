package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class omh extends ZZv {
    public omh(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ((ViewGroup) this.KZx.getParent()).setClipChildren(false);
        ((ViewGroup) this.KZx.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.KZx.getParent().getParent().getParent()).setClipChildren(false);
        this.KZx.setTag(2097610712, this.Og.omh());
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        return arrayList;
    }
}
