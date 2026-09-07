package com.bytedance.sdk.component.adexpress.dynamic.animation.pA;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Sn extends ZZv {
    public Sn(View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.pA pAVar) {
        super(view, pAVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.pA.ZZv
    List<ObjectAnimator> pA() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.KZx, Key.ROTATION, 0.0f, this.Og.ML(), 0.0f, this.Og.ML(), 0.0f).setDuration((int) (this.Og.SGo() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pA(duration));
        return arrayList;
    }
}
