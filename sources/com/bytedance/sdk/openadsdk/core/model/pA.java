package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    private long Bzk;
    private String KZx;
    private boolean ML;
    private int Og;
    private boolean SGo;
    private String Sn;
    private int Wx;
    private C0245pA ZZv;
    private String omh;
    private String pA;
    private List<yFO> JG = new ArrayList();
    private List<omh> SD = new ArrayList();
    private JSONObject BSW = new JSONObject();
    private volatile boolean WV = false;

    public JSONObject pA() {
        return this.BSW;
    }

    public void pA(JSONObject jSONObject) {
        this.BSW = jSONObject;
    }

    public String Og() {
        yFO yfoJG = JG();
        if (yfoJG != null) {
            return yfoJG.Ij();
        }
        return "";
    }

    public void pA(String str) {
        this.pA = str;
    }

    public int KZx() {
        return this.Og;
    }

    public void pA(int i) {
        this.Og = i;
    }

    public void Og(String str) {
        this.KZx = str;
    }

    public List<yFO> ZZv() {
        return this.JG;
    }

    public void pA(yFO yfo) {
        this.JG.add(yfo);
    }

    public void pA(List<yFO> list) {
        this.JG = list;
    }

    public void pA(omh omhVar) {
        this.SD.add(omhVar);
    }

    public void KZx(String str) {
        this.omh = str;
    }

    public void pA(long j) {
        this.Bzk = j;
    }

    public static Map<String, yFO> pA(pA pAVar) {
        if (pAVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (yFO yfo : pAVar.ZZv()) {
            if (!TextUtils.isEmpty(yfo.Gag())) {
                map.put(yfo.Gag(), yfo);
            }
        }
        if (map.size() != 0) {
            return map;
        }
        return null;
    }

    public boolean ML() {
        List<yFO> list = this.JG;
        return list != null && list.size() > 0;
    }

    public yFO JG() {
        if (this.JG.size() > 0) {
            return this.JG.get(0);
        }
        return null;
    }

    public boolean SD() {
        if (Bzk() != null && ZZv() != null && ZZv().size() > 1) {
            this.ML = true;
        } else {
            this.ML = false;
            pA((C0245pA) null);
        }
        return this.ML;
    }

    public boolean omh() {
        return this.SGo;
    }

    public void pA(boolean z) {
        this.SGo = z;
    }

    public C0245pA Bzk() {
        return this.ZZv;
    }

    public void pA(C0245pA c0245pA) {
        this.ZZv = c0245pA;
        if (c0245pA == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.pA.Og.Og.pA(yFO.pA.pA(c0245pA, ""));
    }

    public boolean SGo() {
        return this.WV;
    }

    public void BSW() {
        this.WV = false;
    }

    public void Og(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pA(C0245pA.pA(jSONObject.optJSONObject("tpl_info")));
    }

    public void Og(int i) {
        this.Wx = i;
    }

    public boolean WV() {
        return this.Wx == 1;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.model.pA$pA, reason: collision with other inner class name */
    public static class C0245pA extends yFO.pA {
        private int pA;

        public void pA(int i) {
            this.pA = i;
        }

        public int pA() {
            return this.pA;
        }

        public JSONObject Og() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", JG());
                jSONObject.put("md5", SD());
                jSONObject.put("url", omh());
                jSONObject.put("data", Bzk());
                jSONObject.put("diff_data", SGo());
                jSONObject.put("version", ML());
                jSONObject.put("dynamic_creative", BSW());
                jSONObject.put("count_down_time", pA());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public static C0245pA pA(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0245pA c0245pA = new C0245pA();
            c0245pA.KZx(jSONObject.optString("id"));
            c0245pA.ZZv(jSONObject.optString("md5"));
            c0245pA.ML(jSONObject.optString("url"));
            c0245pA.JG(jSONObject.optString("data"));
            c0245pA.SD(jSONObject.optString("diff_data"));
            c0245pA.Og(jSONObject.optString("version"));
            c0245pA.omh(jSONObject.optString("dynamic_creative"));
            c0245pA.pA(jSONObject.optInt("count_down_time"));
            if (pA(c0245pA)) {
                return c0245pA;
            }
            return null;
        }

        private static boolean pA(C0245pA c0245pA) {
            return (c0245pA == null || TextUtils.isEmpty(c0245pA.JG()) || TextUtils.isEmpty(c0245pA.omh())) ? false : true;
        }
    }

    public JSONObject Wx() {
        try {
            JSONObject jSONObject = new JSONObject();
            C0245pA c0245pABzk = Bzk();
            if (c0245pABzk != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObjectOg = c0245pABzk.Og();
                if (jSONObjectOg != null) {
                    jSONObject2.put("tpl_info", jSONObjectOg);
                    jSONObject.put("choose_ui_data", jSONObject2);
                }
            }
            List<yFO> list = this.JG;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.JG.size(); i++) {
                    jSONArray.put(this.JG.get(i).jO());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("is_choose_ad_original", this.SGo);
            jSONObject.put("multi_ad_style", this.Wx);
            jSONObject.put("request_id", this.pA);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA(c.f8029a, "toJsonObj: ", th);
            return null;
        }
    }

    public static pA KZx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            pA pAVar = new pA();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("choose_ui_data");
            if (jSONObjectOptJSONObject != null) {
                pAVar.Og(jSONObjectOptJSONObject);
            }
            pAVar.Og(jSONObject.optInt("multi_ad_style", 0));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    yFO yfoPA = com.bytedance.sdk.openadsdk.core.Og.pA(jSONArrayOptJSONArray.optJSONObject(i));
                    if (yfoPA != null) {
                        yfoPA.Bzk(pAVar.WV());
                        arrayList.add(yfoPA);
                    }
                }
                pAVar.pA(arrayList);
            }
            pAVar.pA(jSONObject.optBoolean("is_choose_ad_original", false));
            pAVar.pA(jSONObject.optString("request_id", ""));
            return pAVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA(c.f8029a, "fromJson: ", th);
            return null;
        }
    }

    public void ZZv(String str) {
        this.Sn = str;
    }

    public String Sn() {
        return this.Sn;
    }
}
