package com.safedk.android.analytics.events;

import android.os.Build;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.analytics.events.base.StatsEventWithBundle;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.io.IOException;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class CrashEvent extends StatsEventWithBundle implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f8122a = "is_caught";
    protected static final String b = "is_emulator";
    protected static final String c = "is_debug";
    protected static final String d = "generic";
    public static final String e = "report";
    public static final String f = "events";
    public static final String g = "sdk_versions_map";
    public static final String h = "sdk_key";
    private static final String j = "CrashEvent";
    private static final long serialVersionUID = 0;

    public CrashEvent(JSONObject report) {
        super(null, StatsCollector.EventType.crash, report);
    }

    public CrashEvent(String sdk, StatsCollector.EventType eventType, JSONObject report) {
        super(sdk, eventType, report);
    }

    @Override // com.safedk.android.analytics.events.base.StatsEventWithBundle
    public JSONObject f() throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put(e, jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONObject2.put("events", jSONArray);
        JSONObject jSONObjectF = super.f();
        jSONObjectF.put("event_type", a().toString());
        jSONObjectF.put("timestamp", this.G);
        jSONObjectF.put(f8122a, c());
        jSONObjectF.put(b, Build.FINGERPRINT.contains(d));
        jSONObjectF.put(c, SafeDK.getInstance().o());
        String string = JsonUtils.EMPTY_JSON;
        JSONObject jSONObjectS = SafeDK.getInstance().S();
        if (jSONObjectS != null) {
            string = jSONObjectS.toString();
            Logger.d(j, "sdkVersionsJSON=" + jSONObjectS.toString());
        } else {
            Logger.d(j, "sdkVersionsJSON is null");
        }
        jSONObjectF.put(g, string);
        jSONArray.put(jSONObjectF);
        jSONObject2.put("metadata", n.a(SafeDK.getInstance().x().c()));
        jSONObject.put("sdk_key", SafeDK.getInstance().x().a());
        return jSONObject;
    }

    protected boolean c() {
        return false;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public StatsCollector.EventType a() {
        return StatsCollector.EventType.crash;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public String b() {
        return "";
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public void a(StatsEvent statsEvent) {
    }
}
