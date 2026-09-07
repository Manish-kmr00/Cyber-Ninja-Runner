package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.SurfaceView;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001\u0012\b\u0010\u0097\u0001\u001a\u00030\u0096\u0001\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\u001c\b\u0002\u0010\u009c\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0094\u0001\u0012\u0004\u0012\u0002040\u009a\u0001j\u0003`\u009b\u0001\u0012\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R\u001b\u0010\u0007\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u0003\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0012\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b,\u0010-R\u001b\u00102\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b0\u00101R!\u00107\u001a\b\u0012\u0004\u0012\u000204038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b\t\u00106R\u001b\u0010;\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b9\u0010:R\u001b\u0010?\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0004\u001a\u0004\b\u001f\u0010>R\u001b\u0010C\u001a\u00020@8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0004\u001a\u0004\b=\u0010BR\u001b\u0010H\u001a\u00020D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010GR\u001b\u0010L\u001a\u00020I8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0004\u001a\u0004\b\u0017\u0010KR\u001b\u0010P\u001a\u00020M8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\bN\u0010OR\u001b\u0010S\u001a\u00020Q8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\bE\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010\\R\u001b\u0010`\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\\R\u001b\u0010c\u001a\u00020a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0004\u001a\u0004\b5\u0010bR\u0090\u0001\u0010s\u001aw\u0012\u0013\u0012\u00110e¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0013\u0012\u00110i¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(j\u0012\u0015\u0012\u0013\u0018\u00010k¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(l\u0012\u0013\u0012\u00110m¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110/¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020o0dj\u0002`p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0004\u001a\u0004\bZ\u0010rR\u0090\u0001\u0010u\u001aw\u0012\u0013\u0012\u00110e¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0013\u0012\u00110i¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(j\u0012\u0015\u0012\u0013\u0018\u00010k¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(l\u0012\u0013\u0012\u00110m¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110/¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020o0dj\u0002`p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0004\u001a\u0004\bU\u0010rR9\u0010|\u001a \u0012\u0006\u0012\u0004\u0018\u00010k\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020x0vj\u0002`y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\bz\u0010{R\u0084\u0001\u0010\u0088\u0001\u001ah\u0012\u0013\u0012\u00110~¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(\u007f\u0012\u0015\u0012\u00130\u0080\u0001¢\u0006\r\bf\u0012\t\bg\u0012\u0005\b\b(\u0081\u0001\u0012\u0015\u0012\u00130\u0082\u0001¢\u0006\r\bf\u0012\t\bg\u0012\u0005\b\b(\u0083\u0001\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(2\u0012\u0005\u0012\u00030\u0084\u00010}j\u0003`\u0085\u00018BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b\u000e\u0010\u0004\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001e\u0010\u008b\u0001\u001a\u00030\u0089\u00018BX\u0082\u0084\u0002¢\u0006\r\n\u0004\bF\u0010\u0004\u001a\u0005\bt\u0010\u008a\u0001R\u001f\u0010\u008e\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0004\u001a\u0005\bq\u0010\u008d\u0001R\u001e\u0010\u0091\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002¢\u0006\r\n\u0004\bV\u0010\u0004\u001a\u0005\b^\u0010\u0090\u0001R\u0015\u0010\u0092\u0001\u001a\u00020Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\\R\u008a\u0001\u0010\u0093\u0001\u001aw\u0012\u0013\u0012\u00110e¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0013\u0012\u00110i¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(j\u0012\u0015\u0012\u0013\u0018\u00010k¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(l\u0012\u0013\u0012\u00110m¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110/¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020o0dj\u0002`p8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010r¨\u0006¡\u0001"}, d2 = {"Lcom/chartboost/sdk/impl/b1;", "Lcom/chartboost/sdk/impl/z0;", "Lcom/chartboost/sdk/impl/j8;", "a", "Lkotlin/Lazy;", "h", "()Lcom/chartboost/sdk/impl/j8;", "prefetcher", "Lcom/chartboost/sdk/impl/l8;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/l8;", "privacyApi", "Lcom/chartboost/sdk/impl/e9;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/chartboost/sdk/impl/e9;", "requestBodyBuilder", "Lcom/chartboost/sdk/impl/x3;", "d", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/x3;", "deviceBodyFieldsFactory", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "e", "()Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "Lcom/chartboost/sdk/impl/g2;", "i", "()Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/ba;", "g", "m", "()Lcom/chartboost/sdk/impl/ba;", "timeSource", "Lcom/chartboost/sdk/impl/s9;", "s", "()Lcom/chartboost/sdk/impl/s9;", "session", "Lcom/chartboost/sdk/impl/h2;", "r", "()Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/w1;", "j", "()Lcom/chartboost/sdk/impl/w1;", "identity", "Lcom/chartboost/sdk/impl/f5;", CampaignEx.JSON_KEY_AD_K, "()Lcom/chartboost/sdk/impl/f5;", "fileCache", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "l", "()Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "Lcom/chartboost/sdk/impl/j7;", "z", "()Lcom/chartboost/sdk/impl/j7;", "networkFactory", "Lcom/chartboost/sdk/impl/g4;", "n", "()Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/s2;", "o", "()Lcom/chartboost/sdk/impl/s2;", "carrierBuilder", "Lcom/chartboost/sdk/impl/z9;", "p", "B", "()Lcom/chartboost/sdk/impl/z9;", "tempFileDownloadHelper", "Lcom/chartboost/sdk/impl/s4;", CampaignEx.JSON_KEY_AD_Q, "()Lcom/chartboost/sdk/impl/s4;", "exoPlayerDownloadManager", "Lcom/chartboost/sdk/impl/y4;", "w", "()Lcom/chartboost/sdk/impl/y4;", "exoPlayerMediaItemFactory", "Lcom/chartboost/sdk/impl/w6;", "()Lcom/chartboost/sdk/impl/w6;", "intentResolver", "Lcom/chartboost/sdk/impl/lb$b;", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "D", "()Lcom/chartboost/sdk/impl/lb$b;", "videoPlayerType", "Lcom/chartboost/sdk/impl/qb;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "G", "()Lcom/chartboost/sdk/impl/qb;", "videoRepositoryMediaPlayer", "v", "F", "videoRepositoryExoplayer", "Lcom/chartboost/sdk/impl/kb;", "()Lcom/chartboost/sdk/impl/kb;", "videoCachePolicy", "Lkotlin/Function5;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Landroid/view/SurfaceView;", "surface", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/p0;", "Lcom/chartboost/sdk/internal/di/AdsVideoPlayerFactory;", VastAttributes.HORIZONTAL_POSITION, "()Lkotlin/jvm/functions/Function5;", "adsMediaPlayerFactory", VastAttributes.VERTICAL_POSITION, "adsExoPlayerFactory", "Lkotlin/Function3;", "Lcom/chartboost/sdk/impl/nb$b;", "Lcom/chartboost/sdk/impl/nb;", "Lcom/chartboost/sdk/internal/video/player/scheduler/VideoProgressSchedulerFactory;", ExifInterface.LONGITUDE_EAST, "()Lkotlin/jvm/functions/Function3;", "videoProgressSchedulerFactory", "Lkotlin/Function4;", "Lcom/chartboost/sdk/impl/gb;", "videoAsset", "Lcom/chartboost/sdk/impl/ib$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lcom/chartboost/sdk/impl/ib;", "Lcom/chartboost/sdk/internal/video/player/mediaplayer/VideoBufferFactory;", "C", "()Lkotlin/jvm/functions/Function4;", "videoBufferFactory", "Lcom/chartboost/sdk/impl/q5;", "()Lcom/chartboost/sdk/impl/q5;", POBConstants.KEY_IFA, "Lcom/chartboost/sdk/impl/m5;", "()Lcom/chartboost/sdk/impl/m5;", "googleAdvertisingId", "Lcom/chartboost/sdk/impl/t0;", "()Lcom/chartboost/sdk/impl/t0;", "amazonAdvertisingId", "videoRepository", "adsVideoPlayerFactory", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/q4;", "executorComponent", "Lcom/chartboost/sdk/impl/n8;", "privacyComponent", "Lkotlin/Function1;", "Lcom/chartboost/sdk/internal/di/SDKConfigFactory;", "sdkConfigFactory", "Lcom/chartboost/sdk/impl/ea;", "trackerComponent", "<init>", "(Lcom/chartboost/sdk/impl/w0;Lcom/chartboost/sdk/impl/q4;Lcom/chartboost/sdk/impl/n8;Lkotlin/jvm/functions/Function1;Lcom/chartboost/sdk/impl/ea;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class b1 implements z0 {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final Lazy videoBufferFactory;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final Lazy ifa;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final Lazy googleAdvertisingId;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public final Lazy amazonAdvertisingId;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy prefetcher;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy privacyApi;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy requestBodyBuilder;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy deviceBodyFieldsFactory;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy endpointRepository;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy networkService;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Lazy timeSource;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Lazy session;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Lazy reachability;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Lazy identity;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Lazy fileCache;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy sdkConfig;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy networkFactory;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Lazy downloader;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Lazy carrierBuilder;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final Lazy tempFileDownloadHelper;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final Lazy exoPlayerDownloadManager;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final Lazy exoPlayerMediaItemFactory;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final Lazy intentResolver;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final Lazy videoPlayerType;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final Lazy videoRepositoryMediaPlayer;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final Lazy videoRepositoryExoplayer;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final Lazy videoCachePolicy;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public final Lazy adsMediaPlayerFactory;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public final Lazy adsExoPlayerFactory;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final Lazy videoProgressSchedulerFactory;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f974a;

        static {
            int[] iArr = new int[lb.b.values().length];
            try {
                iArr[lb.b.MEDIA_PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[lb.b.EXO_PLAYER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f974a = iArr;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000e\u001as\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0000H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlin/Function5;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Landroid/view/SurfaceView;", "surface", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/m0;", "a", "()Lkotlin/jvm/functions/Function5;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<Function5<? super Context, ? super SurfaceView, ? super q0, ? super sa, ? super f5, ? extends m0>> {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroid/content/Context;", "cxt", "Landroid/view/SurfaceView;", "s", "Lcom/chartboost/sdk/impl/q0;", "cb", "Lcom/chartboost/sdk/impl/sa;", "h", "Lcom/chartboost/sdk/impl/f5;", "<anonymous parameter 4>", "Lcom/chartboost/sdk/impl/m0;", "a", "(Landroid/content/Context;Landroid/view/SurfaceView;Lcom/chartboost/sdk/impl/q0;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/f5;)Lcom/chartboost/sdk/impl/m0;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function5<Context, SurfaceView, q0, sa, f5, m0> {
            public final /* synthetic */ b1 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b1 b1Var) {
                super(5);
                this.b = b1Var;
            }

            @Override // kotlin.jvm.functions.Function5
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final m0 invoke(Context cxt, SurfaceView s, q0 q0Var, sa h, f5 f5Var) {
                Intrinsics.checkNotNullParameter(cxt, "cxt");
                Intrinsics.checkNotNullParameter(s, "s");
                Intrinsics.checkNotNullParameter(h, "h");
                Intrinsics.checkNotNullParameter(f5Var, "<anonymous parameter 4>");
                return new m0(cxt, null, this.b.w(), s, q0Var, h, this.b.E(), 2, null);
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function5<Context, SurfaceView, q0, sa, f5, m0> invoke() {
            return new a(b1.this);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000e\u001as\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0000H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlin/Function5;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Landroid/view/SurfaceView;", "surface", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/o0;", "a", "()Lkotlin/jvm/functions/Function5;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<Function5<? super Context, ? super SurfaceView, ? super q0, ? super sa, ? super f5, ? extends o0>> {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroid/content/Context;", "<anonymous parameter 0>", "Landroid/view/SurfaceView;", "s", "Lcom/chartboost/sdk/impl/q0;", "cb", "Lcom/chartboost/sdk/impl/sa;", "h", "Lcom/chartboost/sdk/impl/f5;", "fc", "Lcom/chartboost/sdk/impl/o0;", "a", "(Landroid/content/Context;Landroid/view/SurfaceView;Lcom/chartboost/sdk/impl/q0;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/f5;)Lcom/chartboost/sdk/impl/o0;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function5<Context, SurfaceView, q0, sa, f5, o0> {
            public final /* synthetic */ b1 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b1 b1Var) {
                super(5);
                this.b = b1Var;
            }

            @Override // kotlin.jvm.functions.Function5
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final o0 invoke(Context context, SurfaceView s, q0 q0Var, sa h, f5 fc) {
                Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(s, "s");
                Intrinsics.checkNotNullParameter(h, "h");
                Intrinsics.checkNotNullParameter(fc, "fc");
                return new o0(null, s, q0Var, h, this.b.E(), this.b.C(), null, fc, 65, null);
            }
        }

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function5<Context, SurfaceView, q0, sa, f5, o0> invoke() {
            return new a(b1.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Function3;", "Lcom/chartboost/sdk/impl/q0;", "Lcom/chartboost/sdk/impl/nb$b;", "Lcom/chartboost/sdk/impl/sa;", "Lcom/chartboost/sdk/impl/ob;", "a", "()Lkotlin/jvm/functions/Function3;"}, k = 3, mv = {1, 8, 0})
    public static final class c0 extends Lambda implements Function0<Function3<? super q0, ? super nb.b, ? super sa, ? extends ob>> {
        public static final c0 b = new c0();

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/chartboost/sdk/impl/q0;", "l", "Lcom/chartboost/sdk/impl/nb$b;", "vp", "Lcom/chartboost/sdk/impl/sa;", "<anonymous parameter 2>", "Lcom/chartboost/sdk/impl/ob;", "a", "(Lcom/chartboost/sdk/impl/q0;Lcom/chartboost/sdk/impl/nb$b;Lcom/chartboost/sdk/impl/sa;)Lcom/chartboost/sdk/impl/ob;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function3<q0, nb.b, sa, ob> {
            public static final a b = new a();

            public a() {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ob invoke(q0 q0Var, nb.b vp, sa saVar) {
                Intrinsics.checkNotNullParameter(vp, "vp");
                Intrinsics.checkNotNullParameter(saVar, "<anonymous parameter 2>");
                return new ob(q0Var, vp, null, 4, null);
            }
        }

        public c0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function3<q0, nb.b, sa, ob> invoke() {
            return a.b;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/t0;", "a", "()Lcom/chartboost/sdk/impl/t0;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<t0> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t0 invoke() {
            return new t0(this.b.getContext(), this.b.c());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/s2;", "a", "()Lcom/chartboost/sdk/impl/s2;"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<s2> {
        public static final e b = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s2 invoke() {
            return new s2();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/sb;", "a", "()Lcom/chartboost/sdk/impl/sb;"}, k = 3, mv = {1, 8, 0})
    public static final class e0 extends Lambda implements Function0<sb> {
        public final /* synthetic */ q4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(q4 q4Var) {
            super(0);
            this.c = q4Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sb invoke() {
            return new sb(b1.this.i(), b1.this.l(), b1.this.r(), b1.this.k(), b1.this.B(), this.c.a());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/x3;", "a", "()Lcom/chartboost/sdk/impl/x3;"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function0<x3> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x3 invoke() {
            return new x3(this.b.getContext(), this.b.h(), this.b.k());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/g4;", "a", "()Lcom/chartboost/sdk/impl/g4;"}, k = 3, mv = {1, 8, 0})
    public static final class g extends Lambda implements Function0<g4> {
        public final /* synthetic */ q4 b;
        public final /* synthetic */ b1 c;
        public final /* synthetic */ ea d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(q4 q4Var, b1 b1Var, ea eaVar) {
            super(0);
            this.b = q4Var;
            this.c = b1Var;
            this.d = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g4 invoke() {
            return new g4(this.b.a(), this.c.k(), this.c.i(), this.c.r(), this.c.b(), this.c.m(), this.d.a());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/c;", "a", "()Lcom/chartboost/sdk/internal/Networking/c;"}, k = 3, mv = {1, 8, 0})
    public static final class h extends Lambda implements Function0<com.chartboost.sdk.internal.Networking.c> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.chartboost.sdk.internal.Networking.c invoke() {
            o9 o9Var = b1.this.b().get();
            Intrinsics.checkNotNullExpressionValue(o9Var, "sdkConfig.get()");
            return new com.chartboost.sdk.internal.Networking.c(o9Var);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u4;", "a", "()Lcom/chartboost/sdk/impl/u4;"}, k = 3, mv = {1, 8, 0})
    public static final class i extends Lambda implements Function0<u4> {
        public static final i b = new i();

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u4 invoke() {
            return new u4(null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/y4;", "a", "()Lcom/chartboost/sdk/impl/y4;"}, k = 3, mv = {1, 8, 0})
    public static final class j extends Lambda implements Function0<y4> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y4 invoke() {
            return new y4(b1.this.e());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/f5;", "a", "()Lcom/chartboost/sdk/impl/f5;"}, k = 3, mv = {1, 8, 0})
    public static final class k extends Lambda implements Function0<f5> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ b1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(w0 w0Var, b1 b1Var) {
            super(0);
            this.b = w0Var;
            this.c = b1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f5 invoke() {
            return new f5(this.b.getContext(), this.c.b());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/m5;", "a", "()Lcom/chartboost/sdk/impl/m5;"}, k = 3, mv = {1, 8, 0})
    public static final class l extends Lambda implements Function0<m5> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m5 invoke() {
            return new m5(this.b.getContext());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/w1;", "a", "()Lcom/chartboost/sdk/impl/w1;"}, k = 3, mv = {1, 8, 0})
    public static final class m extends Lambda implements Function0<w1> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ b1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(w0 w0Var, b1 b1Var) {
            super(0);
            this.b = w0Var;
            this.c = b1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w1 invoke() {
            return new w1(this.b.getContext(), this.b.j(), this.c.y(), this.b.a(), null, 16, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/q5;", "a", "()Lcom/chartboost/sdk/impl/q5;"}, k = 3, mv = {1, 8, 0})
    public static final class n extends Lambda implements Function0<q5> {
        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q5 invoke() {
            return new q5(b1.this.x(), b1.this.v(), null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/w6;", "a", "()Lcom/chartboost/sdk/impl/w6;"}, k = 3, mv = {1, 8, 0})
    public static final class o extends Lambda implements Function0<w6> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w6 invoke() {
            PackageManager packageManager = this.b.getContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "androidComponent.context.packageManager");
            return new w6(packageManager, null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/j7;", "a", "()Lcom/chartboost/sdk/impl/j7;"}, k = 3, mv = {1, 8, 0})
    public static final class p extends Lambda implements Function0<j7> {
        public static final p b = new p();

        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j7 invoke() {
            return new j7();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/g2;", "a", "()Lcom/chartboost/sdk/impl/g2;"}, k = 3, mv = {1, 8, 0})
    public static final class q extends Lambda implements Function0<g2> {
        public final /* synthetic */ q4 b;
        public final /* synthetic */ b1 c;
        public final /* synthetic */ w0 d;
        public final /* synthetic */ ea e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(q4 q4Var, b1 b1Var, w0 w0Var, ea eaVar) {
            super(0);
            this.b = q4Var;
            this.c = b1Var;
            this.d = w0Var;
            this.e = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g2 invoke() {
            return new g2(this.b.a(), this.c.z(), this.c.r(), this.c.m(), this.d.e(), this.b.b(), this.e.a());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/j8;", "a", "()Lcom/chartboost/sdk/impl/j8;"}, k = 3, mv = {1, 8, 0})
    public static final class r extends Lambda implements Function0<j8> {
        public final /* synthetic */ ea c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ea eaVar) {
            super(0);
            this.c = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j8 invoke() {
            return new j8(b1.this.g(), b1.this.k(), b1.this.i(), b1.this.o(), b1.this.b(), this.c.a(), b1.this.d());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/h2;", "a", "()Lcom/chartboost/sdk/impl/h2;"}, k = 3, mv = {1, 8, 0})
    public static final class t extends Lambda implements Function0<h2> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h2 invoke() {
            return new h2(this.b.getContext());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/e9;", "a", "()Lcom/chartboost/sdk/impl/e9;"}, k = 3, mv = {1, 8, 0})
    public static final class u extends Lambda implements Function0<e9> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ b1 c;
        public final /* synthetic */ n8 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(w0 w0Var, b1 b1Var, n8 n8Var) {
            super(0);
            this.b = w0Var;
            this.c = b1Var;
            this.d = n8Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e9 invoke() {
            return new e9(this.b.getContext(), this.c.j(), this.c.r(), this.c.b(), this.b.f(), this.c.m(), this.c.n(), this.c.s(), this.d.a(), null, this.c.f());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "a", "()Ljava/util/concurrent/atomic/AtomicReference;"}, k = 3, mv = {1, 8, 0})
    public static final class v extends Lambda implements Function0<AtomicReference<o9>> {
        public final /* synthetic */ Function1<w0, o9> b;
        public final /* synthetic */ w0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public v(Function1<? super w0, ? extends o9> function1, w0 w0Var) {
            super(0);
            this.b = function1;
            this.c = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AtomicReference<o9> invoke() {
            return new AtomicReference<>(this.b.invoke(this.c));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/s9;", "a", "()Lcom/chartboost/sdk/impl/s9;"}, k = 3, mv = {1, 8, 0})
    public static final class w extends Lambda implements Function0<s9> {
        public final /* synthetic */ w0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(w0 w0Var) {
            super(0);
            this.b = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s9 invoke() {
            return new s9(this.b.f());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/z9;", "a", "()Lcom/chartboost/sdk/impl/z9;"}, k = 3, mv = {1, 8, 0})
    public static final class x extends Lambda implements Function0<z9> {
        public static final x b = new x();

        public x() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z9 invoke() {
            return new z9();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/ba;", "a", "()Lcom/chartboost/sdk/impl/ba;"}, k = 3, mv = {1, 8, 0})
    public static final class y extends Lambda implements Function0<ba> {
        public static final y b = new y();

        public y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ba invoke() {
            return new ba();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\f\u001a^\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/Function4;", "Lcom/chartboost/sdk/impl/gb;", "Lkotlin/ParameterName;", "name", "videoAsset", "Lcom/chartboost/sdk/impl/ib$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/ib;", "a", "()Lkotlin/jvm/functions/Function4;"}, k = 3, mv = {1, 8, 0})
    public static final class z extends Lambda implements Function0<Function4<? super gb, ? super ib.b, ? super CoroutineDispatcher, ? super f5, ? extends ib>> {
        public static final z b = new z();

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/chartboost/sdk/impl/gb;", "va", "Lcom/chartboost/sdk/impl/ib$b;", "l", "Lkotlinx/coroutines/CoroutineDispatcher;", "d", "Lcom/chartboost/sdk/impl/f5;", "fc", "Lcom/chartboost/sdk/impl/ib;", "a", "(Lcom/chartboost/sdk/impl/gb;Lcom/chartboost/sdk/impl/ib$b;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/chartboost/sdk/impl/f5;)Lcom/chartboost/sdk/impl/ib;"}, k = 3, mv = {1, 8, 0})
        public static final class a extends Lambda implements Function4<gb, ib.b, CoroutineDispatcher, f5, ib> {
            public static final a b = new a();

            public a() {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ib invoke(gb va, ib.b l, CoroutineDispatcher d, f5 f5Var) {
                Intrinsics.checkNotNullParameter(va, "va");
                Intrinsics.checkNotNullParameter(l, "l");
                Intrinsics.checkNotNullParameter(d, "d");
                return new ib(va, l, 0.0f, null, f5Var, d, null, 76, null);
            }
        }

        public z() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function4<gb, ib.b, CoroutineDispatcher, f5, ib> invoke() {
            return a.b;
        }
    }

    public b1(w0 androidComponent, q4 executorComponent, n8 privacyComponent, Function1<? super w0, ? extends o9> sdkConfigFactory, ea trackerComponent) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        Intrinsics.checkNotNullParameter(executorComponent, "executorComponent");
        Intrinsics.checkNotNullParameter(privacyComponent, "privacyComponent");
        Intrinsics.checkNotNullParameter(sdkConfigFactory, "sdkConfigFactory");
        Intrinsics.checkNotNullParameter(trackerComponent, "trackerComponent");
        this.prefetcher = LazyKt.lazy(new r(trackerComponent));
        this.privacyApi = LazyKt.lazy(new s(privacyComponent));
        this.requestBodyBuilder = LazyKt.lazy(new u(androidComponent, this, privacyComponent));
        this.deviceBodyFieldsFactory = LazyKt.lazy(new f(androidComponent));
        this.endpointRepository = LazyKt.lazy(new h());
        this.networkService = LazyKt.lazy(new q(executorComponent, this, androidComponent, trackerComponent));
        this.timeSource = LazyKt.lazy(y.b);
        this.session = LazyKt.lazy(new w(androidComponent));
        this.reachability = LazyKt.lazy(new t(androidComponent));
        this.identity = LazyKt.lazy(new m(androidComponent, this));
        this.fileCache = LazyKt.lazy(new k(androidComponent, this));
        this.sdkConfig = LazyKt.lazy(new v(sdkConfigFactory, androidComponent));
        this.networkFactory = LazyKt.lazy(p.b);
        this.downloader = LazyKt.lazy(new g(executorComponent, this, trackerComponent));
        this.carrierBuilder = LazyKt.lazy(e.b);
        this.tempFileDownloadHelper = LazyKt.lazy(x.b);
        this.exoPlayerDownloadManager = LazyKt.lazy(i.b);
        this.exoPlayerMediaItemFactory = LazyKt.lazy(new j());
        this.intentResolver = LazyKt.lazy(new o(androidComponent));
        this.videoPlayerType = LazyKt.lazy(new b0());
        this.videoRepositoryMediaPlayer = LazyKt.lazy(new e0(executorComponent));
        this.videoRepositoryExoplayer = LazyKt.lazy(new d0());
        this.videoCachePolicy = LazyKt.lazy(new a0());
        this.adsMediaPlayerFactory = LazyKt.lazy(new c());
        this.adsExoPlayerFactory = LazyKt.lazy(new b());
        this.videoProgressSchedulerFactory = LazyKt.lazy(c0.b);
        this.videoBufferFactory = LazyKt.lazy(z.b);
        this.ifa = LazyKt.lazy(new n());
        this.googleAdvertisingId = LazyKt.lazy(new l(androidComponent));
        this.amazonAdvertisingId = LazyKt.lazy(new d(androidComponent));
    }

    @Override // com.chartboost.sdk.impl.z0
    public j8 h() {
        return (j8) this.prefetcher.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/l8;", "a", "()Lcom/chartboost/sdk/impl/l8;"}, k = 3, mv = {1, 8, 0})
    public static final class s extends Lambda implements Function0<l8> {
        public final /* synthetic */ n8 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(n8 n8Var) {
            super(0);
            this.b = n8Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l8 invoke() {
            return this.b.a();
        }
    }

    @Override // com.chartboost.sdk.impl.z0
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public e9 o() {
        return (e9) this.requestBodyBuilder.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public g2 i() {
        return (g2) this.networkService.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public ba m() {
        return (ba) this.timeSource.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public s9 s() {
        return (s9) this.session.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public h2 r() {
        return (h2) this.reachability.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public w1 j() {
        return (w1) this.identity.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public f5 k() {
        return (f5) this.fileCache.getValue();
    }

    public final j7 z() {
        return (j7) this.networkFactory.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public g4 g() {
        return (g4) this.downloader.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public s2 n() {
        return (s2) this.carrierBuilder.getValue();
    }

    public z9 B() {
        return (z9) this.tempFileDownloadHelper.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public l8 a() {
        return (l8) this.privacyApi.getValue();
    }

    public y4 w() {
        return (y4) this.exoPlayerMediaItemFactory.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public w6 p() {
        return (w6) this.intentResolver.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/lb$b;", "a", "()Lcom/chartboost/sdk/impl/lb$b;"}, k = 3, mv = {1, 8, 0})
    public static final class b0 extends Lambda implements Function0<lb.b> {
        public b0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lb.b invoke() {
            lb.b videoPlayer;
            lb lbVarC;
            o9 o9Var = b1.this.b().get();
            if (o9Var == null || (lbVarC = o9Var.c()) == null || (videoPlayer = lbVarC.getVideoPlayer()) == null) {
                videoPlayer = lb.b.EXO_PLAYER;
            }
            b7.a("Video player type: " + videoPlayer, (Throwable) null, 2, (Object) null);
            return videoPlayer;
        }
    }

    public final lb.b D() {
        return (lb.b) this.videoPlayerType.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public x3 f() {
        return (x3) this.deviceBodyFieldsFactory.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public qb q() {
        qb qbVarG;
        int i2 = a.f974a[D().ordinal()];
        if (i2 == 1) {
            qbVarG = G();
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            qbVarG = F();
        }
        b7.a("Video repository: " + qbVarG, (Throwable) null, 2, (Object) null);
        return qbVarG;
    }

    @Override // com.chartboost.sdk.impl.z0
    public EndpointRepository d() {
        return (EndpointRepository) this.endpointRepository.getValue();
    }

    public final qb G() {
        return (qb) this.videoRepositoryMediaPlayer.getValue();
    }

    public final qb F() {
        return (qb) this.videoRepositoryExoplayer.getValue();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/rb;", "a", "()Lcom/chartboost/sdk/impl/rb;"}, k = 3, mv = {1, 8, 0})
    public static final class d0 extends Lambda implements Function0<rb> {
        public d0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final rb invoke() {
            return new rb(b1.this.l(), b1.this.e(), null, null, 12, null);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/kb;", "a", "()Lcom/chartboost/sdk/impl/kb;"}, k = 3, mv = {1, 8, 0})
    public static final class a0 extends Lambda implements Function0<kb> {
        public a0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kb invoke() {
            lb lbVar = new lb(0L, 0, 0, 0L, 0L, 0L, 0, null, 255, null);
            return new kb(lbVar.getMaxBytes(), lbVar.getMaxUnitsPerTimeWindow(), lbVar.getMaxUnitsPerTimeWindowCellular(), lbVar.getTimeWindow(), lbVar.getTimeWindowCellular(), lbVar.getTtl(), lbVar.getBufferSize(), b1.this.r());
        }
    }

    @Override // com.chartboost.sdk.impl.z0
    public kb l() {
        return (kb) this.videoCachePolicy.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public AtomicReference<o9> b() {
        return (AtomicReference) this.sdkConfig.getValue();
    }

    public final Function5<Context, SurfaceView, q0, sa, f5, p0> u() {
        return (Function5) this.adsMediaPlayerFactory.getValue();
    }

    public final Function5<Context, SurfaceView, q0, sa, f5, p0> t() {
        return (Function5) this.adsExoPlayerFactory.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public s4 e() {
        return (s4) this.exoPlayerDownloadManager.getValue();
    }

    public final Function3<q0, nb.b, sa, nb> E() {
        return (Function3) this.videoProgressSchedulerFactory.getValue();
    }

    public final Function4<gb, ib.b, CoroutineDispatcher, f5, ib> C() {
        return (Function4) this.videoBufferFactory.getValue();
    }

    public final q5 y() {
        return (q5) this.ifa.getValue();
    }

    public final m5 x() {
        return (m5) this.googleAdvertisingId.getValue();
    }

    public final t0 v() {
        return (t0) this.amazonAdvertisingId.getValue();
    }

    @Override // com.chartboost.sdk.impl.z0
    public Function5<Context, SurfaceView, q0, sa, f5, p0> c() {
        int i2 = a.f974a[D().ordinal()];
        if (i2 == 1) {
            return u();
        }
        if (i2 == 2) {
            return t();
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ b1(w0 w0Var, q4 q4Var, n8 n8Var, Function1 function1, ea eaVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(w0Var, q4Var, n8Var, (i2 & 8) != 0 ? a1.f963a : function1, eaVar);
    }
}
