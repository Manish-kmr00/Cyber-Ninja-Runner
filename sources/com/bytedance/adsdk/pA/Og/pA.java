package com.bytedance.adsdk.pA.Og;

import com.bytedance.adsdk.pA.Og.KZx.pA.Bzk;
import com.bytedance.adsdk.pA.Og.KZx.pA.JG;
import com.bytedance.adsdk.pA.Og.KZx.pA.KZx;
import com.bytedance.adsdk.pA.Og.KZx.pA.ML;
import com.bytedance.adsdk.pA.Og.KZx.pA.Og;
import com.bytedance.adsdk.pA.Og.KZx.pA.SD;
import com.bytedance.adsdk.pA.Og.KZx.pA.SGo;
import com.bytedance.adsdk.pA.Og.KZx.pA.ZZv;
import com.bytedance.adsdk.pA.Og.KZx.pA.omh;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pA {
    private static final com.bytedance.adsdk.pA.Og.KZx.pA pA;
    private com.bytedance.adsdk.pA.Og.Og.pA KZx;
    private String ML;
    private final com.bytedance.adsdk.pA.Og.KZx.pA Og;
    private Deque<com.bytedance.adsdk.pA.Og.Og.pA> ZZv = new LinkedList();

    static {
        int i = 8;
        JG[] jgArr = {new SGo(), new ZZv(), new Bzk(), new Og(), new ML(), new com.bytedance.adsdk.pA.Og.KZx.pA.pA(), new SD(), new KZx(), new omh()};
        final com.bytedance.adsdk.pA.Og.KZx.pA pAVar = new com.bytedance.adsdk.pA.Og.KZx.pA() { // from class: com.bytedance.adsdk.pA.Og.pA.1
            @Override // com.bytedance.adsdk.pA.Og.KZx.pA
            public int pA(String str, int i2, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final JG jg = jgArr[i];
            i--;
            pAVar = new com.bytedance.adsdk.pA.Og.KZx.pA() { // from class: com.bytedance.adsdk.pA.Og.pA.2
                @Override // com.bytedance.adsdk.pA.Og.KZx.pA
                public int pA(String str, int i2, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque) {
                    return jg.pA(str, i2, deque, pAVar);
                }
            };
        }
        pA = pAVar;
    }

    private pA(String str, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        this.Og = pAVar;
        this.ML = str;
        try {
            pA();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.pA.pA.Og(str, e);
        }
    }

    public static pA pA(String str) {
        return new pA(str, pA);
    }

    private void pA() {
        int length = this.ML.length();
        int i = 0;
        while (i < length) {
            int iPA = this.Og.pA(this.ML, i, this.ZZv);
            if (iPA == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.ML.substring(0, i));
            }
            i = iPA;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.pA.Og.Og.pA pAVarPollFirst = this.ZZv.pollFirst();
            if (pAVarPollFirst != null) {
                arrayList.add(0, pAVarPollFirst);
            } else {
                this.KZx = com.bytedance.adsdk.pA.Og.ML.Og.pA(arrayList, this.ML, i);
                this.ZZv = null;
                return;
            }
        }
    }

    public <T> T pA(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) pA(map);
    }

    public <T> T pA(Map<String, JSONObject> map) {
        return (T) this.KZx.pA(map);
    }
}
