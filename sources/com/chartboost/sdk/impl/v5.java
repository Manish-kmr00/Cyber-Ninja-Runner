package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.smaato.sdk.video.vast.model.Ad;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010C\u001a\u00020A\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010Y\u001a\u00020V\u0012\b\u0010]\u001a\u0004\u0018\u00010Z\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u0010e\u001a\u00020b\u0012\u0006\u0010i\u001a\u00020f\u0012\u001a\u0010n\u001a\u0016\u0012\u0004\u0012\u00020k\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u0002030j\u0012\u0006\u0010q\u001a\u00020\u0001\u0012\u0006\u0010u\u001a\u00020r¢\u0006\u0004\bv\u0010wJ \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0014\u0010\n\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u0016J\u0014\u0010\f\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0016J\u0014\u0010\u000f\u001a\u00020\r*\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0017J\u0014\u0010\u0013\u001a\u00020\u0011*\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0018J\u0014\u0010\u0015\u001a\u00020\b*\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016Ja\u0010.\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b.\u0010/Jq\u0010.\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00101\u001a\u0002002\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b.\u00104J\u001f\u0010.\u001a\u0002082\u0006\u00105\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b.\u00109J\u0017\u0010.\u001a\u0002082\u0006\u00105\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010:J)\u0010.\u001a\u0004\u0018\u00010=2\u0006\u00101\u001a\u0002002\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010>J1\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020+2\u0006\u00101\u001a\u0002002\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010?J\u001f\u0010.\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u0007R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u0004\u0018\u00010Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR(\u0010n\u001a\u0016\u0012\u0004\u0012\u00020k\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u0002030j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010q\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006x"}, d2 = {"Lcom/chartboost/sdk/impl/v5;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/y0;", "appRequest", "Lcom/chartboost/sdk/impl/j0;", "callback", "Landroid/view/ViewGroup;", "bannerView", "Lcom/chartboost/sdk/impl/j6;", "impressionIntermediateCallback", "Lcom/chartboost/sdk/impl/x5;", "impressionClickCallback", "Lcom/chartboost/sdk/impl/p6;", "viewProtocolBuilder", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lcom/chartboost/sdk/impl/yb;", "webViewTimeoutInterface", "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "Lcom/chartboost/sdk/impl/aa;", "templateLoader", "Lcom/chartboost/sdk/impl/h6;", "a", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/j0;Landroid/view/ViewGroup;Lcom/chartboost/sdk/impl/j6;Lcom/chartboost/sdk/impl/x5;Lcom/chartboost/sdk/impl/p6;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/yb;Lcom/chartboost/sdk/impl/g7;Lcom/chartboost/sdk/impl/aa;)Lcom/chartboost/sdk/impl/h6;", "Lcom/chartboost/sdk/impl/v;", "adUnit", "templateHtml", "Lcom/chartboost/sdk/impl/y1;", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/v;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/j0;Landroid/view/ViewGroup;Lcom/chartboost/sdk/impl/j6;Lcom/chartboost/sdk/impl/x5;Lcom/chartboost/sdk/impl/p6;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/yb;Lcom/chartboost/sdk/impl/g7;)Lcom/chartboost/sdk/impl/y1;", "adUnitMediaType", "Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "Lcom/chartboost/sdk/impl/k6;", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/u;)Lcom/chartboost/sdk/impl/k6;", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/k6;", "Ljava/io/File;", "baseDir", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "(Lcom/chartboost/sdk/impl/v;Ljava/io/File;Ljava/lang/String;)Lcom/chartboost/sdk/internal/Model/CBError$b;", "(Lcom/chartboost/sdk/impl/aa;Lcom/chartboost/sdk/impl/v;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;", "assetFilename", "Lcom/chartboost/sdk/impl/f5;", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/g4;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/za;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/za;", "urlResolver", "Lcom/chartboost/sdk/impl/w6;", "d", "Lcom/chartboost/sdk/impl/w6;", "intentResolver", "e", "Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/g2;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/d9;", "g", "Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", "Lcom/chartboost/sdk/Mediation;", "h", "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/t7;", "i", "Lcom/chartboost/sdk/impl/t7;", "measurementManager", "Lcom/chartboost/sdk/impl/j9;", "j", "Lcom/chartboost/sdk/impl/j9;", "sdkBiddingTemplateParser", "Lcom/chartboost/sdk/impl/s7;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lkotlin/Function2;", "Lcom/chartboost/sdk/impl/e6;", "l", "Lkotlin/jvm/functions/Function2;", "impressionFactory", "m", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "n", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "<init>", "(Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/g4;Lcom/chartboost/sdk/impl/za;Lcom/chartboost/sdk/impl/w6;Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/d9;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/t7;Lcom/chartboost/sdk/impl/j9;Lcom/chartboost/sdk/impl/s7;Lkotlin/jvm/functions/Function2;Lcom/chartboost/sdk/impl/m4;Lcom/chartboost/sdk/internal/Networking/EndpointRepository;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v5 implements m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final g4 downloader;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final za urlResolver;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final w6 intentResolver;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final u adType;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final d9 requestBodyBuilder;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final t7 measurementManager;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final j9 sdkBiddingTemplateParser;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final s7 openMeasurementImpressionCallback;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Function2<e6, ViewGroup, y1> impressionFactory;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final EndpointRepository endpointRepository;

    /* JADX WARN: Multi-variable type inference failed */
    public v5(f5 fileCache, g4 downloader, za urlResolver, w6 intentResolver, u adType, g2 networkService, d9 requestBodyBuilder, Mediation mediation, t7 measurementManager, j9 sdkBiddingTemplateParser, s7 openMeasurementImpressionCallback, Function2<? super e6, ? super ViewGroup, y1> impressionFactory, m4 eventTracker, EndpointRepository endpointRepository) {
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(urlResolver, "urlResolver");
        Intrinsics.checkNotNullParameter(intentResolver, "intentResolver");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(requestBodyBuilder, "requestBodyBuilder");
        Intrinsics.checkNotNullParameter(measurementManager, "measurementManager");
        Intrinsics.checkNotNullParameter(sdkBiddingTemplateParser, "sdkBiddingTemplateParser");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(impressionFactory, "impressionFactory");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(endpointRepository, "endpointRepository");
        this.fileCache = fileCache;
        this.downloader = downloader;
        this.urlResolver = urlResolver;
        this.intentResolver = intentResolver;
        this.adType = adType;
        this.networkService = networkService;
        this.requestBodyBuilder = requestBodyBuilder;
        this.mediation = mediation;
        this.measurementManager = measurementManager;
        this.sdkBiddingTemplateParser = sdkBiddingTemplateParser;
        this.openMeasurementImpressionCallback = openMeasurementImpressionCallback;
        this.impressionFactory = impressionFactory;
        this.eventTracker = eventTracker;
        this.endpointRepository = endpointRepository;
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

    public final k6 a(String adUnitMediaType, u adType) {
        if (Intrinsics.areEqual(adType, u.b.g)) {
            return a(adUnitMediaType);
        }
        if (Intrinsics.areEqual(adType, u.c.g)) {
            return k6.INTERSTITIAL_REWARD_VIDEO;
        }
        if (Intrinsics.areEqual(adType, u.a.g)) {
            return k6.BANNER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final CBError.b a(v adUnit, File baseDir, String location) {
        Map<String, c1> mapD = adUnit.d();
        if (mapD.isEmpty()) {
            return null;
        }
        for (c1 c1Var : mapD.values()) {
            File fileA = c1Var.a(baseDir);
            if (fileA == null || !fileA.exists()) {
                b7.b("Asset does not exist: " + c1Var.b, null, 2, null);
                String str = c1Var.b;
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "asset.filename ?: \"\"");
                }
                a(location, str);
                return CBError.b.ASSET_MISSING;
            }
        }
        return null;
    }

    public final h6 a(y0 appRequest, j0 callback, ViewGroup bannerView, j6 impressionIntermediateCallback, x5 impressionClickCallback, p6 viewProtocolBuilder, i6 impressionInterface, yb webViewTimeoutInterface, g7 nativeBridgeCommand, aa templateLoader) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(impressionIntermediateCallback, "impressionIntermediateCallback");
        Intrinsics.checkNotNullParameter(impressionClickCallback, "impressionClickCallback");
        Intrinsics.checkNotNullParameter(viewProtocolBuilder, "viewProtocolBuilder");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(webViewTimeoutInterface, "webViewTimeoutInterface");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        Intrinsics.checkNotNullParameter(templateLoader, "templateLoader");
        try {
            File baseDir = this.fileCache.a().a();
            v adUnit = appRequest.getAdUnit();
            String location = appRequest.getLocation();
            if (adUnit == null) {
                return new h6(null, CBError.b.PENDING_IMPRESSION_ERROR);
            }
            Intrinsics.checkNotNullExpressionValue(baseDir, "baseDir");
            CBError.b bVarA = a(adUnit, baseDir, location);
            if (bVarA != null) {
                return new h6(null, bVarA);
            }
            String strA = a(templateLoader, adUnit, baseDir, location);
            if (strA == null) {
                return new h6(null, CBError.b.ERROR_LOADING_WEB_VIEW);
            }
            return new h6(a(appRequest, adUnit, location, this.measurementManager.a(strA), callback, bannerView, impressionIntermediateCallback, impressionClickCallback, viewProtocolBuilder, impressionInterface, webViewTimeoutInterface, nativeBridgeCommand), null);
        } catch (Exception e) {
            b7.b("showReady exception:", e);
            return new h6(null, CBError.b.INTERNAL);
        }
    }

    public final y1 a(y0 appRequest, v adUnit, String location, String templateHtml, j0 callback, ViewGroup bannerView, j6 impressionIntermediateCallback, x5 impressionClickCallback, p6 viewProtocolBuilder, i6 impressionInterface, yb webViewTimeoutInterface, g7 nativeBridgeCommand) {
        k6 k6VarA = a(adUnit.getCom.smaato.sdk.video.vast.model.MediaFile.MEDIA_TYPE java.lang.String(), this.adType);
        c3 c3Var = new c3(this.networkService, this.requestBodyBuilder, this.eventTracker, this.endpointRepository);
        k3 k3Var = new k3(this.networkService, this.requestBodyBuilder, this.eventTracker, this.endpointRepository);
        o2 o2VarA = viewProtocolBuilder.a(location, adUnit, this.adType.getName(), templateHtml, callback, impressionInterface, webViewTimeoutInterface, nativeBridgeCommand);
        return this.impressionFactory.invoke(new e6(this.urlResolver, this.intentResolver, c3Var, fa.a(this.adType.getName(), location, this.mediation, this.eventTracker), k3Var, k6VarA, this.openMeasurementImpressionCallback, appRequest, this.downloader, o2VarA, new d6(0, 0, 0, 0, 15, null), adUnit, this.adType, location, impressionIntermediateCallback, impressionClickCallback, callback, this.eventTracker), bannerView);
    }

    public final String a(aa templateLoader, v adUnit, File baseDir, String location) {
        c1 body = adUnit.getBody();
        String strA = body.a();
        if (strA != null && strA.length() != 0) {
            File htmlFile = body.a(baseDir);
            HashMap map = new HashMap(adUnit.s());
            if (adUnit.getTemplateParams().length() > 0 && adUnit.getAdm().length() > 0) {
                j9 j9Var = this.sdkBiddingTemplateParser;
                Intrinsics.checkNotNullExpressionValue(htmlFile, "htmlFile");
                String strA2 = j9Var.a(htmlFile, adUnit.getTemplateParams(), adUnit.getAdm());
                if (strA2 != null) {
                    return strA2;
                }
            }
            if (adUnit.getIo.bidmachine.unified.UnifiedMediationParams.KEY_VIDEO_URL java.lang.String().length() == 0 || adUnit.getVideoFilename().length() == 0) {
                map.put("{% native_video_player %}", "false");
            } else {
                map.put("{% native_video_player %}", "true");
            }
            Iterator<T> it = adUnit.d().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                map.put(entry.getKey(), ((c1) entry.getValue()).b);
            }
            Intrinsics.checkNotNullExpressionValue(htmlFile, "htmlFile");
            return templateLoader.a(htmlFile, map, this.adType.getName(), location);
        }
        b7.b("AdUnit does not have a template body", null, 2, null);
        return null;
    }

    public final k6 a(String adUnitMediaType) {
        if (Intrinsics.areEqual(adUnitMediaType, "video")) {
            return k6.INTERSTITIAL_VIDEO;
        }
        return k6.INTERSTITIAL;
    }

    public final void a(String location, String assetFilename) {
        track((ka) new r3(ma.i.UNAVAILABLE_ASSET_ERROR, assetFilename, this.adType.getName(), location, this.mediation, null, 32, null));
    }
}
