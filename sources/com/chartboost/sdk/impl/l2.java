package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.playon.bridge.Ad;
import com.safedk.android.internal.partials.ChartboostNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020\u0001¢\u0006\u0004\b+\u0010,J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0014\u0010\n\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u0016J\u0014\u0010\f\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0016J\u0014\u0010\u000f\u001a\u00020\r*\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0017J\u0014\u0010\u0013\u001a\u00020\u0011*\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0018J\u0014\u0010\u0015\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ/\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010!J'\u0010\"\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u001dJ/\u0010\u001e\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010!J'\u0010$\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u001dJ1\u0010\u001e\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010&J9\u0010\u001c\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010(J1\u0010\u001c\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010&¨\u0006-"}, d2 = {"Lcom/chartboost/sdk/impl/l2;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/p2;", com.ironsource.b9.h.K, "adTypeName", "a", "(Lcom/chartboost/sdk/impl/p2;Ljava/lang/String;Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "currentTime", "(Lcom/chartboost/sdk/impl/p2;FLjava/lang/String;Ljava/lang/String;)V", "d", "duration", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "function", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/p2;Ljava/lang/String;Ljava/lang/String;)V", Ad.VERIFICATIONPARAM, "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/p2;Ljava/lang/String;Ljava/lang/String;)V", "url", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class l2 implements m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m4 f1065a;

    public l2(m4 eventTracker) {
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.f1065a = eventTracker;
    }

    public final void c(p2 webview, String location, String adTypeName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        b(h7.VIDEO_ENDED.getCmdName(), webview, location, adTypeName);
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.f1065a.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f1065a.clearFromStorage(kaVar);
    }

    public final void d(p2 webview, String location, String adTypeName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        b(h7.VIDEO_FAILED.getCmdName(), webview, location, adTypeName);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f1065a.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.f1065a.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.f1065a.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.f1065a.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1065a.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1065a.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f1065a.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f1065a.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1065a.mo4741track(event);
    }

    public final void b(String function, p2 webview, String location, String adTypeName) {
        a("javascript:Chartboost.EventHandler.handleNativeEvent(\"" + function + "\")", webview, location, adTypeName);
    }

    public final void b(p2 webview, String location, String adTypeName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        b(h7.ON_FOREGROUND.getCmdName(), webview, location, adTypeName);
    }

    public final void a(String url, p2 webview, String location, String adTypeName) {
        try {
            if (webview == null) {
                track((ka) new r3(ma.i.WEBVIEW_ERROR, "Webview is null", adTypeName, location, null, null, 48, null));
                b7.b("Calling native to javascript webview is null", null, 2, null);
            } else {
                b7.a("Calling native to javascript: " + url, (Throwable) null, 2, (Object) null);
                ChartboostNetworkBridge.webviewLoadUrl(webview, url);
            }
        } catch (Exception e) {
            track((ka) new r3(ma.i.WEBVIEW_CRASH, "Cannot open url: " + e, adTypeName, location, null, null, 48, null));
            b7.b("Calling native to javascript. Cannot open url", e);
        }
    }

    public final void b(p2 webview, float duration, String location, String adTypeName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("totalDuration", Float.valueOf(duration));
        String cmdName = h7.VIDEO_STARTED.getCmdName();
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        a(cmdName, string, webview, location, adTypeName);
    }

    public final void a(String function, String param, p2 webview, String location, String adTypeName) {
        a("javascript:Chartboost.EventHandler.handleNativeEvent(\"" + function + "\", " + param + ')', webview, location, adTypeName);
    }

    public final void a(p2 webview, String location, String adTypeName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        b(h7.ON_BACKGROUND.getCmdName(), webview, location, adTypeName);
    }

    public final void a(p2 webview, float currentTime, String location, String adTypeName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("seconds", Float.valueOf(currentTime));
        String cmdName = h7.PLAYBACK_TIME.getCmdName();
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        a(cmdName, string, webview, location, adTypeName);
    }
}
