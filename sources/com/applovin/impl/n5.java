package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.safedk.android.utils.SdksMapping;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n5 extends g5 {
    private static JSONObject j;
    private static final Object k = new Object();
    private static final Map l = Collections.synchronizedMap(new HashMap());
    private final x2 g;
    private final Context h;
    private final b i;

    public interface b {
        void a(JSONArray jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements a5.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f558a;
        private final Object b;
        private int c;
        private final AtomicBoolean d;
        private final Collection e;
        private final com.applovin.impl.sdk.k f;
        private final com.applovin.impl.sdk.o g;

        @Override // com.applovin.impl.a5.a
        public void a(a5 a5Var) {
            boolean z;
            synchronized (this.b) {
                this.e.add(a5Var);
                int i = this.c - 1;
                this.c = i;
                z = i < 1;
            }
            if (z && this.d.compareAndSet(false, true)) {
                if (k7.h() && ((Boolean) this.f.a(v4.N)).booleanValue()) {
                    this.f.r0().a((g5) new p6(this.f, "handleSignalCollectionCompleted", new Runnable() { // from class: com.applovin.impl.n5$c$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a();
                        }
                    }), b6.b.MEDIATION);
                } else {
                    a();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.compareAndSet(false, true)) {
                a();
            }
        }

        private c(int i, b bVar, com.applovin.impl.sdk.k kVar) {
            this.c = i;
            this.f558a = bVar;
            this.f = kVar;
            this.g = kVar.O();
            this.b = new Object();
            this.e = new ArrayList(i);
            this.d = new AtomicBoolean();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            ArrayList<a5> arrayList;
            synchronized (this.b) {
                arrayList = new ArrayList(this.e);
            }
            JSONArray jSONArray = new JSONArray();
            for (a5 a5Var : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b5 b5VarF = a5Var.f();
                    jSONObject.put("name", b5VarF.c());
                    jSONObject.put(SdksMapping.KEY_INSTALLED_MEDIATION_ADAPTERS_CLASS, b5VarF.b());
                    jSONObject.put("adapter_version", a5Var.a());
                    jSONObject.put("sdk_version", a5Var.d());
                    JSONObject jSONObject2 = new JSONObject();
                    MaxError maxErrorC = a5Var.c();
                    if (maxErrorC != null) {
                        jSONObject2.put("error_message", maxErrorC.getMessage());
                    } else {
                        jSONObject2.put("signal", a5Var.e());
                    }
                    jSONObject2.put("signal_collection_time_ms", a5Var.b());
                    jSONObject2.put("is_cached", a5Var.g());
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (com.applovin.impl.sdk.o.a()) {
                        this.g.a("TaskCollectSignals", "Collected signal from " + b5VarF);
                    }
                } catch (JSONException e) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.g.a("TaskCollectSignals", "Failed to create signal data", e);
                    }
                    this.f.E().a("TaskCollectSignals", "createSignalsData", e);
                }
            }
            a(jSONArray);
        }

        private void a(JSONArray jSONArray) {
            b bVar = this.f558a;
            if (bVar != null) {
                bVar.a(jSONArray);
            }
        }
    }

    public n5(x2 x2Var, Context context, com.applovin.impl.sdk.k kVar, b bVar) {
        super("TaskCollectSignals", kVar);
        this.g = x2Var;
        this.h = context;
        this.i = bVar;
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        c cVar = new c(jSONArray.length(), this.i, this.f424a);
        this.f424a.r0().a(new p6(this.f424a, "timeoutCollectSignal", cVar), b6.b.TIMEOUT, ((Long) this.f424a.a(o3.n7)).longValue());
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new b5(this.g, jSONArray.getJSONObject(i), jSONObject, this.f424a), cVar);
        }
    }

    private void b(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        Set set = (Set) l.get(this.g.b());
        if (set == null || set.isEmpty()) {
            a("No signal providers found for ad unit: " + this.g.b(), (Throwable) null);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (set.contains(JsonUtils.getString(jSONObject2, "name", null))) {
                jSONArray2.put(jSONObject2);
            }
        }
        a(jSONArray2, jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        try {
            synchronized (k) {
                jSONArray = JsonUtils.getJSONArray(j, "signal_providers", null);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                if (l.size() > 0) {
                    b(jSONArray, j);
                    return;
                } else {
                    a(jSONArray, j);
                    return;
                }
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k(this.b, "Unable to find cached signal providers, fetching signal providers from SharedPreferences.");
            }
            JSONObject jSONObject = new JSONObject((String) this.f424a.a(x4.E, JsonUtils.EMPTY_JSON));
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            if (jSONArray2 != null && jSONArray2.length() != 0) {
                if (l.size() > 0) {
                    b(jSONArray2, jSONObject);
                    return;
                } else {
                    a(jSONArray2, jSONObject);
                    return;
                }
            }
            a("No signal providers found", (Throwable) null);
        } catch (InterruptedException e) {
            a("Failed to wait for signals", e);
            this.f424a.E().a("TaskCollectSignals", "waitForSignals", e);
        } catch (JSONException e2) {
            a("Failed to parse signals JSON", e2);
            this.f424a.E().a("TaskCollectSignals", "parseSignalsJSON", e2);
        } catch (Throwable th) {
            a("Failed to collect signals", th);
            this.f424a.E().a("TaskCollectSignals", "collectSignals", th);
        }
    }

    private void a(final b5 b5Var, final a5.a aVar) {
        if (b5Var.r()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.n5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(b5Var, aVar);
                }
            });
        } else {
            this.f424a.X().collectSignal(b5Var, this.h, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(b5 b5Var, a5.a aVar) {
        this.f424a.X().collectSignal(b5Var, this.h, aVar);
    }

    private void a(String str, Throwable th) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "No signals collected: " + str, th);
        }
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(new JSONArray());
        }
    }

    public static void a(JSONObject jSONObject) {
        synchronized (k) {
            j = jSONObject;
        }
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        try {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
            if (jSONObject2 != null) {
                for (String str : JsonUtils.toList(jSONObject2.names())) {
                    l.put(str, new HashSet(JsonUtils.getList(jSONObject2, str, null)));
                }
            }
        } catch (JSONException e) {
            com.applovin.impl.sdk.o.c("TaskCollectSignals", "Failed to parse ad unit signal providers for JSON object: " + jSONObject, e);
            kVar.E().a("TaskCollectSignals", "parseAdUnitSignalProvidersJSON", e);
        }
    }
}
