package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Wx extends ZZv {
    public Wx(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        if ((this.KZx instanceof ImageView) && (this.KZx.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.BSW)) {
            this.KZx = (View) this.KZx.getParent();
            ((ViewGroup) this.KZx).setClipChildren(true);
            ((ViewGroup) this.KZx.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        return arrayList;
    }
}
