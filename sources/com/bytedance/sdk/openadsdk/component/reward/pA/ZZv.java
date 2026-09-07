package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.util.SparseArray;
import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ZZv {
    private final String KZx;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA ML;
    private final com.bytedance.sdk.openadsdk.core.model.yFO Og;
    private boolean ZZv;
    com.bytedance.sdk.openadsdk.XT.pA.pA.JG pA;

    public interface pA {
        void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, int i, int i2, int i3);

        void pA(String str, JSONObject jSONObject);
    }

    public ZZv(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.ML = pAVar;
        this.Og = pAVar.Og;
        this.KZx = pAVar.ML;
    }

    public void pA() {
        if (this.ZZv) {
            return;
        }
        this.ZZv = true;
        ZZv();
    }

    private void ZZv() {
        if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx() && this.Og.JBA() == 4) {
            this.pA = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.ML.Gx, this.Og, this.KZx);
        }
        if (this.pA == null) {
            this.pA = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.ML.SzT, this.Og, this.KZx);
        }
    }

    public void Og() {
        com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg = this.pA;
        if (jg != null) {
            jg.ZZv();
        }
    }

    public com.bytedance.sdk.openadsdk.XT.pA.pA.JG KZx() {
        return this.pA;
    }

    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, int i, int i2, int i3, pA pAVar) {
        if (this.pA != null) {
            int id = view.getId();
            if (id == com.bytedance.sdk.openadsdk.utils.Sn.ML) {
                pAVar.pA("click_play_star_level", null);
                return;
            }
            if (id == com.bytedance.sdk.openadsdk.utils.Sn.ZZv) {
                pAVar.pA("click_play_star_nums", null);
                return;
            } else if (id == com.bytedance.sdk.openadsdk.utils.Sn.KZx) {
                pAVar.pA("click_play_source", null);
                return;
            } else {
                if (id == com.bytedance.sdk.openadsdk.utils.Sn.Og) {
                    pAVar.pA("click_play_logo", null);
                    return;
                }
                return;
            }
        }
        pAVar.pA(view, f, f2, f3, f4, sparseArray, i, i2, i3);
    }
}
