package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class XT extends aBv {
    private static final ThreadLocal<StringBuilder> ZZv = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.pA.Og.Og.pA.XT.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public XT() {
        super(com.bytedance.adsdk.pA.Og.ZZv.KZx.PLUS);
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA;
        Object objPA2 = this.pA.pA(map);
        if (objPA2 == null || (objPA = this.Og.pA(map)) == null) {
            return null;
        }
        if ((objPA2 instanceof String) || (objPA instanceof String)) {
            StringBuilder sb = ZZv.get();
            sb.append(objPA2).append(objPA);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.bytedance.adsdk.pA.Og.ML.pA.omh.pA((Number) objPA2, (Number) objPA);
    }
}
