package com.bytedance.sdk.openadsdk.core.BSW.Og;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public class Og extends com.bytedance.adsdk.ugeno.Bzk.JG.Og {
    private String ZZv;
    private String guZ;

    public Og(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.JG.Og, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        if (TextUtils.isEmpty(this.guZ) || TextUtils.equals(this.guZ, "null")) {
            this.guZ = "";
        }
        if (TextUtils.isEmpty(this.ZZv) || TextUtils.equals(this.ZZv, "null")) {
            this.ZZv = "";
        }
        this.pA = this.ZZv + this.guZ;
        ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setText(this.pA);
        ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.JG.Og
    public void SD(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "null")) {
            str = "";
        }
        if (TextUtils.isEmpty(this.guZ) || TextUtils.equals(this.guZ, "null")) {
            this.guZ = "";
        }
        if (TextUtils.isEmpty(this.ZZv) || TextUtils.equals(this.ZZv, "null")) {
            this.ZZv = "";
        }
        this.pA = this.ZZv + str + this.guZ;
        ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).setText(this.pA);
        try {
            float f = this.gbA ? this.IG : this.Mc;
            float f2 = this.Vgu ? this.lT : this.Mc;
            float fMeasureText = ((com.bytedance.adsdk.ugeno.Bzk.JG.pA) this.omh).getPaint().measureText(this.pA);
            if (fMeasureText >= 0.0f) {
                ML((int) (f + fMeasureText + f2));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.JG.Og, com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        str.hashCode();
        if (str.equals("before")) {
            this.ZZv = str2;
        } else if (str.equals("after")) {
            this.guZ = str2;
        }
    }
}
