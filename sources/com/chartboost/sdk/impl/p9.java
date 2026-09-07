package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.events.StartError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u00102\u001a\u000200\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020403\u0012\u0006\u00109\u001a\u000207\u0012\u0006\u0010<\u001a\u00020:\u0012\u0006\u0010?\u001a\u00020=\u0012\u0006\u0010B\u001a\u00020@\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020D0C\u0012\u0006\u0010I\u001a\u00020G\u0012\u0006\u0010L\u001a\u00020J\u0012\u0006\u0010O\u001a\u00020M\u0012\u0006\u0010R\u001a\u00020P\u0012\u0006\u0010U\u001a\u00020S\u0012\u0006\u0010X\u001a\u00020V¢\u0006\u0004\bi\u0010jJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0014J\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0014J\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u0014J\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u0014J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b\u000b\u0010%J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0014J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fR\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010AR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010WR(\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bY\u0010Z\u0012\u0004\b^\u0010\u0014\u001a\u0004\b[\u0010\u0004\"\u0004\b\\\u0010]R(\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b_\u0010Z\u0012\u0004\bb\u0010\u0014\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010]R \u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b030c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010Z¨\u0006k"}, d2 = {"Lcom/chartboost/sdk/impl/p9;", "Lcom/chartboost/sdk/impl/m3;", "", "e", "()Z", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "appSignature", "Lcom/chartboost/sdk/callbacks/StartCallback;", "onStarted", "", "a", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/callbacks/StartCallback;)V", "Lorg/json/JSONObject;", "configJson", "(Lorg/json/JSONObject;)V", "errorMsg", "(Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "g", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "i", DTBMetricsConfiguration.CONFIG_DIR, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "h", "()Ljava/lang/String;", "n", "m", "o", "p", "j", InneractiveMediationDefs.GENDER_FEMALE, "l", "Lcom/chartboost/sdk/events/StartError;", "error", "(Lcom/chartboost/sdk/events/StartError;)V", CampaignEx.JSON_KEY_AD_K, "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/chartboost/sdk/impl/sa;", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/l8;", "Lcom/chartboost/sdk/impl/l8;", "privacyApi", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "Lcom/chartboost/sdk/impl/j8;", "Lcom/chartboost/sdk/impl/j8;", "prefetcher", "Lcom/chartboost/sdk/impl/g4;", "Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/s9;", "session", "Lcom/chartboost/sdk/impl/kb;", "Lcom/chartboost/sdk/impl/kb;", "videoCachePolicy", "Lkotlin/Lazy;", "Lcom/chartboost/sdk/impl/qb;", "Lkotlin/Lazy;", "videoRepository", "Lcom/chartboost/sdk/impl/u6;", "Lcom/chartboost/sdk/impl/u6;", "initInstallRequest", "Lcom/chartboost/sdk/impl/t6;", "Lcom/chartboost/sdk/impl/t6;", "initConfigRequest", "Lcom/chartboost/sdk/impl/h2;", "Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/q8;", "Lcom/chartboost/sdk/impl/q8;", "providerInstallerHelper", "Lcom/chartboost/sdk/impl/w1;", "Lcom/chartboost/sdk/impl/w1;", "identity", "Lcom/chartboost/sdk/impl/t7;", "Lcom/chartboost/sdk/impl/t7;", "openMeasurementManager", CampaignEx.JSON_KEY_AD_Q, "Z", "isSDKInitialized", "setSDKInitialized", "(Z)V", "isSDKInitialized$annotations", "r", "isFirstSession", "setFirstSession", "isFirstSession$annotations", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "s", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "startCallbackList", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "isInitializing", "<init>", "(Landroid/content/Context;Landroid/content/SharedPreferences;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/l8;Ljava/util/concurrent/atomic/AtomicReference;Lcom/chartboost/sdk/impl/j8;Lcom/chartboost/sdk/impl/g4;Lcom/chartboost/sdk/impl/s9;Lcom/chartboost/sdk/impl/kb;Lkotlin/Lazy;Lcom/chartboost/sdk/impl/u6;Lcom/chartboost/sdk/impl/t6;Lcom/chartboost/sdk/impl/h2;Lcom/chartboost/sdk/impl/q8;Lcom/chartboost/sdk/impl/w1;Lcom/chartboost/sdk/impl/t7;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class p9 implements m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final sa uiPoster;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final l8 privacyApi;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final AtomicReference<o9> sdkConfig;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final j8 prefetcher;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final g4 downloader;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final s9 session;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final kb videoCachePolicy;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Lazy<qb> videoRepository;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final u6 initInstallRequest;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final t6 initConfigRequest;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final q8 providerInstallerHelper;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final w1 identity;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final t7 openMeasurementManager;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean isSDKInitialized;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean isFirstSession;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final ConcurrentLinkedQueue<AtomicReference<StartCallback>> startCallbackList;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public boolean isInitializing;

    /* JADX WARN: Multi-variable type inference failed */
    public p9(Context context, SharedPreferences sharedPreferences, sa uiPoster, l8 privacyApi, AtomicReference<o9> sdkConfig, j8 prefetcher, g4 downloader, s9 session, kb videoCachePolicy, Lazy<? extends qb> videoRepository, u6 initInstallRequest, t6 initConfigRequest, h2 reachability, q8 providerInstallerHelper, w1 identity, t7 openMeasurementManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(privacyApi, "privacyApi");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(prefetcher, "prefetcher");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(videoCachePolicy, "videoCachePolicy");
        Intrinsics.checkNotNullParameter(videoRepository, "videoRepository");
        Intrinsics.checkNotNullParameter(initInstallRequest, "initInstallRequest");
        Intrinsics.checkNotNullParameter(initConfigRequest, "initConfigRequest");
        Intrinsics.checkNotNullParameter(reachability, "reachability");
        Intrinsics.checkNotNullParameter(providerInstallerHelper, "providerInstallerHelper");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(openMeasurementManager, "openMeasurementManager");
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.uiPoster = uiPoster;
        this.privacyApi = privacyApi;
        this.sdkConfig = sdkConfig;
        this.prefetcher = prefetcher;
        this.downloader = downloader;
        this.session = session;
        this.videoCachePolicy = videoCachePolicy;
        this.videoRepository = videoRepository;
        this.initInstallRequest = initInstallRequest;
        this.initConfigRequest = initConfigRequest;
        this.reachability = reachability;
        this.providerInstallerHelper = providerInstallerHelper;
        this.identity = identity;
        this.openMeasurementManager = openMeasurementManager;
        this.isFirstSession = true;
        this.startCallbackList = new ConcurrentLinkedQueue<>();
    }

    public final void k() {
        if (k9.f1061a.d()) {
            String strH = h();
            String str = JsonUtils.EMPTY_JSON;
            if (strH == null) {
                strH = JsonUtils.EMPTY_JSON;
            }
            if (strH.length() != 0) {
                str = strH;
            }
            b(new JSONObject(str));
        }
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getIsSDKInitialized() {
        return this.isSDKInitialized;
    }

    public final void g() {
        a((StartError) null);
        this.isSDKInitialized = true;
        i();
    }

    public final void b() {
        if (this.privacyApi.a("coppa") != null || this.isSDKInitialized) {
            return;
        }
        b7.d("COPPA is not set. If this app is child directed, please use ´addDataUseConsent(android.content.Context, com.chartboost.sdk.Privacy.model.COPPA)´ to set the correct value.", null, 2, null);
    }

    public final void b(JSONObject configJson) {
        if (k9.f1061a.d()) {
            k9.a("Video player: " + new o9(configJson).c().getVideoPlayer());
        }
    }

    public final void i() {
        this.initConfigRequest.a(this);
    }

    public final boolean d() {
        String strH = h();
        return strH != null && strH.length() > 0;
    }

    public final String h() {
        return this.sharedPreferences.getString(DTBMetricsConfiguration.CONFIG_DIR, "");
    }

    public final void c() {
        this.openMeasurementManager.e();
        o();
        p();
        j();
        m();
        this.isFirstSession = false;
    }

    public final void n() {
        if (this.session.getSessionId() == null) {
            this.session.a();
            b7.b("Current session count: " + this.session.getSessionCounter(), null, 2, null);
        }
    }

    public final void m() {
        if (this.isSDKInitialized) {
            return;
        }
        a((StartError) null);
        this.isSDKInitialized = true;
    }

    public final void o() {
        ia iaVarG = this.sdkConfig.get().g();
        if (iaVarG != null) {
            ab.b.refresh(iaVarG);
        }
    }

    public final void p() {
        lb lbVarC = this.sdkConfig.get().c();
        if (lbVarC != null) {
            this.videoCachePolicy.c(lbVarC.getMaxBytes());
            this.videoCachePolicy.b(lbVarC.getMaxUnitsPerTimeWindow());
            this.videoCachePolicy.c(lbVarC.getMaxUnitsPerTimeWindowCellular());
            this.videoCachePolicy.d(lbVarC.getTimeWindow());
            this.videoCachePolicy.e(lbVarC.getMaxUnitsPerTimeWindowCellular());
            this.videoCachePolicy.f(lbVarC.getTtl());
            this.videoCachePolicy.a(lbVarC.getBufferSize());
        }
        this.videoRepository.getValue().a(this.context);
    }

    public final void j() {
        f();
        o9 o9Var = this.sdkConfig.get();
        if (o9Var != null) {
            this.privacyApi.a(o9Var.B);
        }
        this.initInstallRequest.a();
        l();
    }

    public final void f() {
        if (this.sdkConfig.get() == null || this.sdkConfig.get().f() == null) {
            return;
        }
        String strF = this.sdkConfig.get().f();
        Intrinsics.checkNotNullExpressionValue(strF, "sdkConfig.get().publisherWarning");
        b7.d(strF, null, 2, null);
    }

    public final void l() {
        this.prefetcher.b();
    }

    public final void a(StartError error) {
        a();
        while (true) {
            AtomicReference<StartCallback> atomicReferencePoll = this.startCallbackList.poll();
            StartCallback startCallback = atomicReferencePoll != null ? atomicReferencePoll.get() : null;
            if (startCallback == null) {
                this.isInitializing = false;
                return;
            }
            this.uiPoster.a(new a(startCallback, error));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StartCallback b;
        public final /* synthetic */ StartError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(StartCallback startCallback, StartError startError) {
            super(0);
            this.b = startCallback;
            this.c = startError;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.b.onStartCompleted(this.c);
        }
    }

    public final synchronized void a(String appId, String appSignature, StartCallback onStarted) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSignature, "appSignature");
        Intrinsics.checkNotNullParameter(onStarted, "onStarted");
        try {
            o4.b.a();
            this.startCallbackList.add(new AtomicReference<>(onStarted));
            if (this.isInitializing) {
                b7.b("Initialization already in progress", null, 2, null);
                return;
            }
            if (this.session.getSessionCounter() > 1) {
                this.isFirstSession = false;
            }
            this.isInitializing = true;
            n();
            if (this.isSDKInitialized) {
                g();
            } else {
                a(appId, appSignature);
            }
            b();
        } catch (Exception e) {
            b7.b("Cannot initialize Chartboost sdk due to internal error", e);
            a(new StartError(StartError.Code.INTERNAL, e));
        }
    }

    public final void c(JSONObject config) {
        if (config == null || !q1.a(this.sdkConfig, config)) {
            return;
        }
        this.sharedPreferences.edit().putString(DTBMetricsConfiguration.CONFIG_DIR, config.toString()).apply();
    }

    @Override // com.chartboost.sdk.impl.m3
    public void a(String errorMsg) {
        StartError startError;
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (this.isFirstSession) {
            if (this.reachability.e()) {
                startError = new StartError(StartError.Code.SERVER_ERROR, new Exception(errorMsg));
            } else {
                startError = new StartError(StartError.Code.NETWORK_FAILURE, new Exception(errorMsg));
            }
            a(startError);
        } else {
            c();
        }
        k();
    }

    @Override // com.chartboost.sdk.impl.m3
    public void a(JSONObject configJson) {
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        c(configJson);
        c();
        b(configJson);
    }

    public final void a(String appId, String appSignature) {
        if (!q1.a(this.context)) {
            b7.b("Permissions not set correctly", null, 2, null);
            a(new StartError(StartError.Code.INVALID_CREDENTIALS, new Exception("Permissions not set correctly")));
            return;
        }
        if (appId.length() != 0 && appSignature.length() != 0 && appId.length() == 24 && appSignature.length() == 40 && q9.f1115a.matches(appId) && q9.f1115a.matches(appSignature)) {
            this.providerInstallerHelper.a();
            this.downloader.b();
            if (d()) {
                g();
                return;
            } else {
                i();
                return;
            }
        }
        b7.b("AppId or AppSignature is invalid. Please pass a valid id's", null, 2, null);
        a(new StartError(StartError.Code.INVALID_CREDENTIALS, new Exception("AppId or AppSignature is invalid. Please pass a valid id's")));
    }

    public final void a() {
        if (k9.f1061a.d()) {
            r5 r5VarH = this.identity.h();
            k9.a("SetId: " + r5VarH.getSetId() + " scope:" + r5VarH.getSetIdScope() + " Tracking state: " + r5VarH.getTrackingState() + " Identifiers: " + r5VarH.getIdentifiers());
        }
    }
}
