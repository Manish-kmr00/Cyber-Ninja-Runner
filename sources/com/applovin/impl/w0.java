package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.yandex.div.core.timer.TimerController;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f734a;

    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    private w0(JSONObject jSONObject) {
        this.f734a = jSONObject;
    }

    public static w0 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "title", (JSONObject) null), "key", null);
        if ("TOS".equalsIgnoreCase(string) && kVar.y().h() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && kVar.y().f() == null) {
            return null;
        }
        return new w0(jSONObject);
    }

    public String b() {
        return JsonUtils.getString(this.f734a, "event", null);
    }

    public a c() {
        String string = JsonUtils.getString(this.f734a, "style", null);
        if ("default".equalsIgnoreCase(string)) {
            return a.POSITIVE;
        }
        return ("destructive".equalsIgnoreCase(string) || TimerController.CANCEL_COMMAND.equalsIgnoreCase(string)) ? a.NEGATIVE : a.NEUTRAL;
    }

    public String d() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f734a, "title", (JSONObject) null);
        return com.applovin.impl.sdk.k.a(JsonUtils.getString(jSONObject, "key", ""), JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + d() + ", destinationStateId=" + a() + ", event=" + b() + "}";
    }

    public int a() {
        return JsonUtils.getInt(this.f734a, "destination_state_id", -1);
    }
}
