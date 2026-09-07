package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Sn extends aBv {
    public Sn() {
        super(com.bytedance.adsdk.pA.Og.ZZv.KZx.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA = this.pA.pA(map);
        Object objPA2 = this.Og.pA(map);
        if (objPA == null && objPA2 == null) {
            return Boolean.FALSE;
        }
        if (objPA == null && objPA2 != null) {
            return Boolean.TRUE;
        }
        if (objPA != null && objPA2 == null) {
            return Boolean.TRUE;
        }
        if ((objPA instanceof Number) && (objPA2 instanceof Number)) {
            return Boolean.valueOf(!com.bytedance.adsdk.pA.Og.ML.pA.Og.pA((Number) objPA, (Number) objPA2));
        }
        return Boolean.valueOf(!objPA.equals(objPA2));
    }
}
