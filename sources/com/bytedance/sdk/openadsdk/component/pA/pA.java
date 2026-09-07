package com.bytedance.sdk.openadsdk.component.pA;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.BF.Og.ML;
import com.bytedance.sdk.openadsdk.core.Og.KZx;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class pA extends com.bytedance.sdk.openadsdk.core.Og.pA {
    private final com.bytedance.sdk.openadsdk.component.omh.pA pA;

    public pA(Context context, yFO yfo, String str, int i, com.bytedance.sdk.openadsdk.component.omh.pA pAVar) {
        super(context, yfo, str, i);
        this.pA = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        if (view.getTag() == "open_ad_click_button_tag") {
            pA("click_bar");
        } else {
            pA("click_material");
        }
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(this.pA.Og()));
        pA(map);
        super.pA(view, f, f2, f3, f4, sparseArray, z);
        ML.pA(this.JG, 9);
    }
}
