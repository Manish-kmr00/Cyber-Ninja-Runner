package com.bytedance.adsdk.ugeno.Bzk.ML;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.Og.KZx;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends KZx<pA> {
    private static final int npn = Color.parseColor("#FFC642");
    private static final int rjD = Color.parseColor("#e3e3e4");
    private float KZx;
    private int Og;
    private float ZZv;
    private float guZ;
    private int pA;

    public Og(Context context) {
        super(context);
        this.pA = npn;
        this.Og = rjD;
        this.KZx = 4.0f;
        this.ZZv = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public pA ZZv() {
        pA pAVar = new pA(this.ML);
        pAVar.pA(this);
        return pAVar;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        if (roi()) {
            ((pA) this.omh).pA(this.KZx, this.pA, this.Og, this.ZZv, (int) this.guZ);
        } else {
            ((pA) this.omh).pA(this.KZx, this.pA, this.Og, this.ZZv, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.pA = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.Og = com.bytedance.adsdk.ugeno.SD.pA.pA(str2, rjD);
                break;
            case "gap":
                this.guZ = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case "size":
                this.ZZv = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 20.0f);
                break;
            case "score":
                this.KZx = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 4.0f);
                break;
        }
    }
}
