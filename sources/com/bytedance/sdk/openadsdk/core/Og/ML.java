package com.bytedance.sdk.openadsdk.core.Og;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ML extends pA {
    protected abstract void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, int i, int i2, int i3, boolean z);

    public ML(Context context, yFO yfo, String str, int i) {
        super(context, yfo, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        if (pA(view, z)) {
            pA(view, f, f2, f3, f4, sparseArray, this.Mc, this.eG, this.roi, z);
        }
        super.pA(view, f, f2, f3, f4, sparseArray, z);
    }
}
