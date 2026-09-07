package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public interface yFO<T> {

    public interface Og {
        void pA(int i, String str);

        void pA(vZF.Og og);
    }

    public interface pA {
        void pA(int i, String str);

        void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og);
    }

    com.bytedance.sdk.openadsdk.ZZv.ML Og(JSONObject jSONObject);

    com.bytedance.sdk.component.adexpress.pA.KZx.pA pA();

    com.bytedance.sdk.openadsdk.ZZv.ML pA(JSONObject jSONObject, String str, boolean z);

    JSONObject pA(JSONObject jSONObject);

    void pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.TX tx, int i, pA pAVar);

    void pA(String str);

    void pA(String str, List<FilterWord> list, String str2, String str3, String str4);

    void pA(JSONObject jSONObject, Og og);

    void pA(JSONObject jSONObject, String str);
}
