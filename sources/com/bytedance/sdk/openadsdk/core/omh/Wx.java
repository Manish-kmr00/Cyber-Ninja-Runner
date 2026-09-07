package com.bytedance.sdk.openadsdk.core.omh;

import com.bytedance.sdk.openadsdk.utils.xy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Wx implements com.bytedance.adsdk.ugeno.core.DX, com.bytedance.sdk.component.adexpress.Og.Bzk {
    private final com.bytedance.sdk.openadsdk.core.model.yFO KZx;
    private long ML;
    private final String Og;
    private final String ZZv;
    private final com.bytedance.sdk.openadsdk.ZZv.ZZv.ML pA;

    public Wx(com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str2) {
        this.pA = ml;
        this.Og = str;
        this.ZZv = str2;
        this.KZx = yfo;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void ZZv() {
        this.pA.pA();
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void pA(boolean z) {
        this.pA.pA(z ? 1 : 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void ML() {
        this.pA.Og();
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void pA(int i, String str) {
        this.pA.pA(i, str);
        BSW.pA("Web", i, str, this.Og, this.ZZv, this.KZx);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void pA(int i) {
        this.ML = System.currentTimeMillis();
        if (i == 3) {
            this.pA.KZx("dynamic_render2_start");
        } else {
            this.pA.KZx("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void Og(int i) {
        if (i == 3) {
            this.pA.ZZv("dynamic_sub_analysis2_start");
        } else {
            this.pA.ZZv("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void KZx(int i) {
        if (i == 3) {
            this.pA.ZZv("dynamic_sub_analysis2_end");
        } else {
            this.pA.ZZv("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void ZZv(int i) {
        if (i == 3) {
            this.pA.ZZv("dynamic_sub_render2_start");
        } else {
            this.pA.ZZv("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void ML(int i) {
        if (i == 3) {
            this.pA.ZZv("dynamic_sub_render2_end");
        } else {
            this.pA.ZZv("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void JG(int i) {
        final String str;
        System.currentTimeMillis();
        if (i == 3) {
            this.pA.SD("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.pA.SD("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.pA.pA(true);
        xy.Og(new com.bytedance.sdk.component.omh.omh("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.omh.Wx.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(Wx.this.KZx, Wx.this.Og, str, (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void pA(int i, int i2, String str, boolean z) {
        if (!z) {
            this.pA.pA(true);
        }
        if (i == 3) {
            this.pA.Og(i2, "dynamic_render2_error");
        } else {
            this.pA.Og(i2, "dynamic_render_error");
        }
        BSW.pA("NDR", i2, str, this.Og, this.ZZv, this.KZx);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void JG() {
        this.pA.KZx();
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void SD() {
        this.pA.pA(true);
        this.pA.Wx();
        xy.Og(new com.bytedance.sdk.component.omh.omh("native_success") { // from class: com.bytedance.sdk.openadsdk.core.omh.Wx.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(Wx.this.KZx, Wx.this.Og, "dynamic_backup_render", (JSONObject) null);
            }
        }, 10);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void omh() {
        this.pA.Sn();
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void Bzk() {
        this.pA.DX();
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.Bzk
    public void SGo() {
        this.pA.Og();
    }

    public void BSW() {
        this.pA.BSW();
        this.pA.WV();
    }

    @Override // com.bytedance.adsdk.ugeno.core.DX
    public void pA() {
        this.pA.ML("ugen_render_start");
        this.pA.ML("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.core.DX
    public void Og() {
        this.pA.ML("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.adsdk.ugeno.core.DX
    public void KZx() {
        this.pA.ML("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.core.DX
    public void pA(com.bytedance.adsdk.ugeno.core.Sn sn) {
        if (sn.pA() == 0) {
            this.pA.ML("ugen_sub_render_end");
            this.pA.JG("ugen_render_success");
        } else {
            this.pA.KZx(sn.pA(), "ugen_render_error");
            BSW.pA("UGen", sn.pA(), sn.Og(), this.Og, this.ZZv, this.KZx);
        }
        this.pA.pA(true);
    }
}
