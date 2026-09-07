package com.bytedance.adsdk.ugeno.ZZv.Og;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ZZv extends pA {
    public ZZv(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
        super(kZx, str, pAVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.Og.pA
    public void pA() {
        if (this.JG == null || this.JG.size() <= 0) {
            return;
        }
        String str = this.JG.get("id");
        if (TextUtils.isEmpty(str)) {
            pA(this.KZx);
            return;
        }
        com.bytedance.adsdk.ugeno.Og.KZx kZxOg = this.KZx.Og(this.KZx);
        if (kZxOg == null) {
            return;
        }
        pA(kZxOg.KZx(str));
    }

    private void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        if (kZx == null) {
            return;
        }
        for (String str : this.JG.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                kZx.pA(str, this.JG.get(str));
            }
        }
        kZx.du();
        kZx.Og();
    }
}
