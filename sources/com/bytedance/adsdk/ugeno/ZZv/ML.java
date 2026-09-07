package com.bytedance.adsdk.ugeno.ZZv;

import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class ML implements SD {
    private boolean KZx;
    private com.bytedance.adsdk.ugeno.Og.KZx Og;
    private Map<String, com.bytedance.adsdk.ugeno.ZZv.KZx.pA> pA;

    public ML(com.bytedance.adsdk.ugeno.Og.KZx kZx, Map<String, com.bytedance.adsdk.ugeno.ZZv.KZx.pA> map) {
        this.Og = kZx;
        this.pA = map;
    }

    public void pA() {
        com.bytedance.adsdk.ugeno.ZZv.KZx.pA pAVarPA = pA("shake");
        if (pAVarPA != null) {
            pAVarPA.pA(this);
            pAVarPA.pA(new Object[0]);
        }
    }

    public void Og() {
        com.bytedance.adsdk.ugeno.ZZv.KZx.pA pAVarPA = pA("twist");
        if (pAVarPA != null) {
            pAVarPA.pA(this);
            pAVarPA.pA(new Object[0]);
        }
    }

    public void KZx() {
        for (Map.Entry<String, com.bytedance.adsdk.ugeno.ZZv.KZx.pA> entry : this.pA.entrySet()) {
            if (entry != null) {
                com.bytedance.adsdk.ugeno.ZZv.KZx.pA value = entry.getValue();
                if (value instanceof com.bytedance.adsdk.ugeno.ZZv.KZx.Og) {
                    value.pA(this);
                    value.pA(new Object[0]);
                }
            }
        }
    }

    public void ZZv() {
        com.bytedance.adsdk.ugeno.ZZv.KZx.pA pAVarPA = pA("timer");
        if (pAVarPA != null) {
            pAVarPA.pA(this);
            pAVarPA.pA(new Object[0]);
        }
    }

    public boolean pA(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.ZZv.KZx.pA pAVarPA = pA("tap");
        if (pAVarPA instanceof com.bytedance.adsdk.ugeno.ZZv.KZx.ZZv) {
            pAVarPA.pA(this);
            this.KZx = pAVarPA.pA(motionEvent);
        }
        if (this.KZx) {
            return true;
        }
        com.bytedance.adsdk.ugeno.ZZv.KZx.pA pAVarPA2 = pA("slide");
        if (pAVarPA2 instanceof com.bytedance.adsdk.ugeno.ZZv.KZx.KZx) {
            pAVarPA2.pA(this);
            return pAVarPA2.pA(motionEvent);
        }
        return this.KZx;
    }

    private void pA(String str, List<Og.pA> list) {
        com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVarPA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Og.pA pAVar : list) {
            if (pAVar != null && (pAVarPA = com.bytedance.adsdk.ugeno.ZZv.Og.pA.C0177pA.pA(this.Og, str, pAVar)) != null) {
                pAVarPA.pA();
            }
        }
    }

    public com.bytedance.adsdk.ugeno.ZZv.KZx.pA pA(String str) {
        Map<String, com.bytedance.adsdk.ugeno.ZZv.KZx.pA> map = this.pA;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.pA.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.SD
    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, List<Og.pA> list) {
        pA(str, list);
    }

    public static ML pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str) {
        com.bytedance.adsdk.ugeno.ZZv.KZx.pA pAVarPA;
        if (kZx != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                HashMap map = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (pAVarPA = com.bytedance.adsdk.ugeno.ZZv.KZx.pA.C0176pA.pA(kZx.Bzk().getContext(), kZx, jSONObjectOptJSONObject, kZx.SGo())) != null) {
                        map.put(pAVarPA.Og(), pAVarPA);
                    }
                }
                return new ML(kZx, map);
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}
