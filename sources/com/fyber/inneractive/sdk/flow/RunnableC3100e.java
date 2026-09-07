package com.fyber.inneractive.sdk.flow;

import android.app.Application;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC3100e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInfrastructureError f1787a;
    public final /* synthetic */ C3101f b;

    public RunnableC3100e(C3101f c3101f, InneractiveInfrastructureError inneractiveInfrastructureError) {
        this.b = c3101f;
        this.f1787a = inneractiveInfrastructureError;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String string;
        com.fyber.inneractive.sdk.response.e eVar = this.b.b;
        if (eVar == null || (str = eVar.h) == null) {
            return;
        }
        Map map = eVar.r;
        if (map == null && eVar.s == null) {
            return;
        }
        C3085o c3085o = IAConfigManager.O.u.b;
        String strA = c3085o.a("max_failed_creatives_interval_hours", C3101f.e);
        String strA2 = c3085o.a("max_failed_creatives_per_interval", C3101f.f);
        int iA = AbstractC3256u.a(strA, 24);
        int iA2 = AbstractC3256u.a(strA2, 1);
        Application application = AbstractC3251o.f2370a;
        if (application != null) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigPrefs", 0);
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray = new JSONArray(sharedPreferences.getString("lt", "[]"));
            } catch (JSONException unused) {
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (c3085o.a(false, this.b.f1867a) && !com.fyber.inneractive.sdk.metrics.a.a(iA, iA2, jSONArray, copyOnWriteArrayList)) {
                copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis()));
                if (map != null) {
                    try {
                        string = new JSONObject(map).toString();
                    } catch (Throwable unused2) {
                        string = "";
                    }
                } else {
                    string = this.b.b.s;
                }
                C3101f c3101f = this.b;
                InneractiveAdRequest inneractiveAdRequest = c3101f.c;
                com.fyber.inneractive.sdk.response.e eVar2 = c3101f.b;
                InneractiveInfrastructureError inneractiveInfrastructureError = this.f1787a;
                JSONArray jSONArray2 = c3101f.d;
                EnumC3143t enumC3143t = EnumC3143t.IA_AD_FAILURE_DATA;
                C3146w c3146w = new C3146w(eVar2);
                c3146w.b = enumC3143t;
                c3146w.f1934a = inneractiveAdRequest;
                c3146w.d = jSONArray2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("raw_response", str);
                } catch (Exception unused3) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "raw_response", str);
                }
                try {
                    jSONObject.put("headers", string);
                } catch (Exception unused4) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "headers", string);
                }
                String strDescription = inneractiveInfrastructureError.description();
                try {
                    jSONObject.put("error_code", strDescription);
                } catch (Exception unused5) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "error_code", strDescription);
                }
                c3146w.f.put(jSONObject);
                c3146w.a((String) null);
            }
            sharedPreferences.edit().putString("lt", new JSONArray((Collection) copyOnWriteArrayList).toString()).apply();
        }
    }
}
