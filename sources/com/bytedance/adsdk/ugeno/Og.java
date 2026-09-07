package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.SD.omh;
import com.bytedance.adsdk.ugeno.core.Bzk;
import com.google.common.base.Ascii;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends com.bytedance.adsdk.ugeno.Og.pA<com.bytedance.adsdk.ugeno.JG.Og> {
    private boolean KZx;
    private String Og;
    private JSONArray PU;
    private int Xj;
    private boolean ZZv;
    private float bA;
    private boolean dGZ;
    private float guZ;
    private com.bytedance.adsdk.ugeno.Og.KZx ka;
    private float lgT;
    private float npn;
    private int qQU;
    private String rjD;
    private float uhO;
    private float vkV;

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(JSONObject jSONObject) {
    }

    public Og(Context context) {
        super(context);
        this.KZx = true;
        this.ZZv = true;
        this.guZ = 0.0f;
        this.npn = 2000.0f;
        this.rjD = Constants.NORMAL;
        this.dGZ = true;
        this.qQU = Color.parseColor("#666666");
        this.Xj = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public View ZZv() {
        this.omh = new com.bytedance.adsdk.ugeno.JG.Og(this.ML);
        ((com.bytedance.adsdk.ugeno.JG.Og) this.omh).pA((KZx) this);
        return this.omh;
    }

    public void pA(com.bytedance.adsdk.ugeno.JG.KZx kZx) {
        if (this.omh != 0) {
            ((com.bytedance.adsdk.ugeno.JG.Og) this.omh).setOnPageChangeListener(kZx);
        }
    }

    public void pA(int i) {
        if (this.omh != 0) {
            ((com.bytedance.adsdk.ugeno.JG.Og) this.omh).Bzk(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        JSONArray jSONArray = this.PU;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.JG.Og) this.omh).ZZv((int) this.uhO).ML((int) this.bA).JG((int) this.lgT).Og(this.dGZ).Og(this.Xj).KZx(this.qQU).pA(this.rjD).KZx(this.KZx).pA(this.vkV).pA(this.ZZv).pA((int) this.npn).Og(this.dGZ);
        for (int i = 0; i < this.PU.length(); i++) {
            Bzk bzk = new Bzk(this.ML);
            bzk.pA(this.jO);
            com.bytedance.adsdk.ugeno.Og.KZx<View> kZxOg = bzk.Og(this.ka.eG(), null);
            bzk.Og(this.PU.optJSONObject(i));
            ((com.bytedance.adsdk.ugeno.JG.Og) this.omh).pA(kZxOg);
        }
        if (this.ZZv) {
            ((com.bytedance.adsdk.ugeno.JG.Og) this.omh).pA();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA
    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.ka = kZx;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    b = 0;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 1;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 2;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 3;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 4;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 5;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = 6;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 7;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 8;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 9;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = 10;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = Ascii.VT;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = Ascii.FF;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = Ascii.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                this.guZ = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 1:
                this.qQU = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                break;
            case 2:
                this.lgT = omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 3:
                this.rjD = str2;
                break;
            case 4:
                this.Og = str2;
                break;
            case 5:
                this.dGZ = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, true);
                break;
            case 6:
                this.bA = omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 7:
                this.KZx = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, true);
                break;
            case 8:
                this.npn = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 500.0f);
                break;
            case 9:
                this.vkV = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 1.0f);
                break;
            case 10:
                this.uhO = omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 11:
                this.Xj = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                break;
            case 12:
                this.ZZv = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, true);
                break;
            case 13:
                this.PU = com.bytedance.adsdk.ugeno.SD.Og.pA(str2, (JSONArray) null);
                break;
        }
    }
}
