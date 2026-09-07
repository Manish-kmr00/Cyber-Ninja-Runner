package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b6\u00107J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\fJ\u0014\u0010\u000b\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\u0017J\u0014\u0010\r\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\r\u0010\u0017J\u0014\u0010\u0010\u001a\u00020\u000e*\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0018J\u0014\u0010\u0014\u001a\u00020\u0012*\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u0014\u0010\u0016\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001c\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\u001c\u0010\"J#\u0010\u001c\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b\u001c\u0010%R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/chartboost/sdk/impl/t6;", "Lcom/chartboost/sdk/impl/i2$a;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/m3;", "callback", "a", "(Lcom/chartboost/sdk/impl/m3;)V", "Lcom/chartboost/sdk/impl/i2;", "request", "Lorg/json/JSONObject;", "response", "(Lcom/chartboost/sdk/impl/i2;Lorg/json/JSONObject;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/impl/i2;Lcom/chartboost/sdk/internal/Model/CBError;)V", "Lcom/chartboost/sdk/impl/g2;", "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/d9;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "d", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "e", "Lcom/chartboost/sdk/impl/m3;", "<init>", "(Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/d9;Lcom/chartboost/sdk/impl/m4;Lcom/chartboost/sdk/internal/Networking/EndpointRepository;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class t6 implements i2.a, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final d9 requestBodyBuilder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final EndpointRepository endpointRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public m3 callback;

    public t6(g2 networkService, d9 requestBodyBuilder, m4 eventTracker, EndpointRepository endpointRepository) {
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(requestBodyBuilder, "requestBodyBuilder");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(endpointRepository, "endpointRepository");
        this.networkService = networkService;
        this.requestBodyBuilder = requestBodyBuilder;
        this.eventTracker = eventTracker;
        this.endpointRepository = endpointRepository;
    }

    public final void a(m3 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        URL endPointUrl = this.endpointRepository.getEndPointUrl(EndpointRepository.EndPoint.CONFIG);
        String strA = com.chartboost.sdk.internal.Networking.b.a(endPointUrl);
        String path = endPointUrl.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "url.path");
        i2 i2Var = new i2(strA, path, this.requestBodyBuilder.a(), k8.HIGH, this, this.eventTracker);
        i2Var.checkStatusInResponseBody = true;
        this.networkService.a(i2Var);
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.eventTracker.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.eventTracker.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.eventTracker.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.eventTracker.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.eventTracker.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.eventTracker.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventTracker.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventTracker.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.eventTracker.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.eventTracker.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventTracker.mo4741track(event);
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public void a(i2 request, CBError error) {
        String errorDesc;
        if (error == null || (errorDesc = error.getErrorDesc()) == null) {
            errorDesc = "Config failure";
        }
        track((ka) new j4(ma.f.CONFIG_REQUEST_ERROR, errorDesc, null, null, null, 28, null));
        m3 m3Var = this.callback;
        if (m3Var != null) {
            m3Var.a(errorDesc);
        }
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public void a(i2 request, JSONObject response) {
        JSONObject configJson = z1.a(response, "response");
        m3 m3Var = this.callback;
        if (m3Var != null) {
            Intrinsics.checkNotNullExpressionValue(configJson, "configJson");
            m3Var.a(configJson);
        }
    }
}
