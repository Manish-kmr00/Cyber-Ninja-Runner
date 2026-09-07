package com.inmobi.media;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.c8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public class C3328c8 {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3283a;
    public final String b;
    public Map c;
    public final String d;
    public HashMap e;

    public C3328c8(String url, int i, String eventType, HashMap map) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter("url_ping", "trackerType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.f3283a = i;
        this.b = eventType;
        this.c = map;
        int length = url.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) url.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        this.d = Q6.a(length, 1, url, i2);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "url_ping");
            jSONObject.put("url", this.d);
            jSONObject.put("eventType", this.b);
            jSONObject.put("eventId", this.f3283a);
            boolean z = W8.f3228a;
            Map map = this.c;
            if (map == null) {
                map = new HashMap();
            }
            jSONObject.put("extras", W8.a(StringUtils.COMMA, map));
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        } catch (JSONException e) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return "";
        }
    }
}
