package com.bytedance.sdk.openadsdk.core.JG.pA;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.Og.BSW;
import com.bytedance.sdk.openadsdk.core.Og.KZx;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class pA extends KZx implements com.bytedance.sdk.component.adexpress.dynamic.JG.pA {
    private BSW KZx;
    protected WeakReference<View> Og;
    protected WeakReference<View> pA;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.JG.pA
    public void pA(BSW bsw) {
        this.KZx = bsw;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.JG.pA
    public void pA(View view) {
        this.pA = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.JG.pA
    public void Og(View view) {
        this.Og = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.KZx
    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        pA(view, ((Integer) view.getTag()).intValue(), f, f2, f3, f4, sparseArray);
    }

    private void pA(View view, int i, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray) {
        if (this.KZx != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.Og;
            if (weakReference != null) {
                int[] iArrPA = Vgu.pA(weakReference.get());
                if (iArrPA != null) {
                    iArr = iArrPA;
                }
                int[] iArrKZx = Vgu.KZx(this.Og.get());
                if (iArrKZx != null) {
                    iArr2 = iArrKZx;
                }
            }
            String strValueOf = "";
            try {
                if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.pA.Sd) != null) {
                    strValueOf = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.pA.Sd));
                }
            } catch (Exception unused) {
            }
            this.KZx.pA(view, i, new Sn.pA().ZZv(f).KZx(f2).Og(f3).pA(f4).Og(this.TV).pA(this.du).KZx(iArr[0]).ZZv(iArr[1]).ML(iArr2[0]).JG(iArr2[1]).pA(sparseArray).pA(this.lT).pA(strValueOf).pA());
        }
    }
}
