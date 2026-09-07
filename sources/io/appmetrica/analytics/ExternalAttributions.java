package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.C3992ae;
import io.appmetrica.analytics.impl.C4238kb;
import io.appmetrica.analytics.impl.Gc;
import io.appmetrica.analytics.impl.Q9;
import io.appmetrica.analytics.impl.Wd;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        return obj == null ? new Wd(Q9.ADJUST) : new C3992ae(Q9.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        return map == null ? new Wd(Q9.AIRBRIDGE) : new Gc(Q9.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        return map == null ? new Wd(Q9.APPSFLYER) : new Gc(Q9.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        return jSONObject == null ? new Wd(Q9.KOCHAVA) : new C4238kb(Q9.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        return map == null ? new Wd(Q9.SINGULAR) : new Gc(Q9.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        return map == null ? new Wd(Q9.TENJIN) : new Gc(Q9.TENJIN, map);
    }
}
