package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class Ob implements InterfaceC3585u9, InterfaceC3458la, InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ob f3160a;
    public static final String b;
    public static final List c;
    public static final AtomicBoolean d;
    public static volatile TelemetryConfig e;
    public static M3 f;
    public static volatile C3318bc g;
    public static final Nb h;
    public static Xb i;

    static {
        Ob ob = new Ob();
        f3160a = ob;
        Intrinsics.checkNotNullExpressionValue("Ob", "getSimpleName(...)");
        b = "Ob";
        List listMutableListOf = CollectionsKt.mutableListOf("AdLoadCalled", "AdLoadDroppedAtSDK", "AdLoadSuccessful", "AdLoadFailed", "ServerFill", "ServerNoFill", "ServerError", "AssetDownloaded", "AdShowCalled", "AdShowSuccessful", "AdShowFailed", "AdGetSignalsCalled", "AdGetSignalsSucceeded", "AdGetSignalsFailed", "UnifiedIdNetworkCallRequested", "UnifiedIdNetworkResponseFailure", "FetchApiInvoked", "FetchCallbackFailure", "AdImpressionSuccessful", "RenderSuccess", "ParseSuccess", "PageStarted", "WebViewLoadFinished", "FireAdReady", "WebViewLoadCalled", "FireAdFailed", "ResourceCacheMiss", "ResourceCacheHit", "ResourceDiskCacheFileMissing", "ResourceDiskCacheFileEvicted", "LowAvailableSpaceForCache", "WebViewRenderProcessGoneEvent", "clickStartCalled", "landingsStartSuccess", "landingsStartFailed", "browserOpenFailed", "landingsPageStarted", "landingsCompleteSuccess", "landingsCompleteFailed", "ImmersiveNotSupported", "AdNotReady", "IAPFetchFailed", "BillingClientConnectionError", "BillingClientNotCompatible");
        c = listMutableListOf;
        d = new AtomicBoolean(false);
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("telemetry", C3517pb.b(), ob);
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig");
        e = (TelemetryConfig) configA;
        TelemetryConfig telemetryConfig = e;
        g = new C3318bc(new Rb(telemetryConfig.getEnabled(), telemetryConfig.getAssetReporting().isImageEnabled(), telemetryConfig.getAssetReporting().isGifEnabled(), telemetryConfig.getAssetReporting().isVideoEnabled(), telemetryConfig.getDisableAllGeneralEvents(), telemetryConfig.getPriorityEventsList(), telemetryConfig.getSamplingFactor()), CollectionsKt.toList(listMutableListOf));
        h = Nb.f3150a;
    }

    public static final void b(final String eventType, final Map keyValueMap, final Sb telemetryEventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
        Intrinsics.checkNotNullParameter(telemetryEventType, "telemetryEventType");
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.Ob$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ob.c(eventType, keyValueMap, telemetryEventType);
            }
        });
    }

    public static final void c() {
        if (d.getAndSet(true)) {
            return;
        }
        Ob ob = f3160a;
        if (D1.a((D1) AbstractC3415ib.e()) > 0) {
            ob.b();
        }
        C3517pb.f().a(new int[]{2, 1}, h);
        i = new Xb(e);
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof TelemetryConfig) {
            TelemetryConfig telemetryConfig = (TelemetryConfig) config;
            e = telemetryConfig;
            g = new C3318bc(new Rb(telemetryConfig.getEnabled(), telemetryConfig.getAssetReporting().isImageEnabled(), telemetryConfig.getAssetReporting().isGifEnabled(), telemetryConfig.getAssetReporting().isVideoEnabled(), telemetryConfig.getDisableAllGeneralEvents(), telemetryConfig.getPriorityEventsList(), telemetryConfig.getSamplingFactor()), CollectionsKt.toList(c));
            Xb xb = i;
            if (xb != null) {
                Intrinsics.checkNotNullParameter(telemetryConfig, "telemetryConfig");
                xb.f3238a = telemetryConfig;
            }
        }
    }

    public final void b() {
        if (d.get()) {
            J3 eventConfig = e.getEventConfig();
            eventConfig.k = e.getTelemetryUrl();
            M3 m3 = f;
            if (m3 == null) {
                f = new M3(AbstractC3415ib.e(), this, eventConfig, this);
            } else {
                Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
                m3.i = eventConfig;
            }
            M3 m4 = f;
            if (m4 != null) {
                J3 j3 = m4.i;
                if (m4.f.get() || j3 == null) {
                    return;
                }
                m4.a(j3.c, true);
            }
        }
    }

    public static final void c(String eventType, Map keyValueMap, Sb telemetryEventType) {
        String str;
        Intrinsics.checkNotNullParameter(eventType, "$eventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "$keyValueMap");
        Intrinsics.checkNotNullParameter(telemetryEventType, "$telemetryEventType");
        Objects.toString(keyValueMap);
        try {
            if (g == null) {
                return;
            }
            Ob ob = f3160a;
            if (a(eventType, keyValueMap, telemetryEventType)) {
                return;
            }
            C3318bc c3318bc = g;
            if (c3318bc == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTelemetryValidator");
                c3318bc = null;
            }
            int iA = c3318bc.a(telemetryEventType, eventType);
            if (iA == 0) {
                keyValueMap.put("samplingRate", Integer.valueOf(MathKt.roundToInt((((double) 1) - e.getSamplingFactor()) * ((double) 100))));
            } else if (iA != 1) {
                return;
            } else {
                keyValueMap.put("samplingRate", 100);
            }
            int iOrdinal = telemetryEventType.ordinal();
            if (iOrdinal == 0) {
                str = "sdk";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "template";
            }
            Vb vb = new Vb(eventType, null, str);
            keyValueMap.put("eventType", vb.f3054a);
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            keyValueMap.put("eventId", string);
            keyValueMap.put("isTemplateEvent", Boolean.valueOf(telemetryEventType == Sb.TEMPLATE));
            String payload = new JSONObject(keyValueMap).toString();
            Intrinsics.checkNotNullExpressionValue(payload, "toString(...)");
            Intrinsics.checkNotNullParameter(payload, "payload");
            vb.d = payload;
            int iA2 = (D1.a((D1) AbstractC3415ib.e()) + 1) - e.getMaxEventsToPersist();
            if (iA2 > 0) {
                AbstractC3415ib.e().a(iA2);
                int iA3 = Tb.a() + iA2;
                if (iA3 != -1) {
                    Tb.b = iA3;
                    K5 k5 = Tb.f3205a;
                    if (k5 != null) {
                        k5.a("count", iA3);
                    }
                }
            }
            AbstractC3415ib.e().a(vb);
            ob.b();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x009e  */
    public static boolean a(String eventType, Map keyValueMap, Sb telemetryEventType) {
        boolean z;
        C3318bc c3318bc = g;
        if (c3318bc == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTelemetryValidator");
            c3318bc = null;
        }
        c3318bc.getClass();
        Intrinsics.checkNotNullParameter(telemetryEventType, "telemetryEventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (c3318bc.f3278a.f3185a) {
            int iOrdinal = telemetryEventType.ordinal();
            if (iOrdinal == 0) {
                C3429jb c3429jb = c3318bc.b;
                c3429jb.getClass();
                Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
                Intrinsics.checkNotNullParameter(eventType, "eventType");
                Rb rb = c3429jb.f3349a;
                if ((rb.e && !rb.f.contains(eventType)) || (!keyValueMap.isEmpty() && Intrinsics.areEqual(eventType, "AssetDownloaded") && keyValueMap.containsKey("assetType") && ((Intrinsics.areEqual("image", keyValueMap.get("assetType")) && !c3429jb.f3349a.b) || ((Intrinsics.areEqual("gif", keyValueMap.get("assetType")) && !c3429jb.f3349a.c) || (Intrinsics.areEqual("video", keyValueMap.get("assetType")) && !c3429jb.f3349a.d))))) {
                    z = false;
                }
            } else if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @Override // com.inmobi.media.InterfaceC3585u9
    public final L3 a() {
        int iA;
        String string;
        if (C3435k3.f3355a.p() == 1) {
            iA = e.getWifiConfig().a();
        } else {
            iA = e.getMobileConfig().a();
        }
        List<Vb> mutableList = CollectionsKt.toMutableList((Collection) AbstractC3415ib.e().b(iA));
        if (!a("DatabaseMaxLimitReachedV2", MapsKt.emptyMap(), Sb.SDK) && mutableList.size() < iA && Tb.a() > 0) {
            int iA2 = Tb.a();
            Vb vb = new Vb("DatabaseMaxLimitReachedV2", null, "sdk");
            String string2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("eventId", string2), TuplesKt.to("eventType", "DatabaseMaxLimitReachedV2"), TuplesKt.to("samplingRate", 100), TuplesKt.to("isTemplateEvent", Boolean.FALSE), TuplesKt.to("eventLostCount", Integer.valueOf(iA2)));
            Intrinsics.checkNotNull(mapHashMapOf, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            String payload = new JSONObject(mapHashMapOf).toString();
            Intrinsics.checkNotNullExpressionValue(payload, "toString(...)");
            Intrinsics.checkNotNullParameter(payload, "payload");
            vb.d = payload;
            Tb.c = Integer.valueOf(vb.c);
            mutableList.add(vb);
        }
        if (!mutableList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((Vb) it.next()).c));
            }
            try {
                String strB = C3517pb.b();
                if (strB == null) {
                    strB = "";
                }
                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("im-accid", strB), TuplesKt.to("version", "4.0.0"), TuplesKt.to("mk-version", C3531qb.a()), TuplesKt.to("u-appbid", O0.f3153a), TuplesKt.to("tp", C3531qb.d()));
                String strF = C3531qb.f();
                if (strF != null) {
                    mapMutableMapOf.put("tp-v", strF);
                }
                Intrinsics.checkNotNull(mapMutableMapOf, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                JSONObject jSONObject = new JSONObject(mapMutableMapOf);
                JSONArray jSONArray = new JSONArray();
                for (Vb vb2 : mutableList) {
                    if (StringsKt.trim((CharSequence) vb2.a()).toString().length() > 0) {
                        jSONArray.put(new JSONObject(vb2.a()));
                    }
                }
                jSONObject.put("payload", jSONArray);
                string = jSONObject.toString();
            } catch (JSONException unused) {
                string = null;
            }
            if (string != null) {
                return new L3(arrayList, string);
            }
        }
        return null;
    }
}
