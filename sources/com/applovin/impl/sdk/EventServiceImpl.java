package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.b6;
import com.applovin.impl.g5;
import com.applovin.impl.h1;
import com.applovin.impl.k7;
import com.applovin.impl.p6;
import com.applovin.impl.r1;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class EventServiceImpl implements AppLovinEventService {
    public static final List<String> ALLOW_PRE_INIT_EVENT_TYPES = Arrays.asList("landing", "paused", "resumed", "cf_start", "tos_ok", "gdpr_ok");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f625a;
    private final AtomicBoolean b = new AtomicBoolean();

    public EventServiceImpl(k kVar) {
        this.f625a = kVar;
    }

    private void a(final String str, final Map map) {
        final boolean zContains = ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
        this.f625a.r0().a((g5) new p6(this.f625a, zContains, "submitTrackEventPostback", new Runnable() { // from class: com.applovin.impl.sdk.EventServiceImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, map, zContains);
            }
        }), b6.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, Map map, Map map2) {
        Map map3 = CollectionUtils.map("AppLovin-Event", str);
        map3.put("AppLovin-SDK-Name", "AppLovin-MAX");
        com.applovin.impl.sdk.network.d.b bVarD = com.applovin.impl.sdk.network.d.b().d(b()).a(a()).a(map3).c(a(str, map, map2)).a(((Boolean) this.f625a.a(v4.a5)).booleanValue()).a(s4.a.a(((Integer) this.f625a.a(v4.l5)).intValue())).d(false);
        if (this.f625a.t0().c()) {
            bVarD.b(CollectionUtils.map("axon_test_code", "1"));
        }
        this.f625a.f0().e(bVarD.a());
    }

    private void c(final String str, final Map map, final Map map2) {
        if (map.containsKey(FirebaseAnalytics.Param.ITEMS)) {
            Object obj = map.get(FirebaseAnalytics.Param.ITEMS);
            if (!(obj instanceof List)) {
                a("Invalid 'items' value: expected a list.");
                return;
            }
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof Map)) {
                    a("Invalid element in 'items': expected a map.");
                    return;
                }
            }
        }
        this.f625a.r0().a((g5) new p6(this.f625a, false, "track_event:" + str, new Runnable() { // from class: com.applovin.impl.sdk.EventServiceImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str, map, map2);
            }
        }), b6.b.OTHER);
    }

    private String d() {
        return ((String) this.f625a.a(v4.s0)) + "4.0/pix";
    }

    public void maybeTrackAppOpenEvent() {
        if (this.b.compareAndSet(false, true)) {
            this.f625a.G().trackEvent("landing");
        }
    }

    public String toString() {
        return "EventService{}";
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, ?> map2 = CollectionUtils.map(map);
        map2.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEventSynchronously(String str) {
        this.f625a.O();
        if (o.a()) {
            this.f625a.O().a("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        r1 r1Var = new r1(str, new HashMap());
        boolean zContains = this.f625a.c(v4.z0).contains(r1Var.c());
        Map mapA = a(r1Var, true, zContains);
        HashMap map = new HashMap(r1Var.d());
        if (((Boolean) this.f625a.a(v4.t5)).booleanValue() || ((Boolean) this.f625a.a(v4.o5)).booleanValue()) {
            map.putAll(mapA);
            mapA = null;
        }
        this.f625a.f0().e(com.applovin.impl.sdk.network.d.b().d(d()).a(c()).b(mapA).c(map).a(a(r1Var, zContains)).c(((Boolean) this.f625a.a(v4.D5)).booleanValue()).a(((Boolean) this.f625a.a(v4.a5)).booleanValue()).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, ?> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            o.c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            this.f625a.E().a("AppLovinEventService", "trackIAP", th);
        }
        trackEvent("iap", map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, ?> map) {
        trackEvent(str, map, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Map map, boolean z) {
        r1 r1Var = new r1(str, map);
        boolean zContains = this.f625a.c(v4.z0).contains(r1Var.c());
        Map mapA = a(r1Var, false, zContains);
        HashMap map2 = new HashMap(r1Var.d());
        if (((Boolean) this.f625a.a(v4.t5)).booleanValue() || ((Boolean) this.f625a.a(v4.o5)).booleanValue()) {
            map2.putAll(mapA);
            mapA = null;
        }
        this.f625a.f0().e(com.applovin.impl.sdk.network.d.b().d(d()).a(c()).a(a(r1Var, zContains)).b(mapA).c(map2).c(((Boolean) this.f625a.a(v4.D5)).booleanValue()).a(((Boolean) this.f625a.a(v4.a5)).booleanValue()).d(z).a(s4.a.a(((Integer) this.f625a.a(v4.k5)).intValue())).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, ?> map, Map<String, Object> map2) {
        if (TextUtils.isEmpty(str)) {
            a("Unable to track empty event");
        } else if (this.f625a.c(v4.A0).contains(str)) {
            c(str, map, map2);
        } else {
            a(str, map);
        }
    }

    private String b() {
        return ((String) this.f625a.a(v4.u0)) + "v1/app";
    }

    private String c() {
        return ((String) this.f625a.a(v4.t0)) + "4.0/pix";
    }

    private void a(String str) {
        o.h("AppLovinEventService", str);
        if (k7.c(this.f625a)) {
            throw new IllegalArgumentException(str);
        }
    }

    private Map a(r1 r1Var, boolean z, boolean z2) {
        Map mapA = this.f625a.B().a((Map) null, z, false);
        mapA.put("event_id", r1Var.b());
        mapA.put("ts", Long.toString(r1Var.a()));
        if (z2) {
            mapA.put("event", r1Var.c());
        } else {
            mapA.put("event", "postinstall");
            mapA.put("sub_event", r1Var.c());
        }
        return k7.a(mapA);
    }

    private Map a(r1 r1Var, boolean z) {
        HashMap map = new HashMap();
        if (z) {
            map.put("AppLovin-Event", r1Var.c());
        } else {
            map.put("AppLovin-Event", "postinstall");
            map.put("AppLovin-Sub-Event", r1Var.c());
        }
        return map;
    }

    private Map a(String str, Map map, Map map2) {
        HashMap map3 = new HashMap();
        r1 r1Var = new r1(str, map);
        map3.put("id", r1Var.b());
        map3.put("name", r1Var.c());
        map3.put("data", r1Var.d());
        map3.put("timestamp", h1.a(r1Var.a()));
        Map mapE = this.f625a.B().E();
        map3.put("app_info", mapE);
        map3.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, this.f625a.B().o());
        CollectionUtils.putObjectToStringIfValid("dedupe_id", map2.get("dedupe_id"), map3);
        HashMap map4 = new HashMap();
        map4.put("connectEventKey", this.f625a.r());
        CollectionUtils.putStringIfValid("eventId", this.f625a.F(), map4);
        map4.put("version", AppLovinSdk.VERSION);
        map4.put("sdk_key", this.f625a.j0());
        map4.put("platform", this.f625a.B().y());
        if (((Boolean) this.f625a.a(v4.G3)).booleanValue()) {
            CollectionUtils.putStringIfValid("art", this.f625a.s(), map4);
        }
        HashMap map5 = new HashMap();
        map5.put("firstVisitTs", mapE.get("ia_v2"));
        map5.put("lastVisitTs", mapE.get("last_launch_ms"));
        map5.put("visitCount", mapE.get("app_launch_count"));
        map5.put("currentVisitStartTs", mapE.get("alts_ms"));
        map4.put("visitInfo", map5);
        map3.put("axon", map4);
        return map3;
    }

    private String a() {
        return ((String) this.f625a.a(v4.v0)) + "v1/app";
    }
}
