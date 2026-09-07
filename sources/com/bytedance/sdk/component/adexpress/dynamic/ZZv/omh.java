package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class omh {
    private omh BSW;
    private ML Bzk;
    private float JG;
    private float KZx;
    private float ML;
    private float Og;
    private float SD;
    private List<omh> SGo;
    private boolean Sn;
    private List<List<omh>> WV;
    private String Wx;
    private float ZZv;
    private float omh;
    private String pA;
    private Map<String, String> DX = new HashMap();
    private Map<Integer, String> oX = new HashMap();

    public String pA() {
        return this.Wx;
    }

    public void pA(String str) {
        this.Wx = str;
    }

    public Map<Integer, String> Og() {
        return this.oX;
    }

    public void pA(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.oX.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String KZx() {
        return this.pA;
    }

    public void Og(String str) {
        this.pA = str;
    }

    public float ZZv() {
        return this.ZZv;
    }

    public void pA(float f) {
        this.ZZv = f;
    }

    public float ML() {
        return this.ML;
    }

    public void Og(float f) {
        this.ML = f;
    }

    public float JG() {
        return this.Og;
    }

    public void KZx(float f) {
        this.Og = f;
    }

    public float SD() {
        return this.KZx;
    }

    public void ZZv(float f) {
        this.KZx = f;
    }

    public float omh() {
        return this.JG;
    }

    public void ML(float f) {
        this.JG = f;
    }

    public float Bzk() {
        return this.SD;
    }

    public void JG(float f) {
        this.SD = f;
    }

    public void SD(float f) {
        this.omh = f;
    }

    public ML SGo() {
        return this.Bzk;
    }

    public void pA(ML ml) {
        this.Bzk = ml;
    }

    public List<omh> BSW() {
        return this.SGo;
    }

    public void pA(List<omh> list) {
        this.SGo = list;
    }

    public void pA(omh omhVar) {
        this.BSW = omhVar;
    }

    public omh WV() {
        return this.BSW;
    }

    public int Wx() {
        JG jgML = this.Bzk.ML();
        return jgML.fN() + jgML.dmv();
    }

    public int Sn() {
        JG jgML = this.Bzk.ML();
        return jgML.JBA() + jgML.agB();
    }

    public float DX() {
        JG jgML = this.Bzk.ML();
        return Wx() + jgML.DX() + jgML.oX() + (jgML.WV() * 2.0f);
    }

    public float oX() {
        JG jgML = this.Bzk.ML();
        return Sn() + jgML.aBv() + jgML.Sn() + (jgML.WV() * 2.0f);
    }

    public void Og(List<List<omh>> list) {
        this.WV = list;
    }

    public List<List<omh>> aBv() {
        return this.WV;
    }

    public boolean XT() {
        List<omh> list = this.SGo;
        return list == null || list.size() <= 0;
    }

    public boolean yFO() {
        return this.Sn;
    }

    public void pA(boolean z) {
        this.Sn = z;
    }

    public Map<String, String> vZF() {
        return this.DX;
    }

    public void pA(String str, String str2) {
        this.DX.put(str, str2);
    }

    public void Sd() {
        List<List<omh>> list = this.WV;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<omh> list2 : this.WV) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.WV = arrayList;
    }

    public boolean TX() {
        return TextUtils.equals(this.Bzk.ML().roi(), "flex");
    }

    public String BF() {
        return this.Bzk.ML().BF();
    }

    public void KZx(String str) {
        this.Bzk.ML().JG(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.pA + "', x=" + this.Og + ", y=" + this.KZx + ", width=" + this.JG + ", height=" + this.SD + ", remainWidth=" + this.omh + ", rootBrick=" + this.Bzk + ", childrenBrickUnits=" + this.SGo + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean WQf() {
        return this.Bzk.ML().Qj() < 0 || this.Bzk.ML().sk() < 0 || this.Bzk.ML().QI() < 0 || this.Bzk.ML().Gag() < 0;
    }

    public String pA(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Bzk.Og());
        sb.append(":");
        sb.append(this.pA);
        if (this.Bzk.ML() != null) {
            sb.append(":");
            sb.append(this.Bzk.ML().Xj());
        }
        sb.append(":");
        sb.append(i);
        return sb.toString();
    }
}
