package com.fyber.inneractive.sdk.flow;

import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3096a {
    public static void a(InneractiveAdRequest inneractiveAdRequest, InneractiveInfrastructureError inneractiveInfrastructureError, x xVar, com.fyber.inneractive.sdk.response.e eVar, JSONArray jSONArray) {
        String string;
        if (inneractiveInfrastructureError.getErrorCode().getMetricable() == InneractiveErrorCode.Metricable.INCLUDED_IN_FAILED_METRICS) {
            if ((xVar == null || xVar.d() || xVar.isVideoAd()) && !inneractiveInfrastructureError.isErrorAlreadyReported(EnumC3143t.IA_AD_LOAD_FAILED)) {
                IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", inneractiveInfrastructureError.getErrorCode());
                if (inneractiveInfrastructureError.getCause() != null) {
                    string = Arrays.toString(inneractiveInfrastructureError.getCause().getStackTrace());
                } else {
                    StringBuilder sb = new StringBuilder();
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    for (int i = 7; i >= 0 && i < 13 && i < stackTrace.length; i++) {
                        sb.append(stackTrace[i].toString()).append(StringUtils.COMMA);
                    }
                    Log.d("stack trace:", sb.toString());
                    string = sb.toString();
                }
                EnumC3143t enumC3143t = EnumC3143t.IA_AD_LOAD_FAILED;
                C3146w c3146w = new C3146w(eVar);
                c3146w.b = enumC3143t;
                c3146w.f1934a = inneractiveAdRequest;
                c3146w.d = jSONArray;
                JSONObject jSONObject = new JSONObject();
                String string2 = inneractiveInfrastructureError.getFyberMarketplaceAdLoadFailureReason().toString();
                try {
                    jSONObject.put("message", string2);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "message", string2);
                }
                try {
                    jSONObject.put("description", string);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "description", string);
                }
                String strDescription = inneractiveInfrastructureError.description();
                try {
                    jSONObject.put("extra_description", strDescription);
                } catch (Exception unused3) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "extra_description", strDescription);
                }
                c3146w.f.put(jSONObject);
                c3146w.a((String) null);
                inneractiveInfrastructureError.addReportedError(enumC3143t);
            }
        }
    }
}
