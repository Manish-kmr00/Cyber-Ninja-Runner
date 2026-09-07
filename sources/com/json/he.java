package com.json;

import android.content.Context;
import com.json.environment.ContextProvider;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3747a = "adunit_data";

    private JSONObject a(Context context, fe.a aVar) throws JSONException {
        String strName = aVar.name();
        JSONObject jSONObjectB = ge.a().b(context);
        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject(f3747a);
        JSONObject jSONObjectA = a(jSONObjectB);
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optJSONObject(strName) != null) {
            JSONObject jSONObject = jSONObjectOptJSONObject.getJSONObject(strName);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectA.putOpt(next, jSONObject.opt(next));
            }
        }
        return jSONObjectA;
    }

    private JSONObject a(Context context, List<String> list) throws JSONException {
        return a(a(ge.a().b(context)), (String[]) list.toArray(new String[list.size()]));
    }

    private JSONObject a(JSONObject jSONObject) {
        jSONObject.remove(f3747a);
        return jSONObject;
    }

    private JSONObject a(JSONObject jSONObject, String[] strArr) throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        for (String str : strArr) {
            if (jSONObject.has(str)) {
                jSONObjectJsonObjectInit.put(str, jSONObject.opt(str));
            }
        }
        return jSONObjectJsonObjectInit;
    }

    public JSONObject a(Context context, String[] strArr) throws JSONException {
        return a(a(ge.a().b(context)), strArr);
    }

    public JSONObject a(List<String> list) throws JSONException {
        return a(ContextProvider.getInstance().getApplicationContext(), list);
    }

    public JSONObject a(List<String> list, fe.a aVar) throws JSONException {
        return a(a(ContextProvider.getInstance().getApplicationContext(), aVar), (String[]) list.toArray(new String[list.size()]));
    }

    public JSONObject a(String[] strArr) throws JSONException {
        return a(a(ge.a().b(ContextProvider.getInstance().getApplicationContext())), strArr);
    }
}
