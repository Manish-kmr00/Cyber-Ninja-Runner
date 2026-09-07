package com.bytedance.adsdk.ugeno.ZZv.KZx;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends pA implements com.bytedance.adsdk.ugeno.ZZv.pA.ZZv {
    private com.bytedance.adsdk.ugeno.ZZv.pA.KZx Bzk;

    public Og(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.KZx.pA
    public boolean pA(Object... objArr) {
        com.bytedance.adsdk.ugeno.ZZv.pA.pA pAVarVgu = this.Og.Vgu();
        if (pAVarVgu == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.ZZv.pA.KZx kZxPA = pAVarVgu.pA(this.JG);
        this.Bzk = kZxPA;
        if (kZxPA != null) {
            kZxPA.pA(this);
            return false;
        }
        pAVarVgu.pA(this.JG, new com.bytedance.adsdk.ugeno.ZZv.pA.Og());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.pA.ZZv
    public void pA(String str) {
        Log.d("UGBaseEventMonitor", "receive: ");
        this.pA.pA(this.Og, this.JG, this.KZx.Og());
    }
}
