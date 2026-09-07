package com.inmobi.media;

import android.os.SystemClock;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.yandex.div.core.DivActionHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class R5 {
    public static void a(final N5 funnelState, Z5 z5, Integer num, Function2 function2) {
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        if (z5 == null || funnelState.c <= z5.f) {
            return;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("plType", z5.f3254a.c);
        linkedHashMap.put("impressionId", z5.f3254a.b);
        linkedHashMap.put("plId", Long.valueOf(z5.f3254a.f3266a));
        linkedHashMap.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, z5.f3254a.d);
        linkedHashMap.put("markupType", z5.f3254a.e);
        linkedHashMap.put("creativeType", z5.f3254a.f);
        linkedHashMap.put("metadataBlob", z5.f3254a.g);
        linkedHashMap.put("isRewarded", Boolean.valueOf(z5.f3254a.h));
        String str = z5.g;
        if (str == null) {
            str = z5.f3254a.i;
        }
        linkedHashMap.put(DivActionHandler.DivActionReason.TRIGGER, str);
        linkedHashMap.put("urlType", z5.b);
        if (num != null) {
            linkedHashMap.put("errorCode", num);
        }
        long j = z5.d;
        if (j != 0) {
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            linkedHashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        z5.f = funnelState.c;
        ((ScheduledThreadPoolExecutor) S3.b.getValue()).submit(new Runnable() { // from class: com.inmobi.media.R5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                R5.a(linkedHashMap, funnelState);
            }
        });
        if (z5.c > ((TelemetryConfig.LandingPageConfig) z5.e.getValue()).getMaxFunnelsToTrackPerAd() || function2 == null) {
            return;
        }
        String str2 = funnelState.b;
        String str3 = z5.g;
        if (str3 == null) {
            str3 = z5.f3254a.i;
        }
        function2.invoke(str2, MapsKt.mapOf(TuplesKt.to("$OPENMODE", str3), TuplesKt.to("$URLTYPE", z5.b)));
    }

    public static String a(String str) {
        if (str == null || str.length() == 0 || !StringsKt.contains$default((CharSequence) str, (CharSequence) "://", false, 2, (Object) null)) {
            return "invalid";
        }
        if (StringsKt.startsWith(str, "inmobideeplink://", true)) {
            return "inmobideeplink";
        }
        if (StringsKt.startsWith(str, "inmobinativebrowser://", true)) {
            return "inmobinativebrowser";
        }
        if (StringsKt.startsWith(str, "https://", true)) {
            return "https";
        }
        if (StringsKt.startsWith(str, com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v, true)) {
            return "http";
        }
        return StringsKt.startsWith(str, "market://", true) ? ApsAdWebViewSupportClient.MARKET_SCHEME : "deeplink";
    }

    public static /* synthetic */ void a(N5 n5, Z5 z5, Integer num, int i) {
        if ((i & 4) != 0) {
            num = null;
        }
        a(n5, z5, num, (Function2) null);
    }

    public static final void a(Map keyValueMap, N5 funnelState) {
        Intrinsics.checkNotNullParameter(keyValueMap, "$keyValueMap");
        Intrinsics.checkNotNullParameter(funnelState, "$funnelState");
        keyValueMap.put("networkType", C3435k3.q());
        String str = funnelState.f3145a;
        Ob ob = Ob.f3160a;
        Ob.b(str, keyValueMap, Sb.SDK);
    }
}
