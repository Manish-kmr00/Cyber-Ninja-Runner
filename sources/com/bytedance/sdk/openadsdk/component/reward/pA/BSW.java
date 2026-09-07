package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.R;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.pgl.ssdk.ces.out.DungeonFlag;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class BSW {
    private final com.bytedance.sdk.openadsdk.core.Og.ML KZx;
    private final com.bytedance.sdk.openadsdk.core.Og.Og Og;
    private final pA pA;

    @DungeonFlag
    public BSW(pA pAVar) {
        this.pA = pAVar;
        this.KZx = pA(pAVar, pAVar.Og);
        this.Og = new com.bytedance.sdk.openadsdk.core.Og.Og(pAVar.SzT, pAVar.Og, pAVar.ML, pAVar.ZZv ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.BSW.1
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                try {
                    BSW.this.pA(view, f, f2, f3, f4, sparseArray, this.Mc, this.eG, this.roi);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.RFReportManager", "onClickReport error :" + e.getMessage());
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(BSW.this.pA.Og, 9);
                BSW.this.pA.BF.rB();
            }
        };
    }

    @DungeonFlag
    public void pA() {
        if (this.pA.Wx.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA.Og;
        pA(jSONObject);
        if (this.pA.Wx.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, this.pA.ML, jSONObject);
            this.pA.FQ.JG();
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA pAVar = new com.bytedance.sdk.openadsdk.BF.Og.ML.pA(-1);
            if (this.pA.Itl && this.pA.RS != null) {
                pAVar.Og = this.pA.RS.Bzk;
            }
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.pA.SzT.findViewById(R.id.content), yfo, pAVar);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(yfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA.Og;
        if ((yfo instanceof vZF) && ((vZF) yfo).cmu()) {
            try {
                jSONObject.put("choose_one_ad_real_show", true);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFReportManager", "reportShow json error", e);
            }
        }
        if (!this.pA.Itl || this.pA.RS == null) {
            return;
        }
        try {
            jSONObject.put("ad_show_order", this.pA.RS.Bzk + 1);
        } catch (JSONException unused) {
        }
    }

    @DungeonFlag
    public void Og() {
        boolean z;
        if (this.pA.Wx.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.pA.Og.pA() || this.pA.du == null) {
                z = false;
            } else {
                jSONObject.put("dynamic_show_type", this.pA.du.Bzk());
                this.pA.du.pA(jSONObject);
                z = true;
            }
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA.Og;
            pA(jSONObject);
            View viewFindViewById = this.pA.SzT.findViewById(R.id.content);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", viewFindViewById.getWidth());
                jSONObject2.put("height", viewFindViewById.getHeight());
                jSONObject2.put("alpha", viewFindViewById.getAlpha());
            } catch (Throwable unused) {
            }
            jSONObject.put("root_view", jSONObject2.toString());
            if (this.pA.Wx.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, this.pA.ML, jSONObject);
                this.pA.FQ.JG();
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA pAVar = new com.bytedance.sdk.openadsdk.BF.Og.ML.pA(z ? this.pA.du.Bzk() : -1);
                if (this.pA.Itl && this.pA.RS != null) {
                    pAVar.Og = this.pA.RS.Bzk;
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.pA.SzT.findViewById(R.id.content), yfo, pAVar);
                com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(yfo);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e);
        }
    }

    @DungeonFlag
    public void pA(final Map<String, Object> map) {
        if (this.pA.Wx.get()) {
            return;
        }
        this.pA.Wx.set(true);
        final View viewFindViewById = this.pA.SzT.findViewById(R.id.content);
        if (viewFindViewById == null) {
            viewFindViewById = this.pA.SzT.getWindow().getDecorView();
        }
        viewFindViewById.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.BSW.2
            @Override // java.lang.Runnable
            public void run() {
                Map map2;
                JSONObject jSONObject;
                boolean z = false;
                if (BSW.this.pA.Sn.compareAndSet(false, true)) {
                    com.bytedance.sdk.openadsdk.core.model.yFO yfo = BSW.this.pA.Og;
                    JSONObject jSONObject2 = null;
                    try {
                        if (map != null) {
                            jSONObject = new JSONObject(map);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("width", viewFindViewById.getWidth());
                        jSONObject3.put("height", viewFindViewById.getHeight());
                        jSONObject3.put("alpha", viewFindViewById.getAlpha());
                        jSONObject2.put("root_view", jSONObject3.toString());
                        BSW.this.pA(jSONObject2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.RFReportManager", "run: ", th);
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, BSW.this.pA.ML, jSONObject2);
                    BSW.this.pA.FQ.JG();
                    if (BSW.this.pA.du != null && (map2 = map) != null && map2.containsKey("dynamic_show_type")) {
                        z = true;
                    }
                    com.bytedance.sdk.openadsdk.BF.Og.ML.pA pAVar = new com.bytedance.sdk.openadsdk.BF.Og.ML.pA(z ? BSW.this.pA.du.Bzk() : -1);
                    if (BSW.this.pA.Itl && BSW.this.pA.RS != null) {
                        pAVar.Og = BSW.this.pA.RS.Bzk;
                    }
                    com.bytedance.sdk.openadsdk.BF.Og.ML.pA(BSW.this.pA.SzT.findViewById(R.id.content), yfo, pAVar);
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(yfo);
                }
            }
        });
    }

    public void pA(boolean z) {
        if (this.pA.Og == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Sn.pA.ZZv zZvML = com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA(z ? 7 : 8).KZx(String.valueOf(this.pA.Og.Wf())).ML(this.pA.Og.Ij());
        zZvML.Og(this.pA.rB.BF()).JG(this.pA.rB.WQf());
        zZvML.SD(this.pA.Og.tM()).ZZv(this.pA.Og.nCO());
        com.bytedance.sdk.openadsdk.Sn.KZx.pA().Og(zZvML);
    }

    public com.bytedance.sdk.openadsdk.core.Og.ML KZx() {
        this.KZx.pA(this.pA.SzT.findViewById(R.id.content));
        this.KZx.Og(this.pA.CIG.findViewById(520093713));
        if (this.pA.WQf.KZx() != null) {
            this.KZx.pA(this.pA.WQf.KZx());
        }
        this.pA.TV.pA(this.KZx);
        this.KZx.pA(new com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.BSW.3
            @Override // com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA
            public long getVideoProgress() {
                return BSW.this.pA.BF.SD();
            }
        });
        com.bytedance.sdk.openadsdk.component.reward.view.SGo sGo = this.pA.Vgu;
        com.bytedance.sdk.openadsdk.core.Og.ML ml = this.KZx;
        sGo.pA(ml, ml, this.Og);
        this.pA.gbA.pA(this.KZx);
        return this.KZx;
    }

    public com.bytedance.sdk.openadsdk.core.Og.Og ZZv() {
        return this.Og;
    }

    public com.bytedance.sdk.openadsdk.core.Og.ML ML() {
        return this.KZx;
    }

    @DungeonFlag
    public void Og(boolean z) {
        pA pAVar = this.pA;
        if (pAVar == null) {
            return;
        }
        if (!z && pAVar.Wx.get() && this.pA.SXO > 0) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(SystemClock.elapsedRealtime() - this.pA.SXO), this.pA.Og, this.pA.ML, this.pA.BF.pA());
            this.pA.SXO = 0L;
        } else {
            this.pA.SXO = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.pA.Og, z ? 4 : 8);
        com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(this.pA.Og, z ? 4 : 8);
    }

    public void JG() {
        JSONObject jSONObject = new JSONObject();
        if (WQf.XT(this.pA.Og)) {
            this.pA.TV.pA(jSONObject);
        }
        int i = 1;
        try {
            if (this.pA.SGo.get()) {
                if (!this.pA.rB.KZx()) {
                    if (this.pA.xy.ZZv()) {
                        i = 3;
                    } else {
                        i = this.pA.rB.ZZv() ? 2 : 0;
                    }
                }
                jSONObject.put("endcard_content", i);
            } else {
                jSONObject.put("endCardNotShow", 1);
            }
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.pA.Og, this.pA.ML, "click_close", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, int i, int i2, int i3) {
        if (view == null) {
            return;
        }
        if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.ML) {
            pA("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.ZZv || view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.SD) {
            pA("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.KZx) {
            pA("click_play_source", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.Og) {
            pA("click_play_logo", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.WV || view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.slz || view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.aBv) {
            pA("click_start_play_bar", Bzk());
        } else if (view.getId() == 520093705) {
            pA("click_start_play", Bzk());
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.BSW) {
            pA("click_video", Bzk());
        } else if (view.getId() == 520093707 || view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.omh) {
            pA("fallback_endcard_click", Bzk());
        }
        Og(view, f, f2, f3, f4, sparseArray, i, i2, i3);
    }

    private void Og(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, int i, int i2, int i3) {
        if (!omh() || this.pA.Og == null || view == null) {
            return;
        }
        int id = view.getId();
        if (id == com.bytedance.sdk.openadsdk.utils.Sn.ML || id == com.bytedance.sdk.openadsdk.utils.Sn.ZZv || id == com.bytedance.sdk.openadsdk.utils.Sn.KZx || id == com.bytedance.sdk.openadsdk.utils.Sn.Og || id == com.bytedance.sdk.openadsdk.utils.Sn.WV || id == com.bytedance.sdk.openadsdk.utils.Sn.slz || id == com.bytedance.sdk.openadsdk.utils.Sn.aBv || id == 520093705 || id == com.bytedance.sdk.openadsdk.utils.Sn.BSW || id == 520093707 || id == com.bytedance.sdk.openadsdk.utils.Sn.SD) {
            int iSD = Vgu.SD(com.bytedance.sdk.openadsdk.core.aBv.pA());
            com.bytedance.sdk.openadsdk.core.model.SGo sGoPA = new com.bytedance.sdk.openadsdk.core.model.SGo.pA().JG(f).ML(f2).ZZv(f3).KZx(f4).Og(System.currentTimeMillis()).pA(0L).Og(Vgu.pA(this.pA.Vgu.BSW())).pA(Vgu.pA((View) null)).KZx(Vgu.KZx(this.pA.Vgu.BSW())).ZZv(Vgu.KZx((View) null)).ZZv(i2).ML(i3).JG(i).pA(sparseArray).Og(com.bytedance.sdk.openadsdk.core.Bzk.Og().pA() ? 1 : 2).KZx(iSD).pA(Vgu.ML(com.bytedance.sdk.openadsdk.core.aBv.pA())).Og(Vgu.JG(com.bytedance.sdk.openadsdk.core.aBv.pA())).pA();
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(this.pA.BF.SD()));
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click_other", this.pA.Og, sGoPA, this.pA.ML, true, (Map<String, Object>) map, -1);
        }
    }

    private boolean omh() {
        return this.pA.Og != null && this.pA.Og.Gx() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA.Og;
        String str2 = this.pA.ML;
        if (!this.pA.ZZv) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str2, str, jSONObject);
    }

    private JSONObject Bzk() {
        try {
            long jOX = this.pA.BF.oX();
            int iABv = this.pA.BF.aBv();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jOX);
                jSONObject.put("percent", iABv);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void KZx(boolean z) {
        pA pAVar = this.pA;
        if (pAVar != null && z && pAVar.Og.Dc() && !this.pA.Og.eUc()) {
            this.pA.Og.SD(true);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.pA.Og, this.pA.ML, this.pA.Og.ZF());
        }
    }

    public void SD() {
        JSONObject jSONObject = new JSONObject();
        pA(jSONObject);
        com.bytedance.sdk.openadsdk.ZZv.KZx.ML(this.pA.Og, this.pA.ML, jSONObject);
    }

    public com.bytedance.sdk.openadsdk.core.Og.ML pA(final pA pAVar, final com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        return new com.bytedance.sdk.openadsdk.core.Og.ML(pAVar.SzT, yfo, pAVar.ML, pAVar.ZZv ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.BSW.4
            @Override // com.bytedance.sdk.openadsdk.core.Og.ML
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, int i, int i2, int i3, boolean z) {
                if (yfo.rjD() && view != null) {
                    Object tag = view.getTag(570425345);
                    if (tag instanceof String) {
                        pA((String) tag);
                    }
                }
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(pAVar.BF.SD()));
                if (pAVar.SGo.get()) {
                    map.put("click_scence", 2);
                } else if (WQf.XT(yfo)) {
                    map.put("click_scence", 3);
                } else {
                    map.put("click_scence", 1);
                }
                pA(map);
                pAVar.FQ.c_();
                if (view.getId() == com.bytedance.sdk.openadsdk.utils.Sn.mM && WQf.XT(yfo)) {
                    JSONObject jSONObject = new JSONObject();
                    if (yfo.Bf() != null) {
                        try {
                            jSONObject.put("playable_url", yfo.Bf().WV());
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.WV.pA("TTAD.RFReportManager", "onRewardBarClick json error", e);
                        }
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, pAVar.ML, "click_playable_download_button_loading", jSONObject);
                }
                pAVar.WQf.pA(view, f, f2, f3, f4, sparseArray, i, i2, i3, new ZZv.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.BSW.4.1
                    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.ZZv.pA
                    public void pA(String str, JSONObject jSONObject2) {
                        BSW.this.pA(str, jSONObject2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.ZZv.pA
                    public void pA(View view2, float f5, float f6, float f7, float f8, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray2, int i4, int i5, int i6) {
                        BSW.this.pA(view2, f5, f6, f7, f8, sparseArray2, i4, i5, i6);
                    }
                });
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(yfo, 9);
                pAVar.BF.rB();
            }
        };
    }
}
