package com.fyber.inneractive.sdk.metrics;

import android.app.Application;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1868a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ c c;

    public b(c cVar, g gVar, Map map) {
        this.c = cVar;
        this.f1868a = gVar;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnitDisplayType unitDisplayType;
        int iA;
        int iA2;
        String str;
        IAlog.a("MetricCreativeReporter: sendMetricEvent()", new Object[0]);
        c cVar = this.c;
        UnitDisplayType unitDisplayType2 = cVar.c;
        if (unitDisplayType2 == null || !(unitDisplayType2 == (unitDisplayType = UnitDisplayType.BANNER) || unitDisplayType2 == UnitDisplayType.MRECT || unitDisplayType2.isFullscreenUnit())) {
            UnitDisplayType unitDisplayType3 = cVar.c;
            IAlog.a("Unit display type %s is not supported for metric event", unitDisplayType3 != null ? unitDisplayType3.value() : "");
            return;
        }
        IAlog.a("MetricCreativeReporter: sendMetricEvent(), collectorData: data: %s", this.f1868a.toString());
        C3085o c3085o = IAConfigManager.O.u.b;
        UnitDisplayType unitDisplayType4 = this.c.c;
        if (unitDisplayType4 == unitDisplayType || unitDisplayType4 == UnitDisplayType.MRECT) {
            String strA = c3085o.a("ad_metrics_interval_banner", c.g);
            String strA2 = c3085o.a("ad_metrics_limit_banner", c.h);
            iA = AbstractC3256u.a(strA, 24);
            iA2 = AbstractC3256u.a(strA2, 3);
            str = "LastSentMetricsBanner";
        } else {
            String strA3 = c3085o.a("ad_metrics_interval_interstitial", c.i);
            String strA4 = c3085o.a("ad_metrics_limit_interstitial", c.j);
            iA = AbstractC3256u.a(strA3, 24);
            iA2 = AbstractC3256u.a(strA4, 3);
            str = "LastSentMetricsInterstitial";
        }
        Application application = AbstractC3251o.f2370a;
        if (application != null) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigPrefs", 0);
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray = new JSONArray(sharedPreferences.getString(str, "[]"));
            } catch (JSONException unused) {
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (c3085o.a(false, this.c.f1867a) && !a.a(iA, iA2, jSONArray, copyOnWriteArrayList)) {
                copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis()));
                c cVar2 = this.c;
                InneractiveAdRequest inneractiveAdRequest = cVar2.e;
                com.fyber.inneractive.sdk.response.e eVar = cVar2.d;
                Map map = this.b;
                try {
                    EnumC3144u enumC3144u = EnumC3144u.METRIC_MEASUREMENTS_EVENT;
                    JSONArray jSONArray2 = cVar2.f;
                    C3146w c3146w = new C3146w(eVar);
                    c3146w.c = enumC3144u;
                    c3146w.f1934a = inneractiveAdRequest;
                    c3146w.d = jSONArray2;
                    JSONObject jSONObject = new JSONObject();
                    for (String str2 : map.keySet()) {
                        Object obj = map.get(str2);
                        try {
                            jSONObject.put(str2, obj);
                        } catch (Exception unused2) {
                            IAlog.f("Got exception adding param to json object: %s, %s", str2, obj);
                        }
                    }
                    c3146w.f.put(jSONObject);
                    c3146w.a((String) null);
                } catch (Exception unused3) {
                }
            }
            sharedPreferences.edit().putString(str, new JSONArray((Collection) copyOnWriteArrayList).toString()).apply();
        }
    }
}
