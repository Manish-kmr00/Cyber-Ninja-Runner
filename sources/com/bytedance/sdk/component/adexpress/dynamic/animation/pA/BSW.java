package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class BSW extends ZZv {
    public BSW(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        float f;
        float fBSW = (float) this.Og.BSW();
        float fWV = (float) this.Og.WV();
        String strOX = this.Og.oX();
        float f2 = 1.0f;
        if ("reverse".equals(strOX) || "alternate-reverse".equals(strOX)) {
            f = 1.0f;
        } else {
            f = fWV;
            fWV = 1.0f;
            f2 = fBSW;
            fBSW = 1.0f;
        }
        this.KZx.setTag(2097610710, this.Og.Og());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, "scaleX", fBSW, f2).setDuration((int) (this.Og.SGo() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.KZx, "scaleY", fWV, f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        arrayList.add(pA(duration2));
        return arrayList;
    }
}
