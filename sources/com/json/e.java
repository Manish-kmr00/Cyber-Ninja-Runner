package com.json;

import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3636a = "eventId";
    private final String b = "timestamp";
    private final String c = "InterstitialEvents";
    private final String d = "events";
    private final String e = "events";
    JSONObject f;
    int g;
    private String h;

    e() {
    }

    private String a(int i) {
        return i != 2 ? "events" : "InterstitialEvents";
    }

    protected abstract String a();

    public abstract String a(ArrayList<zb> arrayList, JSONObject jSONObject);

    String a(JSONArray jSONArray) {
        try {
            if (this.f != null) {
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(this.f.toString());
                jSONObjectJsonObjectInit.put("timestamp", IronSourceUtils.getTimestamp());
                jSONObjectJsonObjectInit.put(a(this.g), jSONArray);
                return jSONObjectJsonObjectInit.toString();
            }
        } catch (Exception e) {
            o9.d().a(e);
        }
        return "";
    }

    JSONObject a(zb zbVar) {
        try {
            String strA = zbVar.a();
            JSONObject jSONObjectJsonObjectInit = !TextUtils.isEmpty(strA) ? IronSourceNetworkBridge.jsonObjectInit(strA) : IronSourceNetworkBridge.jsonObjectInit();
            jSONObjectJsonObjectInit.put("eventId", zbVar.c());
            jSONObjectJsonObjectInit.put("timestamp", zbVar.d());
            return jSONObjectJsonObjectInit;
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return null;
        }
    }

    void a(String str) {
        this.h = str;
    }

    String b() {
        return TextUtils.isEmpty(this.h) ? a() : this.h;
    }

    public abstract String c();
}
