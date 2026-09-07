package com.bytedance.adsdk.pA.Og.Og.pA;

import com.json.b9;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SD implements com.bytedance.adsdk.pA.Og.Og.pA {
    private final Object pA;

    public SD(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.pA = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.pA = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase("null")) {
                this.pA = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        return this.pA;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.JG.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.pA + b9.i.e;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        Object obj = this.pA;
        if (obj != null) {
            return obj.toString();
        }
        return "NULL";
    }
}
