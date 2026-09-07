package com.inmobi.media;

import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class N0 extends C3353e5 {
    public final int g;
    public final String h;

    public N0(String str, int i, String trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        String message = "reason - " + i + " description - " + (str == null ? "ApplicationExit" : str);
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        Intrinsics.checkNotNullParameter("AppExitEvent", "name");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(trace, "trace");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", "AppExitEvent");
            jSONObject.put("message", message);
            jSONObject.put("stack", trace);
        } catch (JSONException e) {
            e.toString();
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        super("AppExitReasonReporting", "AppExitReasonEvent", string);
        this.g = i;
        this.h = trace;
    }
}
