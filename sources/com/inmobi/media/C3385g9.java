package com.inmobi.media;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.g9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3385g9 extends C3328c8 {
    public final String g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3385g9(String vendorKey, String str, String url, HashMap map) {
        super(url, 0, "OMID_VIEWABILITY", map);
        Intrinsics.checkNotNullParameter(vendorKey, "vendorKey");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter("OMID_VIEWABILITY", "eventType");
        this.h = vendorKey;
        this.g = str;
    }

    @Override // com.inmobi.media.C3328c8
    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "url_ping");
            jSONObject.put("url", this.d);
            jSONObject.put("eventType", this.b);
            jSONObject.put("eventId", this.f3283a);
            if (AbstractC3420j2.a(this.h)) {
                jSONObject.put(POBNativeConstants.NATIVE_VENDOR_KEY, this.h);
            }
            if (AbstractC3420j2.a(this.g)) {
                jSONObject.put("verificationParams", this.g);
            }
            Map map = this.c;
            boolean z = W8.f3228a;
            if (map == null) {
                map = new HashMap();
            }
            jSONObject.put("extras", W8.a(StringUtils.COMMA, map));
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        } catch (JSONException e) {
            Intrinsics.checkNotNullExpressionValue("g9", "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return "";
        }
    }
}
