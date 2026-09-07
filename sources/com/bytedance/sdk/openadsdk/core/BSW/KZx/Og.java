package com.bytedance.sdk.openadsdk.core.BSW.KZx;

import android.R;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.Og.KZx;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.Wx;
import com.bytedance.sdk.openadsdk.XT.pA.pA.SD;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.BSW.ML.ZZv;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Og implements Wx, pA.InterfaceC0226pA {
    protected static int pA = 8;
    private com.bytedance.sdk.openadsdk.core.BSW.ML.pA BSW;
    private JSONObject Bzk;
    private float DX;
    private String JG;
    private final Activity KZx;
    private final com.bytedance.sdk.openadsdk.core.BSW.JG.pA ML;
    private pA Og;
    private String SD;
    private final com.bytedance.sdk.openadsdk.core.BSW.ML.Og SGo;
    private float Sn;
    private String WV;
    private View Wx;
    private long XT;
    private final yFO ZZv;
    private float aBv;
    private float oX;
    private String omh;
    private boolean vZF = true;
    private long yFO;

    public Og(Activity activity, yFO yfo, com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar, String str, com.bytedance.sdk.openadsdk.core.BSW.ML.Og og) {
        this.KZx = activity;
        this.WV = str;
        this.ZZv = yfo;
        this.SGo = og;
        this.ML = pAVar;
    }

    public void pA() {
        if (this.ZZv == null) {
            this.SGo.pA(1, "material is null", "net");
            return;
        }
        if (this.ML == null) {
            this.SGo.pA(1, "material ugen template is null", "net");
            return;
        }
        this.Og = new pA(this.KZx);
        this.omh = this.ML.KZx();
        this.JG = this.ML.pA();
        this.SD = this.ML.Og();
        this.Bzk = this.ZZv.jO();
        this.SGo.pA(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, this.omh, this.JG, this.SD, "", new com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.BSW.KZx.Og.1
            @Override // com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA
            public void pA(JSONObject jSONObject, String str) {
                Og og = Og.this;
                og.pA(jSONObject, og.Bzk);
                Og.this.SGo.Og(str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA
            public void pA(int i, String str, String str2) {
                Og.this.SGo.pA(i, str, str2);
            }
        });
    }

    public void pA(View view) {
        this.Wx = view;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.BSW.ML.pA pAVar) {
        this.BSW = pAVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(JSONObject jSONObject, JSONObject jSONObject2) {
        this.Og.pA((pA.InterfaceC0226pA) this);
        this.Og.pA((Wx) this);
        this.SGo.pA();
        this.Og.pA(jSONObject, jSONObject2, new ZZv() { // from class: com.bytedance.sdk.openadsdk.core.BSW.KZx.Og.2
            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.ZZv
            public void pA(int i, String str) {
                if (Og.this.SGo != null) {
                    Og.this.SGo.pA(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.ZZv
            public void pA(KZx<View> kZx) {
                if (Og.this.SGo != null) {
                    Og.this.SGo.pA(kZx);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.KZx.pA.InterfaceC0226pA
    public void pA(SGo sGo) {
        String strOptString = sGo.KZx().optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "privacy":
                if (this.KZx != null && !TextUtils.isEmpty(aBv.ZZv().qmB())) {
                    TTWebsiteActivity.pA(this.KZx, this.ZZv, this.WV);
                    break;
                }
                break;
            case "close":
                com.bytedance.sdk.openadsdk.core.BSW.ML.pA pAVar = this.BSW;
                if (pAVar != null) {
                    pAVar.Og();
                    break;
                }
                break;
            case "creative":
                if (this.KZx != null && this.ZZv != null) {
                    Og();
                    ComponentCallbacks2 componentCallbacks2 = this.KZx;
                    if (componentCallbacks2 instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og) {
                        ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og) componentCallbacks2).ZZv();
                    }
                    pA(sGo, this.ZZv);
                    break;
                }
                break;
        }
    }

    private void Og() {
        int iJBA = this.ZZv.JBA();
        if (iJBA != 2 && iJBA != 3) {
            if (iJBA == 4) {
                SD.pA(this.KZx, this.ZZv, this.WV).ZZv();
                return;
            } else {
                if (iJBA != 5) {
                    return;
                }
                gbA.KZx(this.KZx, this.ZZv.vA());
                return;
            }
        }
        if (iJBA == 3) {
            String strDC = this.ZZv.dC();
            if (!TextUtils.isEmpty(strDC) && strDC.contains("play.google.com/store")) {
                if (com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv.pA(this.KZx, strDC, strDC.substring(strDC.indexOf("?id=") + 4), this.WV, this.ZZv)) {
                    return;
                }
            }
        }
        Activity activity = this.KZx;
        yFO yfo = this.ZZv;
        int iPA = gbA.pA(this.WV);
        String str = this.WV;
        rB.pA((Context) activity, yfo, iPA, (PAGNativeAd) null, (PangleAd) null, str, SD.pA(this.KZx, this.ZZv, str), true, 0);
    }

    private void pA(SGo sGo, yFO yfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", this.Sn);
            jSONObject.put("down_y", this.DX);
            jSONObject.put("down_time", this.XT);
            jSONObject.put("up_x", this.oX);
            jSONObject.put("up_y", this.aBv);
            jSONObject.put("up_time", this.yFO);
            View viewBzk = sGo.pA().Bzk();
            int i = 1;
            if (viewBzk != null) {
                JSONObject jSONObject2 = new JSONObject();
                int[] iArr = new int[2];
                float width = viewBzk.getWidth();
                float height = viewBzk.getHeight();
                viewBzk.getLocationOnScreen(iArr);
                float f = iArr[0];
                float f2 = iArr[1];
                jSONObject2.put("width", width);
                jSONObject2.put("height", height);
                jSONObject2.put("left", f);
                jSONObject2.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, f2);
                jSONObject.put("rectInfo", jSONObject2);
            }
            View view = this.Wx;
            if (view != null) {
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                jSONObject.put("button_x", iArr2[0]);
                jSONObject.put("button_y", iArr2[1]);
                jSONObject.put("button_width", this.Wx.getWidth());
                jSONObject.put("button_height", this.Wx.getHeight());
            }
            View viewFindViewById = this.KZx.findViewById(R.id.content);
            if (viewFindViewById != null) {
                int[] iArr3 = new int[2];
                viewFindViewById.getLocationOnScreen(iArr3);
                jSONObject.put("ad_x", iArr3[0]);
                jSONObject.put("ad_y", iArr3[1]);
                jSONObject.put("width", viewFindViewById.getWidth());
                jSONObject.put("height", viewFindViewById.getHeight());
            }
            jSONObject.put("click_area_type", sGo.pA().lT());
            jSONObject.put("brick_id", sGo.pA().IG());
            jSONObject.put("endcard_id", this.JG);
            jSONObject.put("click_scence", 2);
            if (!this.vZF) {
                i = 2;
            }
            jSONObject.put("user_behavior_type", i);
            com.bytedance.sdk.openadsdk.core.BSW.ML.pA pAVar = this.BSW;
            if (pAVar != null) {
                jSONObject.put("endcard_type", pAVar.pA());
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, this.WV, "click", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.Wx
    public void pA(KZx kZx, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.XT = System.currentTimeMillis();
            this.Sn = motionEvent.getRawX();
            this.DX = motionEvent.getRawY();
            this.vZF = true;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            if (Math.abs(motionEvent.getRawX() - this.Sn) >= pA || Math.abs(motionEvent.getRawY() - this.DX) >= pA) {
                this.vZF = false;
                return;
            }
            return;
        }
        this.oX = motionEvent.getRawX();
        this.aBv = motionEvent.getRawY();
        if (Math.abs(this.oX - this.Sn) >= pA || Math.abs(this.aBv - this.DX) >= pA) {
            this.vZF = false;
        }
        this.yFO = System.currentTimeMillis();
    }
}
