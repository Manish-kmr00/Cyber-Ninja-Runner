package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\b\u0010+\u001a\u0004\u0018\u00010(\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\b8\u00109JM\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/chartboost/sdk/impl/p6;", "", "", "location", "Lcom/chartboost/sdk/impl/v;", "adUnit", "adTypeTraitsName", "html", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererImpressionCallback", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lcom/chartboost/sdk/impl/yb;", "webViewTimeoutInterface", "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "Lcom/chartboost/sdk/impl/o2;", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/v;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/yb;Lcom/chartboost/sdk/impl/g7;)Lcom/chartboost/sdk/impl/o2;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/sa;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/f5;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/l2;", "d", "Lcom/chartboost/sdk/impl/l2;", "templateProxy", "Lcom/chartboost/sdk/impl/qb;", "e", "Lcom/chartboost/sdk/impl/qb;", "videoRepository", "Lcom/chartboost/sdk/Mediation;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/g2;", "g", "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/s7;", "h", "Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/m4;", "i", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/l2;Lcom/chartboost/sdk/impl/qb;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final sa uiPoster;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final l2 templateProxy;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final qb videoRepository;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final s7 openMeasurementImpressionCallback;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final m4 eventTracker;

    public p6(Context context, sa uiPoster, f5 fileCache, l2 templateProxy, qb videoRepository, Mediation mediation, g2 networkService, s7 openMeasurementImpressionCallback, m4 eventTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(templateProxy, "templateProxy");
        Intrinsics.checkNotNullParameter(videoRepository, "videoRepository");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.context = context;
        this.uiPoster = uiPoster;
        this.fileCache = fileCache;
        this.templateProxy = templateProxy;
        this.videoRepository = videoRepository;
        this.mediation = mediation;
        this.networkService = networkService;
        this.openMeasurementImpressionCallback = openMeasurementImpressionCallback;
        this.eventTracker = eventTracker;
    }

    public final o2 a(String location, v adUnit, String adTypeTraitsName, String html, j0 adUnitRendererImpressionCallback, i6 impressionInterface, yb webViewTimeoutInterface, g7 nativeBridgeCommand) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adTypeTraitsName, "adTypeTraitsName");
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(adUnitRendererImpressionCallback, "adUnitRendererImpressionCallback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(webViewTimeoutInterface, "webViewTimeoutInterface");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        if (adUnit.getIo.bidmachine.unified.UnifiedMediationParams.KEY_VIDEO_URL java.lang.String().length() > 0) {
            return new pb(this.context, location, adUnit.getMtype(), adTypeTraitsName, this.uiPoster, this.fileCache, this.templateProxy, this.videoRepository, adUnit.getVideoFilename(), this.mediation, y2.b.d().c(), this.networkService, html, this.openMeasurementImpressionCallback, adUnitRendererImpressionCallback, impressionInterface, webViewTimeoutInterface, nativeBridgeCommand, this.eventTracker, null, 524288, null);
        }
        return adUnit.getRenderingEngine() == b9.HTML ? new v1(this.context, location, adUnit.getMtype(), adTypeTraitsName, this.fileCache, this.networkService, this.uiPoster, this.templateProxy, this.mediation, adUnit.getBaseUrl(), adUnit.getDecodedAdm(), adUnit.getInfoIcon(), this.openMeasurementImpressionCallback, adUnitRendererImpressionCallback, impressionInterface, webViewTimeoutInterface, adUnit.x(), this.eventTracker, null, null, 786432, null) : new b2(this.context, location, adUnit.getMtype(), adTypeTraitsName, this.fileCache, this.networkService, this.uiPoster, this.templateProxy, this.mediation, html, this.openMeasurementImpressionCallback, adUnitRendererImpressionCallback, impressionInterface, webViewTimeoutInterface, nativeBridgeCommand, this.eventTracker);
    }
}
