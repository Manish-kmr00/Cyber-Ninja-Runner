package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class KZx {
    private JSONObject Og;
    private HashMap<String, Object> pA = new HashMap<>();

    public KZx(JSONObject jSONObject) {
        this.Og = jSONObject;
    }

    public Object pA(String str) {
        if (this.pA.containsKey(str)) {
            return this.pA.get(str);
        }
        return null;
    }

    public boolean Og(String str) {
        return this.pA.containsKey(str);
    }

    public void pA() {
        Iterator<String> itKeys = this.Og.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.Og.opt(next);
            int i = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    this.pA.put(next + "." + i + "." + next2, jSONObjectOptJSONObject.opt(next2));
                                }
                            }
                            i++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit((String) objOpt);
                        Iterator<String> itKeys3 = jSONObjectJsonObjectInit.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt2 = jSONObjectJsonObjectInit.opt(next3);
                            if ((objOpt2 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) objOpt2).length(); i2++) {
                                    this.pA.put(next + "." + next3 + "." + i2, ((JSONArray) objOpt2).opt(i2));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, FirebaseAnalytics.Param.COUPON)) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt2).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    this.pA.put(next + "." + next3 + "." + next4, ((JSONObject) objOpt2).opt(next4));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                pA(next, next3, objOpt2);
                            } else {
                                this.pA.put(next + "." + next3, objOpt2);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.pA.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.pA.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    this.pA.put(next + "." + next5, jSONObject.opt(next5));
                }
            }
        }
    }

    private void pA(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if ((objOpt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            this.pA.put(str + "." + str2 + "." + next + "." + i + "." + next2, jSONObjectOptJSONObject.opt(next2));
                        }
                        i++;
                    }
                }
            } else {
                this.pA.put(str + "." + str2 + "." + next, objOpt);
            }
        }
    }
}
