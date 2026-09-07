package com.json;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u0010AJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u000f\u001a\u00020\u0012H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u001cJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0013008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/ironsource/xr;", "", "Landroid/content/Context;", "context", "Lcom/ironsource/ak;", "globalDataWriter", "Lcom/ironsource/ls;", "serverResponse", "", "a", "Lcom/ironsource/mr;", "error", "applicationContext", "Lcom/ironsource/kr;", "sdkConfig", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "inProgress", "Lcom/ironsource/zr;", "Lcom/ironsource/qr;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/h4;", DTBMetricsConfiguration.CONFIG_DIR, "response", "d", "Lcom/ironsource/rr;", "initRequest", "e", "Lcom/ironsource/sr;", "Lcom/ironsource/os;", "Lcom/ironsource/os;", "sessionCalcManager", "Lcom/ironsource/bf;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/Lazy;", "()Lcom/ironsource/bf;", "applicationLifecycleService", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "Lcom/ironsource/bs;", "Lcom/ironsource/bs;", "tools", "Lcom/ironsource/js;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/js;", "serverInit", "", "g", "Ljava/util/List;", "sdkInitListeners", "h", "Lcom/ironsource/kr;", "i", "Lcom/ironsource/mr;", "errorReason", "j", "Z", "initInProgress", "", CampaignEx.JSON_KEY_AD_K, "J", "initStartTime", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class xr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xr f4600a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static os sessionCalcManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final Lazy applicationLifecycleService;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final String TAG;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final bs tools;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private static final js serverInit;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private static final List<qr> sdkInitListeners;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private static kr sdkConfig;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private static mr errorReason;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private static boolean initInProgress;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private static long initStartTime;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/bf;", "a", "()Lcom/ironsource/bf;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0<bf> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4601a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final bf invoke() {
            return mm.INSTANCE.d().v();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/xr$b", "Lcom/ironsource/qr;", "Lcom/ironsource/kr;", "sdkConfig", "", "a", "Lcom/ironsource/mr;", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements qr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4602a;

        b(Context context) {
            this.f4602a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Context applicationContext, kr sdkConfig) throws Throwable {
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            xr xrVar = xr.f4600a;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            xrVar.a(applicationContext, sdkConfig);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(mr error) {
            Intrinsics.checkNotNullParameter(error, "$error");
            xr.f4600a.a(error);
        }

        @Override // com.json.qr
        public void a(final kr sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            bs bsVar = xr.tools;
            final Context context = this.f4602a;
            bsVar.a(new Runnable() { // from class: com.ironsource.xr$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    xr.b.a(context, sdkConfig);
                }
            });
        }

        @Override // com.json.qr
        public void a(final mr error) {
            Intrinsics.checkNotNullParameter(error, "error");
            xr.tools.a(new Runnable() { // from class: com.ironsource.xr$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    xr.b.b(error);
                }
            });
        }
    }

    static {
        xr xrVar = new xr();
        f4600a = xrVar;
        applicationLifecycleService = LazyKt.lazy(a.f4601a);
        TAG = xrVar.getClass().getSimpleName();
        tools = new bs();
        serverInit = new js();
        sdkInitListeners = new ArrayList();
    }

    private xr() {
    }

    private final void a(Context context, ak globalDataWriter, ls serverResponse) {
        globalDataWriter.i(serverResponse.f().h());
        globalDataWriter.b(serverResponse.f().d());
        a4 applicationConfigurations = serverResponse.c().getApplicationConfigurations();
        Intrinsics.checkNotNull(applicationConfigurations);
        globalDataWriter.a(applicationConfigurations.a());
        globalDataWriter.c(applicationConfigurations.b().b());
        globalDataWriter.b(applicationConfigurations.j().b());
        globalDataWriter.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
        a4 applicationConfigurations2 = serverResponse.c().getApplicationConfigurations();
        Intrinsics.checkNotNull(applicationConfigurations2);
        globalDataWriter.b(applicationConfigurations2.e().getCmpId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context applicationContext, kr sdkConfig2) throws Throwable {
        b(sdkConfig2);
        k4 k4VarA = sdkConfig2.a();
        xa xaVar = xa.f4585a;
        xaVar.c(k4VarA.getShouldUseAppSet());
        mm.INSTANCE.a().x().a(k4VarA.getCom.ironsource.b9.a.c java.lang.String());
        xaVar.a(k4VarA.getShouldReuseAdvId());
        xaVar.a(k4VarA.getUserAgentExpirationThresholdInHours());
        IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(k4VarA.getShouldUseSharedThreadPool());
        c().a(k4VarA);
        bs bsVar = tools;
        a(applicationContext, bsVar.getGlobalDataWriter(), sdkConfig2.d());
        bsVar.a(new Date().getTime() - initStartTime, sdkConfig2.f());
        os osVar = new os();
        sessionCalcManager = osVar;
        osVar.a(c());
        IronSourceUtils.saveLastResponse(applicationContext, sdkConfig2.d().toString());
        oj.i().c(true);
        ar.i().c(true);
        ip.P.c(true);
        b(applicationContext, sdkConfig2);
        IronSourceLoggerManager.getLogger(0).setDebugLevel(sdkConfig2.e().getPublisher());
        d4 d4VarB = sdkConfig2.b();
        if (d4VarB.getIsCrashReporterEnabled()) {
            bsVar.a(d4VarB);
        }
        a(sdkConfig2);
        new ip.a().a();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, qr listener, rr initRequest, Context context2) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        j.f3792a.a(context);
        kr krVar = sdkConfig;
        if (krVar != null) {
            f4600a.a(listener, krVar);
            return;
        }
        sdkInitListeners.add(listener);
        if (initInProgress) {
            return;
        }
        errorReason = null;
        f4600a.a(true);
        initStartTime = new Date().getTime();
        serverInit.a(context, initRequest, tools, new b(context2));
    }

    private final void a(h4 config, Context context, ls response) {
        oj.i().a(config.c(), context);
        oj.i().b(config.d(), context);
        oj.i().b(config.f());
        oj.i().a(config.e());
        oj.i().c(config.a());
        oj.i().c(config.i(), context);
        oj.i().a(config.h(), context);
        oj.i().b(config.j(), context);
        oj.i().d(config.g(), context);
        oj ojVarI = oj.i();
        a4 applicationConfigurations = response.c().getApplicationConfigurations();
        Intrinsics.checkNotNull(applicationConfigurations);
        ojVarI.a(applicationConfigurations.i());
        oj.i().a(config.k());
        oj.i().d(config.b());
    }

    private final void a(kr sdkConfig2) {
        Iterator<qr> it = sdkInitListeners.iterator();
        while (it.hasNext()) {
            a(it.next(), sdkConfig2);
        }
        sdkInitListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(mr error) {
        errorReason = error;
        a(false);
        Iterator<qr> it = sdkInitListeners.iterator();
        while (it.hasNext()) {
            a(it.next(), error);
        }
        sdkInitListeners.clear();
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: " + error, 1);
    }

    private final void a(final qr listener, final kr sdkConfig2) {
        tools.e(new Runnable() { // from class: com.ironsource.xr$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                xr.b(listener, sdkConfig2);
            }
        });
    }

    private final void a(final qr listener, final mr error) {
        tools.e(new Runnable() { // from class: com.ironsource.xr$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                xr.b(listener, error);
            }
        });
    }

    private final void a(boolean inProgress) {
        initInProgress = inProgress;
        tools.a(b());
    }

    private final zr b() {
        if (sdkConfig != null) {
            return zr.INITIATED;
        }
        if (errorReason != null) {
            return zr.INIT_FAILED;
        }
        return initInProgress ? zr.INIT_IN_PROGRESS : zr.NOT_INIT;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:68:0x010e  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    private final void b(Context context, kr sdkConfig2) {
        h4 eventsConfigurations;
        String str;
        boolean pixelEventsEnabled;
        String pixelEventsUrl;
        boolean pixelEventsCompression;
        int pixelEventsCompressionLevel;
        int[] pixelOptOut;
        int[] pixelOptIn;
        ip ipVar;
        rm nativeAdConfigurations;
        h4 eventsConfigurations2;
        u6 bannerConfigurations;
        h4 h4VarG;
        mj interstitialConfigurations;
        h4 h4VarI;
        yq rewardedVideoConfigurations;
        h4 h4VarM;
        ls lsVarD = sdkConfig2.d();
        s8 s8VarC = lsVarD.c();
        boolean zL = (s8VarC == null || (rewardedVideoConfigurations = s8VarC.getRewardedVideoConfigurations()) == null || (h4VarM = rewardedVideoConfigurations.m()) == null) ? false : h4VarM.l();
        s8 s8VarC2 = lsVarD.c();
        boolean zL2 = (s8VarC2 == null || (interstitialConfigurations = s8VarC2.getInterstitialConfigurations()) == null || (h4VarI = interstitialConfigurations.i()) == null) ? false : h4VarI.l();
        s8 s8VarC3 = lsVarD.c();
        boolean zL3 = (s8VarC3 == null || (bannerConfigurations = s8VarC3.getBannerConfigurations()) == null || (h4VarG = bannerConfigurations.g()) == null) ? false : h4VarG.l();
        s8 s8VarC4 = lsVarD.c();
        boolean zL4 = (s8VarC4 == null || (nativeAdConfigurations = s8VarC4.getNativeAdConfigurations()) == null || (eventsConfigurations2 = nativeAdConfigurations.getEventsConfigurations()) == null) ? false : eventsConfigurations2.l();
        if (zL) {
            s8 s8VarC5 = lsVarD.c();
            yq rewardedVideoConfigurations2 = s8VarC5 != null ? s8VarC5.getRewardedVideoConfigurations() : null;
            Intrinsics.checkNotNull(rewardedVideoConfigurations2);
            h4 rewardedVideoConfig = rewardedVideoConfigurations2.m();
            Intrinsics.checkNotNullExpressionValue(rewardedVideoConfig, "rewardedVideoConfig");
            b(rewardedVideoConfig, context, lsVarD);
        } else {
            ar.i().b(false);
        }
        if (!zL2) {
            if (zL3) {
                s8 s8VarC6 = lsVarD.c();
                u6 bannerConfigurations2 = s8VarC6 != null ? s8VarC6.getBannerConfigurations() : null;
                Intrinsics.checkNotNull(bannerConfigurations2);
                eventsConfigurations = bannerConfigurations2.g();
                str = "bannerConfig";
            } else if (zL4) {
                s8 s8VarC7 = lsVarD.c();
                rm nativeAdConfigurations2 = s8VarC7 != null ? s8VarC7.getNativeAdConfigurations() : null;
                Intrinsics.checkNotNull(nativeAdConfigurations2);
                eventsConfigurations = nativeAdConfigurations2.getEventsConfigurations();
                a(eventsConfigurations, context, lsVarD);
            } else {
                oj.i().b(false);
            }
            s8 s8VarC8 = lsVarD.c();
            a4 applicationConfigurations = s8VarC8 != null ? s8VarC8.getApplicationConfigurations() : null;
            Intrinsics.checkNotNull(applicationConfigurations);
            jp jpVarH = applicationConfigurations.h();
            pixelEventsEnabled = jpVarH.getPixelEventsEnabled();
            pixelEventsUrl = jpVarH.getPixelEventsUrl();
            pixelEventsCompression = jpVarH.getPixelEventsCompression();
            pixelEventsCompressionLevel = jpVarH.getPixelEventsCompressionLevel();
            pixelOptOut = jpVarH.getPixelOptOut();
            pixelOptIn = jpVarH.getPixelOptIn();
            ipVar = ip.P;
            ipVar.b(pixelEventsEnabled);
            if (pixelEventsEnabled) {
                ipVar.b(pixelEventsUrl, context);
                ipVar.c(pixelOptOut, context);
                ipVar.a(pixelOptIn, context);
                ipVar.a(pixelEventsCompression);
                ipVar.d(pixelEventsCompressionLevel);
            }
        }
        s8 s8VarC9 = lsVarD.c();
        mj interstitialConfigurations2 = s8VarC9 != null ? s8VarC9.getInterstitialConfigurations() : null;
        Intrinsics.checkNotNull(interstitialConfigurations2);
        eventsConfigurations = interstitialConfigurations2.i();
        str = "interstitialConfig";
        Intrinsics.checkNotNullExpressionValue(eventsConfigurations, str);
        a(eventsConfigurations, context, lsVarD);
        s8 s8VarC10 = lsVarD.c();
        if (s8VarC10 != null) {
        }
        Intrinsics.checkNotNull(applicationConfigurations);
        jp jpVarH2 = applicationConfigurations.h();
        pixelEventsEnabled = jpVarH2.getPixelEventsEnabled();
        pixelEventsUrl = jpVarH2.getPixelEventsUrl();
        pixelEventsCompression = jpVarH2.getPixelEventsCompression();
        pixelEventsCompressionLevel = jpVarH2.getPixelEventsCompressionLevel();
        pixelOptOut = jpVarH2.getPixelOptOut();
        pixelOptIn = jpVarH2.getPixelOptIn();
        ipVar = ip.P;
        ipVar.b(pixelEventsEnabled);
        if (pixelEventsEnabled) {
            ipVar.b(pixelEventsUrl, context);
            ipVar.c(pixelOptOut, context);
            ipVar.a(pixelOptIn, context);
            ipVar.a(pixelEventsCompression);
            ipVar.d(pixelEventsCompressionLevel);
        }
    }

    private final void b(h4 config, Context context, ls response) {
        ar.i().a(config.c(), context);
        ar.i().b(config.d(), context);
        ar.i().b(config.f());
        ar.i().a(config.e());
        ar.i().c(config.a());
        ar.i().c(config.i(), context);
        ar.i().a(config.h(), context);
        ar.i().b(config.j(), context);
        ar.i().d(config.g(), context);
        ar arVarI = ar.i();
        a4 applicationConfigurations = response.c().getApplicationConfigurations();
        Intrinsics.checkNotNull(applicationConfigurations);
        arVarI.a(applicationConfigurations.i());
        ar.i().a(config.k());
        ar.i().d(config.b());
    }

    private final void b(kr sdkConfig2) {
        sdkConfig = sdkConfig2;
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(qr listener, kr sdkConfig2) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(sdkConfig2, "$sdkConfig");
        listener.a(sdkConfig2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(qr listener, mr error) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(error, "$error");
        listener.a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(sr serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "$serverResponse");
        kr krVar = new kr(serverResponse);
        xr xrVar = f4600a;
        xrVar.b(krVar);
        xrVar.a(krVar);
    }

    private final bf c() {
        return (bf) applicationLifecycleService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(mr error) {
        Intrinsics.checkNotNullParameter(error, "$error");
        f4600a.a(error);
    }

    private final void d() {
        if (mm.INSTANCE.d().d().f()) {
            ar.i().a(new zb(IronSourceConstants.EP_CONFIG_RECEIVED, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f4600a.a(true);
    }

    public final void a(final Context context, final rr initRequest, final qr listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Context applicationContext = context.getApplicationContext();
        tools.c(new Runnable() { // from class: com.ironsource.xr$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                xr.a(context, listener, initRequest, applicationContext);
            }
        });
    }

    public final void a(final sr serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        tools.c(new Runnable() { // from class: com.ironsource.xr$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                xr.b(serverResponse);
            }
        });
    }

    public final void b(final mr error) {
        Intrinsics.checkNotNullParameter(error, "error");
        tools.c(new Runnable() { // from class: com.ironsource.xr$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                xr.c(error);
            }
        });
    }

    public final void e() {
        tools.c(new Runnable() { // from class: com.ironsource.xr$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                xr.f();
            }
        });
    }
}
