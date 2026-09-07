package com.json;

import android.content.Context;
import com.json.environment.ContextProvider;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3810a = "adunit_data";

    public void a(Context context) {
        ge.a().c(context);
    }

    public void a(String str, fe.a aVar) {
        JSONObject jSONObjectOptJSONObject;
        try {
            String strName = aVar.name();
            ge geVarA = ge.a();
            JSONObject jSONObjectOptJSONObject2 = geVarA.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f3810a);
            if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(strName)) == null || jSONObjectOptJSONObject.remove(str) == null) {
                return;
            }
            geVarA.b(f3810a, jSONObjectOptJSONObject2.put(strName, jSONObjectOptJSONObject));
        } catch (JSONException e) {
            o9.d().a(e);
        }
    }

    public void a(String str, Object obj) {
        ge.a().b(str, obj);
    }

    public void a(String str, Object obj, fe.a aVar) {
        try {
            String strName = aVar.name();
            ge geVarA = ge.a();
            JSONObject jSONObjectOptJSONObject = geVarA.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f3810a);
            if (jSONObjectOptJSONObject == null) {
                geVarA.b(f3810a, IronSourceNetworkBridge.jsonObjectInit().put(strName, IronSourceNetworkBridge.jsonObjectInit().put(str, obj)));
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(strName);
            if (jSONObjectOptJSONObject2 == null) {
                geVarA.b(f3810a, jSONObjectOptJSONObject.put(strName, IronSourceNetworkBridge.jsonObjectInit().put(str, obj)));
            } else {
                geVarA.b(f3810a, jSONObjectOptJSONObject.put(strName, jSONObjectOptJSONObject2.put(str, obj)));
            }
        } catch (JSONException e) {
            o9.d().a(e);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        ge.a().a(str, jSONObject);
    }

    public void a(Map<String, Object> map) {
        ge.a().a(map);
    }
}
