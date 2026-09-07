package com.bytedance.adsdk.pA.Og.Og.pA;

import android.text.TextUtils;
import com.json.b9;
import com.smaato.sdk.core.dns.DnsName;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class BF implements com.bytedance.adsdk.pA.Og.Og.pA {
    private final String pA;

    public BF(String str) {
        this.pA = str;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA;
        if (map == null || map.size() <= 0 || (objPA = pA(this.pA, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objPA;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.JG.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.pA + b9.i.e;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        return this.pA;
    }

    public Object pA(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return pA(str.split(DnsName.ESCAPED_DOT), 0, jSONObject);
    }

    private Object pA(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf(b9.i.d);
            int iIndexOf2 = str.indexOf(b9.i.e);
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return pA(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException unused2) {
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return pA(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
