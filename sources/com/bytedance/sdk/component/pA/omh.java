package com.bytedance.sdk.component.pA;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
class omh {
    private WV pA;

    static omh pA(WV wv) {
        return new omh(wv);
    }

    private omh(WV wv) {
        this.pA = wv;
    }

    <T> T pA(String str, Type type) throws JSONException {
        pA(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) PangleNetworkBridge.jsonObjectInit(str);
        }
        return (T) this.pA.pA(str, type);
    }

    <T> String pA(T t) {
        String string;
        if (t == null) {
            return JsonUtils.EMPTY_JSON;
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.pA.pA(t);
        }
        pA(string);
        return string;
    }

    private static void pA(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        Bzk.pA(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
