package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2435a;
    public final com.fyber.inneractive.sdk.response.a b;
    public final Map c;

    public h(JSONObject jSONObject, com.fyber.inneractive.sdk.response.a aVar, Map map) {
        try {
            this.f2435a = jSONObject.getJSONObject(Reporting.Key.CLICK_SOURCE_TYPE_AD).optString("markup");
        } catch (JSONException e) {
            IAlog.a("Failed extracting markup", e, new Object[0]);
        }
        this.b = aVar;
        this.c = map;
    }
}
