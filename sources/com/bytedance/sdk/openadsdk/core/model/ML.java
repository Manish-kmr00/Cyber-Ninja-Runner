package com.bytedance.sdk.openadsdk.core.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ML {
    private int JG;
    private List<Integer> KZx;
    private List<String> ML;
    private int Og;
    private int SD;
    private int ZZv;
    private int pA;

    public boolean pA() {
        return this.JG == 1;
    }

    public void pA(int i) {
        this.JG = i;
    }

    public int Og() {
        int i = this.SD;
        if (i >= 2) {
            return i;
        }
        return 0;
    }

    public void Og(int i) {
        this.SD = i;
    }

    public List<String> KZx() {
        return this.ML;
    }

    public void pA(List<String> list) {
        this.ML = list;
    }

    public int ZZv() {
        return this.pA;
    }

    public void KZx(int i) {
        this.pA = i;
    }

    public int ML() {
        return this.Og;
    }

    public void ZZv(int i) {
        this.Og = i;
    }

    public List<Integer> JG() {
        return this.KZx;
    }

    public void Og(List<Integer> list) {
        this.KZx = list;
    }

    public int SD() {
        return this.ZZv;
    }

    public void ML(int i) {
        this.ZZv = i;
    }

    public JSONObject omh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interceptor_x", this.pA);
            jSONObject.put("interceptor_y", this.Og);
            if (this.KZx != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this.KZx.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().intValue());
                }
                jSONObject.put("interceptor_page", jSONArray);
            }
            jSONObject.put("interceptor_interval_time", this.ZZv);
            if (this.ML != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it2 = this.ML.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
                jSONObject.put("url_regular", jSONArray2);
            }
            jSONObject.put("is_act", this.JG);
            jSONObject.put("boc_index", this.SD);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
        }
        return jSONObject;
    }
}
