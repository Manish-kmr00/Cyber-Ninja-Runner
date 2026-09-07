package com.bytedance.sdk.openadsdk.core.settings;

import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public interface ML {
    public static final Og<JSONObject> pA = new Og<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.ML.1
        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public JSONObject Og(String str) {
            try {
                return PangleNetworkBridge.jsonObjectInit(str);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("ISettingsDataRepository", "", e);
                return null;
            }
        }
    };
    public static final Og<Set<String>> Og = new Og<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.ML.2
        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public Set<String> Og(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("ISettingsDataRepository", "", e);
            }
            return hashSet;
        }
    };

    public interface Og<T> {
        T Og(String str);
    }

    public interface pA {
        pA pA(String str);

        pA pA(String str, float f);

        pA pA(String str, int i);

        pA pA(String str, long j);

        pA pA(String str, String str2);

        pA pA(String str, boolean z);

        void pA();
    }

    void pA(JSONObject jSONObject);
}
