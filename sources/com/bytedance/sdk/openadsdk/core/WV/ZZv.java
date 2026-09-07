package com.bytedance.sdk.openadsdk.core.WV;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv {
    private String Sd;
    private final pA Wx;
    private boolean XT;
    private yFO aBv;
    private long oX;
    private boolean vZF;
    private boolean yFO;
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> pA = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> Og = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> KZx = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> ZZv = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> ML = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> JG = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> SD = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> omh = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> Bzk = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> SGo = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.Og> BSW = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.WV.Og.pA> WV = new ArrayList();
    private final AtomicBoolean Sn = new AtomicBoolean(false);
    private final AtomicBoolean DX = new AtomicBoolean(false);

    public ZZv(pA pAVar) {
        this.Wx = pAVar;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar) {
        pA(-1L, this.pA, pAVar);
    }

    public void pA(long j) {
        if (this.Sn.compareAndSet(false, true)) {
            pA(j, this.Og, null, new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("show_impression", this.aBv));
        }
    }

    public void Og(long j) {
        pA(j, this.KZx, (com.bytedance.sdk.openadsdk.core.WV.pA.pA) null);
    }

    public void KZx(long j) {
        pA(j, this.ZZv, (com.bytedance.sdk.openadsdk.core.WV.pA.pA) null);
    }

    public void ZZv(long j) {
        pA(j, this.ML, null, new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("video_progress", this.aBv, 1.0f));
    }

    public void ML(long j) {
        if (this.DX.compareAndSet(false, true)) {
            pA(j, this.JG, (com.bytedance.sdk.openadsdk.core.WV.pA.pA) null);
        }
    }

    public void JG(long j) {
        pA(j, this.SD, (com.bytedance.sdk.openadsdk.core.WV.pA.pA) null);
    }

    public void SD(long j) {
        pA(j, this.omh, null, new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("click", this.aBv));
    }

    public void omh(long j) {
        pA(j, this.Bzk, (com.bytedance.sdk.openadsdk.core.WV.pA.pA) null);
    }

    public void Bzk(long j) {
        pA(j, this.SGo, (com.bytedance.sdk.openadsdk.core.WV.pA.pA) null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0077  */
    public void pA(long j, long j2, JG jg) {
        if (System.currentTimeMillis() - this.oX >= 1000 && j >= 0 && j2 > 0) {
            this.oX = System.currentTimeMillis();
            float f = j / j2;
            List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> listPA = pA(j, f);
            float f2 = 0.25f;
            if (f >= 0.25f && !this.XT) {
                Og(EventConstants.FIRST_QUARTILE);
                this.XT = true;
                if (jg != null) {
                    pA(jg, 6);
                }
            } else {
                f2 = 0.5f;
                if (f >= 0.5f && !this.yFO) {
                    Og("midpoint");
                    this.yFO = true;
                    if (jg != null) {
                        pA(jg, 7);
                    }
                } else {
                    f2 = 0.75f;
                    if (f >= 0.75f && !this.vZF) {
                        Og(EventConstants.THIRD_QUARTILE);
                        this.vZF = true;
                        if (jg != null) {
                            pA(jg, 8);
                        }
                    }
                    if (f < 0.03f) {
                        f = 0.0f;
                    }
                    pA(j, listPA, null, new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("video_progress", this.aBv, f));
                }
            }
            f = f2;
            if (f < 0.03f) {
                f = 0.0f;
            }
            pA(j, listPA, null, new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("video_progress", this.aBv, f));
        }
    }

    private void pA(final JG jg, final int i) {
        com.bytedance.sdk.component.utils.SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.WV.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                JG jg2 = jg;
                if (jg2 != null) {
                    jg2.pA(i);
                }
            }
        });
    }

    private void Og(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.aBv, this.Sd, "vast_play_track", jSONObject);
        } catch (Throwable unused) {
        }
    }

    private void pA(long j, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list, com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar, com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og og) {
        pA pAVar2 = this.Wx;
        com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(list, pAVar, j, pAVar2 != null ? pAVar2.SD() : null, og);
    }

    private void pA(long j, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list, com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar) {
        pA(j, list, pAVar, null);
    }

    public List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> pA(long j, float f) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.BSW.size(); i++) {
            com.bytedance.sdk.openadsdk.core.WV.Og.Og og = this.BSW.get(i);
            if (og.pA(f)) {
                arrayList.add(og);
            }
        }
        for (int i2 = 0; i2 < this.WV.size(); i2++) {
            com.bytedance.sdk.openadsdk.core.WV.Og.pA pAVar = this.WV.get(i2);
            if (pAVar.pA(j)) {
                arrayList.add(pAVar);
            }
        }
        return arrayList;
    }

    public void pA(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.Og.addAll(list);
    }

    public void Og(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.KZx.addAll(list);
    }

    public void KZx(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.ZZv.addAll(list);
    }

    public void ZZv(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.ML.addAll(list);
    }

    public void ML(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.JG.addAll(list);
    }

    public void JG(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.SD.addAll(list);
    }

    public void SD(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.omh.addAll(list);
    }

    public void omh(List<com.bytedance.sdk.openadsdk.core.WV.Og.Og> list) {
        this.BSW.addAll(list);
        Collections.sort(this.BSW);
    }

    public void Bzk(List<com.bytedance.sdk.openadsdk.core.WV.Og.pA> list) {
        this.WV.addAll(list);
        Collections.sort(this.WV);
    }

    public void SGo(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.pA.addAll(list);
    }

    public void BSW(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.Bzk.addAll(list);
    }

    public void WV(List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) {
        this.SGo.addAll(list);
    }

    public JSONObject pA() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.pA));
        jSONObject.put("impressionTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.Og));
        jSONObject.put("pauseTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.KZx));
        jSONObject.put("resumeTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.ZZv));
        jSONObject.put("completeTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.ML));
        jSONObject.put("closeTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.JG));
        jSONObject.put("skipTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.SD));
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.omh));
        jSONObject.put("muteTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.Bzk));
        jSONObject.put("unMuteTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.SGo));
        jSONObject.put("fractionalTrackers", Og());
        jSONObject.put("absoluteTrackers", KZx());
        return jSONObject;
    }

    private JSONArray Og() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.WV.Og.Og> it = this.BSW.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().Og());
        }
        return jSONArray;
    }

    private JSONArray KZx() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.WV.Og.pA> it = this.WV.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pA());
        }
        return jSONArray;
    }

    public void pA(JSONObject jSONObject) {
        SGo(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("errorTrackers")));
        pA(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("impressionTrackers")));
        Og(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("pauseTrackers"), true));
        KZx(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("resumeTrackers"), true));
        ZZv(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("completeTrackers")));
        ML(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("closeTrackers")));
        JG(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("skipTrackers")));
        SD(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("clickTrackers")));
        BSW(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("muteTrackers"), true));
        WV(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONObject.optJSONArray("unMuteTrackers"), true));
        omh(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og(jSONObject.optJSONArray("fractionalTrackers")));
        Bzk(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.KZx(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void pA(yFO yfo) {
        this.aBv = yfo;
    }

    public void pA(String str) {
        this.Sd = str;
    }

    public void pA(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        Bzk(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.WV.Og.pA.C0235pA(str, j).pA()));
    }

    public void pA(String str, float f) {
        if (TextUtils.isEmpty(str) || f < 0.0f) {
            return;
        }
        omh(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.WV.Og.Og.pA(str, f).pA()));
    }

    public void pA(ZZv zZv) {
        SGo(zZv.pA);
        pA(zZv.Og);
        Og(zZv.KZx);
        KZx(zZv.ZZv);
        ZZv(zZv.ML);
        ML(zZv.JG);
        JG(zZv.SD);
        SD(zZv.omh);
        BSW(zZv.Bzk);
        WV(zZv.SGo);
        omh(zZv.BSW);
        Bzk(zZv.WV);
    }
}
