package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.SurfaceView;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0089\u0001\u0010>\u001aw\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0013\u0012\u001104¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u000106¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(7\u0012\u0013\u0012\u001108¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020:0/j\u0002`;8&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8&X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8&X¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8&X¦\u0004¢\u0006\u0006\u001a\u0004\bX\u0010Y¨\u0006["}, d2 = {"Lcom/chartboost/sdk/impl/z0;", "", "Lcom/chartboost/sdk/impl/g2;", "i", "()Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/ba;", "m", "()Lcom/chartboost/sdk/impl/ba;", "timeSource", "Lcom/chartboost/sdk/impl/s9;", "s", "()Lcom/chartboost/sdk/impl/s9;", "session", "Lcom/chartboost/sdk/impl/h2;", "r", "()Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/w1;", "j", "()Lcom/chartboost/sdk/impl/w1;", "identity", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "Lcom/chartboost/sdk/impl/f5;", CampaignEx.JSON_KEY_AD_K, "()Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/g4;", "g", "()Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/s2;", "n", "()Lcom/chartboost/sdk/impl/s2;", "carrierBuilder", "Lcom/chartboost/sdk/impl/qb;", CampaignEx.JSON_KEY_AD_Q, "()Lcom/chartboost/sdk/impl/qb;", "videoRepository", "Lcom/chartboost/sdk/impl/kb;", "l", "()Lcom/chartboost/sdk/impl/kb;", "videoCachePolicy", "Lkotlin/Function5;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Landroid/view/SurfaceView;", "surface", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/p0;", "Lcom/chartboost/sdk/internal/di/AdsVideoPlayerFactory;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lkotlin/jvm/functions/Function5;", "adsVideoPlayerFactory", "Lcom/chartboost/sdk/impl/d9;", "o", "()Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", "Lcom/chartboost/sdk/impl/j8;", "h", "()Lcom/chartboost/sdk/impl/j8;", "prefetcher", "Lcom/chartboost/sdk/impl/l8;", "a", "()Lcom/chartboost/sdk/impl/l8;", "privacyApi", "Lcom/chartboost/sdk/impl/s4;", "e", "()Lcom/chartboost/sdk/impl/s4;", "exoPlayerDownloadManager", "Lcom/chartboost/sdk/impl/w6;", "p", "()Lcom/chartboost/sdk/impl/w6;", "intentResolver", "Lcom/chartboost/sdk/impl/x3;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/x3;", "deviceBodyFieldsFactory", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "d", "()Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface z0 {
    l8 a();

    AtomicReference<o9> b();

    Function5<Context, SurfaceView, q0, sa, f5, p0> c();

    EndpointRepository d();

    s4 e();

    x3 f();

    g4 g();

    j8 h();

    g2 i();

    w1 j();

    f5 k();

    kb l();

    ba m();

    s2 n();

    d9 o();

    w6 p();

    qb q();

    h2 r();

    s9 s();
}
