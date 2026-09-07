package com.inmobi.media;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class Gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3084a;
    public final String b;

    public Gc(byte b, String str) {
        this.f3084a = b;
        this.b = str;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            byte b = this.f3084a;
            String str = "unknown";
            if (b != 0) {
                if (b == 1) {
                    str = "static";
                } else if (b == 2) {
                    str = "html";
                } else if (b == 3) {
                    str = Reporting.Key.END_CARD_IFRAME;
                }
            }
            jSONObject.put("type", str);
            jSONObject.put("content", this.b);
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        } catch (JSONException e) {
            List list = Hc.h;
            Intrinsics.checkNotNullExpressionValue("Hc", "access$getTAG$cp(...)");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return "";
        }
    }
}
