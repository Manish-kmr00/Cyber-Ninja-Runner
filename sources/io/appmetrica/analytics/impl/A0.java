package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.amazon.device.ads.DTBMetricsConfiguration;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class A0 {
    public static String a(C4601z0 c4601z0) {
        try {
            return Base64.encodeToString(new JSONObject().put(DTBMetricsConfiguration.APSMETRICS_APIKEY, c4601z0.f11867a).put("packageName", c4601z0.b).put("reporterType", c4601z0.c.getStringValue()).put("processID", c4601z0.d).put("processSessionID", c4601z0.e).put("errorEnvironment", c4601z0.f).toString().getBytes(Charsets.UTF_8), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static C4601z0 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), Charsets.UTF_8));
            return new C4601z0(jSONObject.getString(DTBMetricsConfiguration.APSMETRICS_APIKEY), jSONObject.getString("packageName"), CounterConfigurationReporterType.INSTANCE.fromStringValue(jSONObject.getString("reporterType")), jSONObject.getInt("processID"), jSONObject.getString("processSessionID"), JsonUtils.optStringOrNull(jSONObject, "errorEnvironment"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
