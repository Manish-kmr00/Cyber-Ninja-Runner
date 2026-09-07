package io.appmetrica.analytics.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class Yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11435a;

    public Yd() {
        HashMap map = new HashMap();
        this.f11435a = map;
        map.put("google_aid", "g");
        map.put("huawei_oaid", "h");
        map.put("sim_info", "si");
        map.put("features_collecting", "fc");
        map.put("permissions_collecting", ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORY);
        map.put("retry_policy", "rp");
        map.put("cache_control", "cc");
        map.put("auto_inapp_collecting", "aic");
        map.put(com.json.c9.c, POBConstants.KEY_AT);
        map.put("startup_update", "su");
        map.put("ssl_pinning", "sp");
        map.put("external_attribution", "exta");
    }

    public final String a(String str) {
        return this.f11435a.containsKey(str) ? (String) this.f11435a.get(str) : str;
    }
}
