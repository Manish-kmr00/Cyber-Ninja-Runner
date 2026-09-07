package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BO\u0012\u0006\u0010D\u001a\u00020B\u0012\u0006\u0010J\u001a\u00020E\u0012\u0006\u0010P\u001a\u00020K\u0012\u0006\u0010V\u001a\u00020Q\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010c\u001a\u00020\u0003\u0012\u0006\u0010g\u001a\u00020d¢\u0006\u0004\bn\u0010oJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u0014\u0010\f\u001a\u00020\n*\u00020\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0018J\u0014\u0010\u000e\u001a\u00020\n*\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u0018J\u0014\u0010\u0011\u001a\u00020\u000f*\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0019J\u0014\u0010\u0015\u001a\u00020\u0013*\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u001aJ\u0014\u0010\u0017\u001a\u00020\n*\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J:\u0010#\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u001dH\u0016¢\u0006\u0004\b#\u0010$J#\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b#\u0010)J#\u0010#\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b#\u0010,J)\u0010#\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020-2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u00100JG\u0010#\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00105\u001a\u0002042\u0006\u0010.\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b#\u00108J?\u0010#\u001a\u00020:2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00109\u001a\u0002012\u0006\u00105\u001a\u0002042\u0006\u0010.\u001a\u00020-2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b#\u0010;JG\u0010#\u001a\u00020<2\u0006\u0010\"\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u00109\u001a\u0002012\u0006\u0010.\u001a\u00020-2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b#\u0010=J\u001f\u0010#\u001a\u00020\u00072\u0006\u0010>\u001a\u00020/2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b#\u0010?J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010AR\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010CR\u0017\u0010J\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010P\u001a\u00020K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010V\u001a\u00020Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bj\u0010kR1\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006p"}, d2 = {"Lcom/chartboost/sdk/impl/m;", "Lcom/chartboost/sdk/impl/l;", "Lcom/chartboost/sdk/impl/i2$a;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/z6;", "params", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/a7;", "Lkotlin/ParameterName;", "name", "result", "callback", "a", "(Lcom/chartboost/sdk/impl/z6;Lkotlin/jvm/functions/Function1;)V", "Lcom/chartboost/sdk/impl/i2;", "request", "Lorg/json/JSONObject;", "response", "(Lcom/chartboost/sdk/impl/i2;Lorg/json/JSONObject;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/impl/i2;Lcom/chartboost/sdk/internal/Model/CBError;)V", "Lcom/chartboost/sdk/impl/f9;", "requestBodyFields", "Lcom/chartboost/sdk/impl/v;", "(Lcom/chartboost/sdk/impl/f9;Lorg/json/JSONObject;Ljava/lang/String;)Lcom/chartboost/sdk/impl/v;", "", "height", "width", "", "isCacheRequest", "Lcom/chartboost/sdk/impl/t7;", "openMeasurementManager", "(Ljava/lang/String;IIZLcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/i2$a;Lcom/chartboost/sdk/impl/t7;)Lcom/chartboost/sdk/impl/i2;", "impressionCounter", "Lcom/chartboost/sdk/impl/q2;", "(Lcom/chartboost/sdk/impl/i2$a;Ljava/lang/String;IZLcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/t7;)Lcom/chartboost/sdk/impl/q2;", "Lcom/chartboost/sdk/impl/y7;", "(Lcom/chartboost/sdk/impl/i2$a;IILjava/lang/String;ILcom/chartboost/sdk/impl/f9;Lcom/chartboost/sdk/impl/t7;)Lcom/chartboost/sdk/impl/y7;", "adUnit", "(Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/impl/i2;)V", "errorMsg", "(Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/u;", "adTraits", "Lcom/chartboost/sdk/impl/f5;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/f5;", "getFileCache", "()Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/d9;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/d9;", "getRequestBodyBuilder", "()Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", "Lcom/chartboost/sdk/impl/g2;", "d", "Lcom/chartboost/sdk/impl/g2;", "getNetworkService", "()Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/e0;", "e", "Lcom/chartboost/sdk/impl/e0;", "adUnitParser", "Lcom/chartboost/sdk/impl/x7;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/x7;", "openRTBAdUnitParser", "g", "Lcom/chartboost/sdk/impl/t7;", "h", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "i", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "j", "Lcom/chartboost/sdk/impl/f9;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/z6;", "l", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/d9;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/e0;Lcom/chartboost/sdk/impl/x7;Lcom/chartboost/sdk/impl/t7;Lcom/chartboost/sdk/impl/m4;Lcom/chartboost/sdk/internal/Networking/EndpointRepository;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class m implements l, i2.a, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final u adTraits;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final d9 requestBodyBuilder;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final e0 adUnitParser;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final x7 openRTBAdUnitParser;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final t7 openMeasurementManager;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final EndpointRepository endpointRepository;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public f9 requestBodyFields;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public z6 params;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super a7, Unit> callback;

    public m(u adTraits, f5 fileCache, d9 requestBodyBuilder, g2 networkService, e0 adUnitParser, x7 openRTBAdUnitParser, t7 openMeasurementManager, m4 eventTracker, EndpointRepository endpointRepository) {
        Intrinsics.checkNotNullParameter(adTraits, "adTraits");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(requestBodyBuilder, "requestBodyBuilder");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(adUnitParser, "adUnitParser");
        Intrinsics.checkNotNullParameter(openRTBAdUnitParser, "openRTBAdUnitParser");
        Intrinsics.checkNotNullParameter(openMeasurementManager, "openMeasurementManager");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(endpointRepository, "endpointRepository");
        this.adTraits = adTraits;
        this.fileCache = fileCache;
        this.requestBodyBuilder = requestBodyBuilder;
        this.networkService = networkService;
        this.adUnitParser = adUnitParser;
        this.openRTBAdUnitParser = openRTBAdUnitParser;
        this.openMeasurementManager = openMeasurementManager;
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

    public final y7 a(i2.a callback, int height, int width, String location, int impressionCounter, f9 requestBodyFields, t7 openMeasurementManager) {
        URL endPointUrl = this.endpointRepository.getEndPointUrl(this.adTraits.getGetEndPoint());
        return new y7(new k7(com.chartboost.sdk.internal.Networking.b.a(endPointUrl), endPointUrl.getPath(), requestBodyFields, k8.NORMAL, callback), new o(this.adTraits, Integer.valueOf(height), Integer.valueOf(width), location, impressionCounter), openMeasurementManager, this.eventTracker);
    }

    public final i2 a(String location, int height, int width, boolean isCacheRequest, f9 requestBodyFields, i2.a callback, t7 openMeasurementManager) {
        int interstitialImpressionCounter;
        u uVar = this.adTraits;
        if (Intrinsics.areEqual(uVar, u.c.g)) {
            interstitialImpressionCounter = requestBodyFields.h().getRewardedImpressionCounter();
        } else {
            interstitialImpressionCounter = Intrinsics.areEqual(uVar, u.b.g) ? requestBodyFields.h().getInterstitialImpressionCounter() : requestBodyFields.h().getBannerImpressionCounter();
        }
        int i = interstitialImpressionCounter;
        if (Intrinsics.areEqual(this.adTraits, u.a.g)) {
            return a(callback, height, width, location, i, requestBodyFields, openMeasurementManager);
        }
        return a(callback, location, i, isCacheRequest, requestBodyFields, openMeasurementManager);
    }

    public final q2 a(i2.a callback, String location, int impressionCounter, boolean isCacheRequest, f9 requestBodyFields, t7 openMeasurementManager) {
        f8 f8VarC;
        URL endPointUrl = this.endpointRepository.getEndPointUrl(this.adTraits.getGetEndPoint());
        c2.c cVar = c2.c.POST;
        String strA = com.chartboost.sdk.internal.Networking.b.a(endPointUrl);
        String path = endPointUrl.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "url.path");
        q2 q2Var = new q2(cVar, strA, path, requestBodyFields, k8.NORMAL, null, callback, this.eventTracker);
        JSONObject jSONObjectE = this.fileCache.e();
        Intrinsics.checkNotNullExpressionValue(jSONObjectE, "fileCache.webViewCacheAssets");
        q2Var.b("cache_assets", jSONObjectE);
        q2Var.b("location", location);
        q2Var.b(Reporting.Key.IMP_DEPTH, Integer.valueOf(impressionCounter));
        if (openMeasurementManager.g() && (f8VarC = openMeasurementManager.c()) != null) {
            q2Var.c("omidpn", f8VarC.a());
            q2Var.c("omidpv", f8VarC.b());
        }
        q2Var.b(Reporting.EventType.CACHE, Boolean.valueOf(isCacheRequest));
        q2Var.checkStatusInResponseBody = true;
        return q2Var;
    }

    public final void a(v adUnit, i2 request) {
        Function1<? super a7, Unit> function1 = this.callback;
        z6 z6Var = null;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            function1 = null;
        }
        z6 z6Var2 = this.params;
        if (z6Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            z6Var = z6Var2;
        }
        function1.invoke(new a7(z6Var.getAppRequest(), adUnit, null, request.readDataNs, request.getResponseCodeNs));
    }

    public final void a(String errorMsg) {
        Function1<? super a7, Unit> function1 = this.callback;
        z6 z6Var = null;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            function1 = null;
        }
        z6 z6Var2 = this.params;
        if (z6Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            z6Var = z6Var2;
        }
        function1.invoke(new a7(z6Var.getAppRequest(), null, new CBError(CBError.c.UNEXPECTED_RESPONSE, errorMsg), 0L, 0L, 26, null));
    }

    public String a(JSONObject jSONObject, String str, String str2) {
        return l.a.a(this, jSONObject, str, str2);
    }

    @Override // com.chartboost.sdk.impl.l
    public void a(z6 params, Function1<? super a7, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.params = params;
        this.callback = callback;
        this.requestBodyFields = this.requestBodyBuilder.a();
        String location = params.getAppRequest().getLocation();
        Integer bannerHeight = params.getBannerHeight();
        int iIntValue = bannerHeight != null ? bannerHeight.intValue() : 0;
        Integer bannerWidth = params.getBannerWidth();
        int iIntValue2 = bannerWidth != null ? bannerWidth.intValue() : 0;
        boolean isCacheRequest = params.getIsCacheRequest();
        f9 f9Var = this.requestBodyFields;
        if (f9Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBodyFields");
            f9Var = null;
        }
        i2 i2VarA = a(location, iIntValue, iIntValue2, isCacheRequest, f9Var, this, this.openMeasurementManager);
        i2VarA.dispatch = c2.b.ASYNC;
        this.networkService.a(i2VarA);
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public void a(i2 request, CBError error) {
        Function1<? super a7, Unit> function1 = this.callback;
        z6 z6Var = null;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            function1 = null;
        }
        z6 z6Var2 = this.params;
        if (z6Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            z6Var = z6Var2;
        }
        y0 appRequest = z6Var.getAppRequest();
        if (error == null) {
            error = new CBError(CBError.c.INVALID_RESPONSE, "Error parsing response");
        }
        function1.invoke(new a7(appRequest, null, error, 0L, 0L, 26, null));
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public void a(i2 request, JSONObject response) {
        if (request != null && response != null) {
            f9 f9Var = this.requestBodyFields;
            Unit unit = null;
            if (f9Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestBodyFields");
                f9Var = null;
            }
            z6 z6Var = this.params;
            if (z6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                z6Var = null;
            }
            JSONObject jSONObjectA = z6Var.getInterceptor().a(response);
            z6 z6Var2 = this.params;
            if (z6Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
                z6Var2 = null;
            }
            v vVarA = a(f9Var, jSONObjectA, z6Var2.getAppRequest().getLocation());
            if (vVarA != null) {
                a(vVarA, request);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                a("Error parsing response");
                return;
            }
            return;
        }
        a("Unexpected response");
    }

    public final v a(f9 requestBodyFields, JSONObject response, String location) {
        v vVarA;
        try {
            u uVar = this.adTraits;
            u.a aVar = u.a.g;
            if (Intrinsics.areEqual(uVar, aVar)) {
                vVarA = this.openRTBAdUnitParser.a(aVar, response);
            } else {
                if (!requestBodyFields.a().getWebViewEnabled()) {
                    return null;
                }
                vVarA = this.adUnitParser.a(response);
            }
            return vVarA;
        } catch (Exception e) {
            ma.a aVar2 = ma.a.GET_RESPONSE_PARSING_ERROR;
            JSONObject jSONObject = new JSONObject();
            String message = e.getMessage();
            if (message == null) {
                message = "no message";
            }
            String string = response.toString();
            Intrinsics.checkNotNullExpressionValue(string, "response.toString()");
            track((ka) new r3(aVar2, a(jSONObject, message, string), this.adTraits.getName(), location, null, null, 48, null));
            return null;
        }
    }
}
