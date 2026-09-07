package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ZZv extends aBv {
    public ZZv() {
        super(com.bytedance.adsdk.pA.Og.ZZv.KZx.EQ);
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA = this.pA.pA(map);
        Object objPA2 = this.Og.pA(map);
        if (objPA == null && objPA2 == null) {
            return Boolean.TRUE;
        }
        if (objPA == null && objPA2 != null) {
            return Boolean.FALSE;
        }
        if (objPA != null && objPA2 == null) {
            return Boolean.FALSE;
        }
        if ((objPA instanceof Number) && (objPA2 instanceof Number)) {
            return Boolean.valueOf(com.bytedance.adsdk.pA.Og.ML.pA.Og.pA((Number) objPA, (Number) objPA2));
        }
        return Boolean.valueOf(objPA.equals(objPA2));
    }
}
