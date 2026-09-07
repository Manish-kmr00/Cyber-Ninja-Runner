package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.json.b9;
import com.safedk.android.internal.partials.AppLovinNetworkBridge;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import net.pubnative.lite.sdk.models.AdExperience;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d2 {
    private static volatile ExecutorService g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f392a;
    protected final com.applovin.impl.sdk.o b;
    private final c2.b c;
    private final Map d = Collections.synchronizedMap(new HashMap());
    private final Set e = Collections.synchronizedSet(new HashSet());
    private static final int f = (int) TimeUnit.SECONDS.toMillis(30);
    private static final Object h = new Object();

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: com.applovin.impl.d2$a$a, reason: collision with other inner class name */
        class C0131a implements Thread.UncaughtExceptionHandler {
            C0131a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                d2.this.f392a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    d2.this.f392a.O().a("HealthEventsReporter", "Caught unhandled exception", th);
                }
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:health_events_reporter");
            thread.setDaemon(true);
            thread.setPriority(((Integer) d2.this.f392a.a(v4.Q)).intValue());
            thread.setUncaughtExceptionHandler(new C0131a());
            return thread;
        }
    }

    public d2(com.applovin.impl.sdk.k kVar, c2.b bVar) {
        this.f392a = kVar;
        this.b = kVar.O();
        this.c = bVar;
        a();
    }

    private void a() {
        if (g != null) {
            return;
        }
        synchronized (h) {
            if (g != null) {
                return;
            }
            g = Executors.newFixedThreadPool(1, new a());
        }
    }

    private void c(c2 c2Var, List list) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        if (c2Var.a() == c2.b.AD || c2Var.a() == c2.b.MEDIATED_AD || c2Var.a() == c2.b.USER_SESSION || !k7.a(((Integer) this.f392a.a(v4.z)).intValue())) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                httpURLConnection = (HttpURLConnection) a(c2Var, map).openConnection();
                try {
                    int i = f;
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i);
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("AppLovin-Event-Type", c2Var.b());
                    int iHttpUrlConnectionGetResponseCode = AppLovinNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.a("HealthEventsReporter", c2Var.b() + " reported with code " + iHttpUrlConnectionGetResponseCode + " and extra parameters " + map);
                    }
                    this.d.put(c2Var, Long.valueOf(System.currentTimeMillis()));
                    k7.a(httpURLConnection, this.f392a);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (com.applovin.impl.sdk.o.a()) {
                            this.b.d("HealthEventsReporter", "Failed to report " + c2Var.b() + " with extra parameters " + map, th);
                        }
                        k7.a(httpURLConnection, this.f392a);
                    } catch (Throwable th3) {
                        k7.a(httpURLConnection, this.f392a);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                httpURLConnection = null;
                th = th4;
            }
        }
    }

    public void d(c2 c2Var, Map map) {
        a(c2Var, map, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str, c2 c2Var, JSONObject jSONObject) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(str);
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                int i = f;
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setReadTimeout(i);
                httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpURLConnection2.setDefaultUseCaches(false);
                httpURLConnection2.setAllowUserInteraction(false);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("AppLovin-Event-Type", c2Var.b());
                OutputStream outputStreamUrlConnectionGetOutputStream = AppLovinNetworkBridge.urlConnectionGetOutputStream(httpURLConnection2);
                outputStreamUrlConnectionGetOutputStream.write(bytes);
                outputStreamUrlConnectionGetOutputStream.close();
                int iHttpUrlConnectionGetResponseCode = AppLovinNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection2);
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.a("HealthEventsReporter", c2Var.b() + " reported with code " + iHttpUrlConnectionGetResponseCode);
                }
                this.d.put(c2Var, Long.valueOf(System.currentTimeMillis()));
                k7.a(httpURLConnection2, this.f392a);
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.d("HealthEventsReporter", "Failed to report " + c2Var.b(), th);
                    }
                } finally {
                    k7.a(httpURLConnection, this.f392a);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void d(final c2 c2Var, List list) {
        final String str = (String) this.f392a.a(v4.A);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        double dA = c2Var.a(this.f392a);
        if (k7.a(dA)) {
            if (((Boolean) this.f392a.a(v4.G)).booleanValue()) {
                a(str, c2Var, a(c2Var, dA, list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final JSONObject jSONObjectA = a(c2Var, dA, Collections.singletonList((Map) it.next()));
                g.execute(new Runnable() { // from class: com.applovin.impl.d2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(str, c2Var, jSONObjectA);
                    }
                });
            }
        }
    }

    public void a(c2 c2Var, String str) {
        a(c2Var, str, new HashMap());
    }

    public void a(c2 c2Var, String str, Map map) {
        map.put("source", str);
        d(c2Var, map);
    }

    public void a(c2 c2Var, String str, Map map, String str2) {
        if (!StringUtils.isValidString(str2) || this.e.add(str2)) {
            map.put("source", str);
            a(c2Var, str, map);
        }
    }

    public void a(c2 c2Var, Map map, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        a(c2Var, arrayList, j);
    }

    private Map b(c2 c2Var, Map map) {
        HashMap map2 = new HashMap();
        map2.put("type", c2Var.b());
        if (c2Var == c2.y0 || c2Var == c2.x0 || c2Var == c2.N0 || c2Var == c2.L0) {
            if (((Boolean) this.f392a.a(v4.k4)).booleanValue()) {
                CollectionUtils.putStringIfValid("wvvc", String.valueOf(k8.d()), map2);
                CollectionUtils.putStringIfValid("wvv", k8.c(), map2);
                CollectionUtils.putStringIfValid("wvpn", k8.b(), map2);
            }
            CollectionUtils.putStringIfValid("oglv", this.f392a.B().I(), map2);
        }
        Map mapL = this.f392a.B().L();
        map2.put("platform", String.valueOf(mapL.get("platform")));
        map2.put("country_code", String.valueOf(mapL.get("country_code")));
        map2.put("cc", this.f392a.w().getCountryCode());
        map2.put("applovin_random_token", this.f392a.i0());
        map2.put("compass_random_token", this.f392a.v());
        map2.put("model", Build.MODEL);
        map2.put(AdExperience.BRAND, Build.MANUFACTURER);
        map2.put("brand_name", Build.BRAND);
        map2.put("hardware", Build.HARDWARE);
        map2.put("revision", Build.DEVICE);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        map2.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        CollectionUtils.putStringIfValid("ad_review_sdk_version", j.b(), map2);
        map2.put("md", (String) this.f392a.a(v4.t));
        b(map2);
        a(map2);
        if (map != null) {
            map2.putAll(c(c2Var, map));
        }
        return map2;
    }

    private Map c(c2 c2Var, Map map) {
        HashMap map2 = new HashMap(map);
        if (c2Var == c2.C0) {
            map2.remove("details");
        }
        return map2;
    }

    public void a(final c2 c2Var, final List list, long j) {
        if (a(c2Var, j)) {
            return;
        }
        try {
            if (k7.h()) {
                g.execute(new Runnable() { // from class: com.applovin.impl.d2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(c2Var, list);
                    }
                });
            } else {
                b(c2Var, list);
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.d("HealthEventsReporter", "Failed to report " + c2Var.b() + " with extra parameters collection " + list, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(c2 c2Var, List list) {
        if (AppLovinSdkUtils.isEmulator()) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("HealthEventsReporter", "Reporting " + c2Var.b() + " with extra parameters collection " + list);
        }
        if (this.c != c2Var.a()) {
            k1.a("Health event " + c2Var.b() + " category: " + c2Var.a() + " does not match the reporter category: " + this.c, new Object[0]);
        }
        c(c2Var, list);
        d(c2Var, list);
    }

    private URL a(c2 c2Var, Map map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error?");
        Iterator it = b(c2Var, map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strEncode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
            sb.append(strEncode).append("=").append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            if (it.hasNext()) {
                sb.append(b9.i.c);
            }
        }
        return new URL(sb.toString());
    }

    private void b(Map map) {
        String packageName;
        PackageInfo packageInfo;
        String str = "";
        try {
            PackageManager packageManager = com.applovin.impl.sdk.k.o().getPackageManager();
            packageName = com.applovin.impl.sdk.k.o().getPackageName();
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 0);
            } catch (Throwable unused) {
                packageInfo = null;
            }
        } catch (Throwable unused2) {
            packageName = "";
        }
        map.put("package_name", packageName);
        if (packageInfo != null) {
            str = packageInfo.versionName;
        }
        map.put("app_version", str);
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    private JSONObject a(c2 c2Var, double d, List list) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_ms", System.currentTimeMillis());
        if (c2Var == c2.y0 || c2Var == c2.x0 || c2Var == c2.N0 || c2Var == c2.L0) {
            if (((Boolean) this.f392a.a(v4.k4)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "wvvc", String.valueOf(k8.d()));
                JsonUtils.putStringIfValid(jSONObject, "wvv", k8.c());
                JsonUtils.putStringIfValid(jSONObject, "wvpn", k8.b());
            }
            JsonUtils.putStringIfValid(jSONObject, "oglv", this.f392a.B().I());
        }
        JSONObject jSONObject2 = new JSONObject();
        Map mapL = this.f392a.B().L();
        JsonUtils.putObject(jSONObject2, "platform", mapL.get("platform"));
        JsonUtils.putObject(jSONObject2, "os", mapL.get("os"));
        JsonUtils.putObject(jSONObject2, "api_level", String.valueOf(mapL.get("api_level")));
        JsonUtils.putObject(jSONObject2, AdExperience.BRAND, mapL.get(AdExperience.BRAND));
        JsonUtils.putObject(jSONObject2, "model", mapL.get("model"));
        JsonUtils.putObject(jSONObject2, "revision", mapL.get("revision"));
        JsonUtils.putObject(jSONObject2, "country_code", mapL.get("country_code"));
        JsonUtils.putObject(jSONObject2, "cc", this.f392a.w().getCountryCode());
        JsonUtils.putObject(jSONObject2, "applovin_random_token", this.f392a.i0());
        JsonUtils.putObject(jSONObject2, "ad_review_sdk_version", StringUtils.emptyIfNull(j.b()));
        Map mapE = this.f392a.B().E();
        JsonUtils.putObject(jSONObject2, "sdk_version", mapE.get("sdk_version"));
        JsonUtils.putObject(jSONObject2, "plugin_version", this.f392a.a(v4.I3));
        JsonUtils.putObject(jSONObject2, "app_version", mapE.get("app_version"));
        JsonUtils.putObject(jSONObject2, "package_name", mapE.get("package_name"));
        JsonUtils.putObject(jSONObject2, "first_install", Boolean.toString(Boolean.TRUE.equals((Boolean) mapE.get("first_install_v2"))));
        JsonUtils.putObject(jSONObject2, "md", this.f392a.a(v4.t));
        JsonUtils.putObject(jSONObject2, "mediation_provider", this.f392a.V());
        SessionTracker sessionTrackerN0 = this.f392a.n0();
        JsonUtils.putObject(jSONObject2, "app_state", sessionTrackerN0.getCurrentApplicationState().b());
        JsonUtils.putObject(jSONObject2, "app_state_duration_ms", Long.valueOf(sessionTrackerN0.getCurrentApplicationStateDurationMillis()));
        JsonUtils.putObject(jSONObject2, SDKAnalyticsEvents.PARAMETER_SESSION_ID, sessionTrackerN0.getSessionId());
        JsonUtils.putObject(jSONObject2, "session_duration_ms", Long.valueOf(System.currentTimeMillis() - com.applovin.impl.sdk.k.n()));
        JsonUtils.putObject(jSONObject, "shared_fields", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putDouble(jSONObject3, "ts_ms", System.currentTimeMillis());
            JsonUtils.putString(jSONObject3, "type", c2Var.b());
            JsonUtils.putDouble(jSONObject3, "weight", d);
            JsonUtils.putString(jSONObject3, "level", "DEBUG");
            a(map);
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) map);
            jSONArray.put(jSONObject3);
        }
        JsonUtils.putObject(jSONObject, "events", jSONArray);
        return jSONObject;
    }

    private void a(Map map) {
        if (map == null) {
            return;
        }
        Object objA = this.f392a.I().a();
        if (objA instanceof com.applovin.impl.sdk.ad.b) {
            map.put("fs_ad_network", "AppLovin");
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.b) objA).getAdIdNumber()));
        } else if (objA instanceof v2) {
            v2 v2Var = (v2) objA;
            map.put("fs_ad_network", v2Var.getNetworkName());
            map.put("fs_ad_creative_id", v2Var.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private boolean a(c2 c2Var, long j) {
        Long l = (Long) this.d.get(c2Var);
        return System.currentTimeMillis() - (l != null ? l.longValue() : -1L) < j;
    }
}
