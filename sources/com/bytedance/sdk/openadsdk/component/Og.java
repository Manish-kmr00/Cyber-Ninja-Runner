package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.Bzk;
import com.bytedance.sdk.openadsdk.core.omh.omh;
import com.json.b9;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Og extends KZx {
    private com.bytedance.sdk.openadsdk.component.Bzk.SD DX;
    private boolean Sn;
    private final com.bytedance.sdk.openadsdk.component.JG.Og WV;
    private com.bytedance.sdk.openadsdk.component.Bzk.Og Wx;

    public Og(Activity activity, yFO yfo, FrameLayout frameLayout, pA pAVar, int i, boolean z, com.bytedance.sdk.openadsdk.component.omh.pA pAVar2, com.bytedance.sdk.openadsdk.component.JG.Og og) {
        super(activity, yfo, frameLayout, pAVar, i, z, pAVar2);
        this.WV = og;
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public void pA(ViewGroup viewGroup) {
        Pair<Float, Float> pairPA = com.bytedance.sdk.openadsdk.core.omh.pA.pA.pA(this.pA.getWindow(), this.SD);
        com.bytedance.sdk.openadsdk.component.Bzk.Og og = new com.bytedance.sdk.openadsdk.component.Bzk.Og(this.pA, this.Og, new AdSlot.Builder().setCodeId(String.valueOf(this.Og.Wf())).setExpressViewAcceptedSize(((Float) pairPA.first).floatValue(), ((Float) pairPA.second).floatValue()).build(), "open_ad", this.ML, this.WV, this.BSW);
        this.Wx = og;
        og.setTopListener(this.ML);
        this.Wx.setExpressVideoListenerProxy(this.ML);
        this.Wx.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.Og.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
            public void onAdClicked() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i) {
                Og.this.ML.ZZv();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f, float f2) {
                if (Og.this.Wx.Wx()) {
                    Og.this.Sn = true;
                    if (Og.this.DX != null && Og.this.ZZv == Og.this.DX.getParent()) {
                        Og.this.ZZv.removeView(Og.this.DX);
                    }
                    Og og2 = Og.this;
                    Og.super.pA((ViewGroup) og2.ZZv);
                    Og.super.pA();
                    Og.super.Og();
                    return;
                }
                if (Og.this.Og.zi()) {
                    Og.this.ML.KZx();
                    return;
                }
                if (Og.this.KZx) {
                    Og og3 = Og.this;
                    if (og3.pA(og3.Wx.getVideoFrameLayout())) {
                        Og.this.Wx.setVideoManager(Og.this.SD());
                        Og.this.ML.KZx();
                        return;
                    } else {
                        Og.this.ML.ZZv();
                        return;
                    }
                }
                Og.this.ML.KZx();
            }
        });
        this.Og.omh(1);
        this.ZZv.addView(this.Wx, new FrameLayout.LayoutParams(-1, -1));
        this.DX = new com.bytedance.sdk.openadsdk.component.Bzk.SD(this.pA);
        this.ZZv.addView(this.DX);
        this.Bzk = this.DX.getTopDislike();
        this.SGo = this.DX.getTopSkip();
        this.SGo.setVisibility(4);
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public void pA() {
        Bzk bzkPA = com.bytedance.sdk.openadsdk.component.pA.Og.pA(this.Og, this.pA, this.BSW, this.Wx);
        bzkPA.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.Og.2
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                Og.this.ML.ML();
            }
        });
        this.Wx.setClickListener(bzkPA);
        omh omhVarOg = com.bytedance.sdk.openadsdk.component.pA.Og.Og(this.Og, this.pA, this.BSW, this.Wx);
        this.Wx.setClickCreativeListener(omhVarOg);
        omhVarOg.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.Og.3
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                Og.this.ML.ML();
            }
        });
        super.JG();
        this.Wx.setBackupListener(new com.bytedance.sdk.component.adexpress.Og.KZx() { // from class: com.bytedance.sdk.openadsdk.component.Og.4
            @Override // com.bytedance.sdk.component.adexpress.Og.KZx
            public boolean pA(ViewGroup viewGroup, int i) {
                new Object[]{"open_ad", "isUseBackup() called with: view = [" + viewGroup + "], errCode = [" + i + b9.i.e};
                try {
                    ((com.bytedance.sdk.openadsdk.core.omh.yFO) viewGroup).WV();
                    new com.bytedance.sdk.openadsdk.component.Bzk.pA(Og.this.pA).pA((com.bytedance.sdk.openadsdk.core.omh.yFO) Og.this.Wx);
                    return true;
                } catch (Exception e) {
                    Log.e("AppOpenAdExpressManager", "", e);
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public void Og() {
        this.Wx.Bzk();
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public void pA(int i, int i2, boolean z) {
        super.pA(i, i2, z);
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public void KZx() {
        super.KZx();
        com.bytedance.sdk.openadsdk.component.Bzk.Og og = this.Wx;
        if (og != null) {
            og.BSW();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public int ZZv() {
        return this.Wx.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public JSONObject pA(JSONObject jSONObject) {
        return this.Wx.pA(jSONObject, this.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.component.KZx
    public void ML() {
        com.bytedance.sdk.openadsdk.component.Bzk.Og og = this.Wx;
        if (og != null) {
            og.omh();
        }
    }
}
