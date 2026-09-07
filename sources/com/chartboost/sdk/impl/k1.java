package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010*\u001a\u00020#\u0012\b\u00100\u001a\u0004\u0018\u00010+¢\u0006\u0004\b1\u00102J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0019\u00100\u001a\u0004\u0018\u00010+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/chartboost/sdk/impl/k1;", "Lcom/chartboost/sdk/impl/j1;", "Lcom/chartboost/sdk/impl/y0;", "appRequest", "", "adTypeTraitsName", "Lcom/chartboost/sdk/impl/f1;", "assetDownloadedCallback", "Lcom/chartboost/sdk/impl/a0;", "adUnitLoaderCallback", "", "a", "(Lcom/chartboost/sdk/impl/y0;Ljava/lang/String;Lcom/chartboost/sdk/impl/f1;Lcom/chartboost/sdk/impl/a0;)V", "Lcom/chartboost/sdk/impl/v;", "adUnit", "callback", "Lcom/chartboost/sdk/impl/g1;", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/impl/a0;)Lcom/chartboost/sdk/impl/g1;", "Lcom/chartboost/sdk/impl/g4;", "Lcom/chartboost/sdk/impl/g4;", "getDownloader", "()Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/ba;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/ba;", "getTimeSource", "()Lcom/chartboost/sdk/impl/ba;", "timeSource", "Lcom/chartboost/sdk/impl/qb;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/qb;", "getVideoRepository", "()Lcom/chartboost/sdk/impl/qb;", "videoRepository", "Lcom/chartboost/sdk/impl/u;", "d", "Lcom/chartboost/sdk/impl/u;", "getAdType", "()Lcom/chartboost/sdk/impl/u;", "setAdType", "(Lcom/chartboost/sdk/impl/u;)V", Ad.AD_TYPE, "Lcom/chartboost/sdk/Mediation;", "e", "Lcom/chartboost/sdk/Mediation;", "getMediation", "()Lcom/chartboost/sdk/Mediation;", "mediation", "<init>", "(Lcom/chartboost/sdk/impl/g4;Lcom/chartboost/sdk/impl/ba;Lcom/chartboost/sdk/impl/qb;Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/Mediation;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class k1 implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g4 downloader;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final ba timeSource;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final qb videoRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public u adType;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Mediation mediation;

    public k1(g4 downloader, ba timeSource, qb videoRepository, u adType, Mediation mediation) {
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(videoRepository, "videoRepository");
        Intrinsics.checkNotNullParameter(adType, "adType");
        this.downloader = downloader;
        this.timeSource = timeSource;
        this.videoRepository = videoRepository;
        this.adType = adType;
        this.mediation = mediation;
    }

    @Override // com.chartboost.sdk.impl.j1
    public void a(final y0 appRequest, String adTypeTraitsName, final f1 assetDownloadedCallback, final a0 adUnitLoaderCallback) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(adTypeTraitsName, "adTypeTraitsName");
        Intrinsics.checkNotNullParameter(assetDownloadedCallback, "assetDownloadedCallback");
        Intrinsics.checkNotNullParameter(adUnitLoaderCallback, "adUnitLoaderCallback");
        final v adUnit = appRequest.getAdUnit();
        if (adUnit == null) {
            return;
        }
        d1 d1Var = new d1() { // from class: com.chartboost.sdk.impl.k1$$ExternalSyntheticLambda0
            @Override // com.chartboost.sdk.impl.d1
            public final void a(boolean z) {
                k1.a(this.f$0, appRequest, adUnit, adUnitLoaderCallback, assetDownloadedCallback, z);
            }
        };
        this.downloader.c();
        this.downloader.a(k8.NORMAL, adUnit.d(), new AtomicInteger(), (d1) d5.a().a(d1Var), adTypeTraitsName);
    }

    public static final void a(k1 this$0, y0 appRequest, v adUnit, a0 adUnitLoaderCallback, f1 assetDownloadedCallback, boolean z) {
        g1 g1VarA;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appRequest, "$appRequest");
        Intrinsics.checkNotNullParameter(adUnit, "$adUnit");
        Intrinsics.checkNotNullParameter(adUnitLoaderCallback, "$adUnitLoaderCallback");
        Intrinsics.checkNotNullParameter(assetDownloadedCallback, "$assetDownloadedCallback");
        if (z) {
            g1VarA = this$0.a(appRequest, adUnit, adUnitLoaderCallback);
        } else if (!z) {
            g1VarA = g1.FAILURE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        assetDownloadedCallback.a(appRequest, g1VarA);
    }

    public final g1 a(y0 appRequest, v adUnit, a0 callback) {
        callback.a(appRequest, ma.a.FINISH_SUCCESS);
        if (adUnit.getIsPrecacheVideoAd()) {
            if (!this.videoRepository.a(adUnit.getVideoFilename())) {
                this.videoRepository.a(adUnit.getIo.bidmachine.unified.UnifiedMediationParams.KEY_VIDEO_URL java.lang.String(), adUnit.getVideoFilename(), false, null);
            }
            return g1.SUCCESS;
        }
        return g1.READY_TO_SHOW;
    }
}
