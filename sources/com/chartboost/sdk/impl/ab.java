package com.chartboost.sdk.impl;

import android.content.Context;
import android.webkit.WebSettings;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0014\u0010\n\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u0016J\u0014\u0010\f\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0016J\u0014\u0010\u000f\u001a\u00020\r*\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0017J\u0014\u0010\u0013\u001a\u00020\u0011*\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0018J\u0014\u0010\u0015\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001eR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010!\"\u0004\b\"\u0010\u001e¨\u0006&"}, d2 = {"Lcom/chartboost/sdk/impl/ab;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Landroid/content/Context;", "context", "a", "(Landroid/content/Context;)V", "errorMsg", "(Ljava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "()Ljava/lang/String;", "setWebViewUserAgentValue", "webViewUserAgentValue", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class ab implements m4 {
    public static final ab b = new ab();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static String webViewUserAgentValue = "Invalid user-agent value";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m4 f970a = fa.a();

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.f970a.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f970a.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f970a.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.f970a.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.f970a.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f970a.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f970a.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f970a.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f970a.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f970a.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f970a.mo4741track(event);
    }

    public final void a(String errorMsg) {
        try {
            track((ka) new j4(ma.f.USER_AGENT_UPDATE_ERROR, errorMsg, null, null, null, 28, null));
        } catch (Exception e) {
            b7.b("sendUserAgentErrorTracking", e);
        }
    }

    public final void a(Context context) {
        String defaultUserAgent;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            defaultUserAgent = System.getProperty("http.agent");
        } catch (Exception e) {
            a(e.toString());
            defaultUserAgent = "";
        }
        try {
            defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        } catch (Exception e2) {
            a(e2.toString());
        }
        if (defaultUserAgent != null) {
            webViewUserAgentValue = defaultUserAgent;
        }
    }

    public final String a() {
        return webViewUserAgentValue;
    }
}
