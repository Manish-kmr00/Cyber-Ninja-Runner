package com.bytedance.sdk.openadsdk.core.Og;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SD extends KZx {
    private KZx KZx;
    private final com.bytedance.sdk.openadsdk.core.WV.pA Og;
    private final String pA;

    @Override // com.bytedance.sdk.openadsdk.core.Og.KZx, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Og/SD;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
        return safedk_SD_onTouch_cf7a6adf54d3cbec8fbb55307f9fe634(view, motionEvent);
    }

    public SD(String str, com.bytedance.sdk.openadsdk.core.WV.pA pAVar) {
        this(str, pAVar, null);
    }

    public SD(String str, com.bytedance.sdk.openadsdk.core.WV.pA pAVar, KZx kZx) {
        this.pA = str;
        this.Og = pAVar;
        this.KZx = kZx;
    }

    public void pA(KZx kZx) {
        this.KZx = kZx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.KZx
    protected void pA(View view, float f, float f2, float f3, float f4, SparseArray<KZx.pA> sparseArray, boolean z) {
        com.bytedance.sdk.openadsdk.core.WV.pA pAVar = this.Og;
        if (pAVar != null) {
            pAVar.ML(this.pA);
        }
        if (view != null) {
            if (view.getId() == Sn.KZx) {
                view.setTag(570425345, "VAST_TITLE");
            } else if (view.getId() == Sn.SD) {
                view.setTag(570425345, "VAST_DESCRIPTION");
            } else {
                view.setTag(570425345, this.pA);
            }
        }
        KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.TV = this.TV;
            this.KZx.du = this.du;
            this.KZx.eG = this.eG;
            this.KZx.roi = this.eG;
            this.KZx.Mc = this.eG;
            this.KZx.pA(view, f, f2, f3, f4, sparseArray, z);
        }
    }

    public boolean safedk_SD_onTouch_cf7a6adf54d3cbec8fbb55307f9fe634(View p0, MotionEvent p1) {
        return super.onTouch(p0, p1);
    }
}
