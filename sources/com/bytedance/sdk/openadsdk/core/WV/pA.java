package com.bytedance.sdk.openadsdk.core.WV;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class pA {
    private String BSW;
    private int Bzk;
    private String DX;
    private String JG;
    KZx KZx;
    private String ML;
    Og Og;
    private String SD;
    private int SGo;
    private String ZZv;
    private double omh;
    ZZv pA = new ZZv(this);
    private final Set<SGo> WV = new HashSet();
    private String Wx = "VAST_ACTION_BUTTON";
    private boolean Sn = false;

    public ZZv pA() {
        return this.pA;
    }

    public Og Og() {
        return this.Og;
    }

    public KZx KZx() {
        return this.KZx;
    }

    public String ZZv() {
        return this.ZZv;
    }

    public String ML() {
        return this.ML;
    }

    public String JG() {
        return this.JG;
    }

    public String SD() {
        return this.SD;
    }

    public void pA(Og og) {
        if (og != null) {
            og.pA(this.SD);
        }
        this.Og = og;
    }

    public void pA(KZx kZx) {
        if (kZx != null) {
            kZx.pA(this.SD);
        }
        this.KZx = kZx;
    }

    public void pA(String str) {
        this.ZZv = str;
    }

    public void Og(String str) {
        this.ML = str;
    }

    public void KZx(String str) {
        this.JG = str;
    }

    public void ZZv(String str) {
        this.SD = str;
    }

    public double omh() {
        return this.omh;
    }

    public void pA(double d) {
        this.omh = d;
    }

    public String Bzk() {
        KZx kZx;
        String str = this.JG;
        if (!TextUtils.isEmpty(this.DX)) {
            String str2 = this.DX;
            this.DX = null;
            return str2;
        }
        String str3 = this.Wx;
        str3.hashCode();
        if (str3.equals("VAST_ICON")) {
            Og og = this.Og;
            if (og != null && !TextUtils.isEmpty(og.omh)) {
                str = this.Og.omh;
            }
        } else if (str3.equals("VAST_END_CARD") && (kZx = this.KZx) != null && !TextUtils.isEmpty(kZx.omh)) {
            str = this.KZx.omh;
        }
        this.Wx = "VAST_ACTION_BUTTON";
        return str;
    }

    public void ML(String str) {
        this.Wx = str;
    }

    public JSONObject SGo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoTrackers", this.pA.pA());
        Og og = this.Og;
        if (og != null) {
            jSONObject.put("vastIcon", og.pA());
        }
        KZx kZx = this.KZx;
        if (kZx != null) {
            jSONObject.put("endCard", kZx.pA());
        }
        jSONObject.put("title", this.ZZv);
        jSONObject.put("description", this.ML);
        jSONObject.put("clickThroughUrl", this.JG);
        jSONObject.put(UnifiedMediationParams.KEY_VIDEO_URL, this.SD);
        jSONObject.put("videDuration", this.omh);
        jSONObject.put("tag", this.BSW);
        jSONObject.put("videoWidth", this.Bzk);
        jSONObject.put("videoHeight", this.SGo);
        jSONObject.put("viewabilityVendor", oX());
        return jSONObject;
    }

    private JSONArray oX() {
        JSONArray jSONArray = new JSONArray();
        for (SGo sGo : this.WV) {
            if (sGo != null) {
                jSONArray.put(sGo.ZZv());
            }
        }
        return jSONArray;
    }

    public static pA pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        pA pAVar = new pA();
        pAVar.pA.pA(jSONObject.optJSONObject("videoTrackers"));
        pAVar.Og = Og.pA(jSONObject.optJSONObject("vastIcon"));
        pAVar.KZx = KZx.Og(jSONObject.optJSONObject("endCard"));
        pAVar.ZZv = jSONObject.optString("title");
        pAVar.ML = jSONObject.optString("description");
        pAVar.JG = jSONObject.optString("clickThroughUrl");
        pAVar.SD = jSONObject.optString(UnifiedMediationParams.KEY_VIDEO_URL);
        pAVar.omh = jSONObject.optDouble("videDuration");
        pAVar.BSW = jSONObject.optString("tag");
        pAVar.Bzk = jSONObject.optInt("videoWidth");
        pAVar.Bzk = jSONObject.optInt("videoHeight");
        pAVar.WV.addAll(SGo.pA(jSONObject.optJSONArray("viewabilityVendor")));
        return pAVar;
    }

    public void pA(yFO yfo) {
        this.pA.pA(yfo);
        Og og = this.Og;
        if (og != null) {
            og.pA(yfo);
        }
        KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.pA(yfo);
        }
    }

    public String BSW() {
        return this.BSW;
    }

    public void JG(String str) {
        this.BSW = str;
        this.pA.pA(str);
    }

    public void pA(int i) {
        this.Bzk = i;
    }

    public void Og(int i) {
        this.SGo = i;
    }

    public int WV() {
        return this.Bzk;
    }

    public int Wx() {
        return this.SGo;
    }

    public void pA(Set<SGo> set) {
        if (set == null || set.size() <= 0) {
            return;
        }
        this.WV.addAll(set);
    }

    public Set<SGo> Sn() {
        return this.WV;
    }

    public void SD(String str) {
        this.DX = str;
    }

    public void DX() {
        this.Sn = true;
    }
}
