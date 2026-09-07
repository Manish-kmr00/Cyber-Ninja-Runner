package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.Og.Sn;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class JG extends Og implements com.bytedance.sdk.openadsdk.WV.JG {
    private final vZF DX;
    private boolean oX;

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean JG() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean ML() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void SD() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    protected boolean roi() {
        return false;
    }

    public JG(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
        this.DX = (vZF) pAVar.Og;
    }

    public static void pA(yFO yfo, boolean z, String str) {
        HashMap map = new HashMap();
        map.put("is_backup", Boolean.valueOf(z));
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("choose_ad_start_show", yfo, str, map);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_id", yfo.Ij());
            jSONObject.put("is_backup", z);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA("choose_ad_start_show", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(com.bytedance.sdk.openadsdk.component.reward.view.SD sd) {
        if (ZZv.pA(this.DX)) {
            ZZv.pA(this.DX, sd, this.pA);
        } else {
            super.pA(sd);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.pA
    public boolean Og() {
        return this.oX;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void du() {
        IG jsObject;
        if (this.pA.SzT.isFinishing()) {
            return;
        }
        if (this.pA.du.omh() || this.oX) {
            super.du();
            if (this.pA.du.omh()) {
                eG();
                this.pA.gbA.Og();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.Og ogPA = this.pA.du.pA();
        if (ogPA == null || (jsObject = ogPA.getJsObject()) == null) {
            return;
        }
        jsObject.pA(this);
    }

    @Override // com.bytedance.sdk.openadsdk.WV.JG
    public void pA(int i, long j) {
        this.oX = true;
        int i2 = i - 1;
        this.DX.JBA(i2);
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.DX, this.pA.ML, i, j);
        com.bytedance.sdk.openadsdk.component.reward.pA.pA(this.DX.xoO(), i2, this.pA.ZZv);
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Og.JG.1
            @Override // java.lang.Runnable
            public void run() {
                JG.this.du();
                if (JG.this.pA.HSv) {
                    JG.this.eG();
                    JG.this.pA.gbA.Og();
                } else {
                    com.bytedance.sdk.openadsdk.component.reward.pA.ML.pA pAVarJG = JG.this.pA.gbA.JG();
                    if (pAVarJG != null) {
                        pAVarJG.oX();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.WV.JG
    public void pA(Sn sn) {
        this.pA.du.pA().Og(sn);
    }

    public void Og(boolean z) {
        if (this.oX) {
            return;
        }
        HashMap map = new HashMap();
        map.put("has_focus", Boolean.valueOf(z));
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA("choose_ad_focus_changed", this.DX, this.pA.ML, map);
    }
}
