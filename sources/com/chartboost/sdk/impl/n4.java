package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130*\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0*\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0*\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002000*\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u0002020*\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u0002050*\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u0002070*¢\u0006\u0004\bH\u0010IJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0017J\u0013\u0010\u0011\u001a\u00020\u000f*\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0018J\u0013\u0010\u0015\u001a\u00020\u0013*\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0019J\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0017J\u0013\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u0007J\u0013\u0010\u001d\u001a\u00020\u0005*\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u0007J\u0013\u0010\u001f\u001a\u00020\u001e*\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010\u001a\u001a\u00020!*\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\"J\u0019\u0010#\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b#\u0010\u0007J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0007J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0007J\u001d\u0010\u001a\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002¢\u0006\u0004\b\u001a\u0010)R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020,0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020.0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010+R\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002000*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010+R\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010+R\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002050*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010+R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002070*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010+R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010:R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u00020\n*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010BR\u0018\u0010C\u001a\u00020\n*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010DR\u0014\u0010G\u001a\u00020E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010F¨\u0006J"}, d2 = {"Lcom/chartboost/sdk/impl/n4;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/l4;", "Lcom/chartboost/sdk/impl/ka;", "event", "", "track", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "clearFromStorage", "", "type", "location", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "g", "h", "", InneractiveMediationDefs.GENDER_FEMALE, "(Lcom/chartboost/sdk/impl/ka;)Z", "", "(Lcom/chartboost/sdk/impl/ka;)F", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "", "Lorg/json/JSONObject;", "requestBody", "(Ljava/util/List;)V", "Lkotlin/Lazy;", "Lkotlin/Lazy;", "Lcom/chartboost/sdk/impl/k4;", "throttler", "Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", "Lcom/chartboost/sdk/impl/l8;", "privacyApi", "Lcom/chartboost/sdk/impl/h4;", "e", "environment", "Lcom/chartboost/sdk/impl/oa;", "trackingRequest", "Lcom/chartboost/sdk/impl/la;", "trackingEventCache", "", "Ljava/util/Map;", "adsReference", "i", "references", "", "j", "Ljava/util/List;", "events", "(Lcom/chartboost/sdk/impl/da;)Ljava/lang/String;", "referenceKey", "(Lcom/chartboost/sdk/impl/ka;)Ljava/lang/String;", "Lcom/chartboost/sdk/impl/i4;", "()Lcom/chartboost/sdk/impl/i4;", "environmentData", "<init>", "(Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class n4 implements m4, l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Lazy<ia> config;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Lazy<? extends k4> throttler;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Lazy<? extends d9> requestBodyBuilder;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Lazy<? extends l8> privacyApi;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Lazy<h4> environment;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public Lazy<oa> trackingRequest;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public Lazy<la> trackingEventCache;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Map<String, da> adsReference;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Map<String, ka> references;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final List<ka> events;

    public n4(Lazy<ia> config, Lazy<? extends k4> throttler, Lazy<? extends d9> requestBodyBuilder, Lazy<? extends l8> privacyApi, Lazy<h4> environment, Lazy<oa> trackingRequest, Lazy<la> trackingEventCache) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(throttler, "throttler");
        Intrinsics.checkNotNullParameter(requestBodyBuilder, "requestBodyBuilder");
        Intrinsics.checkNotNullParameter(privacyApi, "privacyApi");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(trackingRequest, "trackingRequest");
        Intrinsics.checkNotNullParameter(trackingEventCache, "trackingEventCache");
        this.config = config;
        this.throttler = throttler;
        this.requestBodyBuilder = requestBodyBuilder;
        this.privacyApi = privacyApi;
        this.environment = environment;
        this.trackingRequest = trackingRequest;
        this.trackingEventCache = trackingEventCache;
        this.adsReference = new LinkedHashMap();
        this.references = new LinkedHashMap();
        this.events = new ArrayList();
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.references.remove(a(location, type));
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        mo4737clearFromStorage(kaVar);
        return kaVar;
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        mo4738persist(kaVar);
        return kaVar;
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        mo4739refresh(iaVar);
        return iaVar;
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        mo4740store(daVar);
        return daVar;
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        mo4741track(kaVar);
        return kaVar;
    }

    public final String e(ka kaVar) {
        return a(kaVar.getLocation(), kaVar.getImpressionAdType());
    }

    public final void g(ka event) {
        event.a(this.adsReference.get(e(event)));
        event.a(a(event));
        b(event);
        b7.a("Event: " + event, (Throwable) null, 2, (Object) null);
        h(event);
    }

    public final void h(ka kaVar) {
        if (f(kaVar)) {
            this.references.put(e(kaVar), kaVar);
        }
    }

    public final boolean f(ka kaVar) {
        ma name = kaVar.getName();
        return name == ma.a.START || name == ma.i.START;
    }

    public final float a(ka kaVar) {
        if (!kaVar.getShouldCalculateLatency()) {
            return kaVar.getLatency();
        }
        if (!kaVar.getIsLatencyEvent()) {
            return 0.0f;
        }
        try {
            ka kaVarRemove = this.references.remove(e(kaVar));
            if (kaVarRemove != null) {
                return (kaVar.getTimestamp() - kaVarRemove.getTimestamp()) / 1000.0f;
            }
            return -1.0f;
        } catch (Exception e) {
            b7.a("Cannot calculate latency", e);
            return -1.0f;
        }
    }

    public final void b(ka event) {
        Unit unit;
        if (event != null) {
            try {
                if (this.config.getValue().getPersistenceEnabled()) {
                    c(event);
                } else {
                    d(event);
                }
                unit = Unit.INSTANCE;
            } catch (Exception e) {
                b7.a("Cannot send tracking event", e);
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Cannot save empty event", (Throwable) null, 2, (Object) null);
        }
    }

    public final void c(ka event) {
        this.trackingEventCache.getValue().a(event, a(), this.config.getValue().getPersistenceMaxEvents());
        if (event.getCom.unity3d.ads.core.domain.HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY java.lang.String() == ka.a.HIGH) {
            a(this.trackingEventCache.getValue().a());
        }
    }

    public final void d(ka event) {
        this.events.add(event);
        if (event.getCom.unity3d.ads.core.domain.HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY java.lang.String() == ka.a.HIGH) {
            a(this.trackingEventCache.getValue().a(this.events, a()));
        }
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Unit unit;
        Intrinsics.checkNotNullParameter(event, "event");
        ia value = this.config.getValue();
        if (!value.getIsEnabled()) {
            b7.a("Tracking is disabled", (Throwable) null, 2, (Object) null);
            return;
        }
        if (value.a().contains(event.getName())) {
            b7.a("Event name " + event.getName() + " is black-listed", (Throwable) null, 2, (Object) null);
            return;
        }
        ka kaVarE = this.throttler.getValue().e(event);
        if (kaVarE != null) {
            g(kaVarE);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Event is throttled " + event, (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.adsReference.put(a(ad), ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = LazyKt.lazyOf(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.a(this.adsReference.get(e(event)));
        event.a(a(event));
        b7.a("Persist event: " + event, (Throwable) null, 2, (Object) null);
        this.trackingEventCache.getValue().a(event, a());
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.trackingEventCache.getValue().a(event);
    }

    public final void a(List<? extends JSONObject> requestBody) {
        this.trackingRequest.getValue().a(this.config.getValue().getEndpoint(), requestBody);
    }

    public final i4 a() {
        try {
            f9 f9VarA = this.requestBodyBuilder.getValue().a();
            return this.environment.getValue().a(f9VarA.c(), f9VarA.h(), f9VarA.g().getDetailedConnectionType(), this.privacyApi.getValue(), f9VarA.h);
        } catch (Exception e) {
            b7.a("Cannot create environment data for tracking", e);
            return new i4(null, 0, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 0, false, 0, 0L, 0L, 0, 0, 0, 0L, 0L, -1, null);
        }
    }

    public final String a(da daVar) {
        return daVar.getLocation() + daVar.getAdType();
    }

    public final String a(String location, String type) {
        return location + type;
    }
}
